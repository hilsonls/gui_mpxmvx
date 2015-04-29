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
    
    private JLabel source1Label;
    private JComboBox[] source1Combo;
    
    private JLabel source2Label;
    private JComboBox[] source2Combo;
    
    private JLabel source3Label;
    private JComboBox[] source3Combo;
    
    private JLabel source4Label;
    private JComboBox[] source4Combo;
    
            
    public BoardsPanel(VideoCards videoCards, int idModulo) throws MVException {
        setLayout(null);
        setBounds(1, 30, 400, 400);
        
        this.videoCards = videoCards;
        int cardsCount = videoCards.getCardCount();
        
        comboCombi = new HashMap[cardsCount];
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
            } else for (int j = 0; j < vcmo.getModeOptionCount(); j++) {
                DefaultComboBoxModel[] dcbm = new DefaultComboBoxModel[vcmo.getModeOption(j).getSourceInputOptionsCount()];
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
        
        source1Label = new JLabel("Source 1");
        source1Label.setBounds(20, 260, 120, 20);
        if (showSources)
            add(source1Label);
        source1Combo = new JComboBox[cardsCount];
        for (int i = 0; i < cardsCount; i++) {
            //source1Combo[i] = ComponentFactory.createComboBox(videoCards.getCard(i).getCardMode().getSourceInput(0).getOptionsList(), videoCards.getCard(i).getCardMode().getSourceInput(0).getVal());
            source1Combo[i] = new JComboBox(comboCombi[i].get(cardConfigCombo[i].getSelectedItem().toString())[0]);
            source1Combo[i].setSelectedItem(videoCards.getCard(i).getCardMode().getSourceInput(0).getVal());
            source1Combo[i].setBounds(160, 260, 200, 20);
            source1Combo[i].setVisible(false);
            if (showSources)
                add(source1Combo[i]);
        }
        
        
        source2Label = new JLabel("Source 2");
        source2Label.setBounds(20, 300, 120, 20);
        if (showSources)
            add(source2Label);
        source2Combo = new JComboBox[cardsCount];
        for (int i = 0; i < cardsCount; i++) {
            //source2Combo[i] = ComponentFactory.createComboBox(videoCards.getCard(i).getCardMode().getSourceInput(1).getOptionsList(), videoCards.getCard(i).getCardMode().getSourceInput(1).getVal());
            source2Combo[i] = new JComboBox(comboCombi[i].get(cardConfigCombo[i].getSelectedItem().toString())[1]);
            source2Combo[i].setSelectedItem(videoCards.getCard(i).getCardMode().getSourceInput(1).getVal());
            source2Combo[i].setBounds(160, 300, 200, 20);
            source2Combo[i].setVisible(false);
            if (showSources)
                add(source2Combo[i]);
        }
        
        
        source3Label = new JLabel("Source 3");
        source3Label.setBounds(20, 340, 120, 20);
        if (showSources)
            add(source3Label);
        source3Combo = new JComboBox[cardsCount];
        for (int i = 0; i < cardsCount; i++) {
            //source3Combo[i] = ComponentFactory.createComboBox(videoCards.getCard(i).getCardMode().getSourceInput(2).getOptionsList(), videoCards.getCard(i).getCardMode().getSourceInput(2).getVal());
            source3Combo[i] = new JComboBox(comboCombi[i].get(cardConfigCombo[i].getSelectedItem().toString())[2]);
            source3Combo[i].setSelectedItem(videoCards.getCard(i).getCardMode().getSourceInput(2).getVal());
            source3Combo[i].setBounds(160, 340, 200, 20);
            source3Combo[i].setVisible(false);
            if (showSources)
                add(source3Combo[i]);
        }
        
        
        source4Label = new JLabel("Source 4");
        source4Label.setBounds(20, 380, 120, 20);
        if (showSources)
            add(source4Label);
        source4Combo = new JComboBox[cardsCount];
        for (int i = 0; i < cardsCount; i++) {
            //source4Combo[i] = ComponentFactory.createComboBox(videoCards.getCard(i).getCardMode().getSourceInput(3).getOptionsList(), videoCards.getCard(i).getCardMode().getSourceInput(3).getVal());
            source4Combo[i] = new JComboBox(comboCombi[i].get(cardConfigCombo[i].getSelectedItem().toString())[3]);
            source4Combo[i].setSelectedItem(videoCards.getCard(i).getCardMode().getSourceInput(3).getVal());
            source4Combo[i].setBounds(160, 380, 200, 20);
            source4Combo[i].setVisible(false);
            if (showSources)
                add(source4Combo[i]);
        }
        
        if ( cardsCount > 0 ){
            cardConfigCombo[0].setVisible(true);
            source1Combo[0].setVisible(true);
            source2Combo[0].setVisible(true);
            source3Combo[0].setVisible(true);
            source4Combo[0].setVisible(true);
            boardsList.addListSelectionListener(new BoardsPanelListListener());
        }
        else{
            boardsListModel.addElement("NO BOARDS DETECTED");
            cardConfigLabel.setVisible(false);
            source1Label.setVisible(false);
            source2Label.setVisible(false);
            source3Label.setVisible(false);
            source4Label.setVisible(false);
        }
            
    }
    
    public void save() {
        int cardsCount = videoCards.getCardCount();
        for (int i = 0; i < cardsCount; i++) {
            CardMode currCardMode = videoCards.getCard(i).getCardMode();
            currCardMode.setVal(cardConfigCombo[i].getSelectedItem().toString());
            currCardMode.getSourceInput(0).setVal(source1Combo[i].getSelectedItem().toString());
            currCardMode.getSourceInput(1).setVal(source2Combo[i].getSelectedItem().toString());
            currCardMode.getSourceInput(2).setVal(source3Combo[i].getSelectedItem().toString());
            currCardMode.getSourceInput(3).setVal(source4Combo[i].getSelectedItem().toString());
        }
        
    }
    
    public class BoardsPanelListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent listselectionevent) {
             int i = boardsList.getSelectedIndex();

             cardConfigCombo[lastIndex].setVisible(false);
             source1Combo[lastIndex].setVisible(false);
             source2Combo[lastIndex].setVisible(false);
             source3Combo[lastIndex].setVisible(false);
             source4Combo[lastIndex].setVisible(false);

             cardConfigCombo[i].setVisible(true);
             source1Combo[i].setVisible(true);
             source2Combo[i].setVisible(true);
             source3Combo[i].setVisible(true);
             source4Combo[i].setVisible(true);

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
            source1Combo[i].setModel(dcbm[0]);
            source2Combo[i].setModel(dcbm[1]);
            source3Combo[i].setModel(dcbm[2]);
            source4Combo[i].setModel(dcbm[3]);
        }
    }
}
