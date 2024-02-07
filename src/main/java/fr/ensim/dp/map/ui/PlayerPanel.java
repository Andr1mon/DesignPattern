package fr.ensim.dp.map.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ensim.dp.map.player.IPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerPanel extends JPanel {

  private static final Logger LOG =  LogManager.getLogger();

  private IPlayer         player;

  private JButton         buttonPlayPause;

  private JButton         buttonStop;

  private JButton         buttonBackward;

  private JButton         buttonForward;

  private JLabel          label;

  public static ImageIcon iconStop     = new ImageIcon(PlayerPanel.class.getResource("/img/stop.png"));

  public static ImageIcon iconPlay     = new ImageIcon(PlayerPanel.class.getResource("/img/play.png"));

  public static ImageIcon iconPause    = new ImageIcon(PlayerPanel.class.getResource("/img/pause.png"));

  public static ImageIcon iconForward  = new ImageIcon(PlayerPanel.class.getResource("/img/forward.png"));

  public static ImageIcon iconBackward = new ImageIcon(PlayerPanel.class.getResource("/img/backward.png"));

  /**
   * Create the panel.
   */
  public PlayerPanel(IPlayer player) {
    super();
    this.player = player;
    initUI();
  }

  private void initUI() {

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    label = new JLabel("Play");
    
    // Panel player
    JPanel panelPlayer = new JPanel();
    panelPlayer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    buttonPlayPause = createButton(iconPlay);
    buttonBackward = createButton(iconForward);
    buttonStop = createButton(iconStop);
    buttonForward = createButton(iconBackward);
    panelPlayer.add(buttonPlayPause);
    panelPlayer.add(buttonBackward);
    panelPlayer.add(buttonStop);
    panelPlayer.add(buttonForward);
    
    add(label);
    add(panelPlayer);

    // Evenement

    buttonPlayPause.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });
    buttonStop.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       }
    });
    buttonBackward.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });
    buttonForward.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });
  }

  private JButton createButton(ImageIcon icon) {
    Dimension dimButton = new Dimension(40, 40);

    JButton btn = new JButton();
    btn.setMaximumSize(dimButton);
    btn.setMinimumSize(dimButton);
    btn.setBorderPainted(false);
    btn.setContentAreaFilled(false);
    btn.setOpaque(false);
    btn.setIcon(icon);

    return btn;
  }

}
