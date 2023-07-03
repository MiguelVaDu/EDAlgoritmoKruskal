package entidad;

import java.io.Serializable;

public class Solicitud implements Serializable{
	
	private String descripcion;
	private int id;
	private Cliente clienteQueSolicita;
	
	public Solicitud(String descripcion, int id, Cliente clienteQueSolicita) {
		this.descripcion = descripcion;
		this.id = id;
		this.clienteQueSolicita = clienteQueSolicita;
	}
	
	public Solicitud() {
		this.descripcion = "";
		this.id = 0;
		this.clienteQueSolicita = null;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public Cliente getClienteQueSolicita() {
		return clienteQueSolicita;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setClienteQueSolicita(Cliente clienteQueSolicita) {
		this.clienteQueSolicita = clienteQueSolicita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

