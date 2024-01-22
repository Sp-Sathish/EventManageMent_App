package DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId ;
	private String clientName ;
	private String clientEmail ;
	private String clientPAssword ;
	private long clientContact ;
	private String clientAddress ;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ClientEvent> events ; 
	
	
	public List<ClientEvent> getEvents() {
		return events;
	}
	public void setEvents(List<ClientEvent> events) {
		this.events = events;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientPAssword() {
		return clientPAssword;
	}
	public void setClientPAssword(String clientPAssword) {
		this.clientPAssword = clientPAssword;
	}
	public long getClientContact() {
		return clientContact;
	}
	public void setClientContact(long clientContact) {
		this.clientContact = clientContact;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientEmail=" + clientEmail
				+ ", clientPAssword=" + clientPAssword + ", clientContact=" + clientContact + ", clientAddress="
				+ clientAddress + ", events=" + events + "]";
	}
	
	
	
	
}
