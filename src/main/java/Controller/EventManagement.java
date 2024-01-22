package Controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Persistence;
import javax.persistence.Query;

import DAO.AdminDAO;
import DAO.ClientDAO;
import DAO.ClientEventDAO;
import DAO.ClientServiceDAO;
import DAO.ServicesDAO;
import DTO.Admin;
import DTO.Client;
import DTO.ClientEvent;
import DTO.ClientService;
import DTO.EventType;
import DTO.Services;

public class EventManagement{

	static AdminDAO adminDAO = new AdminDAO();
	static ServicesDAO serviceDA0 =  new ServicesDAO() ;

	static ClientDAO clientDAO = new ClientDAO();

	static ClientEventDAO clientEventDAO = new ClientEventDAO(); 
	static ClientServiceDAO clientServiceDao = new ClientServiceDAO();
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{

	     EventManagement em =  new EventManagement();
	     System.out.println(em.createClientEvent());
//	     System.out.println(em.saveServices());
//	     System.out.println(em.saveClient());
	}

	public Admin saveAdmin() 
	{ 
		Admin admin = new Admin();
	    
	    System.out.println("enter admin name");
	    admin.setAdminName(sc.next()); 
	    System.out.println("enter admin Email");
	    admin.setAdminEmail(sc.next());
	    System.out.println("enter admin password"); admin.setAdminPassword(sc.next());
	    System.out.println("enter admin contact number");
	    admin.setAdminContact(sc.nextLong());
	    
	    return adminDAO.saveAdmin (admin);
	}
	
	
	public Admin adminLogin()
	{
		
		System.out.println("Enter the Admin Email");
		String adminEmail = sc.nextLine() ;
		System.out.println("Enter the Admin Password");
		String adminPassword = sc.nextLine() ;
		Query query   = Persistence.createEntityManagerFactory("amit").createEntityManager().createQuery("select a from Admin a where a.adminEmail = ?1");
		query.setParameter(1, adminEmail);
		Admin exAdmin = (Admin) query.getSingleResult() ;
		
		if(exAdmin != null)
		{
			if(exAdmin.getAdminPassword().equals(adminPassword))
			{   
				return exAdmin ;
			}
			return null ;
		}
		return null ;
		
	}
	public Services saveServices()
	{
		System.out.println("Enter the admin credential to proceed");
		Admin exAdmin = adminLogin() ;
		if(exAdmin != null)
		{
			Services services =  new Services() ;			
			System.out.println("Enter the Service Name");
			String serviceName = sc.nextLine();
			services.setServiceName(serviceName);
			System.out.println("Enter the Service Cost Per Person");
			services.setServiceCostPerPerson(sc.nextDouble());
			System.out.println("Enter the Service Cost Per Day");
			services.setServiceCostPerDay(sc.nextDouble());
			Services savedServices = serviceDA0.saveServices(services);
			exAdmin.getServices().add(savedServices);
			adminDAO.updateAdmin(exAdmin, exAdmin.getAdminId());
			sc.close();
			return services;
		}
		return null ;
	}
	
	public List<Services> getAllServices()
	{

		System.out.println("Enter the admin credential to proceed");
		Admin exAdmin = adminLogin() ;
		if(exAdmin != null)
		{
			Query query   = Persistence.createEntityManagerFactory("amit").createEntityManager().createQuery("select a from Services a");
			List<Services> services = query.getResultList();
			return services ;
			
		}
		return null;
	}
	
	public String updateServices()
	{
		
		List<Services> services = getAllServices();
		for(Services s : services)
		{
			System.out.println("ServiceId  " + "ServiceName   "+ "Cost_Per_Person  " + "Cost_Per_Day  ");
			System.out.println("   " + s.getServiceId()+"       "+s.getServiceName() + "         " +s.getServiceCostPerPerson()+"          "+s.getServiceCostPerDay());
		}
		
		System.out.println("============Choose Service id from above to update ==================");
		int id= sc.nextInt();
		Services tobeUpdated = serviceDA0.findServices(id);
		System.out.println("enter the updated cost per Person");
		double costPerPerson = sc.nextDouble();
		System.out.println("enter the updated cost per Day");
		double costPerDay = sc.nextDouble();
		tobeUpdated.setServiceCostPerDay(costPerDay);
		tobeUpdated.setServiceCostPerPerson(costPerPerson);
		
		Services updated = serviceDA0.updateServices(tobeUpdated, id);
		
		if(updated != null)
		{
			return "Service updated SuccessFully";
		}
		return "Invalid Service Id";
	}
	
	public String deleteService()
	{
		Admin exAdmin = adminLogin();
		
		if(exAdmin !=  null)
		{
			List<Services> services = getAllServices();
			for(Services s : services)
			{
				System.out.println("ServiceId  " + "ServiceName   "+ "Cost_Per_Person  " + "Cost_Per_Day  ");
				System.out.println("   " + s.getServiceId()+"       "+s.getServiceName() + "         " +s.getServiceCostPerPerson()+"          "+s.getServiceCostPerDay());
			}
			
			System.out.println("============Choose Service id from above to Delete ===============");
			int id= sc.nextInt();
		
			List<Services> serviceList = exAdmin.getServices();
			List<Services> newServices = new ArrayList<Services>();
			for(Services s :serviceList )
			{
				if(s.getServiceId()!= id)
				{
					newServices.add(s);
				}
			}
			exAdmin.setServices(newServices);
			adminDAO.updateAdmin(exAdmin, exAdmin.getAdminId());
			Services deletedService = serviceDA0.deleteServices(id);
			
			if(deletedService != null)
			{
				return "Service Deleted SuccessFully";
			}
			else
			{
				return "Invalid Service Id" ;
			}
		
		}
		return "Admin login required" ;
		
	}
	
