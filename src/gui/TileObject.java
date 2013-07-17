package gui;

import bean.AspectRatio;
import eccezioni.MVException;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import bean.Oggetto;
import bean.Source;
import controllori.CtrlProtocol;
import controllori.CtrlWorkspace;
import gui.style.StyleInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TileObject {

    private Oggetto bean;
    private TilesWorkspace tilesWorkspace;
    private long x;
    private long y;
    private long width;
    private long height;
    private long extX;
    private long extY;
    private String aspectRatio;
    private Color bgColor;
    private Color fgColor;
    private int parentId;
    private int parentAnchorId;
    private int offsetX;
    private int offsetY;
    private boolean parentLockRatio;
    private double parentLockRatioX;
    private double parentLockRatioY;
    private boolean valid;

    public TileObject(TilesWorkspace tilesWorkspace, Oggetto bean) {

        this.tilesWorkspace = tilesWorkspace;

        loadFromBean(bean);
        //colore del testo
        fgColor = StyleInterface.getInstance().getTileForegroundColor();
        //colore sfondo tile
        bgColor = StyleInterface.getInstance().getTileBackgroundColor(getItemType());

    }

    //TODO: forse andrebbe messo dentro ai set width e height
    public void updateAspectRatio() {
        if (getAspectRatio().startsWith("4:3")) {
            long altezza = tilesWorkspace.mvScreenToVirtualY((tilesWorkspace.virtualToMVScreenX(width) * 3) / 4);
            if (altezza < tilesWorkspace.mvScreenToVirtualY(TilesWorkspace.MIN_TILE_SIZE)) {
                altezza = tilesWorkspace.mvScreenToVirtualY(TilesWorkspace.MIN_TILE_SIZE);
            }
            setHeight((int) altezza);
        } else if (getAspectRatio().startsWith("16:9")) {
            long altezza = tilesWorkspace.mvScreenToVirtualY((tilesWorkspace.virtualToMVScreenX(width) * 9) / 16);
            if (altezza < tilesWorkspace.mvScreenToVirtualY(TilesWorkspace.MIN_TILE_SIZE)) {
                altezza = tilesWorkspace.mvScreenToVirtualY(TilesWorkspace.MIN_TILE_SIZE);
            }
            setHeight((int) altezza);
        }
    }



    public void reloadFromBean() {
        if (getBean() != null) {
            loadFromBean(getBean());
        }
    }

    public void loadFromBean(Oggetto bean) {
        this.bean = bean;

        parentId = bean.getParent().getObjid();
        parentAnchorId = bean.getParent().getAnchorPoint().getIntval();
        offsetX = bean.getParent().getXoffs().getVal();
        offsetY = bean.getParent().getYoffs().getVal();
        parentLockRatio = bean.getParent().getLockSizeRatio().getVal();

        aspectRatio = bean.getAspectRatio().getVal();
        extX = tilesWorkspace.mvScreenToVirtualX(bean.getAspectRatio().getExtX());
        extY = tilesWorkspace.mvScreenToVirtualY(bean.getAspectRatio().getExtY());
        
        setX(tilesWorkspace.mvScreenToVirtualX(bean.getPosition().getX().getVal()));
        setY(tilesWorkspace.mvScreenToVirtualY(bean.getPosition().getY().getVal()));
        setWidth(tilesWorkspace.mvScreenToVirtualX(bean.getPosition().getWidth().getVal()));
        setHeight(tilesWorkspace.mvScreenToVirtualY(bean.getPosition().getHeight().getVal()));
        initParenting();

        valid = bean.getValid().getVal();

        bgColor = StyleInterface.getInstance().getTileBackgroundColor(getItemType());
    }

    public void saveToBean() {

        getBean().getParent().setObjid(getParentId());
        getBean().getParent().getAnchorPoint().setIntval(getParentAnchorId());
        getBean().getParent().getXoffs().setVal(offsetX);
        getBean().getParent().getYoffs().setVal(offsetY);
        getBean().getParent().getLockSizeRatio().setVal(parentLockRatio);

        getBean().getUsername().setVal(getItemName());
        getBean().getType().setVal(getItemType());
        getBean().getAspectRatio().setVal(getAspectRatio());

        //TODO: PANDA DICE: bisogna sistemare i meccanismi di conversione delle coordinate
        getBean().getPosition().getX().setVal((int) tilesWorkspace.virtualToMVScreenX(getX()));
        getBean().getPosition().getY().setVal((int) tilesWorkspace.virtualToMVScreenY(getY()));
        getBean().getPosition().getWidth().setVal((int) tilesWorkspace.virtualToMVScreenX(width));
        getBean().getPosition().getHeight().setVal((int) tilesWorkspace.virtualToMVScreenY(height));

        getBean().getValid().setVal(isValid());
    }

    public void initParenting() {
        TileObject tileObject = tilesWorkspace.getParent(this.getParentId());
        if (tileObject != null) {
            this.parentLockRatioX = (double) width / (double) tileObject.width;
            this.parentLockRatioY = (double) height / (double) tileObject.height;
        }
    }

    public void draw(Graphics2D graphics2d, boolean preview, boolean isSelected, boolean isGroupMember, int currentScreen) {
        long x = tilesWorkspace.virtualToPCScreenX(getX());
        long y = tilesWorkspace.virtualToPCScreenY(getY());
        long width = tilesWorkspace.virtualToPCScreenX(getX() + getWidth()) - x;
        long height = tilesWorkspace.virtualToPCScreenY(getY() + getHeight()) - y;
        //spessore bordo : 1 nella preview , 2 in genere, 3 se oggetto selezionato
        int borderTickness = (preview) ? 1 : (isSelected) ? 3 : 2;

        //EXTX EXTY
//        if (bean.getAspectRatio().getVal().indexOf("+") != -1) {
//            //System.out.println(bean.getAspectRatio().getExtX() + "   " + bean.getAspectRatio().getExtY());
//            width += bean.getAspectRatio().getExtX();
//            height += bean.getAspectRatio().getExtY();
//        }

        Shape shape = graphics2d.getClip();

        graphics2d.setClip((int) x, (int) y, (int) width + 1, (int) height + 1);


        int coordAdj = (borderTickness / 2);
        int sizeAdj = (borderTickness == 3) ? 2 : coordAdj;
        Rectangle tileRect = new Rectangle((int) x + coordAdj, (int) y + coordAdj, (int) width - sizeAdj, (int) height - sizeAdj);



        drawTileBackground(graphics2d, tileRect, currentScreen);

        if (!preview) {
            drawTileInfo(graphics2d, tileRect);
        }

        drawTileBorder(graphics2d, tileRect, isSelected, borderTickness, preview);

        graphics2d.setClip(shape);
    }

    private void drawTileBackground(Graphics2D graphics2d, Rectangle tileRect, int currentScreen) {
        //disegno sfondo tile
        graphics2d.setColor(bgColor);
        //SE e' visualizzato su entrambi gli schermi ed è il phantom allora lo disegnamo a scacchi
        if (this.getBean().getObjectSequence().getVideoProperties().getDisplayOnAllScreens().getVal() && currentScreen != this.getBean().getObjectScreen().getVal()) {
            int squareEdge = 2;
            int hStep = (int) tileRect.getWidth() / squareEdge;
            int vStep = (int) tileRect.getHeight() / squareEdge;
            Color aColor = bgColor;
            Color bColor = aColor.brighter();
            for (int h = 0; h <= hStep; h++) {
                for (int v = 0; v <= vStep; v++) {
                    graphics2d.setColor(((h + v) % 2 == 0) ? aColor : bColor);
                    graphics2d.fillRect((int) tileRect.getX() + h * squareEdge, (int) tileRect.getY() + v * squareEdge, squareEdge, squareEdge);
                }
            }
        } else {
            graphics2d.fill(tileRect);
            //GESTIONE SFONDO EXTX EXTY
            if (extX != 0 || extY != 0) {
                Stroke prevThickness = graphics2d.getStroke();
                graphics2d.setStroke(new BasicStroke(1));
                int lastY = tileRect.width + tileRect.height;
                graphics2d.setColor(bgColor.brighter());

                for (int i = 0; i <= lastY; i += 4) {
                    graphics2d.drawLine(tileRect.x, tileRect.y + i, tileRect.x + i, tileRect.y);
                }
                graphics2d.setColor(bgColor);
                Rectangle rettangoloEffettivo = new Rectangle(tileRect.x, tileRect.y, tileRect.width - (int) tilesWorkspace.virtualToPCScreenX(extX) + (int) tilesWorkspace.virtualToPCScreenX(0), tileRect.height - (int) tilesWorkspace.virtualToPCScreenY(extY) + (int) tilesWorkspace.virtualToPCScreenY(0));
                graphics2d.fill(rettangoloEffettivo);
                graphics2d.setStroke(prevThickness);
            }
        }
    }

    public void drawTileBorder(Graphics2D graphics2d, Rectangle rectangle, boolean isSelected, int borderTickness, boolean preview) {

        graphics2d.setStroke(new BasicStroke(borderTickness));

        if (!isValid()) {
            graphics2d.setColor(Color.red);
        } else if (isSelected) {
            graphics2d.setColor(StyleInterface.getInstance().getTileBorderSelectedColor()); //colore selezione
        } else if (preview) {
            graphics2d.setColor(fgColor);
        } else {
            graphics2d.setColor(StyleInterface.getInstance().getTileBorderUnselectedColor()); //colore bordo non selezionato
        }
        graphics2d.draw(rectangle);
    }

    private void drawTileInfo(Graphics2D graphics2d, Rectangle tileRect) {

        graphics2d.setColor(fgColor);
        long fontSize = (long) tileRect.getWidth() / 47 + 8;
        Font font = new Font("Lucida", Font.PLAIN, (int) fontSize);
        String itemName = getItemName();
        if(getItemType().equals("Video")||getItemType().equals("Audio")){
            String sorgente = getBean().getObjectSequence().getVidAudProperties().getVidAudSource().getVal();
            int idsrc = Integer.valueOf(sorgente.replaceAll("Source ","").trim());
            Source src = CtrlWorkspace.getInstance().getSource(CtrlActions.getInstance().getIdModulo(), idsrc);
            sorgente = " ("+((src.getUsername().getVal().equals(""))?"Source "+src.getId()+")":src.getUsername().getVal()+" #"+src.getId()+")");
            itemName += sorgente;
        }
        TextLayout textlayout = new TextLayout(itemName, font.deriveFont(Font.BOLD), graphics2d.getFontRenderContext());
        textlayout.draw(graphics2d, tileRect.x + 10, tileRect.y + 8 + fontSize);
        itemName = "" + tilesWorkspace.virtualToMVScreenX(getWidth()) + " X " + tilesWorkspace.virtualToMVScreenY(getHeight());
        textlayout = new TextLayout(itemName, font, graphics2d.getFontRenderContext());
        textlayout.draw(graphics2d, tileRect.x + 10, tileRect.y + 16 + fontSize * 2);
        if (extX != 0 || extY != 0) {
            itemName = "( " + tilesWorkspace.virtualToMVScreenX(width) + " X " + tilesWorkspace.virtualToMVScreenY(height) + " )";
            textlayout = new TextLayout(itemName, font.deriveFont(Math.max((float)fontSize-2 , 8)), graphics2d.getFontRenderContext());
            textlayout.draw(graphics2d, tileRect.x + 10, (float)(tileRect.y + 16 + fontSize * 3.14));
        }

    }

    //bordo di tile in secondo piano e quadratino selezione
    public void drawHiddenStuff(Graphics2D graphics2d, boolean isPreview, boolean isSelected, boolean isGroupMember) {
        long x = tilesWorkspace.virtualToPCScreenX(getX());
        long y = tilesWorkspace.virtualToPCScreenY(getY());
        long width = tilesWorkspace.virtualToPCScreenX(getX() + getWidth()) - x;
        long height = tilesWorkspace.virtualToPCScreenY(getY() + getHeight()) - y;
//        if (bean.getAspectRatio().getVal().indexOf("+")!=-1) {
//            width += bean.getAspectRatio().getExtX();
//            height += bean.getAspectRatio().getExtY();
//        }

        Rectangle tileRect = new Rectangle((int) x, (int) y, (int) width, (int) height);
        graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f));
        drawTileBorder(graphics2d, tileRect, isSelected, 1, false);
        graphics2d.setComposite(AlphaComposite.SrcOver);
        //disegno quadratino selezione
        if (!isPreview && isGroupMember) {
            graphics2d.fillRect((int) ((x + width) - 10L), (int) ((y + height) - 10L), 7, 7);
        }
    }

    /**
     * @return the bean
     */
    public Oggetto getBean() {
        return bean;
    }

    public int getId() {
        return bean.getId();
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public long getWidth() {
        if (bean.getAspectRatio().getVal().indexOf("+") != -1) {
            return width + extX;
        }
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        if (bean.getAspectRatio().getVal().indexOf("+") != -1) {
            return height + extY;
        }
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return bean.getType().getVal();
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return bean.getUsername().getVal();
    }

    /**
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    public int getParentAnchorId() {
        return parentAnchorId;
    }

    public boolean isParentLockRatio() {
        return parentLockRatio;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    /**
     * @return the parentLockRatioX
     */
    public double getParentLockRatioX() {
        return parentLockRatioX;
    }

    /**
     * @return the parentLockRatioY
     */
    public double getParentLockRatioY() {
        return parentLockRatioY;
    }

    /**
     * @return the offsetX
     */
    public int getOffsetX() {
        return offsetX;
    }

    /**
     * @return the offsetY
     */
    public int getOffsetY() {
        return offsetY;
    }

    /**
     * @return the extX
     */
    public long getExtX() {
        return (aspectRatio.indexOf('+') != -1) ? extX : 0;
    }

    /**
     * @return the extY
     */
    public long getExtY() {
        return (aspectRatio.indexOf('+') != -1) ? extY : 0;
    }
}
