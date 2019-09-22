import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Biodata2 implements ActionListener
{
	JLabel stdbio=new JLabel("Student Biodata Info");
	JLabel stdname=new JLabel("Student Full Name: ");
	JLabel stdroll=new JLabel("Student Roll: ");
	JLabel gen=new JLabel("Gender ");
	JLabel smobi=new JLabel("Contact ");
	JLabel branch=new JLabel("Branch ");
	JLabel div=new JLabel("Div ");
	JLabel batch=new JLabel("Batch ");
	JLabel bloodgrp=new JLabel("Blood Group ");
	JLabel address=new JLabel("Residential Address ");
	JLabel fname=new JLabel("Father Name ");
	JLabel mname=new JLabel("Mother Name ");
	JLabel relig=new JLabel("Religious ");
	JLabel lastyr=new JLabel("Last Year (%) ");
	JLabel mailid=new JLabel("Mail Id ");
	JLabel gl=new JLabel();
	
	JLabel branchjc=new JLabel();
	JLabel divcb=new JLabel();
	JLabel batchjc=new JLabel();
	
	JTextField rollnot=new JTextField(5);
	JTextField namet=new JTextField(10);
	JTextField fnamet=new JTextField(5);
	JTextField mnamet=new JTextField(5);
	JTextField religt=new JTextField(5);
	JTextField lastyrt=new JTextField(3);
	JTextField mailt=new JTextField(10);
	JTextField tsmobi=new JTextField(10);
	JTextField bloodgrpt=new JTextField(5);
	
	JTextArea addta=new JTextArea(5,40);
	

	JButton next=new JButton("Next");
	JButton pre=new JButton("Previous");
	JButton can=new JButton("Cancel");
	
	Connection con;
	  ResultSet rs1;
	  ResultSet rs2;
	  Statement ps1,ps2;
	
	JFrame newf;
	
	
	Biodata2(){
			 rollnot.setEditable(false);
	 namet.setEditable(false);
	 fnamet.setEditable(false);
	 mnamet.setEditable(false);
	 religt.setEditable(false);
	 lastyrt.setEditable(false);
	 mailt.setEditable(false);
	 tsmobi.setEditable(false);
	 bloodgrpt.setEditable(false);
	 addta.setEditable(false);
	
		newf=new JFrame("Java Mini");
		Container c=newf.getContentPane();
		c.setLayout(null);
		stdbio.setFont(new Font("Serif", Font.BOLD,30));
		stdbio.setHorizontalAlignment(JLabel.CENTER);
		stdbio.setVerticalAlignment(JLabel.CENTER);
		
	stdbio.setForeground(Color.blue);
	
	
		next.addActionListener(this);
		pre.addActionListener(this);
		can.addActionListener(this);
		
		stdbio.setBounds(0,0,600,50);
		stdname.setBounds(25,75,125,25);
		namet.setBounds(150, 75,150,25);
		stdroll.setBounds(325,75,100,25);
		rollnot.setBounds(425,75,150,25);
		
		gen.setBounds(25,115,75,25);
		gl.setBounds(100,115,100,25);
		smobi.setBounds(325,115,115,25);
		tsmobi.setBounds(425,115,150,25);
		
		branch.setBounds(25,155,75,25);
		branchjc.setBounds(100,155,100,25);
		div.setBounds(225,155,75,25);
		divcb.setBounds(300,155,100,25);
		batch.setBounds(425,155,75,25);
		batchjc.setBounds(500,155,75,25);
		
		fname.setBounds(25,195,125,25);
		fnamet.setBounds(150,195,150,25);
		mname.setBounds(325,195,100,25);
		mnamet.setBounds(425,195,150,25);
		
		address.setBounds(25,235,125,75);
		addta.setBounds(150,235,425,75);
		
		
		bloodgrp.setBounds(25,330,125,25);
		bloodgrpt.setBounds(150,330,150,25);
		relig.setBounds(325,330,100,25);
		religt.setBounds(425,330,150,25);
		
		lastyr.setBounds(25,370,125,25);
		lastyrt.setBounds(150,370,150,25);
		mailid.setBounds(325,370,100,25);
		mailt.setBounds(425,370,150,25);
		
		pre.setBounds(25,410,150,35);
		can.setBounds(225,410,150,35);
		next.setBounds(425,410,150,35);
		
		
		
		newf.add(stdbio);
		newf.add(stdname);
		newf.add(namet);
		newf.add(stdroll);
		newf.add(rollnot);
		
		newf.add(gen);
		newf.add(gl);
		
		newf.add(smobi);
		newf.add(tsmobi);
		
		newf.add(branch);
		newf.add(branchjc);
		newf.add(div);
		newf.add(divcb);
		newf.add(batch);
		newf.add(batchjc);
			
		newf.add(fname);
		newf.add(fnamet);
		newf.add(mname);
		newf.add(mnamet);
	
	
		newf.add(address);
		newf.add(addta);
		
		newf.add(bloodgrp);
		newf.add(bloodgrpt);
		newf.add(relig);
		newf.add(religt);
		
		
		newf.add(lastyr);
		newf.add(lastyrt);
		newf.add(mailid);
		newf.add(mailt);
		
		newf.add(pre);	
		newf.add(can);
		newf.add(next);
			
	
		try{
		
		Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamini","root","");

		 ps1=con.createStatement();
		 ps2=con.createStatement();
		 

		rs1=ps1.executeQuery("Select * from studentclginfo");
		rs2=ps2.executeQuery("Select * from studentgeneralinfo");
		
		rs1.next();
		rs2.next();
		
	
		}catch(Exception e){System.out.println(e.getMessage());}
		getdatabase();
		newf.setSize(600,500);
		newf.setVisible(true);
	
	}
	
	public void getdatabase(){
		try
		{
			
	 namet.setText(rs1.getString("name"));
	 
	 rollnot.setText(rs1.getInt("rollnum")+"");
	 gl.setText(rs1.getString("gender"));
	 branchjc.setText(rs1.getString("branch"));
	 divcb.setText(rs1.getString("division"));
	 batchjc.setText(rs1.getString("batch"));
	 lastyrt.setText(rs1.getFloat("semper")+"");
	
	 fnamet.setText(rs2.getString("fname"));
	 mnamet.setText(rs2.getString("mname"));
	 religt.setText(rs2.getString("rel"));
	  mailt.setText(rs2.getString("mail"));
	 tsmobi.setText(rs2.getString("contact"));
	 bloodgrpt.setText(rs2.getString("bloodg"));
	 addta.setText(rs2.getString("address"));
	  	}
	catch(Exception e){System.out.println(e.getMessage());}
		
}
	
	
	public void actionPerformed(ActionEvent ae){

		if (pre==ae.getSource())
		{	try{
			rs1.previous();
			rs2.previous();
			if(rs1.isBeforeFirst()){
				rs1.last();
				rs2.last();
				System.out.println("");
			}
			}
			catch(Exception e){System.out.println(e.getMessage());}
			
			getdatabase();
			
		}
		if (next==ae.getSource())
		{
			
			try{
		      rs1.next();
			  rs2.next();
			
			if(rs1.isAfterLast()){
				System.out.println("End of Database");
				rs1.first();
				rs2.first();
				
			}
			}
			catch(Exception e){System.out.println(e.getMessage());}
					
			getdatabase();
		}
	
		if (can==ae.getSource()){
			try{
		 	con.close();
			}
			catch(Exception e){System.out.println(e.getMessage());}
			newf.setVisible(false);
		}
	}
}
