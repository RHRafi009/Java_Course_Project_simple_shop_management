package Panel;

import java.awt.Rectangle;
import java.awt.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.*;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import eventHandlers.AddUserEventHandlers;


public class AddUser extends JPanel {
       private JLabel lblName;

    private JLabel lblTi;
    private JLabel lblUser;
    private JLabel lblpass;
    private JTextField fldUser;
    private JTextField fldpass;
    private JButton btnSave;
    private JButton btnBack;
    private static AddUser ref;
    
    private AddUser(){
        initializeComponents();
    }
    
    public static AddUser getRef(){
        if(ref == null)
            ref = new AddUser();
        return ref;
    }
    
private void initializeComponents(){
    this.setLayout(null);
    
    this.lblName = new JLabel("Daily Business Tracker");
    this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
    this.lblName.setBounds(100,25,1000,100);
    this.add(this.lblName);

    this.lblTi = new JLabel("ADD USER");
    this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
    this.lblTi.setBounds(425,150,400,50);
    this.add(this.lblTi);

    this.lblUser = new JLabel("User Name");
    this.lblUser.setFont(new Font("serif", Font.PLAIN, 22));
    this.lblUser.setBounds(350,250,100,25);
    this.add(this.lblUser);

    this.lblpass = new JLabel("Password");
    this.lblpass.setFont(new Font("serif", Font.PLAIN, 22));
    this.lblpass.setBounds(350,300,100,25);
    this.add(this.lblpass);

    this.fldUser = new JTextField();
    this.fldUser.setBounds(500,250,200,25);
    this.add(this.fldUser);

    this.fldpass = new JTextField();
    this.fldpass.setBounds(500,300,200,25);
    this.add(this.fldpass);

    this.btnSave = new JButton("Save");
    this.btnSave.setFont(new Font("serif", Font.PLAIN, 22));
    this.btnSave.setBounds(550,350,100,35);
    this.add(this.btnSave);
    
    this.btnSave.addActionListener(new AddUserEventHandlers());
    
    this.btnBack = new JButton("Back");
    this.btnBack.setFont(new Font("serif", Font.PLAIN, 22));
    this.btnBack.setBounds(350,350,100,35);
    this.add(this.btnBack);
 
    this.btnBack.addActionListener(new AddUserEventHandlers());

}

public String getUserName(){
    return this.fldUser.getText();
}

public String getPassword(){
    return this.fldpass.getText();
}
}
