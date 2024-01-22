package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import DTO.ClientService;

public class ClientServiceDAO {

	public EntityManager getEm()
	{
		
		return Persistence.createEntityManagerFactory("amit").createEntityManager();

		
	}
	public ClientService saveClientService(ClientService clientService)
	{
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.persist(clientService);
		em.getTransaction().commit();
		return clientService ;
	}
	
	public ClientService deleteClientService(int id)
	{
		EntityManager em = getEm() ;
		ClientService exClientService =  em.find(ClientService.class, id);
		if(exClientService != null)
		{
			em.getTransaction().begin();
			em.remove(exClientService);
			em.getTransaction().commit();
			return exClientService;
		}
		return null ;
		
		
	}
	
	public ClientService updateClientService(ClientService a , int id)
	{
		EntityManager em = getEm();
		ClientService exClientService = em.find(ClientService.class, id);
		
		if(exClientService != null)
		{
			a.setClieServiceId(id);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return a ;
		}
		return null ;
	}
	
	public ClientService findClientService(int id)
	{
		EntityManager em = getEm();
		ClientService exClientService = em.find(ClientService.class, id);
		if(exClientService!= null )
		{
		   return exClientService ;
		}
		return null ;
	}
}
