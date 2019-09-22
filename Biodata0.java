import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Biodata0 implements ActionListener
{
	JFrame f=new JFrame("JAVA MINI");
	JButton admin;
	JButton student;
	
	Biodata0(){
		admin=new JButton("Admin login To View Student Biodata");
		student=new JButton("Student Registration");
		
		Container c=f.getContentPane();
		c.setLayout(null);
		
		admin.setBounds(50,50,300,125);
		student.setBounds(50,225,300,125);
		
		admin.addActionListener(this);
		student.addActionListener(this);
		
		f.add(admin);
		f.add(student);
		
		f.setSize(400,450);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String as[]){
		new Biodata0();
	}
	public void actionPerformed(ActionEvent ae){

		if (student==ae.getSource())
		{
			new Biodata1();
		}
		if (admin==ae.getSource())
		{
		
			new Biodata3();
		}
	}
}
