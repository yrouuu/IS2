import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaTransportes {
	
	private ArrayList<Transporte> listaTransportes;
	private String ruta;
	public ListaTransportes(String ruta) {
		listaTransportes = new ArrayList<Transporte>();
		this.ruta=ruta;
	}
	

	public void llenarTransportes() {

		File doc = new File(ruta+"\\Aviones.txt");
		Scanner obj;
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaTransportes.add(new Avion(partes[0],partes[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		doc = new File(ruta+"\\Barcos.txt");
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine()){
				String linea = obj.nextLine();
				String[] partes = linea.split("-");
				listaTransportes.add(new Barco(partes[0],partes[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void exportarTransportes() {
		
		ArrayList<Avion> listaAviones = new ArrayList<Avion>();
		ArrayList<Barco> listaBarcos = new ArrayList<Barco>();;
		for (int z=0;z<this.listaTransportes.size();z++) {
			if(this.listaTransportes.get(z).getTipoTransporte().equals("avion")) {
				listaAviones.add((Avion)listaTransportes.get(z));
			}else {
				listaBarcos.add((Barco)listaTransportes.get(z));
			}
		}
		
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta+"\\Aviones.txt");
			pw = new PrintWriter(fichero);
			
			//escribir con pw.println();
			for (int z=0;z<listaAviones.size();z++) {
				pw.println(listaAviones.get(z).getId()+"-"+listaAviones.get(z).getCapacidad());
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
		
		try {
			fichero = new FileWriter(ruta+"\\Barcos.txt");
			pw = new PrintWriter(fichero);
			
			//escribir con pw.println();
			for (int z=0;z<listaBarcos.size();z++) {
				pw.println(listaBarcos.get(z).getId()+"-"+listaBarcos.get(z).getCapacidad());
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


	public Transporte buscarTransporte(String id) {

		boolean encont = false;
		int i = 0;

		while (!encont && i < listaTransportes.size()) {
			if (listaTransportes.get(i).getId().equals(id)) {
				encont=true;
			}
			i++;
		}
		return (listaTransportes.get(i-1));
		
	}
}
