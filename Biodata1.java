import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Biodata1 implements ActionListener
{
	JLabel stdbio=new JLabel("Student Biodata");
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
	
	JButton sub=new JButton("Submit");
	JButton can=new JButton("Cancel");
	
	JComboBox divcb;
	JComboBox batchjc;
	JComboBox branchjc;
	
	
	JRadioButton malecb=new JRadioButton("Male");
	JRadioButton femalecb=new JRadioButton("Female");
	ButtonGroup bg=new ButtonGroup();
	
	Connection con;
	
	JFrame newf;
	
	
	Biodata1(){
		newf=new JFrame("Java Mini");
		Container c=newf.getContentPane();
		c.setLayout(null);
		stdbio.setFont(new Font("Serif", Font.BOLD,30));
		stdbio.setHorizontalAlignment(JLabel.CENTER);
		stdbio.setVerticalAlignment(JLabel.CENTER);
		
		stdbio.setForeground(Color.blue);
	bg.add(malecb);
	bg.add(femalecb);
	
	divcb=new JComboBox();
	batchjc=new JComboBox();
	branchjc=new JComboBox();
	
	divcb.addItem("A");
	divcb.addItem("B");	
	batchjc.addItem("A1");
	batchjc.addItem("A2");	
	batchjc.addItem("A3");	
	batchjc.addItem("A4");	
	batchjc.addItem("B1");	
	batchjc.addItem("B2");	
	batchjc.addItem("B3");	
	batchjc.addItem("B4");	
	branchjc.addItem("COMP");
	branchjc.addItem("IT");
	branchjc.addItem("MECH");
	branchjc.addItem("EXTC");
	branchjc.addItem("CIVIL");
	
		
		sub.addActionListener(this);
		can.addActionListener(this);
		
		stdbio.setBounds(0,0,600,50);
		stdname.setBounds(25,75,125,25);
		namet.setBounds(150, 75,150,25);
		stdroll.setBounds(325,75,100,25);
		rollnot.setBounds(425,75,150,25);
		
		gen.setBounds(25,115,75,25);
		malecb.setBounds(100,115,100,25);
		femalecb.setBounds(200,115,100,25);
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
		
		sub.setBounds(100,410,150,35);
		can.setBounds(350,410,150,35);
		
		newf.add(stdbio);
		newf.add(stdname);
		newf.add(namet);
		newf.add(stdroll);
		newf.add(rollnot);
		
		newf.add(gen);
		newf.add(malecb);
		newf.add(femalecb);
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
		
		newf.add(sub);	
		newf.add(can);	
			
	
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javamini","root","");
		}catch(Exception e){System.out.println(e.getMessage());}
	
		newf.setSize(600,500);
		newf.setVisible(true);
	
	}
	
	
	public void actionPerformed(ActionEvent ae){

		if (sub==ae.getSource())
		{
			
			try
		{

	String sname,sgen="",sbranch,sdiv,sbatch,sbloodg,saddress,sfather,smother,srel,smail,imobi;
	int roll;
	
	float sper;

	sname=namet.getText();
	if(malecb.isSelected()){    
	sgen="Male";  
	}    
	if(femalecb.isSelected()){    
	sgen="Female";   
	}
	

	sbranch=""+branchjc.getSelectedItem();
	sdiv=""+divcb.getSelectedItem();
	sbatch=""+batchjc.getSelectedItem();

	sbloodg=bloodgrpt.getText();
	saddress=addta.getText();
	sfather=fnamet.getText();
	smother=mnamet.getText();
	srel=religt.getText();
	smail=mailt.getText();
	imobi=tsmobi.getText();
	
	roll=Integer.parseInt(rollnot.getText());
	
	sper=Float.parseFloat(lastyrt.getText());

	Statement ps1=con.createStatement();
	PreparedStatement updatestdclg = con.prepareStatement("insert into studentclginfo values(?,?,?,?,?,?,?)");
	updatestdclg.setInt(1,roll);
	updatestdclg.setString(2,sname);
	updatestdclg.setString(3,sgen);
	updatestdclg.setString(4,sbranch);
	updatestdclg.setString(5,sdiv);
	updatestdclg.setString(6,sbatch);
	updatestdclg.setFloat(7,sper);
	updatestdclg.executeUpdate();
	System.out.println("table update");

	PreparedStatement updatestdgen = con.prepareStatement("insert into studentgeneralinfo values(?,?,?,?,?,?,?,?,?)");
	updatestdgen.setInt(1,roll);
	updatestdgen.setString(2,sname);
	updatestdgen.setString(3,sfather);
	updatestdgen.setString(4,smother);
	updatestdgen.setString(5,sbloodg);
	updatestdgen.setString(6,imobi);
	updatestdgen.setString(7,saddress);
	updatestdgen.setString(8,srel);
	updatestdgen.setString(9,smail);

	updatestdgen.executeUpdate();
	System.out.println("table update");
	newf.setVisible(false);
	con.close();
	}
	catch(Exception e){System.out.println(e.getMessage());}
	}
		if (can==ae.getSource()){
			newf.setVisible(false);
		}
	}
}
