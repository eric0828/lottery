package com.lottery.action;

import com.lottery.model.LotteryAny;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmzz on 2014/10/7.
 */
public class ImportBtnAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                String name = file.getName();
                int p = name.lastIndexOf('.');
                if (p == -1) return false;
                String suffix = name.substring(p + 1).toLowerCase();
                return StringUtils.equals(suffix, "txt");
            }

            @Override
            public String getDescription() {
                return "txt files";
            }
        });

        int state = fileChooser.showOpenDialog(null);
        System.out.println(state);

        if (state == 1) {
            return;
        } else {
            File file = fileChooser.getSelectedFile();
            processImport(file);
        }

    }

    /**
     * @param file
     */
    private void processImport(File file) {

        try {
            List<String> lines = FileUtils.readLines(file);

            List<LotteryAny> lotteryAnys = new ArrayList<LotteryAny>();
            for (String line : lines) {
                LotteryAny lotteryAny = new LotteryAny();

                lotteryAnys.add(lotteryAny);
            }

            //TODO 保存 lotteryAnys


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
