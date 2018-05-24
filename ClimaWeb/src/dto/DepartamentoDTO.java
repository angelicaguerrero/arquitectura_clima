package dto;

import java.util.List;

public class DepartamentoDTO {

	private int idDeptarmento;
	private Boolean estado;
	private String Deptarmento;
	private List<CiudadDto> ciudades;

	public int getIdDeptarmento() {
		return idDeptarmento;
	}

	public void setIdDeptarmento(int idDeptarmento) {
		this.idDeptarmento = idDeptarmento;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDeptarmento() {
		return Deptarmento;
	}

	public void setDeptarmento(String deptarmento) {
		Deptarmento = deptarmento;
	}

	public List<CiudadDto> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<CiudadDto> ciudades) {
		this.ciudades = ciudades;
	}

}
