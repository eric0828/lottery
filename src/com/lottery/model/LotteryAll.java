package com.lottery.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lottery.dao.hibernate3.BussinessEntity;

/**
 * Created by mmzz on 2014/10/7.
 */
@Entity
@Table(name = "LOTTERY_ALL")
public class LotteryAll extends BussinessEntity {

	private static final long serialVersionUID = 5934041630191412511L;

	@Column(name = "FRONT_ONE")
	private Integer front_one;

	@Column(name = "FRONT_TWO")
	private Integer front_two;

	@Column(name = "FRONT_THREE")
	private Integer front_three;

	@Column(name = "FRONT_FOUR")
	private Integer front_four;

	@Column(name = "FRONT_FIVE")
	private Integer front_five;

	@Column(name = "STATUS", length = 1)
	private String status;

	@OneToMany(mappedBy = "lotteryAll")
	private List<LotteryAny> lotteryAnys;

	public Integer getFront_one() {
		return front_one;
	}

	public void setFront_one(Integer front_one) {
		this.front_one = front_one;
	}

	public Integer getFront_two() {
		return front_two;
	}

	public void setFront_two(Integer front_two) {
		this.front_two = front_two;
	}

	public Integer getFront_three() {
		return front_three;
	}

	public void setFront_three(Integer front_three) {
		this.front_three = front_three;
	}

	public Integer getFront_four() {
		return front_four;
	}

	public void setFront_four(Integer front_four) {
		this.front_four = front_four;
	}

	public Integer getFront_five() {
		return front_five;
	}

	public void setFront_five(Integer front_five) {
		this.front_five = front_five;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public List<LotteryAny> getLotteryAnys() {
        return lotteryAnys;
    }

    public void setLotteryAnys(List<LotteryAny> lotteryAnys) {
        this.lotteryAnys = lotteryAnys;
    }
}
