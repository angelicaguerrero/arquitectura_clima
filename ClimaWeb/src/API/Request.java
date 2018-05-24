package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.json.JSONException;
import org.json.JSONObject;

import controller.CapturaDAO;
import model.Captura;
import model.Ciudad;

public class Request {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int temp = 0;
		int humedad = 0, c;
		int codigo;
		String url, ciudad, URI;
		CapturaDAO cd = new CapturaDAO();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClimaWeb");
		EntityManager em = emf.createEntityManager();
		String ciu = "Bogota";
		Query query = em.createQuery("Select e.codigo from Ciudad e where e.ciudad ='" + ciu + "'");
		List<Integer> listaCiudad = query.getResultList();
		codigo = listaCiudad.get(0);
		System.out.println(codigo);
		url = "http://api.openweathermap.org/data/2.5/weather?id=";
		URI = url + codigo + "&APPID=92fdf88ea647d40016f1d775cc31a05a";
		URL obj;
		try {
			obj = new URL(URI);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("\nsending 'GET' request to URL: " + URI);
			System.out.println("ResponseCode: " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject RespuestaObtenida = new JSONObject(response.toString());
			JSONObject main_Object = new JSONObject(RespuestaObtenida.getJSONObject("main").toString());
			temp = main_Object.getInt("temp");
			temp = (temp - 270);
			humedad = main_Object.getInt("humidity");
			ciudad = RespuestaObtenida.getString("name");

			System.out.println("Ciudad: " + ciudad);
			System.out.println("tempK: " + temp);
			System.out.println("humidity: " + humedad);
			cd.RegistrarCaptura(temp, humedad,1);

			/*
			 * //Inicio validacion
			 * 
			 * List <Integer> tempera = null; Query query1=
			 * em.createQuery("Select e.temperatura from Captura e where e.idCiudad ="+1+"")
			 * ; tempera = query1.getResultList(); for (Integer e:tempera) {
			 * System.out.println("temp:"+e); }
			 * 
			 * query1=
			 * em.createQuery("Select e.humedad from Captura e where e.idCiudad ="+1+"");
			 * List <Integer> hume = null; hume = query1.getResultList(); for (Integer
			 * e:hume) { System.out.println("hum:"+e); }
			 * 
			 * 
			 * query1=
			 * em.createQuery("Select e.fecha from Captura e where e.idCiudad ="+1+"");
			 * List<Timestamp> fech = null; fech = query1.getResultList(); for (Timestamp
			 * e:fech) { System.out.println("hum:"+e); }
			 */

			// Fin validacion
			
			
		} catch (MalformedURLException e1) {
			System.out.println("\nsending 'GET' request to URL: " + URI);
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
