package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Captura;

import java.sql.Timestamp;
import java.util.*;


public class ConsultaDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClimaWeb");
	EntityManager em = emf.createEntityManager();
	public List <Integer> Tempe (int ciu) {
		List <Integer> tempera = null;
		Query query1= em.createQuery("Select e.temperatura from Captura e where e.idCiudad ="+1+"");
		tempera = query1.getResultList(); 
		for (Integer e:tempera)
		{
			System.out.println("temp:"+e);
		}
		return tempera;
	}
	public List<Integer> humed (int ciu){
		Query query1= em.createQuery("Select e.humedad from Captura e where e.idCiudad ="+1+"");
		List <Integer> hume = null;
		hume = query1.getResultList();
		for (Integer e:hume)
		{
			System.out.println("hum:"+e);
		}
		return hume;
	}
	public List<Timestamp> fecha (int ciu){
	Query query1= em.createQuery("Select e.fecha from Captura e where e.idCiudad ="+1+"");
	List<Timestamp> fech = null;
	fech = query1.getResultList();
	for (Timestamp e:fech)
	{
		System.out.println("hum:"+e);
	}
	return fech;
	}
}
