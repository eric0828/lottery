package com.lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.dao.LotteryAnyDao;

/**
 * @author houyi
 *
 */
@Service
public class LotteryAnyService {
	@Autowired
	private LotteryAnyDao lotteryAnyDao;
}
