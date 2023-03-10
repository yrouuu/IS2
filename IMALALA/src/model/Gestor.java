package model;
public class Gestor {
	private String nombre, contrasena;

	private static Gestor gestor;
	
	private Gestor (String nombre, String contrasena) {
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	
	public static Gestor getSingletonInstance(String nombre, String contrasena) {
			
		if (gestor == null) {
			gestor = new Gestor(nombre, contrasena);
		}
		else {
			System.out.println("No se puede crear el objeto, porque ya existe uno.");
		}

		return gestor;
	}
	
	public String getNombre (){
	    return this.nombre;
	}

	public void eliminarGestor() {
		Gestor.gestor = null;
	}
	
	public void cambiarGestor (String nombre, String contrasena) {
		this.eliminarGestor();
		Gestor.getSingletonInstance(nombre, contrasena);
	}

	public Object getContrasena() {
		return this.contrasena;
	}
}
