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
import javax.swing.JLabel;

import eventHandlers.UserListEventHandlers;


public class UserList extends JPanel {
   
    private JLabel lblName;
    private JLabel lblID;
    private JLabel lblUserName;
    private JLabel lblPassword;
    private JLabel lblIDval;
    private JLabel lblUserNameval;
    private JLabel lblPasswordval;
    private JButton btnBack;
    
    
    
    private static UserList ref; 
    
    private UserList(){
        initializeComponents();
    }
    
    public static UserList getRef(){   
        if(ref==null)
            ref= new UserList();
        return ref;
    }
   
    private void initializeComponents(){
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblID = new JLabel("ID");
        this.lblID.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblID.setBounds(150,200,50,35);
        this.add(this.lblID);
        
        Rectangle r = this.lblID.getBounds();
        
        this.lblUserName = new JLabel("User Name");
        this.lblUserName.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblUserName.setBounds(250,200,100,35);
        this.add(this.lblUserName);
        
        r = this.lblUserName.getBounds();
    
        this.lblPassword = new JLabel("Password");
        this.lblPassword.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(250, 0);
        this.lblPassword.setBounds(r);
        this.add(this.lblPassword);
        
        try{
            Connection con = DBConnectionProvider.getDBConnection();
            Statement stmnt = con.createStatement();
            String query = "select * from User_Table";
            ResultSet rs = stmnt.executeQuery(query);
            r = this.lblID.getBounds();
            while(rs.next()){
                this.lblIDval = new JLabel();
                this.lblIDval.setText(rs.getString("ID"));
                this.lblIDval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblIDval.setBounds(r);
                this.add(this.lblIDval);
            }
            
            rs = stmnt.executeQuery(query);
            r = this.lblUserName.getBounds();
            while(rs.next()){
                this.lblUserNameval = new JLabel();
                this.lblUserNameval.setText(rs.getString("User_name"));
                this.lblUserNameval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblUserNameval.setBounds(r);
                this.add(this.lblUserNameval);
            }
            
            rs = stmnt.executeQuery(query);
            r = this.lblPassword.getBounds();
            while(rs.next()){
                this.lblPasswordval = new JLabel();
                this.lblPasswordval.setText(rs.getString("Password"));
                this.lblPasswordval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblPasswordval.setBounds(r);
                this.add(this.lblPasswordval);
            }
            
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(150,-200);
        this.btnBack.setBounds(r);
        this.add(this.btnBack);
        
        this.btnBack.addActionListener(new UserListEventHandlers());
    }
    
}
