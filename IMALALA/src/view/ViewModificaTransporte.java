package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.Model;
import control.Observer;
import model.Alojamiento;
import model.Avion;
import model.Barco;
import model.Gestor;
import model.Viaje;
import model.Transporte;


public class ViewModificaTransporte extends JFrame implements Observer {
	Model model;
	Gestor g;
	Transporte transporte;
	Avion avion;
	Barco barco;
	JScrollPane jScrollPane1 = new JScrollPane();	
	private JComboBox <String> idtransp;
	private DefaultComboBoxModel <String> _idTransporte;
	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JTextField jTextField4 = new JTextField();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();	
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JButton jButton1 = new JButton();
	

	
	
	public ViewModificaTransporte() 	{
	}
	
	public ViewModificaTransporte(Model model, Gestor g) 	{
	try 	{
		this.model = model;
		this.g = g;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		setLocation(getX()+600, getY()+200);
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(250, 300, 200, 27));
		jButton1.setText("Confirmar cambios");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
	
		
		jLabel1.setText("Introduzca las informaciones que desee modificar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		_idTransporte =  new DefaultComboBoxModel<>(); 
		idtransp = new JComboBox<>(_idTransporte);
		jTextField1.setText("");
		jTextField1.setBounds(new Rectangle(150, 50, 100, 31));
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(150, 100, 100, 31));
		jTextField3.setText("");
		jTextField3.setBounds(new Rectangle(150, 150, 100, 31));
		jTextField4.setText("");
		jTextField4.setBounds(new Rectangle(150, 200, 100, 31));
		
		jLabel2.setText("Id del transporte:");
		jLabel2.setBounds(new Rectangle(42, 50, 100, 32));
		jLabel3.setText("Disponibilidad:");
		jLabel3.setBounds(new Rectangle(42, 100, 100, 32));
		jLabel4.setText("Capacidad:");
		jLabel4.setBounds(new Rectangle(42, 150, 100, 32));
		jLabel5.setText("Tipo:");
		jLabel5.setBounds(new Rectangle(42, 200, 100, 32));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jTextField2, null);
		this.getContentPane().add(jTextField3, null);
		this.getContentPane().add(jTextField4, null);
		//this.getContentPane().add(idtransp, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().isEmpty()&&!jTextField2.getText().isEmpty()&&!jTextField3.getText().isEmpty()&&!jTextField4.getText().isEmpty()) {
			String id = jTextField1.getText();
			if(this.model.getListaTransportes().buscarTransporte(id)!=null){
				String disponibilidad=jTextField2.getText();
				String capacidad=jTextField3.getText();

				//Transporte transporte, String id, String capacidad, boolean disponibilidad
				this.model.getListaTransportes().modificarTransporte(this.model.getListaTransportes().buscarTransporte(id), id, capacidad, true);;
				this.setVisible(false);

			}else JOptionPane.showMessageDialog(new JFrame(), "Error, id del transporte incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Error, hay campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);		
		}
	}
		
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}