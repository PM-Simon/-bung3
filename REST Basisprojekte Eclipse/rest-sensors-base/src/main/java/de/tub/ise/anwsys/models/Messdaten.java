package de.tub.ise.anwsys.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Messdaten {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "SM_ID")	
	private long id;
	int timestamp;
	int messwert;
	
	@ManyToOne()
	private SmartMeter sm;
	
	public Messdaten(int timestamp, int messwert) {
		this.timestamp = timestamp;
		this.messwert = messwert;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getMesswert() {
		return messwert;
	}

	public void setMesswert(int messwert) {
		this.messwert = messwert;
	}

	public SmartMeter getSm() {
		return sm;
	}

	public void setSm(SmartMeter sm) {
		this.sm = sm;
	}

	
}
