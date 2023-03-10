package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.Model;
import control.Observer;
import model.Usuario;

public class View3 extends JFrame {
	Model model;
	Usuario u;
	JScrollPane jScrollPane1 = new JScrollPane();	

	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JButton jButton1 = new JButton();
	

	
	
	public View3() 	{
	}
	
	public View3(Model model, Usuario u) 	{
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
		setTitle("Modificar datos");
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
	
		
		jLabel1.setText("Introduzca los datos que desee modificar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		jTextField1.setText(u.getId());
		jTextField1.setBounds(new Rectangle(150, 50, 100, 31));
		jTextField2.setText(u.getContrasena());
		jTextField2.setBounds(new Rectangle(150, 100, 100, 31));
		jTextField3.setText(u.getTlf());
		jTextField3.setBounds(new Rectangle(150, 150, 100, 31));
		
		jLabel2.setText("Id:");
		jLabel2.setBounds(new Rectangle(42, 50, 80, 32));
		jLabel3.setText("Contrasena:");
		jLabel3.setBounds(new Rectangle(42, 100, 80, 32));
		jLabel4.setText("tlf:");
		jLabel4.setBounds(new Rectangle(42, 150, 80, 32));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jTextField2, null);
		this.getContentPane().add(jTextField3, null);
		
	}

	void jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty()) {
			String id = jTextField1.getText();
			String contrasena = jTextField2.getText();
			String tlf = jTextField3.getText();
			
			this.model.getListaUsuarios().modificarDatosUsuario(u.getId(), id, contrasena, tlf);
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(new JFrame(), "Error, hay campos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);		
		}
	}
		
	
}