package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import DTO.Client;

public class ClientDAO {

	
	public EntityManager getEm()
	{
		
		return Persistence.createEntityManagerFactory("amit").createEntityManager();

		
	}
	public Client saveClient(Client client)
	{
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		return client ;
	}
	
	public Client deleteClient(int id)
	{
		EntityManager em = getEm() ;
		Client exClient =  em.find(Client.class, id);
		if(exClient != null)
		{
			em.getTransaction().begin();
			em.remove(exClient);
			em.getTransaction().commit();
			return exClient;
		}
		return null ;
		
		
	}
	
	public Client updateClient(Client a , int id)
	{
		EntityManager em = getEm();
		Client exClient = em.find(Client.class, id);
		
		if(exClient != null)
		{
			a.setClientId(id);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return a ;
		}
		return null ;
	}
	
	public Client findClient(int id)
	{
		EntityManager em = getEm();
		Client exClient = em.find(Client.class, id);
		if(exClient!= null )
		{
		   return exClient ;
		}
		return null ;
	}
}
