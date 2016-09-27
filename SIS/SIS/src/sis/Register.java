package sis;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Register extends PersonalDetails{

	Button register;
	
	public Register(Home hm) {
		super(hm);
		setSize(500,500);
		// TODO Auto-generated constructor stub
		register = new Button("Register");
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(passText.getText().equals(rePassText.getText()))
					register();
				else
					JOptionPane.showMessageDialog(null, "password and confirmpassword should be same", "Alert", JOptionPane.OK_OPTION);
			}
			
		});
		super.remove(super.update);
		enableTextFields();
		add(register);
	}
	
	public void register(){
		String sql = "insert into user_details values('"+idText.getText()+"','"+nameText.getText()+"','"+batchText.getSelectedItem()+"','"+branchText.getSelectedItem()+"','"+classnoText.getSelectedItem()+"','"+dobText.getText()+"','"+mailText.getText()+"','"+contactText.getText()+"','"+passText.getText()+"');";
		try {
			stmt.execute("use sisbase;");
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Succusfully registerd", "Alert", JOptionPane.OK_OPTION);
			hm.remove(hm.p2);
			hm.p2 = new LoginScreen(hm);
			hm.p2.setBounds(0,40,600,560);
			hm.add(hm.p2);
			revalidate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Please Enter valid values", "Alert", JOptionPane.OK_OPTION);
		}
	}

}
