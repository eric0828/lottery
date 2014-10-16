package com.lottery.action;

import com.lottery.common.SpringBeanFactory;
import com.lottery.service.LotteryAllService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by houyi on 2014/10/15.
 */
public class InitDataAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LotteryAllService lotteryAllService = (LotteryAllService) SpringBeanFactory.getInstance().getBeanById("lotteryAllService");
        lotteryAllService.initLotteryData();
    }
}
