package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import DTO.ClientEvent;

public class ClientEventDAO {

	
	public EntityManager getEm()
	{
		
		return Persistence.createEntityManagerFactory("amit").createEntityManager();

		
	}
	public ClientEvent saveClientEvent(ClientEvent clientEvent)
	{
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.persist(clientEvent);
		em.getTransaction().commit();
		return clientEvent ;
	}
	
	public ClientEvent deleteClientEvent(int id)
	{
		EntityManager em = getEm() ;
		ClientEvent exClientEvent =  em.find(ClientEvent.class, id);
		if(exClientEvent != null)
		{
			em.getTransaction().begin();
			em.remove(exClientEvent);
			em.getTransaction().commit();
			return exClientEvent;
		}
		return null ;
		
		
	}
	
	public ClientEvent updateClientEvent(ClientEvent a , int id)
	{
		EntityManager em = getEm();
		ClientEvent exClientEvent = em.find(ClientEvent.class, id);
		
		if(exClientEvent != null)
		{
			a.setClientEventId(id);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return a ;
		}
		return null ;
	}
	
	public ClientEvent findClientEvent(int id)
	{
		EntityManager em = getEm();
		ClientEvent exClientEvent = em.find(ClientEvent.class, id);
		if(exClientEvent!= null )
		{
		   return exClientEvent ;
		}
		return null ;
	}
}
