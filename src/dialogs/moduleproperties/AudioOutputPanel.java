package dialogs.moduleproperties;

import bean.Aout;
import bean.AudioOut;
import eccezioni.MVException;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class AudioOutputPanel extends AudioOutputPanelGeneric{

    private AudioOut bean;
    
    public AudioOutputPanel(AudioOut bean) throws MVException {
        this.bean = bean;
        init();
    }

    @Override public void save() {
        for (int i=0; i<numOutputs; i++) {
            Aout audioOutput = bean.getAout(i);
            audioOutput.setSource(sourceCombo[audioOutput.getId()].getSelectedIndex());
            audioOutput.setPair(pairCombo[audioOutput.getId()].getSelectedIndex() - 1);
        }
    }
    
    @Override protected int getAoutCount() {
        return bean.getAoutCount();
    }
    
    @Override protected int getAoutId(int i) {
        return bean.getAout(i).getId();
    }

    @Override protected int getAoutSource(int i) {
        return bean.getAout(i).getSource();
    }

    @Override protected int getAoutPair(int i) {
        return bean.getAout(i).getPair();
    }
}
