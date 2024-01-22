package DAO;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import DTO.Services;

public class ServicesDAO {

	public EntityManager getEm()
	{
		
		return Persistence.createEntityManagerFactory("amit").createEntityManager();

		
	}
	public Services saveServices(Services services)
	{
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.persist(services);
		em.getTransaction().commit();
		return services ;
	}
	
	public Services deleteServices(int id)
	{
		EntityManager em = getEm() ;
		Services exServices =  em.find(Services.class, id);
		if(exServices != null)
		{
			em.getTransaction().begin();
			em.remove(exServices);
			em.getTransaction().commit();
			return exServices;
		}
		return null ;
		
		
	}
	
	public Services updateServices(Services a , int id)
	{
		EntityManager em = getEm();
		Services exServices = em.find(Services.class, id);
		
		if(exServices != null)
		{
			a.setServiceId(id);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return a ;
		}
		return null ;
	}
	
	public Services findServices(int id)
	{
		EntityManager em = getEm();
		Services exServices = em.find(Services.class, id);
		if(exServices!= null )
		{
		   return exServices ;
		}
		return null ;
	}
}
