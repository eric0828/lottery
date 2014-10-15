package com.lottery.dao;

import org.springframework.stereotype.Repository;

import com.lottery.dao.hibernate3.SimpleHibernateDao;
import com.lottery.model.LotteryAny;

/**
 * @author houyi
 *
 */
@Repository
public class LotteryAnyDao extends SimpleHibernateDao<LotteryAny, String> {

}
