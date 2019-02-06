package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Login_Page;
import Panel.Menu;

import Database.*;
import java.sql.SQLException;

public class LoginPageEventHandler implements ActionListener{

    private void login(){
        Connection con = DBConnectionProvider.getDBConnection();
        Login_Page L = Login_Page.getRef();

        try{
            Statement stmt = con.createStatement();
            String query = "select * from user_table";
            ResultSet rs = stmt.executeQuery(query);
            if(L.gettxtUserName().isEmpty() || L.getpassField().isEmpty()){
                L.settxtUserName("Enter your user Name and password");
            }else{
                
                String userName = L.gettxtUserName();
                String password = L.getpassField();
                while(rs.next()){
                    String dbUser = rs.getString("User_name");
                    String dbPass = rs.getString("Password");
                    L.setCurrentuser(dbUser, dbPass);
               
                   if(userName.equals(dbUser) && password.equals(dbPass)){
                        ApplicationFrame ref= ApplicationFrame.getRef();
                        ref.remove(Login_Page.getRef());
                        ref.add(Menu.getRef(), BorderLayout.CENTER);
                        ref.paintAll(ref.getGraphics());
                        break;
                   }
                   else{
                       L.settxtUserName("Enter your user Name and password");
                       L.setPassField();
                   }
                
                }
            }
        }catch(SQLException ex){
        
             System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
        
   }

    @Override
    public void actionPerformed(ActionEvent e) {
      login();
    }
  
}
