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

import eventHandlers.UsersEventHandlers;

public class Users extends JPanel {
    
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblUser;
    private JLabel lblPass;
    private JTextField fldUser;
    private JTextField fldPass;
    private JButton btnSave;
    private JButton btnUserlist;
    private JButton btnAddUser;
    private JButton btnBack;

    private static Users ref; 
    
    private Users(){
        initializeComponents();
    }
    
    public static Users getRef(){
        if(ref==null)
            ref= new Users();
        return ref;
    }
    
    
    private void initializeComponents(){
        this.setLayout(null);
        Login_Page L = Login_Page.getRef();
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblTi = new JLabel("Current user");
        this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
        this.lblTi.setBounds(425,150,400,50);
        this.add(this.lblTi);

        this.lblUser = new JLabel("User Name");
        this.lblUser.setFont(new Font("serif", Font.PLAIN, 20));
        this.lblUser.setBounds(300,250,250,25);
        this.add(this.lblUser);
        
        Rectangle r = lblUser.getBounds();
        
        this.fldUser = new JTextField();
        r.translate(150, 0);
        this.fldUser.setBounds(r);
        this.fldUser.setText(L.getCurrentuser());
        this.add(this.fldUser);
        
        this.lblPass = new JLabel("Password");
        this.lblPass.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(-150,50);
        this.lblPass.setBounds(r);
        this.add(this.lblPass);

        this.fldPass = new JTextField();
        r.translate(150, 0);
        this.fldPass.setBounds(r);
        this.fldPass.setText(L.getCurrentpass());
        this.add(this.fldPass);

        this.btnUserlist = new JButton("User List");
        this.btnUserlist.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnUserlist.setBounds(450,400,200,35);
        this.add(this.btnUserlist);
        
        r = this.btnUserlist.getBounds(); 
        
        this.btnUserlist.addActionListener(new UsersEventHandlers());

        this.btnAddUser = new JButton("Add User");
        this.btnAddUser.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,50);
        this.btnAddUser.setBounds(r);
        this.add(this.btnAddUser);
        
        this.btnAddUser.addActionListener(new UsersEventHandlers());
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,50);
        this.btnBack.setBounds(r);
        this.add(this.btnBack);
        
        this.btnBack.addActionListener(new UsersEventHandlers());


    }
    
}
