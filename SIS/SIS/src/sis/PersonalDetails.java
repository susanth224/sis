package sis;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class PersonalDetails extends Panel{
	Boolean flag = false;
	Statement stmt;
	TextField nameText,idText,dobText,mailText,contactText,passText,rePassText;
	Choice branchText,batchText,classnoText;
	Button clr,update,loginHome,examRegistration,logout;
	Home hm;
//	public PersonalDetails(Statement st,String user){
//		stmt = st;
//		userId = user;
//	}

	public PersonalDetails(final Home hm){
		this.hm = hm;
		setSize(300,500);
		CreateJDBCConnection jdbc = new CreateJDBCConnection();
		stmt = jdbc.getStatement();
		Label name = new Label("Name");
		Label id = new Label("ID");
		idText = new TextField(15);
		nameText = new TextField(15);
		setLayout(new GridLayout(11,2));
		
		Label classno = new Label("Class");
		classnoText = new Choice();
		classnoText.addItem("Select");		
		classnoText.addItem("1");
		classnoText.addItem("2");
		classnoText.addItem("3");
		classnoText.addItem("4");
		classnoText.addItem("5");
		classnoText.addItem("6");

		Label branch = new Label("Branch");
		branchText = new Choice();
		branchText.addItem("Select");		
		branchText.addItem("CSE");
		branchText.addItem("ECE");
		branchText.addItem("MME");
		branchText.addItem("MECH");
		branchText.addItem("CHEM");
		branchText.addItem("CIVIL");

		Label dob = new Label("DOB");
		dobText = new TextField(15);

		Label batch = new Label("Batch");
		batchText = new Choice();
		batchText.add("Select");
		batchText.add("E4");
		batchText.add("E3");
		batchText.add("E2");
		
		Label mail = new Label("Email ");
		mailText = new TextField(15);
		
		Label contact = new Label("Contact No ");
		contactText = new TextField(15);

		update = new Button("Edit");
		update.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getActionCommand()=="Edit")
					update(true);
				else{
					update(false);				
				}
			}
			
		});
		
		clr = new Button("Clear");
		clr.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(flag)
					setTextFieldsToNull();
			}
		});
		
		Label password = new Label("Password");
		passText = new TextField(15);
		Label rePassword = new Label("Confirm Password");
		rePassText = new TextField(15);

		add(id);
		add(idText);
		
		add(name);
		add(nameText);

		add(batch);
		add(batchText);

		add(branch);
		add(branchText);

		add(classno);
		add(classnoText);

		add(dob);
		add(dobText);
		
		add(mail);
		add(mailText);
		
		add(contact);
		add(contactText);

		add(password);
		add(passText);
		
		add(rePassword);
		add(rePassText);
		
		add(update);
		add(clr);
		disableTextFields();
	}
	
	@SuppressWarnings("deprecation")
	public void disableTextFields(){
		nameText.disable();;
		idText.disable();
		classnoText.disable();
		branchText.disable();
		dobText.disable();
		batchText.disable();
		mailText.disable();
		contactText.disable();
		passText.disable();
		rePassText.disable();
	}
	@SuppressWarnings("deprecation")
	public void enableTextFields(){
		nameText.enable();;
		idText.enable();
		classnoText.enable();
		branchText.enable();
		dobText.enable();
		batchText.enable();				
		mailText.enable();
		contactText.enable();
		passText.enable();
		rePassText.enable();
	}
	
	@SuppressWarnings("deprecation")
	public void update(boolean value){
		if(value){
			update.setLabel("Update");
			enableTextFields();
			flag = true;
		}
		else{
			String sql = "update user_details set name='"+nameText.getText()+"',idno='"+idText.getText()+"',batch='"+batchText.getSelectedItem()+"',branch='"+branchText.getSelectedItem()+"',class='"+classnoText.getSelectedItem()+"',dob='"+dobText.getText()+"',email='"+mailText.getText()+"',cnctno='"+contactText.getText()+"',password='"+passText.getText()+"' where idno='"+hm.userId+"';";
			try {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			update.setLabel("Edit");
			disableTextFields();
			flag = false;
		}
	}
	
	public void setTextFieldsToNull(){
		nameText.setText("");
		idText.setText("");
		classnoText.select(0);
		branchText.select(0);
		dobText.setText("");
		batchText.select(0);
		mailText.setText("");
		contactText.setText("");
		passText.setText("");
		rePassText.setText("");
	}
	
	public void setTextFieldsToData() {
		String sql = "select * from user_details where idno = '"+hm.userId+"';";
		try {
			stmt.execute("use sisbase;");
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				nameText.setText(rs.getString("name"));
				idText.setText(rs.getString("idno"));
				classnoText.select(rs.getString("class"));
				branchText.select(rs.getString("branch"));
				dobText.setText(rs.getString("dob"));
				batchText.select(rs.getString("batch"));
				mailText.setText(rs.getString("email"));
				contactText.setText(rs.getString("cnctno"));
				passText.setText(rs.getString("password"));
				rePassText.setText(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTopPanel(){
		hm.p1 = new Panel();
		hm.p1.setLayout(null);
		hm.p1.setBounds(0, 0, 600, 50);
		loginHome = new Button("LoginHome");
		loginHome.setBounds(300, 10, 90, 30);
		loginHome.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.p2 = new BaseApplet(hm);
				hm.p2.setBounds(0, 50, 500, 400);
				hm.add(hm.p2);
				hm.revalidate();
			}
			
		});
		
		examRegistration = new Button("ExamRegistration");
		examRegistration.setBounds(400, 10, 100, 30);
		examRegistration.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.p2 = new ExamRegistration(hm);
				hm.p2.setBounds(0, 50, 500, 400);
				hm.add(hm.p2);
				hm.revalidate();				
			}
		});
		
		logout = new Button("logout");
		logout.setBounds(510, 10, 90, 30);
		logout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hm.removeAll();
				hm.addPanel1();
				hm.addPanel2();
				hm.revalidate();				
			}
		});
		Label lb2 = new Label("Welcome "+hm.userId);
		lb2.setBounds(20, 10, 150, 30);
		hm.p1.add(lb2);

		
		hm.p1.add(loginHome);
		hm.p1.add(examRegistration);
		hm.p1.add(logout);
		hm.p1.setBackground(Color.gray);
		hm.add(hm.p1);		
	}
}
