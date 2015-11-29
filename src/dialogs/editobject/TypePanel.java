package dialogs.editobject;

import bean.AspectDefault;
import bean.Oggetto;
import bean.Position;
import dialogs.editobject.EditObjectDialog.TypeListener;
import eccezioni.MVException;
import gui.ComponentFactory;
import gui.CtrlActions;
import gui.TilesWorkspace;
import gui.components.JCheckBoxTransBG;
import gui.components.JPanelBGGradient;
import gui.components.VGroupLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllori.CtrlWorkspace;
import controllori.ProductType;

/**
 *
 * @author Er Principe da'a Marana
 */
public class TypePanel extends JPanelBGGradient{
    private Oggetto bean;
    private AspectListener aL;
    
    private JLabel typeLabel;
    private JComboBox typeCombo;
        
    private JLabel nameLabel;
    private JTextField nameField;
    
    private JLabel xLabel;
    private JTextField xField;
        
    private JLabel yLabel;
    private JTextField yField;
        
    private JLabel widthLabel;
    private JTextField widthField;
        
    private JLabel heightLabel;
    private JTextField heightField;

    private JLabel tileAspectLabel;
    private JComboBox tileAspectCombo;
    
    private JLabel videoAspectLabel;
    private JComboBox videoAspectCombo;
    private static final String videoAspectSdHdString = "4:3 for SD, 16:9 for HD";
    private int videoAspectSdHdIndex;
    
    private int extLeft;
    private int extRight;
    private int extTop;
    private int extBottom;
    
    private JCheckBoxTransBG tileAspectBasedOnVideo;
    
    public TypePanel(Oggetto bean, int modulo) throws MVException {
        
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        aL = new AspectListener();
        
        typeLabel = new JLabel("Type");
        typeCombo = ComponentFactory.createComboBox(bean.getType().getOptionsName(), bean.getType().getVal() );
        if (CtrlWorkspace.getInstance().getProductType(modulo) == ProductType.ProductTypeAM)
            typeCombo.removeItem("Video");
            
        nameLabel = new JLabel("Name");
        nameField = ComponentFactory.createTextField(bean.getUsername().getVal(), 40);
        
        Position pos = bean.getPosition();
        xLabel = new JLabel("X Position");
        xField = ComponentFactory.createTextField(pos.getX().getVal());
        yLabel = new JLabel("Y Position");
        yField = ComponentFactory.createTextField(pos.getY().getVal());
        
        widthLabel = new JLabel("Width");
        widthField = ComponentFactory.createTextField(pos.getWidth().getVal(), pos.getWidth().getMin(), pos.getWidth().getMax());
        widthField.addActionListener(aL);
        widthField.addFocusListener(aL);
        //TODO: vedi Multiviewer-UI-Description, sezione 7.1.1.3 (pag.35), paragrafo Behaviour
        heightLabel = new JLabel("Height");
        heightField = ComponentFactory.createTextField(pos.getHeight().getVal(), pos.getHeight().getMin(), pos.getHeight().getMax());

        tileAspectLabel = new JLabel("Tile Aspect Ratio");
        tileAspectCombo = ComponentFactory.createComboBox(bean.getAspectRatio().getOptionsName(), bean.getAspectRatio().getVal());  
        tileAspectCombo.addItemListener(aL);
        extLeft = bean.getAspectRatio().getExtLeft();
        extRight = bean.getAspectRatio().getExtRight();
        extTop = bean.getAspectRatio().getExtTop();
        extBottom = bean.getAspectRatio().getExtBottom();
        
        videoAspectLabel = new JLabel("Video Aspect Ratio");
        AspectDefault vidAspect = bean.getObjectSequence().getVideoProperties().getWss().getAspectDefault();
        videoAspectCombo = ComponentFactory.createComboBox(vidAspect.getOptionsName(), vidAspect.getVal());
        String hdValStr = vidAspect.getHdVal();
        if (hdValStr != null && !hdValStr.isEmpty()) {
            videoAspectCombo.addItem(videoAspectSdHdString);
            videoAspectSdHdIndex = videoAspectCombo.getItemCount() - 1;
            if (hdValStr.compareTo("16:9") == 0 && vidAspect.getVal().compareTo("4:3") == 0)
                videoAspectCombo.setSelectedIndex(videoAspectSdHdIndex);
        }
        videoAspectCombo.addItemListener(aL);
        
        tileAspectBasedOnVideo = new JCheckBoxTransBG("Adjust tile dimensions based on the video aspect ratio");
        tileAspectBasedOnVideo.setSelected(bean.getAspectRatio().getUseVideo());
        tileAspectBasedOnVideo.addItemListener(aL);
        
        layout.addGrid(new Component[][] {
                {typeLabel, typeCombo},
                {null, null},   // adds an extra gap
                {nameLabel, nameField},
                {null, null},   // adds an extra gap
        });
        layout.addGrid(new Component[][] {
                {xLabel, xField, yLabel, yField},
                {widthLabel, widthField, heightLabel, heightField} 
        });
        layout.addGap();
        layout.add(tileAspectBasedOnVideo);
        layout.addGrid(new Component[][] {
                {tileAspectLabel, tileAspectCombo},
                {videoAspectLabel, videoAspectCombo}
        });
        
        updateHeight();
    }
    
