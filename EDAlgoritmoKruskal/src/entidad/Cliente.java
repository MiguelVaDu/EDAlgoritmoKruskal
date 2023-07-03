package entidad;

import algoritmo.Nodo;
public class Cliente extends Usuario {

	private String nombreComp;
	private String dni;
	private String telefono;
	private boolean usoSolicitud;
	private Nodo n;
	
	public Cliente(String correo, String string, String nombreComp, String dni, String telefono, Nodo n, boolean usoSolicitud) {
		super(correo, string);
		this.nombreComp = nombreComp;
		this.dni = dni;
		this.telefono = telefono;
		this.n=n;
		this.usoSolicitud=usoSolicitud;
	}

	public String getNombreComp() {
		return nombreComp;
	}

	public void setNombreComp(String nombreComp) {
		this.nombreComp = nombreComp;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public Nodo getN(){
		return n;
	}
	
	public boolean getUsoSolicitud() {
		return usoSolicitud;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setN(Nodo n){
		this.n=n;
	}
	
	public void setUsoSolicitud(boolean usoSolicitud) {
		this.usoSolicitud=usoSolicitud;
	}
	
}