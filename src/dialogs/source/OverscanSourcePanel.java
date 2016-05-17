

package dialogs.source;

import bean.Source;
import gui.components.JPanelBGGradient;
import gui.components.JSliderPanel;
import gui.components.VGroupLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;

public class OverscanSourcePanel extends JPanelBGGradient{
    private Source bean;

    private static final int OVERSCAN_SCALING = 10;
    
    private JPanel overscanImagePanel;
    private JLabel normalLabel;
    private JLabel overscanLabel;
    
    private JCheckBox overscanSameCheck;
    
    private JLabel leftLabel;
    private JSliderPanel leftSlider;
    private JLabel leftPercentLabel;
    private JLabel widthLabel;
    private JSliderPanel widthSlider;
    private JLabel widthPercentLabel;
    private JLabel topLabel;
    private JSliderPanel topSlider;
    private JLabel topPercentLabel;
    private JLabel heightLabel;
    private JSliderPanel heightSlider;
    private JLabel heightPercentLabel;
    private JLabel overscanMsgLabel;
    
    public OverscanSourcePanel(Source bean) {
        VGroupLayout layout = new VGroupLayout(this);
        setLayout(layout);
        
        this.bean = bean;
        
        OverscanListener overscanListener = new OverscanListener();
        
        overscanImagePanel = new JPanel();
        overscanImagePanel.setLayout(null);
        overscanImagePanel.setOpaque(false);
        overscanImagePanel.setSize(200 * 16 / 9, 200);
        overscanImagePanel.setMinimumSize(overscanImagePanel.getSize());
        overscanImagePanel.setPreferredSize(overscanImagePanel.getSize());
        overscanImagePanel.setMaximumSize(overscanImagePanel.getSize());
        
        normalLabel = new JLabel("Full image");
        normalLabel.setBounds(0, 0, overscanImagePanel.getWidth(), overscanImagePanel.getHeight());
        normalLabel.setVerticalAlignment(JLabel.TOP);
        normalLabel.setForeground(Color.YELLOW);
        normalLabel.setBackground(Color.BLUE);
        normalLabel.setOpaque(true);
        overscanImagePanel.add(normalLabel);
        overscanLabel = new JLabel("Overscan region");
        overscanLabel.setBounds(0, 0, overscanImagePanel.getWidth(), overscanImagePanel.getHeight());
        overscanLabel.setVerticalAlignment(JLabel.TOP);
        overscanLabel.setForeground(Color.YELLOW);
        overscanLabel.setBackground(Color.GRAY);
        overscanLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
        overscanLabel.setOpaque(true);
        normalLabel.add(overscanLabel);
        
        overscanSameCheck = new JCheckBox("Overscan by the same amount on all edges");
        overscanSameCheck.setSelected(
                bean.getOverscanRect().getLeft() == bean.getOverscanRect().getTop()
                && bean.getOverscanRect().getLeft() * 2 == 100 * OVERSCAN_SCALING - bean.getOverscanRect().getWidth()
                && bean.getOverscanRect().getLeft() * 2 == 100 * OVERSCAN_SCALING - bean.getOverscanRect().getHeight());
        overscanSameCheck.setOpaque(false);
        
        leftLabel = new JLabel("Left");
        leftSlider = new JSliderPanel(1);
        leftSlider.setRange(0, 100);
        leftSlider.setStringValue(Double.toString((double)bean.getOverscanRect().getLeft() / (double)OVERSCAN_SCALING));
        leftPercentLabel = new JLabel("%");
        widthLabel = new JLabel("Width");
        widthSlider = new JSliderPanel(1);
        widthSlider.setRange(0, 100);
        widthSlider.setStringValue(Double.toString((double)bean.getOverscanRect().getWidth() / (double)OVERSCAN_SCALING));
        widthPercentLabel = new JLabel("%");
        topLabel = new JLabel("Top");
        topSlider = new JSliderPanel(1);
        topSlider.setRange(0, 100);
        topSlider.setStringValue(Double.toString((double)bean.getOverscanRect().getTop() / (double)OVERSCAN_SCALING));
        topPercentLabel = new JLabel("%");
        heightLabel = new JLabel("Height");
        heightSlider = new JSliderPanel(1);
        heightSlider.setRange(0, 100);
        heightSlider.setStringValue(Double.toString((double)bean.getOverscanRect().getHeight() / (double)OVERSCAN_SCALING));
        heightPercentLabel = new JLabel("%");
        
        overscanMsgLabel = new JLabel("<html><i>Note: Overscan needs to be ticked in the properties of the tile showing this source for these settings to apply</i></html>");

        layout.add(overscanImagePanel);
        layout.add(overscanSameCheck);
        layout.addGrid(new Component[][] {
                {leftLabel, leftSlider, leftPercentLabel},
                {widthLabel, widthSlider, widthPercentLabel},
                {topLabel, topSlider, topPercentLabel},
                {heightLabel, heightSlider, heightPercentLabel},
        });
        layout.add(overscanMsgLabel);
        
        if (overscanSameCheck.isSelected())
            handleSameCheck();

        leftSlider.addChangeListener(overscanListener);
        widthSlider.addChangeListener(overscanListener);
        topSlider.addChangeListener(overscanListener);
        heightSlider.addChangeListener(overscanListener);
        overscanSameCheck.addChangeListener(overscanListener);

        checkOverscanRect();
        updateImagePanel();
    }
    
