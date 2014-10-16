package com.lottery.action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tasly on 2014/10/16.
 */
public class ExitAction implements ActionListener {
    private final Frame frame;

    public ExitAction(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showExitDialog(frame);
    }

    private void showExitDialog(Frame frame) {
        int value = JOptionPane.showConfirmDialog(frame, "确定要退出系统吗？", " 退 出", JOptionPane.YES_NO_OPTION);
        if (value == JOptionPane.YES_OPTION) {
            frame.dispose();
            System.exit(0);
        }
    }
}
