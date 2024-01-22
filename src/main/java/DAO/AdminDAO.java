package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import DTO.Admin;


public class AdminDAO {
	

	public EntityManager getEm()
	{
		
		return Persistence.createEntityManagerFactory("amit").createEntityManager();
	}
	public Admin saveAdmin(Admin admin)
	{
		EntityManager em = getEm();
		em.getTransaction().begin();
		em.persist(admin);
		em.getTransaction().commit();
		return admin ;
	}
	
	public Admin deleteAdmin(int id)
	{
		EntityManager em = getEm() ;
		Admin exAd =  em.find(Admin.class, id);
		if(exAd != null)
		{
			em.getTransaction().begin();
			em.remove(exAd);
			em.getTransaction().commit();
			return exAd ;
		}
		return null ;
		
		
	}
	
	public Admin updateAdmin(Admin a , int id)
	{
		EntityManager em = getEm();
		Admin exAdmin = em.find(Admin.class, id);
		
		if(exAdmin != null)
		{
			a.setAdminId(id);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			return a ;
		}
		return null ;
	}
	
	public Admin findAd(int id)
	{
		EntityManager em = getEm();
		Admin exAdmin = em.find(Admin.class, id);
		if(exAdmin != null )
		{
		   return exAdmin ;
		}
		return null ;
	}
	
	
	
}
