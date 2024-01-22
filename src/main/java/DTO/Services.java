package DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId ;
	private String serviceName ;
	private double serviceCostPerDay ;
	private int noOfDays ;
	private double serviceCostPerPerson ;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public double getServiceCostPerDay() {
		return serviceCostPerDay;
	}
	public void setServiceCostPerDay(double serviceCostPerDay) {
		this.serviceCostPerDay = serviceCostPerDay;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getServiceCostPerPerson() {
		return serviceCostPerPerson;
	}
	public void setServiceCostPerPerson(double serviceCostPerPerson) {
		this.serviceCostPerPerson = serviceCostPerPerson;
	}
	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceCostPerDay="
				+ serviceCostPerDay + ", noOfDays=" + noOfDays + ", serviceCostPerPerson=" + serviceCostPerPerson + "]";
	}
	
	
	
}
