package controllori;

import bean.ModuleValid;
import bean.Objects;
import bean.ObjectsZOrder;

public class UndoBuffer {

    private static final int SIZE = 4;
    private Objects objects;
    private ObjectsZOrder objectsZOrder;
    private ModuleValid moduleValid;
    private UndoBuffer previous;
    private UndoBuffer next;

    public UndoBuffer() {
        objects = null;
        objectsZOrder = null;
        moduleValid = null;
        previous = null;
        next = null;
    }

    public UndoBuffer getPrevious() {
        return previous;
    }
    
    public UndoBuffer getNext() {
        return next;
    }
    
    public Objects getObjects() {
        if (objects != null) 
            return objects;
        else if (previous!=null)
            return previous.getObjects();
        else
            return null;
        
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    public ObjectsZOrder getObjectsZOrder() {
        if (objectsZOrder != null)
            return objectsZOrder;
        else if (previous!=null)
            return previous.getObjectsZOrder();
        else
            return null;
    }

    public void setObjectsZOrder(ObjectsZOrder objectsZOrder) {
        this.objectsZOrder = objectsZOrder;
    }
    
    public ModuleValid getModuleValid() {
        if (moduleValid != null)
            return moduleValid;
        else if (previous!=null)
            return previous.getModuleValid();
        else
            return null;
    }

    public void setModuleValid(ModuleValid moduleValid) {
        this.moduleValid = moduleValid;
    }
    
    

    private int getIndex() {
        if (isFirst()) {
            return 0;
        } else {
            return previous.getIndex() + 1;
        }
    }

    public boolean isFirst() {
        return previous == null;
    }

    public boolean isLast() {
        return next == null;
    }

    private void removeFirst() {
        if (isFirst()) {
            
            if (next.objects==null)
                next.objects=this.objects;
            
            if (next.objectsZOrder==null)
                next.objectsZOrder=this.objectsZOrder;
            
            if (next.moduleValid==null)
                next.moduleValid=this.moduleValid;
            
            next.previous = null;
            next = null;
        } else {
            previous.removeFirst();
        }
    }

    private void removeLast() {
        if (isLast()) {
            previous.next = null;
            previous = null;
        } else {
            next.removeLast();
        }
    }

    public void add(UndoBuffer undobuffer) {
        while (!isLast()) {
            removeLast();
        }

        next = undobuffer;
        undobuffer.previous = this;

        if (undobuffer.getIndex() == SIZE) {
            removeFirst();
        }
    }
}
