package gui.components;

import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import eccezioni.MVException;
import gui.CtrlActions;
import gui.MultiViewerPopupMenu;
import gui.utils.GUIUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;

/**
 *
 * @author UK
 */
public class JFrontLayoutPanel extends JPanel {

    private JToggleButton[] buttons;
    private MultiViewerPopupMenu popupMenu;
    private static final Color bgColor = new Color(126, 126, 126);
    private int offset;
    private String idActionButton;
    ButtonGroup br;
    public static String lastActionCommand;

    public JFrontLayoutPanel() {
        setLayout(null);
        setSize(150, 100);
        buttons = new JToggleButton[10];
        br = new ButtonGroup();
        offset = (getWidth() - 150) / 2 + 6;

        popupMenu = new MultiViewerPopupMenu();
        JMenuItemBGGradient saveButton = new JMenuItemBGGradient();
        saveButton.setText("Save");
        saveButton.setIcon(GUIUtils.getInstance().getIcon("save16.gif"));
        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    CtrlProtocol.getInstance().quickSaveLayout(idActionButton, CtrlActions.getInstance().getIdModulo());
                    //quando salvi , il server carica a schermo il layout corrente, quindi non bisogna querare il liveread
//                    CtrlWorkspace.getInstance().loadLiveReadFromMV(CtrlActions.getInstance().getIdModulo());
//                    CtrlActions.getInstance().reloadAllPreviews();
                    selectButtonLayout(idActionButton);
                } catch (MVException ex) {
                    //
                }
            }
        });
        popupMenu.add(saveButton);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JToggleButton();
            //buttons[i].setBackground(Color.white);

            buttons[i].setIcon(GUIUtils.getInstance().getIcon("frontButtonOff.gif"));
            buttons[i].setSelectedIcon(GUIUtils.getInstance().getIcon("frontPanelOn.gif"));

            // buttons[i].setText("N");
            br.add(buttons[i]);
            buttons[i].setSize(20, 20);
            //buttons[i].setPreferredSize(20, 20);
            buttons[i].setLocation(offset + 4 + (25 * (i % 5)), 38 + (25 * (i / 5)));
            buttons[i].setActionCommand(Integer.toString(i + 1));

            buttons[i].setToolTipText("Left click to load, Right click to save");

            //LEFT CLICK
            buttons[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    lastActionCommand = e.getActionCommand();
                    ((JFrame) JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace())).getGlassPane().setVisible(true);
                    SwingWorker worker = new SwingWorker<Void, Void>() {

                        public Void doInBackground() {
                            try {
                                CtrlProtocol.getInstance().quickLoadLayout(JFrontLayoutPanel.lastActionCommand, CtrlActions.getInstance().getIdModulo());
                                CtrlWorkspace.getInstance().loadLiveReadFromMV(CtrlActions.getInstance().getIdModulo());
                                CtrlActions.getInstance().reloadAllPreviews();
                            } catch (MVException ex) {
                                //
                            }
                            return null;
                        }

                        @Override
                        public void done() {
                            ((JFrame) JOptionPane.getFrameForComponent(CtrlActions.getInstance().getTilesWorkspace())).getGlassPane().setVisible(false);
                        }
                    };
                    worker.execute();


                }
            });

            //RIGHT CLICK

            buttons[i].addMouseListener(new MouseListener() {

                public void mouseClicked(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        idActionButton = ((JToggleButton) e.getSource()).getActionCommand();
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                        return;
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        idActionButton = ((JToggleButton) e.getSource()).getActionCommand();
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                        return;
                    }
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }
            });

            add(buttons[i]);


        }

        addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                offset = (getWidth() - 150) / 2 + 6;
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setLocation(offset + 4 + (25 * (i % 5)), 38 + (25 * (i / 5)));
                }
            }

            public void componentMoved(ComponentEvent e) {
            }

            public void componentShown(ComponentEvent e) {
            }

            public void componentHidden(ComponentEvent e) {
            }
        });


        //add(popupMenu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        offset = (getWidth() - 150) / 2 + 6;
        g.setColor(bgColor);
        g.fillRect(0, 0, getWidth(), 20);
        g.setColor(Color.white);
        g.fillRect(0, 20, getWidth(), 15);
        g.setColor(bgColor);
        g.fillRect(0, 35, getWidth(), 50);
        g.setColor(Color.white);
        g.fillRect(0, 85, getWidth(), 15);
        g.setColor(bgColor);
        g.fillRect(0, 100, getWidth(), 10);

        //numeri

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setFont(new Font("Lucida", Font.BOLD + Font.ITALIC, 10));
        g.setColor(Color.black);
        g.drawString("MV Configuration Presets", offset-5 , 15);
        g.setFont(new Font("Lucida", Font.BOLD + Font.ITALIC, 12));
        g.setColor(bgColor);
        for (int i = 0; i < 5; i++) {
            g.drawString(Integer.toString(i + 1), offset + 10 + 25 * i, 32);
            g.drawString(Integer.toString(i + 6), ((i == 4) ? offset + 5 : offset + 10) + 25 * i, 97);
        }



    }
//    public static void main (String [] args){
//
//        JFrame frame = new JFrame("TEST");
//        frame.setLayout(new BorderLayout());
//        frame.add(new JFrontLayoutPanel(), BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setSize(300, 200);
//        frame.setVisible(true);
//
//    }

    public void selectButtonLayout(String idButton) {
        selectButtonLayout(Integer.parseInt(idButton));
    }

    public void selectButtonLayout(int idButton) {
        br.clearSelection();
        if (idButton != 0) {
            br.setSelected(buttons[idButton - 1].getModel(), true);
        }
    }
}
