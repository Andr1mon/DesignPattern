package fr.ensim.dp.map.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.painter.Painter;

import fr.ensim.dp.map.player.IPlayer;
import fr.ensim.dp.map.tile.OpenStreetMapTileFactory;

@SuppressWarnings("serial")
public class JMediaMap extends JXPanel {
  private static final Logger LOG =  LogManager.getLogger();

  private BufferedImage            imgStop;

  private BufferedImage            imgStart;

  private BufferedImage            imgPoint;
	  
  private JXMapKit    mapKit;

  private PlayerPanel playerPanel;
  
  private IPlayer player;

  private Timer       timer;
  
  private TimerActionListener timerActionListener;
  
  private List<GeoPosition> listGeo;
  
  private int indexCurrentpoint = 0;
  
  public JMediaMap() {
    super();

    timerActionListener = new TimerActionListener();
    timer = new Timer(300, timerActionListener);
    
    try {
		imgStop = ImageIO.read(getClass().getResource("/img/marker-end.png"));
		imgStart = ImageIO.read(getClass().getResource("/img/marker-start.png"));
	    imgPoint = ImageIO.read(getClass().getResource("/img/marker-blue.png"));
	} catch (IOException e) {
		// ne peut arriver
		throw new RuntimeException(e);
	}
   
    setLayout(new BorderLayout());
    setBorder(new EmptyBorder(5, 5, 5, 5));

    mapKit = new JXMapKit();
    mapKit.setMiniMapVisible(false);
    mapKit.setTileFactory(OpenStreetMapTileFactory
        .getTileFactory(OpenStreetMapTileFactory.getTileNames()[0]));
    mapKit.setCenterPosition(new GeoPosition(47.93000031, 0.20000000));
    mapKit.setZoom(5);

    playerPanel = new PlayerPanel(player);

    add(mapKit, BorderLayout.CENTER);
    add(playerPanel, BorderLayout.PAGE_END);
  }

  public void changedAllPoints(List<GeoPosition> listGeo) {
    this.listGeo = listGeo;
    this.indexCurrentpoint = 0;
    
    mapKit.getMainMap().setZoom(mapKit.getMainMap().getTileFactory().getInfo()
        .getMinimumZoomLevel());

    HashSet<GeoPosition> hashGeoMap = new HashSet<GeoPosition>();
    for (GeoPosition g : listGeo) {
      hashGeoMap.add(g);
    }

    mapKit.getMainMap().calculateZoomFrom(hashGeoMap);

    // re-calculate
    mapKit.getMainMap().calculateZoomFrom(hashGeoMap);

    final GeoPosition[] tab = new GeoPosition[listGeo.size()];
    listGeo.toArray(tab);

    mapKit.getMainMap().setOverlayPainter(new Painter<JXMapViewer>() {
      public void paint(Graphics2D g, JXMapViewer map, int w, int h) {
    	  
        Graphics2D g2 = (Graphics2D) g.create();

        // convert from viewport to world bitmap
        Rectangle rect = map.getViewportBounds();
        g2.translate(-rect.x, -rect.y);
        g2.setColor(Color.RED);

        for (int i = 0; i < tab.length - 1; i++) {
          Point2D p1 = map.getTileFactory().geoToPixel(tab[i], map.getZoom());
          Point2D p2 = map.getTileFactory().geoToPixel(tab[i + 1],
                                                       map.getZoom());

          Line2D line = new Line2D.Double();
          line.setLine(p1, p2);
          g2.draw(line);
          line.setLine(p1.getX(), p1.getY() + 1, p2.getX(), p2.getY() + 1);
          g2.draw(line);
          line.setLine(p1.getX(), p1.getY() + 2, p2.getX(), p2.getY() + 2);
          g2.draw(line);
          line.setLine(p1.getX(), p1.getY() - 1, p2.getX(), p2.getY() - 1);
          g2.draw(line);
        }
        
        // start
        Point2D p = map.getTileFactory().geoToPixel(tab[0], map.getZoom());
        g2.drawImage(imgStart,
                     (int) (p.getX() - (imgStart.getWidth() / 2)),
                     (int) (p.getY() - imgStart.getHeight()),
                     imgStart.getWidth(),
                     imgStart.getHeight(),
                     null);

        // stop
        p = map.getTileFactory().geoToPixel(tab[tab.length - 1],
                                            map.getZoom());
        g2.drawImage(imgStop,
                     (int) (p.getX() - (imgStop.getWidth() / 2)),
                     (int) (p.getY() - imgStop.getHeight()),
                     imgStop.getWidth(),
                     imgStop.getHeight(),
                     null);
        
        // currentPoint
        if (indexCurrentpoint > 0 && indexCurrentpoint < (tab.length - 1)) {
          Point2D pCurrentPoint = map.getTileFactory().geoToPixel(tab[indexCurrentpoint], map.getZoom());
          g2.drawImage(imgPoint,
                       (int) (pCurrentPoint.getX() - (imgPoint.getWidth() / 2)),
                       (int) (pCurrentPoint.getY() - imgPoint.getHeight()),
                       imgPoint.getWidth(),
                       imgPoint.getHeight(),
                       null);
        }
        
        g.dispose();
      }

    });
    timer.start();
  }

  public int getZoom() {
    return mapKit.getMainMap().getZoom();
  }

  public void setZoom(int zoom) {
    mapKit.getMainMap().setZoom(zoom);
  }

  public GeoPosition getCenterPosition() {
    return mapKit.getMainMap().getCenterPosition();
  }

  public void setCenterPosition(GeoPosition center) {
    mapKit.getMainMap().setCenterPosition(center);
  }

  public JXMapKit getMapKit() {
    return mapKit;
  }

  public PlayerPanel getPlayerPanel() {
    return playerPanel;
  }
  
  /**
   * @author Denis Apparicio
   * 
   */
  private class TimerActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      // Incremente le point courant de la map
      setIndexCurrentpoint(++indexCurrentpoint);
    }
  }
  
  private void setIndexCurrentpoint(int indexCurrentpoint) {
    LOG.debug("setIndexCurrentpoint "+indexCurrentpoint);
    if (indexCurrentpoint >= (listGeo.size() - 1)) {
       this.indexCurrentpoint = -1;
       timer.stop();
    }
    else {
	   this.indexCurrentpoint = indexCurrentpoint;
    }
    mapKit.getMainMap().repaint();
  }

}
