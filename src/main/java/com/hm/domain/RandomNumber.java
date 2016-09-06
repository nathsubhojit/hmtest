package com.hm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="RANDOMNUMBER")
public class RandomNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "random_id_seq")
	@SequenceGenerator(name = "random_id_seq", sequenceName = "RANDONMUMBER_ID_SEQ", allocationSize = 100)
	private Integer id;

	@Column(name="APP_NUMBER1")
	private Integer app_Number1;
	@Column(name="APP_NUMBER2")
	private Integer app_Number2;
	@Column(name="APP_NUMBER3")
	private Integer app_Number3;

	@Column(name="SWAPS")
	private Integer swaps;
	
	private Long timeTaken;

	public Long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Integer getApp_Number1() {
		return app_Number1;
	}

	public void setApp_Number1(Integer app_Number1) {
		this.app_Number1 = app_Number1;
	}

	public Integer getApp_Number2() {
		return app_Number2;
	}

	public void setApp_Number2(Integer app_Number2) {
		this.app_Number2 = app_Number2;
	}

	public Integer getApp_Number3() {
		return app_Number3;
	}

	public void setApp_Number3(Integer app_Number3) {
		this.app_Number3 = app_Number3;
	}

	public Integer getSwaps() {
		return swaps;
	}

	public void setSwaps(Integer swaps) {
		this.swaps = swaps;
	}

}
