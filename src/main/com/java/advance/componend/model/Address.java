package main.com.java.advance.componend.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String doorNo;
	private String streetName;
	private String areaName;
	private String cityName;
	private String country;
	private long pinCode;

	public Address(String doorNo, String streetName, String areaName, String cityName, String country, long pinCode) {
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.areaName = areaName;
		this.cityName = cityName;
		this.country = country;
		this.pinCode = pinCode;
	}

	static {
		System.out.println("Address.class file is loading...");
	}

	public Address() {
		System.out.println("Address Object is created...");
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", areaName=" + areaName + ", cityName="
				+ cityName + ", country=" + country + ", pinCode=" + pinCode + "]";
	}

}
