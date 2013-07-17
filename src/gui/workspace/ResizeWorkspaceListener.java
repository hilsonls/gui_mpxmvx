
package gui.workspace;

import gui.CtrlActions;
import gui.TilesWorkspace;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 *
 * @author Germano Mosconi
 */
public class ResizeWorkspaceListener implements ComponentListener {

        private TilesWorkspace tilesWorkspace;

        public void componentHidden(ComponentEvent componentevent)
        {
            tilesWorkspace.handleResize();
        }

        public void componentMoved(ComponentEvent componentevent)
        {
            tilesWorkspace.handleResize();
        }

        public void componentResized(ComponentEvent componentevent)
        {
            tilesWorkspace.handleResize();
        }

        public void componentShown(ComponentEvent componentevent)
        {
            tilesWorkspace.handleResize();
        }

        public ResizeWorkspaceListener(TilesWorkspace tilesWorkspace)
        {
            this.tilesWorkspace = tilesWorkspace;
        }
    }