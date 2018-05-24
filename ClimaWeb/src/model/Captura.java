package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the captura database table.
 * 
 */
@Entity
@NamedQuery(name = "Captura.findAll", query = "SELECT c FROM Captura c")
public class Captura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CAPTURA_IDCAPTURA_GENERATOR", sequenceName = "captura_idcaptura_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAPTURA_IDCAPTURA_GENERATOR")
	private Integer idcaptura;

	private Boolean estado;

	private Timestamp fecha;

	private Integer humedad;

	private Integer temperatura;
	
	private Integer idCiudad;
	
	

	// bi-directional many-to-one association to Ciudad

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Captura() {
	}

	public Integer getIdcaptura() {
		return this.idcaptura;
	}

	public void setIdcaptura(Integer idcaptura) {
		this.idcaptura = idcaptura;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Integer getHumedad() {
		return this.humedad;
	}

	public void setHumedad(Integer humedad) {
		this.humedad = humedad;
	}

	public Integer getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

}
