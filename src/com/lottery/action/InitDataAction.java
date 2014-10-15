package com.lottery.action;

import com.lottery.service.LotteryAllService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by houyi on 2014/10/15.
 */
public class InitDataAction implements ActionListener {
    @Autowired
    private LotteryAllService lotteryAllService;

    @Override
    public void actionPerformed(ActionEvent e) {
        lotteryAllService.initLotteryData();
    }
}
