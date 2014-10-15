package com.lottery.service;

import com.lottery.model.LotteryAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.dao.LotteryAllDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author houyi
 *
 */
@Service
public class LotteryAllService {
	@Autowired
	private LotteryAllDao lotteryAllDao;

    @Transactional
    public void initLotteryData(){
        for (int i = 0 ; i <= 99999 ; i ++){
            LotteryAll lotteryAll = new LotteryAll();
            if(i >= 0 && i < 10){
                lotteryAll.setFront_one(0);
                lotteryAll.setFront_two(0);
                lotteryAll.setFront_three(0);
                lotteryAll.setFront_four(0);
                lotteryAll.setFront_five(i);
            }else if(i >= 10 && i < 100){
                lotteryAll.setFront_one(0);
                lotteryAll.setFront_two(0);
                lotteryAll.setFront_three(0);
                lotteryAll.setFront_four(Integer.parseInt(String.valueOf(i).substring(0, 1)));
                lotteryAll.setFront_five(Integer.parseInt(String.valueOf(i).substring(1)));
            }else if(i >= 100 && i < 1000){
                lotteryAll.setFront_one(0);
                lotteryAll.setFront_two(0);
                lotteryAll.setFront_three(Integer.parseInt(String.valueOf(i).substring(0, 1)));
                lotteryAll.setFront_four(Integer.parseInt(String.valueOf(i).substring(1, 2)));
                lotteryAll.setFront_five(Integer.parseInt(String.valueOf(i).substring(2)));
            }else if(i >= 1000 && i < 10000){
                lotteryAll.setFront_one(0);
                lotteryAll.setFront_two(Integer.parseInt(String.valueOf(i).substring(0, 1)));
                lotteryAll.setFront_three(Integer.parseInt(String.valueOf(i).substring(1, 2)));
                lotteryAll.setFront_four(Integer.parseInt(String.valueOf(i).substring(2, 3)));
                lotteryAll.setFront_five(Integer.parseInt(String.valueOf(i).substring(3)));
            }else if(i >= 10000 && i <= 99999){
                lotteryAll.setFront_one(Integer.parseInt(String.valueOf(i).substring(0, 1)));
                lotteryAll.setFront_two(Integer.parseInt(String.valueOf(i).substring(1, 2)));
                lotteryAll.setFront_three(Integer.parseInt(String.valueOf(i).substring(2, 3)));
                lotteryAll.setFront_four(Integer.parseInt(String.valueOf(i).substring(3, 4)));
                lotteryAll.setFront_five(Integer.parseInt(String.valueOf(i).substring(4)));
            }
            lotteryAll.setStatus("N");
            lotteryAllDao.save(lotteryAll);
        }
    }
}
