package dialogs.moduleproperties;

import bean.EmbAudioOut;
import bean.Aout;
import eccezioni.MVException;

/**
 * @author Marco Ricci & Antonio Poggi
 */
public class EmbeddedAudioMonitorPanel extends AudioOutputPanelGeneric {
    
    private EmbAudioOut bean;

    public EmbeddedAudioMonitorPanel(EmbAudioOut bean, int idModulo) throws MVException {
        this.bean = bean;
        init(idModulo);
    }
    
    @Override public void save() {
        for (int i=0; i<numOutputs; i++) {
            Aout audioOutput = bean.getAout(i);
            audioOutput.setSource(sourceComboToMv(audioOutput.getId()));
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
