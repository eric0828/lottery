package com.lottery.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.lottery.common.SpringBeanFactory;
import com.lottery.model.LotteryAll;
import com.lottery.service.LotteryAllService;

/**
 * Created by mmzz on 2014/10/7.
 */
public class ImportLotteryAllAction implements ActionListener {

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

			List<LotteryAll> lotteryAlls = new ArrayList<LotteryAll>();
			for (String line : lines) {
				String[] array = line.split(" ");
				LotteryAll lotteryAll = new LotteryAll();
				lotteryAll.setFront_one(Integer.parseInt(array[1]));
				lotteryAll.setFront_two(Integer.parseInt(array[2]));
				lotteryAll.setFront_three(Integer.parseInt(array[3]));
				lotteryAll.setFront_four(Integer.parseInt(array[4]));
				lotteryAll.setFront_five(Integer.parseInt(array[5]));
				lotteryAll.setStatus("N");
				lotteryAlls.add(lotteryAll);
			}

			LotteryAllService lotteryAllService = (LotteryAllService) SpringBeanFactory
					.getInstance().getBeanById("lotteryAllService");
			lotteryAllService.saveLotteryAllList(lotteryAlls);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