	public Client saveClient() 
	{ 
		Client client = new Client();
	    
	    System.out.println("enter client name");
	    client.setClientName(sc.next());
	    System.out.println("enter client Email");
	    client.setClientEmail(sc.next());
	    System.out.println("enter client Password");
	    client.setClientPAssword(sc.next());
	    System.out.println("enter admin Contact");
	    client.setClientContact(sc.nextLong());
	    System.out.println("enter admin Address"); 
	    client.setClientAddress(sc.next());
	    
	    return clientDAO.saveClient(client);
	}
	
	public  Client clientLogin()
	{
		
		System.out.println("Enter the client Email");
		String clientEmail = sc.nextLine() ;
		System.out.println("Enter the client Password");
		String clientPassword = sc.nextLine() ;
		Query query   = Persistence.createEntityManagerFactory("amit").createEntityManager().createQuery("select c from Client c where c.clientEmail = ?1");
		query.setParameter(1, clientEmail);
		Client exClient = (Client) query.getSingleResult() ;
		
		if(exClient != null)
		{
			
			if(exClient.getClientPAssword().equals(clientPassword))
			{
				return exClient ;
			}
			return null ;
		}
		return null ;
		
	}
	public ClientEvent createClientEvent()
	{
		Client exClient =  clientLogin();
		if(exClient != null )
		{
			ClientEvent clientEvent =  new ClientEvent() ;
			
			EventType eventType[] = EventType.values();
			int i = 1 ;
			for(EventType et : eventType)
			{
				System.out.println(i++  + " . " + et);
			}
			
			boolean repeat = true ;
			
			while(repeat)
			{
			    System.out.println("Choose The Event");
			   
			    String val = sc.next();
			    if(val.equals("1"))
				{
					clientEvent.setEventType(EventType.Marriage);
					repeat = false ;
				}
				else if(val.equals("2"))
				{
					clientEvent.setEventType(EventType.Engagement);
					repeat = false ;
				}
				else if(val.equals("3"))
				{
					clientEvent.setEventType(EventType.BirthDay);
					repeat = false ;
				}
				else if(val.equals("4"))
				{
					clientEvent.setEventType(EventType.Anniversary);
					repeat = false ;
				}
				else if(val.equals("5"))
				{
					clientEvent.setEventType(EventType.Babyshower);
					repeat = false ;
				}
				else if(val.equals("6"))
				{
					clientEvent.setEventType(EventType.Reunion);
					repeat = false ;
				}
				else if(val.equals("7"))
				{
					clientEvent.setEventType(EventType.NamingCeremony);
					repeat = false ;
				}
				else if(val.equals("8"))
				{
					clientEvent.setEventType(EventType.BachelorParty);
					repeat = false ;
				}
				else
				{
					System.out.println("Invalid Input!! Enter valid Input....... ");
				}
			}
			System.out.println("Enter the number of People:");
			clientEvent.setClientEventNoOfPeople(sc.nextInt());
			System.out.println("Enter the date in the form of d-MM-yyyy");
			LocalDate localDate = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("d-MM-yyyy"));
			clientEvent.setStartDate(localDate);
			System.out.println("Enter the Number of Days");
			clientEvent.setClientEventNoOfDays(sc.nextInt());
			System.out.println("enter the EventLocation");sc.next();
			clientEvent.setClientEventLocation(sc.nextLine());
			
			
			
			ClientEvent savedClientEvent = clientEventDAO.saveClientEvent(clientEvent);
			exClient.getEvents().add(savedClientEvent);
			clientDAO.updateClient(exClient, exClient.getClientId());
			
			
			List<Services> adminServices = getAllServices();
			
			for(Services s : adminServices)
			{
				System.out.println("ServiceId    " + "ServiceName    " + "Cost_Per_Person    "+ "Cost_Per_Day     ");
				System.out.println("     "+s.getServiceId() + "         "+ s.getServiceName() + "          "+ s.getServiceCostPerPerson() + "           "+s.getServiceCostPerDay());
			}
			
			System.out.println("------------How Many Service you want from above Services---------");
			
			int noOfServices = sc.nextInt();
			System.out.println("Your Selected " + noOfServices + " Services...!");
			
			List<Services> clientServices = new ArrayList<>();
			for(int j = 1 ; j <= noOfServices; j++ )
			{
				System.out.println("Confirm your Service  "+ j + " to enter the Service Number from above Services");
				int id = sc.nextInt();
				Services service = serviceDA0.findServices(id);
				
				ClientService clientService =  new  ClientService() ;
				clientService.setClieServiceName(service.getServiceName());
				clientService.setClieServiceCostPerPerson(service.getServiceCostPerPerson());
				clientService.setClieServiceNoOfDays(clientEvent.getClientEventNoOfDays());
				double totalCostOfAllPeople = clientEvent.getClientEventNoOfPeople() *service.getServiceCostPerPerson();
				double totalCostOfAllDays = clientEvent.getClientEventNoOfDays() * service.getServiceCostPerDay();
				clientService.setClieServiceCost(totalCostOfAllDays + totalCostOfAllPeople) ;
				
				clientServices.add(service);
				clientServiceDao.saveClientService(clientService);
			}
			return clientEvent ;
		}
		else
		{
			System.out.println("Invalid Client Email Password");
		}
		return null ;
	}


}
 	