    public void save() {
        try {
            bean.getType().setVal(typeCombo.getSelectedItem().toString());
        } catch(NullPointerException npe) {
            
        }
        bean.getUsername().setVal(nameField.getText());
        bean.getPosition().getX().setVal(Integer.parseInt(xField.getText()));
        bean.getPosition().getY().setVal(Integer.parseInt(yField.getText()));
        bean.getPosition().getHeight().setVal(Integer.parseInt(heightField.getText()));
        bean.getPosition().getWidth().setVal(Integer.parseInt(widthField.getText()));
        bean.getAspectRatio().setVal(tileAspectCombo.getSelectedItem().toString());
        bean.getAspectRatio().setUseVideo(tileAspectBasedOnVideo.isSelected());
        AspectDefault vidAspect = bean.getObjectSequence().getVideoProperties().getWss().getAspectDefault();
        if (videoAspectSdHdIndex == 0 || videoAspectCombo.getSelectedIndex() < videoAspectSdHdIndex) {
            vidAspect.setVal(videoAspectCombo.getSelectedItem().toString());
            vidAspect.setHdVal(videoAspectCombo.getSelectedItem().toString());
        } else {
            vidAspect.setVal("4:3");
            vidAspect.setHdVal("16:9");
        }
    }
    
    public void setTypeListener(TypeListener tL) {
        typeCombo.addActionListener(tL);
        typeCombo.setSelectedItem(typeCombo.getSelectedItem());
    }
    
    /**
     * setTypeChanged - needs to be called back from the TypeListener
     */
    public void setTypeChanged() {
        updateHeight();
        if (typeCombo.getSelectedItem().toString().equals("Video")) {
            tileAspectBasedOnVideo.setVisible(true);
            videoAspectLabel.setVisible(true);
            videoAspectCombo.setVisible(true);
            tileAspectCombo.setEnabled(!tileAspectBasedOnVideo.isSelected() || !tileAspectBasedOnVideo.isEnabled());
            tileAspectLabel.setEnabled(!tileAspectBasedOnVideo.isSelected() || !tileAspectBasedOnVideo.isEnabled());
        } else {
            tileAspectBasedOnVideo.setVisible(false);
            videoAspectLabel.setVisible(false);
            videoAspectCombo.setVisible(false);
            tileAspectCombo.setEnabled(true);
            tileAspectLabel.setEnabled(true);
        }
    }
    
    public JComboBox getVideoAspectRatioCombo() {
        return videoAspectCombo;
    }
    
