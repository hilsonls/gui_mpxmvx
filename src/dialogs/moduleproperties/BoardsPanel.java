package dialogs.moduleproperties;

import bean.CardMode;
import bean.VideoCardModeOptions;
import bean.VideoCards;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import controllori.ProductType;
import eccezioni.MVException;
import gui.components.JPanelBGGradient;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marco Ricci & Antonio Poggi
 */
public class BoardsPanel extends JPanelBGGradient{

    private HashMap<String, DefaultComboBoxModel[]>[] comboCombi;
    private VideoCards videoCards;
    
    private JLabel boardsLabel;
    private JList boardsList;
    
    private JLabel cardConfigLabel;
    private JComboBox[] cardConfigCombo;
    
    private JLabel[] sourceLabel;
    private JComboBox[][] sourceCombo;  // [card number][source number on card]
    
    private int maxSources;
    
            
    public BoardsPanel(VideoCards videoCards, int idModulo) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        this.videoCards = videoCards;
        int cardsCount = videoCards.getCardCount();
        
        comboCombi = new HashMap[cardsCount];
        maxSources = 0;
        for (int i = 0; i < cardsCount; i++) {
            VideoCardModeOptions vcmo = CtrlProtocol.getInstance().loadVideoCardModeOptionsFromMV(idModulo, i);
            comboCombi[i] = new HashMap<String, DefaultComboBoxModel[]>();
            if (vcmo == null) {
                DefaultComboBoxModel[] dcbm = new DefaultComboBoxModel[4];
                for (int k = 0; k < 4; k++) {
                    dcbm[k] = new DefaultComboBoxModel();
                    dcbm[k].addElement("Source " + (k + 1));
                    dcbm[k].setSelectedItem("Source " + (k + 1));
                }
                comboCombi[i].put("Mode 1", dcbm);
                maxSources = dcbm.length;
            } else for (int j = 0; j < vcmo.getModeOptionCount(); j++) {
                DefaultComboBoxModel[] dcbm = new DefaultComboBoxModel[vcmo.getModeOption(j).getSourceInputOptionsCount()];
                if (dcbm.length > maxSources)
                    maxSources = dcbm.length;
                for (int k = 0; k < vcmo.getModeOption(j).getSourceInputOptionsCount(); k++) {
                    dcbm[k] = new DefaultComboBoxModel();
                    for (int n = 0; n < vcmo.getModeOption(j).getSourceInputOptions(k).getNameCount(); n++) {
                        dcbm[k].addElement(vcmo.getModeOption(j).getSourceInputOptions(k).getName(n).getVal());
                    }
                    dcbm[k].setSelectedItem(vcmo.getModeOption(j).getSourceInputOptions(k).getName(0).getVal());
                }
                comboCombi[i].put(vcmo.getModeOption(j).getVal(), dcbm);
            }
        }
        
        boardsLabel = new JLabel("Select board");
        boardsLabel.setFont(new Font("Arial",Font.BOLD,11));
        boardsLabel.setBounds(25, 15, 90, 20);
        add(boardsLabel);
        
        DefaultListModel boardsListModel = new DefaultListModel();
        for (int i = 0; i < cardsCount; i++) {
            boardsListModel.addElement(videoCards.getCard(i).getName().getVal());
        }
        
        boardsList = new JList(boardsListModel);
        boardsList.setSelectedIndex(0);
        boardsList.setFont(new Font("Arial", Font.BOLD, 11));
        boardsList.setBorder((BevelBorder)BorderFactory.createBevelBorder(1));
        
        boardsList.setBounds(20, 40, 340, 150);
        JScrollPane sp = new JScrollPane();
        sp.setOpaque(true);
        sp.getViewport().add(boardsList);
        sp.setBounds(20, 40, 340, 150);
        add(sp);
        
        cardConfigLabel = new JLabel("Card configuration");
        cardConfigLabel.setBounds(20, 210, 120, 20);
        add(cardConfigLabel);
        CardConfigActionListener ccal = new CardConfigActionListener();
        cardConfigCombo = new JComboBox[cardsCount];
        for (int i = 0; i < cardsCount; i++) {
            //cardConfigCombo[i] = ComponentFactory.createComboBox(videoCards.getCard(i).getCardMode().getOptionsName(), videoCards.getCard(i).getCardMode().getVal());
            cardConfigCombo[i] = new JComboBox(comboCombi[i].keySet().toArray());
            cardConfigCombo[i].setSelectedItem(videoCards.getCard(i).getCardMode().getVal());
            cardConfigCombo[i].addActionListener(ccal);
            cardConfigCombo[i].setBounds(160, 210, 200, 20);
            //cardConfigCombo[i].setFont(new Font("Arial", Font.BOLD, 10));
            cardConfigCombo[i].setVisible(false);
            add(cardConfigCombo[i]);
        }
        
