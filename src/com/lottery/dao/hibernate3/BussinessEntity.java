package com.lottery.dao.hibernate3;

import java.io.Serializable;
import java.lang.annotation.Annotation;

import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * 
 * @author houyi
 *
 */
@MappedSuperclass
public abstract class BussinessEntity extends IdEntity implements Serializable {

	private static final long serialVersionUID = 8102619269019476594L;

	public String getTableName() {
		for (Annotation anno : this.getClass().getAnnotations()) {
			if (anno.annotationType().equals(Table.class)) {
				return ((Table) anno).name();
			}
		}
		return null;
	}

}
