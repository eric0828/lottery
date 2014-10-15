package com.lottery.dao;

import com.lottery.model.LotteryAll;
import org.springframework.stereotype.Repository;

import com.lottery.dao.hibernate3.SimpleHibernateDao;
import com.lottery.model.LotteryAny;

/**
 * @author houyi
 *
 */
@Repository
public class LotteryAllDao extends SimpleHibernateDao<LotteryAll, String> {

}
