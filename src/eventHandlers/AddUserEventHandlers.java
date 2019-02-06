package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Users;
import Panel.AddUser;

import Database.*;

public class AddUserEventHandlers implements ActionListener {

    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(AddUser.getRef());
        ref.add(Users.getRef());
        ref.paintAll(ref.getGraphics());
    } 
    
    private void save(){
        AddUser A = AddUser.getRef();
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "INSERT INTO `user_table`(`User_name`, `Password`) VALUES (?,?)";
        try{
            PreparedStatement pstmt = con.prepareStatement(query);
            String user = A.getUserName();
            String pass = A.getPassword();
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();
            ref.remove(AddUser.getRef());
            ref.add(Users.getRef());
            ref.paintAll(ref.getGraphics());
            
        } catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if("Back".equals(event)){
            back();
        } else if("Save".equals(event)){
          save();  
        }
    }
    
}
