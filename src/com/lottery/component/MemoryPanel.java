package com.lottery.component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tasly on 2014/10/21.
 */
public class MemoryPanel extends JPanel {
    //状态条的颜色
    private Color edgeColor = new Color(82, 115, 214);
    private Color centerColor = new Color(180, 200, 230);

    public void paint(Graphics g) {
        super.paint(g);
        //得到当前组件（JPanel）的大小
        Dimension dimension = getSize();
        //得到各边框的宽度
        Insets insets = getInsets();
        int left = insets.left;
        int top = insets.top;
        //得到内存使用状态信息
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        //组件（JPanel）除去左、右边框后的宽度
        int insideWidth = dimension.width - (insets.left + insets.right);
        //内存使用量的显示宽度
        int usedAmount = insideWidth - (int) (((long) insideWidth * freeMemory) / totalMemory);
        int insideHeight = dimension.height - (insets.bottom + insets.top);
        Graphics2D g2 = (Graphics2D) g;
        //设置渐变效果的画笔
        g2.setPaint(new GradientPaint(left, top, edgeColor, left, insideHeight / 2, centerColor, true));
        g.fillRect(left, top, usedAmount, insideHeight);
        g.setColor(getBackground());
        g.fillRect(left + usedAmount, top, insideWidth - usedAmount, insideHeight);
        g.setFont(getFont());
        g.setColor(Color.black);
        //显示状态的文字
        String memory = (Long.toString((totalMemory - freeMemory) / 1048576L) + "M of " + Long.toString(totalMemory / 1048576L) + 'M');
        //确定文字的显示位置
        FontMetrics fontmetrics = g.getFontMetrics();
        int stringWidth = fontmetrics.charsWidth(memory.toCharArray(), 0, memory.length());
        int stringHeight = fontmetrics.getHeight() - fontmetrics.getDescent();
        //显示文字
        g.drawString(memory, left + (insideWidth - stringWidth) / 2, top + (insideHeight + stringHeight) / 2);
    }
}
