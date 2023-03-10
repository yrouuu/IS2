package list;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Reserva;
import model.Usuario;
import model.Viaje;

public class ListaReservas {

	private ArrayList<Reserva> listaReservas;
	public ListaReservas() {

		this.listaReservas = new ArrayList<Reserva>();

	}

	public int getSize() {
		return listaReservas.size();
	}

	public void eliminaReserva(Reserva r) {
		boolean b = false;
		int i = 0;
		while (!b && i < listaReservas.size()) {
			if (listaReservas.get(i).equals(r)) {
				b = true;
				listaReservas.remove(i);
			}
			i++;
		}
	}
	
	public void anadeReserva(Reserva r) {
		listaReservas.add(r);
	}
	
	public ArrayList<Reserva> getReservasUsuario (Usuario u){
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		int i = 0;
		while (i < listaReservas.size()) {
			if (listaReservas.get(i).getUsuario().getId().equals(u.getId())) {
				lista.add(listaReservas.get(i));
			}
			i++;
		}
		
		return lista;
	}
	
	public int getReservasRealizadas(Viaje v){
		int i = 0;
		int r = 0;
		while (i < listaReservas.size()) {
			if (listaReservas.get(i).getViaje().getId().equals(v.getId())) {
				r++;
			}
			i++;
		}

		return r;
	}

	public void llenarReservas(ListaUsuarios listaUsuarios, ListaViajes listaViajes, String ruta) {
		File doc = new File(ruta+"\\Reservas.txt");	
		Scanner obj;
		
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaReservas.add(new Reserva(partes[0], listaUsuarios.buscarUsuario(partes[1]), listaViajes.buscarViaje(partes[2]), Boolean.parseBoolean(partes[3])));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void exportarReservas(String ruta) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta+"\\Reservas.txt");
			pw = new PrintWriter(fichero);
			
			//escribir con pw.println();
			for (int z=0;z<this.listaReservas.size();z++) {
				pw.println(listaReservas.get(z).getId()+"-"+listaReservas.get(z).getUsuario().getId()+"-"+
						listaReservas.get(z).getViaje().getId()+"-"+String.valueOf(listaReservas.get(z).getExtraPosibilidadCancelacion()));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (null!=fichero)
					fichero.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	

	
}
