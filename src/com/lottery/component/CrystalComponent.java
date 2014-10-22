package com.lottery.component;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Created by tasly on 2014/10/22.
 */
public class CrystalComponent extends JButton {
    protected boolean isMouseEntered; // 鼠标进入标志

    public CrystalComponent() {
        this.addMouseListener(new CrystalComponentMouseListenr(this));
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }
}
