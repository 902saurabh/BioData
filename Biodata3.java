import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Biodata3 implements ActionListener
{
	JFrame f;
	JButton login,can;
	JLabel id,pass;
	TextField idt,passt;
	
	String id1="Saurabhkumar tiwari";
	String pass1="1711060";
	Biodata3(){
		f=new JFrame("Java Mini");
		Container c=f.getContentPane();
		c.setLayout(null);
		login=new JButton("Login");
		can=new JButton("Cancel");
		
		id=new JLabel("Admin Id");
		pass=new JLabel("Password");
		
		idt=new TextField();
		passt=new TextField();
	
		id.setBounds(25,50,125,40);
		idt.setBounds(225,50,125,40);
		
		pass.setBounds(25,125,125,40);
		passt.setBounds(225,125,125,40);
		
		login.setBounds(25,200,125,40);
		can.setBounds(225,200,125,40);
		
		login.addActionListener(this);
		can.addActionListener(this);
		
		passt.setEchoChar('*');
		
		f.add(login);
		f.add(can);
		f.add(pass);
		f.add(passt);
		f.add(id);
		f.add(idt);
		
		f.setSize(400,450);
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if (login==ae.getSource())
		{
			String tid=idt.getText();
			String tpass=passt.getText();
			if(tid.equals(id1) && tpass.equals(pass1)){
			f.setVisible(false);	
			new Biodata2();
			}
			else{
				System.out.println("Wrong id password");
			}
			
		}
		if (can==ae.getSource())
		{
		 	f.setVisible(false);
		}
	}
}
