package com.lottery.service;

import com.lottery.dao.LotteryAllDao;
import com.lottery.dao.LotteryAnyDao;
import com.lottery.model.LotteryAll;
import com.lottery.model.LotteryAny;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houyi
 */
@Service("lotteryAnyService")
public class LotteryAnyService {
    @Autowired
    private LotteryAnyDao lotteryAnyDao;

    @Autowired
    private LotteryAllDao lotteryAllDao;

    @Transactional
    public void importLotteryAnyList(List<LotteryAny> list) {
        lotteryAnyDao.batchExecute("delete from LotteryAny");
        for (LotteryAny lotteryAny : list) {
            List<Criterion> queryList = new ArrayList<Criterion>();
            queryList.add(Restrictions.eq("front_one", lotteryAny.getFront_one()));
            queryList.add(Restrictions.eq("front_two", lotteryAny.getFront_two()));
            queryList.add(Restrictions.eq("front_three", lotteryAny.getFront_three()));
            queryList.add(Restrictions.eq("front_four", lotteryAny.getFront_four()));
            queryList.add(Restrictions.eq("front_five", lotteryAny.getFront_five()));
            Criteria criteria = lotteryAllDao.createCriteria((Criterion[]) queryList.toArray(new Criterion[0]));
            List<LotteryAll> result = criteria.list();
            if (result != null && result.size() != 0) {
                lotteryAny.setLotteryAll(result.get(0));
                lotteryAnyDao.saveOrUpdate(lotteryAny);
            }
        }
    }

}
