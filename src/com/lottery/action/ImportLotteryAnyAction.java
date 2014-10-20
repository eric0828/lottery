package com.lottery.action;

import com.lottery.common.SpringBeanFactory;
import com.lottery.model.LotteryAny;
import com.lottery.service.LotteryAnyService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mmzz on 2014/10/7.
 */
public class ImportLotteryAnyAction implements ActionListener {

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
                if (p == -1)
                    return false;
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
                String[] array = line.split("\\|");
                if (array != null && array.length == 8) {
                    LotteryAny lotteryAny = new LotteryAny();
                    lotteryAny.setNo(Integer.parseInt(array[0]));
                    lotteryAny.setFront_one(Integer.parseInt(array[1]));
                    lotteryAny.setFront_two(Integer.parseInt(array[2]));
                    lotteryAny.setFront_three(Integer.parseInt(array[3]));
                    lotteryAny.setFront_four(Integer.parseInt(array[4]));
                    lotteryAny.setFront_five(Integer.parseInt(array[5]));
                    lotteryAny.setBehind_one(Integer.parseInt(array[6]));
                    lotteryAny.setBehind_two(Integer.parseInt(array[7]));
                    lotteryAny.setCreated_date(new Date());
                    lotteryAnys.add(lotteryAny);
                }
            }
            LotteryAnyService lotteryAnyService = (LotteryAnyService) SpringBeanFactory
                    .getInstance().getBeanById("lotteryAnyService");
            lotteryAnyService.importLotteryAnyList(lotteryAnys);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
