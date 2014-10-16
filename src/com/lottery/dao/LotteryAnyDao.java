package com.lottery.dao;

import com.lottery.dao.hibernate3.SimpleHibernateDao;
import com.lottery.model.LotteryAny;
import org.springframework.stereotype.Repository;

/**
 * @author houyi
 */
@Repository
public class LotteryAnyDao extends SimpleHibernateDao<LotteryAny, String> {

}
