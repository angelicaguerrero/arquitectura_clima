package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Captura;

public class CapturaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClimaWeb");
	EntityManager em = emf.createEntityManager();

	public boolean RegistrarCaptura(int temp, int humedad, int idCiudad) {
		em.getTransaction().begin();

		Captura captura = new Captura();
		captura.setHumedad(humedad);
		captura.setTemperatura(temp);
		captura.setFecha(new Timestamp(System.currentTimeMillis()));
		captura.setIdCiudad(idCiudad);
		captura.setEstado(true);
		em.persist(captura);
		em.flush();
		Captura cp = em.find(Captura.class, captura.getIdcaptura());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return true;
	}
}
