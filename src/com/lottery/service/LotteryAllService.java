package com.lottery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottery.dao.LotteryAllDao;
import com.lottery.model.LotteryAll;

/**
 * @author houyi
 *
 */
@Service("lotteryAllService")
public class LotteryAllService {
	@Autowired
	private LotteryAllDao lotteryAllDao;

	@Transactional
	public void saveLotteryAllList(List<LotteryAll> list) {
		for (LotteryAll lotteryAll : list) {
			lotteryAllDao.save(lotteryAll);
		}
	}

	public long countLotteryAll() {
		String hql = "select count(*) from LotteryAll";
		return (Long) lotteryAllDao.getHibernateTemplate().find(hql).iterator().next();
	}

}
