package com.lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.dao.LotteryAllDao;

/**
 * @author houyi
 *
 */
@Service
public class LotteryAllService {
	@Autowired
	private LotteryAllDao lotteryAllDao;
}
