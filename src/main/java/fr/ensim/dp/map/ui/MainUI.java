package fr.ensim.dp.map.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.jdesktop.swingx.mapviewer.AbstractTileFactory;
import org.jdesktop.swingx.mapviewer.GeoPosition;

import fr.ensim.dp.geo.GpxFile;
import fr.ensim.dp.map.tile.OpenStreetMapTileFactory;

@SuppressWarnings("serial")
public class MainUI extends JFrame {
  private static final Logger LOG =  LogManager.getLogger();

  private JPanel        contentPane;

  private JMediaMap     mediaMap;

  /**
   * Create the frame.
   */
  public MainUI() {
    System.setProperty("http.agent", "Java");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    final JComboBox<String> comboBox = new JComboBox<String>(OpenStreetMapTileFactory.getTileNames());
    contentPane.add(comboBox, BorderLayout.NORTH);

    mediaMap = new JMediaMap();
    contentPane.add(mediaMap, BorderLayout.CENTER);

    final JList<String> listGeo = new JList<String>(filesGpx());
    listGeo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(listGeo);
    contentPane.add(scrollPane, BorderLayout.WEST);

    // Listener
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // Caracteristique de l ancienne map
        int zoom = mediaMap.getZoom();
        GeoPosition geo = mediaMap.getCenterPosition();

        // Nouvelle map
        String mapName = (String) comboBox.getSelectedItem();
        AbstractTileFactory newTile = OpenStreetMapTileFactory
            .getTileFactory(mapName);
        mediaMap.getMapKit().setTileFactory(newTile);
        mediaMap.setZoom(zoom);
        mediaMap.setCenterPosition(geo);
        mediaMap.getMapKit().getMainMap().setRestrictOutsidePanning(true);
      }
    });

    listGeo.getSelectionModel()
        .addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (!lsm.isSelectionEmpty()) {
              String name = (String) listGeo.getSelectedValue();
              try {
                mediaMap.changedAllPoints(GpxFile.load(new File("gps", name)));
              }
              catch (Exception ioe) {
                LOG.error("", ioe);
              }
            }
          }
        });

    comboBox.setSelectedIndex(0);
  }

  private String[] filesGpx() {
    File dirGPS = new File("gps");
    return dirGPS.list();
  }

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainUI gui = new MainUI();          
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          
          Dimension frameSize = gui.getSize();
          if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
          }
          if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
          }
          gui.setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);

          gui.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
