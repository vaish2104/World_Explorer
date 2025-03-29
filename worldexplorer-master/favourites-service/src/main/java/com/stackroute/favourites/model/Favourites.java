package com.stackroute.favourites.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favourites {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String username;
	private String capital;               
	private String common_name;        
	private String region;           
	private String officialname;       
	private String flag;     
	private long population;     
	private String coatOfArms;      
	private double area;		
	private boolean status;
	public Favourites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favourites(int cid, String username, String capital, String common_name, String region, String officialname,
			String flag, long population, String coatOfArms, double area, boolean status) {
		super();
		this.cid = cid;
		this.username = username;
		this.capital = capital;
		this.common_name = common_name;
		this.region = region;
		this.officialname = officialname;
		this.flag =flag;
		this.population = population;
		this.coatOfArms = coatOfArms;
		this.area=area;
		this.status = status;
	}
	public int getCId() {
		return cid;
	}
	public void setCId(int cid) {
		this.cid = cid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCommon_name() {
		return common_name;
	}
	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getOfficialname() {
		return officialname;
	}
	public void setOfficialname(String officialname) {
		this.officialname = officialname;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public String getCoatOfArms() {
		return coatOfArms;
	}
	public void setCoatOfArms(String coatOfArms) {
		this.coatOfArms = coatOfArms;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area=area;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Favourites [cid=" + cid + ", username=" + username + ", capital=" + capital + ", common_name="
				+ common_name + ", region=" + region + ", officialname=" + officialname + ", flag=" + flag
				+ ", population=" + population + ", coatOfArms=" + coatOfArms + ", area=" + area + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
