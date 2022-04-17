package view;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.Usuario;
import model.Reserva;

public class View7 extends JFrame implements Observer {
	Model model;
	Usuario u;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();

	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();
	
	public View7() 	{
	}
	
	public View7(Model model, Usuario u) 	{
	try 	{
		this.model = model;
		this.u = u;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
        ArrayList<Reserva> listaReservas = model.getListaReservas().getReservasUsuario(u);

		jLabel1.setText("Selecciona la reserva que quieres cancelar " + this.u.getNombre() + " " + this.u.getApellido() + ":");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		int y=0;
		for (int z=0;z<listaReservas.size();z++) {
			listajLabel.add(new JLabel());
			listajLabel.get(z).setText("Reserva: "+ listaReservas.get(z).getId() + " (" + listaReservas.get(z).getViaje().getAlojamiento().getCiudad() + ")");
			listajLabel.get(z).setBounds(new Rectangle(41, 65+y, 400, 23));

			listajButton.add(new JButton());
            listajButton.get(z).setBounds(new Rectangle(300, 65+y, 100, 27));
		    listajButton.get(z).setText("Cancelar");

		    listajButton.get(z).addActionListener(new ActionListener() 	{

			public void actionPerformed(ActionEvent e)  {
				
                


			}

		    });

			y+=50;
			
			this.getContentPane().add(listajLabel.get(z), null);
			this.getContentPane().add(listajButton.get(z), null);
		}
		
        this.getContentPane().add(jLabel1, null);
		
	}

	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}