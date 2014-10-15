package com.lottery.dao.hibernate3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author houyi
 *
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable{

    private static final long serialVersionUID = 8784608728898957320L;

	@Id
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", length=64)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