    private void updateHeight()
    {
        Dimension tar = aspectRatioStringToDimension(tileAspectCombo.getSelectedItem().toString());
        Dimension var = aspectRatioStringToDimension(videoAspectCombo.getSelectedItem().toString());
        boolean isVideoTile = "Video".equals(typeCombo.getSelectedItem().toString());
        boolean isAspectLocked;
        boolean isAspectLockedToVideo;
        if (isVideoTile && tileAspectBasedOnVideo.isSelected()) {
            isAspectLocked = var.width > 0;
            isAspectLockedToVideo = var.width > 0;
        } else {
            isAspectLocked = tar.width > 0;
            isAspectLockedToVideo = false;
        }
        
        heightField.setEnabled(!isAspectLocked);
        heightLabel.setEnabled(!isAspectLocked);
        tileAspectBasedOnVideo.setEnabled(var.width > 0);
        tileAspectCombo.setEnabled(!tileAspectBasedOnVideo.isSelected() || !tileAspectBasedOnVideo.isEnabled());
        tileAspectLabel.setEnabled(!tileAspectBasedOnVideo.isSelected() || !tileAspectBasedOnVideo.isEnabled());
        
        if (isAspectLocked) {
            int width = Integer.parseInt(widthField.getText());
            int height=0;
            CtrlActions ctrlActions = CtrlActions.getInstance();
            int screenHeight = ctrlActions.getTilesWorkspace().getMvVres();
            int ypos = Integer.parseInt(yField.getText());

            if (isAspectLockedToVideo) {
                int videoWidth = width - extLeft - extRight;
                int videoHeight = videoWidth * var.height / var.width;
                height = videoHeight + extTop + extBottom;
                if (TilesWorkspace.MIN_TILE_SIZE <= height && height <= screenHeight - ypos) {
                    // height is OK
                } else {
                    if (height < TilesWorkspace.MIN_TILE_SIZE) {
                        height = TilesWorkspace.MIN_TILE_SIZE;
                    } else {
                        height = screenHeight - ypos;
                    }
                    videoHeight = height - extTop - extBottom;
                    videoWidth = videoHeight * var.width / var.height;
                    width = videoWidth + extLeft + extRight;
                    if (width < 1) {
                        width = 1;
                    }
                    widthField.setText("" + width);
                }
                heightField.setText("" + height);
            } else {
                height = width * tar.height / tar.width;
                if (TilesWorkspace.MIN_TILE_SIZE <= height && height <= screenHeight - ypos) {
                    // height is OK
                } else {
                    if (height < TilesWorkspace.MIN_TILE_SIZE) {
                        height = TilesWorkspace.MIN_TILE_SIZE;
                    } else {
                        height = screenHeight - ypos;
                    }
                    width = height * tar.width / tar.height;
                    widthField.setText("" + width);
                }
                heightField.setText("" + height);
            }
        }
    }
    
    private Dimension aspectRatioStringToDimension(final String s) {
        Dimension d = new Dimension(-1, -1);
        
        try {
            int pos = s.indexOf(':');
            if (pos > 0 && pos < s.length() - 1) {
                String substr = s.substring(0, pos);
                d.width = Integer.valueOf(substr);
                substr = s.substring(pos + 1, s.length());
                d.height = Integer.valueOf(substr);
                if (d.width <= 0 || d.height <= 0) {
                    d.width = -1;
                    d.height = -1;
                }
            }
        } catch(Exception e) {
            d.width = -1;
            d.height = -1;
        }
        
        return d;
    }

    
    class AspectListener implements ItemListener, ActionListener, FocusListener
    {

        public void itemStateChanged(ItemEvent itemevent)
        {
            if (itemevent.getSource() == tileAspectBasedOnVideo) {
                // enable / disable tile aspect ratio setting
                setTypeChanged();
            }
            updateHeight();
        }

        public void actionPerformed(ActionEvent actionevent)
        {
            updateHeight();
        }

        public void focusLost(FocusEvent focusevent)
        {
            updateHeight();
        }

        public void focusGained(FocusEvent focusevent)
        {
            updateHeight();
        }

        AspectListener()
        {
        }
    }

}
