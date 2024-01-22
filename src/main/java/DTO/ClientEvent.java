package DTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class ClientEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ClientEventId ;
	private int ClientEventNoOfPeople ;
	private LocalDate startDate ;
	private int clientEventNoOfDays ;
	private String clientEventLocation ;
	private double clientEventCost ;
	@ManyToOne(cascade =CascadeType.ALL)
	private Client client ;
	@OneToMany
	private List<ClientService> clientService ;
	private EventType eventType ;
	public int getClientEventId() {
		return ClientEventId;
	}
	public void setClientEventId(int clientEventId) {
		ClientEventId = clientEventId;
	}
	public int getClientEventNoOfPeople() {
		return ClientEventNoOfPeople;
	}
	public void setClientEventNoOfPeople(int clientEventNoOfPeople) {
		ClientEventNoOfPeople = clientEventNoOfPeople;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public int getClientEventNoOfDays() {
		return clientEventNoOfDays;
	}
	public void setClientEventNoOfDays(int clientEventNoOfDays) {
		this.clientEventNoOfDays = clientEventNoOfDays;
	}
	public String getClientEventLocation() {
		return clientEventLocation;
	}
	public void setClientEventLocation(String clientEventLocation) {
		this.clientEventLocation = clientEventLocation;
	}
	public double getClientEventCost() {
		return clientEventCost;
	}
	public void setClientEventCost(double clientEventCost) {
		this.clientEventCost = clientEventCost;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ClientService> getClientService() {
		return clientService;
	}
	public void setClientService(List<ClientService> clientService) {
		this.clientService = clientService;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	@Override
	public String toString() {
		return "ClientEvent [ClientEventId=" + ClientEventId + ", ClientEventNoOfPeople=" + ClientEventNoOfPeople
				+ ", startDate=" + startDate + ", clientEventNoOfDays=" + clientEventNoOfDays + ", clientEventLocation="
				+ clientEventLocation + ", clientEventCost=" + clientEventCost + ", client=" + client
				+ ", clientService=" + clientService + ", eventType=" + eventType + "]";
	}
	
	
	
}
