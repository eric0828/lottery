package com.lottery.component;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by tasly on 2014/10/22.
 */
public class CrystalComponentMouseListenr implements MouseListener {
    private CrystalComponent crystalComponent;

    public CrystalComponentMouseListenr(CrystalComponent crystalComponent) {
        this.crystalComponent = crystalComponent;
    }

    public void mouseClicked(MouseEvent e) {
        crystalComponent.mouseClicked(e);
        crystalComponent.updateUI();
    }

    public void mouseEntered(MouseEvent e) {
        crystalComponent.mouseEntered(e);
        crystalComponent.isMouseEntered = true;
        crystalComponent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        crystalComponent.updateUI();

    }

    public void mouseExited(MouseEvent e) {
        crystalComponent.mouseExited(e);
        crystalComponent.isMouseEntered = false;
        crystalComponent.setCursor(Cursor.getDefaultCursor());
        crystalComponent.updateUI();
    }

    public void mousePressed(MouseEvent e) {
        crystalComponent.mousePressed(e);
        crystalComponent.updateUI();
    }

    public void mouseReleased(MouseEvent e) {
        crystalComponent.mouseReleased(e);
        crystalComponent.updateUI();
    }
}