        boolean showSources = (CtrlWorkspace.getInstance().getProductType(idModulo) != ProductType.ProductTypeAM);
        
        sourceLabel = new JLabel[maxSources];
        sourceCombo = new JComboBox[cardsCount][maxSources];
        int ypos = 260;
        for (int srcNum = 0; srcNum < maxSources; srcNum++) {
            sourceLabel[srcNum] = new JLabel("Source " + Integer.toString(srcNum + 1));
            sourceLabel[srcNum].setBounds(20, ypos, 120, 20);
            if (showSources)
                add(sourceLabel[srcNum]);
            for (int i = 0; i < cardsCount; i++) {
                DefaultComboBoxModel[] m = comboCombi[i].get(cardConfigCombo[i].getSelectedItem().toString());
                if (m.length > srcNum) {
                    sourceCombo[i][srcNum] = new JComboBox(m[srcNum]);
                    sourceCombo[i][srcNum].setSelectedItem(videoCards.getCard(i).getCardMode().getSourceInput(srcNum).getVal());
                } else {
                    sourceCombo[i][srcNum] = new JComboBox();
                }
                sourceCombo[i][srcNum].setBounds(160, ypos, 200, 20);
                sourceCombo[i][srcNum].setVisible(false);
                if (showSources)
                    add(sourceCombo[i][srcNum]);
            }
            ypos += 35;
        }
        
        if ( cardsCount > 0 ){
            cardConfigCombo[0].setVisible(true);
            for (int srcNum = 0; srcNum < maxSources; srcNum++) {
                sourceCombo[0][srcNum].setVisible(true);
            }
            boardsList.addListSelectionListener(new BoardsPanelListListener());
        }
        else{
            boardsListModel.addElement("NO BOARDS DETECTED");
            cardConfigLabel.setVisible(false);
            for (int srcNum = 0; srcNum < maxSources; srcNum++) {
                sourceLabel[srcNum].setVisible(false);
            }
        }
            
    }
    
    public void save() {
        int cardsCount = videoCards.getCardCount();
        for (int i = 0; i < cardsCount; i++) {
            CardMode currCardMode = videoCards.getCard(i).getCardMode();
            currCardMode.setVal(cardConfigCombo[i].getSelectedItem().toString());
            for (int srcNum = 0; srcNum < maxSources; srcNum++) {
                if (sourceCombo[i][srcNum].getItemCount() > 0)
                    currCardMode.getSourceInput(srcNum).setVal(sourceCombo[i][srcNum].getSelectedItem().toString());
            }
        }
        
    }
    
    public class BoardsPanelListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent listselectionevent) {
             int i = boardsList.getSelectedIndex();

             cardConfigCombo[lastIndex].setVisible(false);
             for (int srcNum = 0; srcNum < maxSources; srcNum++)
                 sourceCombo[lastIndex][srcNum].setVisible(false);

             cardConfigCombo[i].setVisible(true);
             for (int srcNum = 0; srcNum < maxSources; srcNum++) {
                 if (sourceCombo[i][srcNum].getItemCount() > 0) {
                     sourceCombo[i][srcNum].setVisible(true);
                     sourceLabel[i].setVisible(true);
                 } else {
                     sourceLabel[i].setVisible(false);
                 }
             }

             lastIndex = i;

             boardsList.repaint();
        }

        BoardsPanelListListener() {
            lastIndex = 0;
        }
        
        private int lastIndex;
    }
    
    private class CardConfigActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int i = boardsList.getSelectedIndex();
            JComboBox cb = (JComboBox)e.getSource();
            DefaultComboBoxModel[] dcbm = comboCombi[i].get(cb.getSelectedItem().toString());
            for (int srcNum = 0; srcNum < maxSources && srcNum < dcbm.length; srcNum++)
                sourceCombo[i][srcNum].setModel(dcbm[srcNum]);
        }
    }
}