    public void save() {
        save(null);
    }
    
    public void save(Source bean) {
        if (bean==null)
            bean = this.bean;
        bean.getOverscanRect().setLeft(leftSlider.getValue());
        bean.getOverscanRect().setWidth(widthSlider.getValue());
        bean.getOverscanRect().setTop(topSlider.getValue());
        bean.getOverscanRect().setHeight(heightSlider.getValue());
    }
    
    private void checkOverscanRect() {
        Rectangle overscanRect;
        if (!overscanSameCheck.isSelected()) {
            overscanRect = new Rectangle(leftSlider.getValue(), topSlider.getValue(), widthSlider.getValue(), heightSlider.getValue());
        } else {
            int c = leftSlider.getValue();
            if (c < 0)
                c = 0;
            else if (c > 45 * OVERSCAN_SCALING)
                c = 45 * OVERSCAN_SCALING;
            overscanRect = new Rectangle(c, c, 100 * OVERSCAN_SCALING - c * 2, 100 * OVERSCAN_SCALING - c * 2);
        }
        Rectangle origRect = new Rectangle(overscanRect);
        if (overscanRect.x < 0)
            overscanRect.x = 0;
        else if (overscanRect.x > 90 * OVERSCAN_SCALING)
            overscanRect.x = 90 * OVERSCAN_SCALING;
        if (overscanRect.width < 10 * OVERSCAN_SCALING)
            overscanRect.width = 10 * OVERSCAN_SCALING;
        else if ((overscanRect.x + overscanRect.width) > 100 * OVERSCAN_SCALING)
            overscanRect.width = 100 * OVERSCAN_SCALING - overscanRect.x;
        double maxWidth = 100.0 - (double)overscanRect.x / (double)OVERSCAN_SCALING;
        
        if (overscanRect.y < 0)
            overscanRect.y = 0;
        else if (overscanRect.y > 90 * OVERSCAN_SCALING)
            overscanRect.y = 90 * OVERSCAN_SCALING;
        if (overscanRect.height < 10 * OVERSCAN_SCALING)
            overscanRect.height = 10 * OVERSCAN_SCALING;
        else if ((overscanRect.y + overscanRect.height) > 100 * OVERSCAN_SCALING)
            overscanRect.height = 100 * OVERSCAN_SCALING - overscanRect.y;
        double maxHeight = 100.0 - (double)overscanRect.y / (double)OVERSCAN_SCALING;
        
        if (!overscanRect.equals(origRect)
                || maxWidth != widthSlider.getMaximum()
                || maxHeight != heightSlider.getMaximum()) {
            widthSlider.setDoubleMaximum(maxWidth);
            heightSlider.setDoubleMaximum(maxHeight);
            leftSlider.setValue(overscanRect.getX() / (double)OVERSCAN_SCALING);
            topSlider.setValue(overscanRect.getY() / (double)OVERSCAN_SCALING);
            widthSlider.setValue(overscanRect.getWidth() / (double)OVERSCAN_SCALING);
            heightSlider.setValue(overscanRect.getHeight() / (double)OVERSCAN_SCALING);
        }
    }
    
    private void updateImagePanel() {
        int normWidth = normalLabel.getWidth();
        int normHeight = normalLabel.getHeight();
        Rectangle overscanRect = new Rectangle(
                leftSlider.getValue() * normWidth / 100 / OVERSCAN_SCALING,
                topSlider.getValue() * normHeight / 100 / OVERSCAN_SCALING,
                (widthSlider.getValue() + OVERSCAN_SCALING / 2) * normWidth / 100 / OVERSCAN_SCALING,
                (heightSlider.getValue() + OVERSCAN_SCALING / 2) * normHeight / 100 / OVERSCAN_SCALING);
        if (overscanRect.x + overscanRect.width > normWidth)
            overscanRect.width = normWidth - overscanRect.x;
        if (overscanRect.y + overscanRect.height > normHeight)
            overscanRect.height = normHeight - overscanRect.y;
        
        overscanLabel.setBounds(overscanRect);
    }
    
    private void handleSameCheck() {
        boolean same = overscanSameCheck.isSelected();
        if (same) {
            leftLabel.setText("Overscan");
            leftSlider.setMaximum(50);
        } else {
            leftLabel.setText("Left");
            leftSlider.setMaximum(100);
        }
        widthLabel.setVisible(!same);
        widthSlider.setVisible(!same);
        widthPercentLabel.setVisible(!same);
        topLabel.setVisible(!same);
        topSlider.setVisible(!same);
        topPercentLabel.setVisible(!same);
        heightLabel.setVisible(!same);
        heightSlider.setVisible(!same);
        heightPercentLabel.setVisible(!same);
    }
    
    private class OverscanListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            Object obj = e.getSource();
            if (obj == leftSlider || obj == topSlider || obj == widthSlider || obj == heightSlider)
                checkOverscanRect();
            else if (obj == overscanSameCheck)
                handleSameCheck();
            updateImagePanel();
        }
        
    }
}
