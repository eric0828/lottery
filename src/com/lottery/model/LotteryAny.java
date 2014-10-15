package com.lottery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lottery.dao.hibernate3.BussinessEntity;

/**
 * Created by mmzz on 2014/10/7.
 */
@Entity
@Table(name = "LOTTERY_ANY")
public class LotteryAny extends BussinessEntity {

	private static final long serialVersionUID = -2301485271595947726L;

	@Column(name = "NO")
	private Integer no;

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

	@Column(name = "BEHIND_ONE")
	private Integer behind_one;

	@Column(name = "BEHIND_TWO")
	private Integer behind_two;

	@Column(name = "CREATED_DATE")
	private Date created_date;
	
	@ManyToOne
	@JoinColumn(name = "LOTTERY_ID")
	private LotteryAll lotteryAll;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

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

	public Integer getBehind_one() {
		return behind_one;
	}

	public void setBehind_one(Integer behind_one) {
		this.behind_one = behind_one;
	}

	public Integer getBehind_two() {
		return behind_two;
	}

	public void setBehind_two(Integer behind_two) {
		this.behind_two = behind_two;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}
