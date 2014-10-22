package com.lottery.ui;

import com.lottery.action.ExitAction;
import com.lottery.action.ImportLotteryAllAction;
import com.lottery.action.ImportLotteryAnyAction;
import com.lottery.common.SpringBeanFactory;
import com.lottery.component.CrystalImageButton;
import com.lottery.component.MemoryPanel;
import com.lottery.component.ProgressPanel;
import com.lottery.service.LotteryAllService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainUI extends JFrame {

    private static final long serialVersionUID = -2089179114014597392L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                    MainUI frame = new MainUI();
                    frame.setSize(1000, 700);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainUI() {
        setTitle("大乐透分析系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        ProgressPanel glassPane = new ProgressPanel();
        setGlassPane(glassPane);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("文 件");
        menuBar.add(mnNewMenu);

        JMenuItem menuItem = new JMenuItem("导入数据");
        mnNewMenu.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("退 出");
        mnNewMenu.add(menuItem_1);
        menuItem_1.addActionListener(new ExitAction(this));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JToolBar toolBar = new JToolBar();
        toolBar.setEnabled(false);
        contentPane.add(toolBar, BorderLayout.NORTH);

        JButton initBtn = new JButton("导入全排列");
        initBtn.addActionListener(new ImportLotteryAllAction(this, glassPane));
        initBtn.setPreferredSize(new Dimension(100, 30));
        toolBar.add(initBtn);
        LotteryAllService lotteryAllService = (LotteryAllService) SpringBeanFactory.getInstance()
                .getBeanById("lotteryAllService");
        if (lotteryAllService != null) {
            if (lotteryAllService.countLotteryAll() != 0) {
                initBtn.setEnabled(false);
            } else {
                initBtn.setEnabled(true);
            }
        }

        JButton importBtn = new JButton("导入数据");
        importBtn.addActionListener(new ImportLotteryAnyAction(this, glassPane));
        importBtn.setPreferredSize(new Dimension(80, 30));
        toolBar.add(importBtn);

        JComboBox<Object> comboBox_1 = new JComboBox<Object>();
        comboBox_1.setPreferredSize(new Dimension(350, 30));
        toolBar.add(comboBox_1);

        JComboBox<Object> comboBox = new JComboBox<Object>();
        comboBox.setPreferredSize(new Dimension(350, 30));
        toolBar.add(comboBox);

        JPanel statusPanel = new JPanel();
        contentPane.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setLayout(new BorderLayout(0, 0));

        JPanel memoryStatusPanel = new JPanel();
        memoryStatusPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        statusPanel.add(memoryStatusPanel, BorderLayout.EAST);

        final MemoryPanel memoryPanel = new MemoryPanel();
        memoryPanel.setPreferredSize(new Dimension(100, 15));
        memoryPanel.setMaximumSize(new Dimension(100, 15));
        memoryPanel.setMinimumSize(new Dimension(100, 15));
        memoryStatusPanel.add(memoryPanel);

        CrystalImageButton gcButton = new CrystalImageButton("");
        gcButton.setPreferredSize(new Dimension(30, 30));
        gcButton.setToolTipText("垃圾回收");
        URL url = getClass().getResource("/icons/trash.png");
        gcButton.setFrameType(CrystalImageButton.FRAME_AROUND);
        if(url != null){
            gcButton.setImage(new ImageIcon(url).getImage());
        }

        memoryStatusPanel.add(gcButton);
        gcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.gc();
                memoryPanel.repaint();
            }
        });

        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent actionevent) {
                memoryPanel.repaint();
            }
        });
        timer.start();
    }

}
