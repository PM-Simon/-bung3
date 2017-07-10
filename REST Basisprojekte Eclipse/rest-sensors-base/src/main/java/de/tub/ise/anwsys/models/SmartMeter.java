package de.tub.ise.anwsys.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SmartMeter {

	@Id
	@Column(name= "SM_ID")
	private long id;
	
	String Gerätekennung;
	
	@OneToMany()
	List<Messdaten> messdaten = new ArrayList<>();
	
	public SmartMeter(String gerätekennung) {
		this.Gerätekennung= gerätekennung;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getGerätekennung() {
		return Gerätekennung;
	}
	public void setGerätekennung(String gerätekennung) {
		Gerätekennung = gerätekennung;
	}
	public List<Messdaten> getMessdaten() {
		return messdaten;
	}
	public void setMessdaten(List<Messdaten> messdaten) {
		this.messdaten = messdaten;
	}
	public List<Messdaten> addMessdatum (Messdaten e) {
		this.messdaten.add(e);
		return this.messdaten;
	}
	public List<Messdaten> addMessdaten (List<Messdaten> e) {
		this.messdaten.addAll(e);
		return this.messdaten;
	}

}
