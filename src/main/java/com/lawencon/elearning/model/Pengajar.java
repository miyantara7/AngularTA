package com.lawencon.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "tb_pengajar")
public class Pengajar {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(updatable = false, nullable = false)
	private String pengajarid;

	public String getPengajarid() {
		return pengajarid;
	}

	public void setPengajarid(String pengajarid) {
		this.pengajarid = pengajarid;
	}
	
}
