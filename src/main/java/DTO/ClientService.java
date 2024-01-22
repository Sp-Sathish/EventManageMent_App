package DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ClientService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clieServiceId ;
	private String  clieServiceName ;
	private double clieServiceCost ;
	private int clieServiceNoOfDays ;
	private double clieServiceCostPerPerson ;
	public int getClieServiceId() {
		return clieServiceId;
	}
	public void setClieServiceId(int clieServiceId) {
		this.clieServiceId = clieServiceId;
	}
	public String getClieServiceName() {
		return clieServiceName;
	}
	public void setClieServiceName(String clieServiceName) {
		this.clieServiceName = clieServiceName;
	}
	public double getClieServiceCost() {
		return clieServiceCost;
	}
	public void setClieServiceCost(double clieServiceCost) {
		this.clieServiceCost = clieServiceCost;
	}
	public int getClieServiceNoOfDays() {
		return clieServiceNoOfDays;
	}
	public void setClieServiceNoOfDays(int clieServiceNoOfDays) {
		this.clieServiceNoOfDays = clieServiceNoOfDays;
	}
	public double getClieServiceCostPerPerson() {
		return clieServiceCostPerPerson;
	}
	public void setClieServiceCostPerPerson(double clieServiceCostPerPerson) {
		this.clieServiceCostPerPerson = clieServiceCostPerPerson;
	}
	@Override
	public String toString() {
		return "ClientService [clieServiceId=" + clieServiceId + ", clieServiceName=" + clieServiceName
				+ ", clieServiceCost=" + clieServiceCost + ", clieServiceNoOfDays=" + clieServiceNoOfDays
				+ ", clieServiceCostPerPerson=" + clieServiceCostPerPerson + "]";
	}
	
	
}
