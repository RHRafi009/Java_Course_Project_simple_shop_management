package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Menu;
import Panel.Users;
import Panel.UserList;

import Database.*;
import Panel.AddUser;
import java.sql.SQLException;

public class UsersEventHandlers implements ActionListener {

    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(Users.getRef());
        ref.add(Menu.getRef());
        ref.paintAll(ref.getGraphics());
    } 
    
    private void userlist(){
        ref.remove(Users.getRef());
        ref.add(UserList.getRef());
        ref.paintAll(ref.getGraphics());
        
    }
    
    private void addUser(){
        ref.remove(Users.getRef());
        ref.add(AddUser.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if("Back".equals(event)){
            back();
        } else if("User List".equals(event)){
            userlist();
        }else if("Add User".equals(event)){
            addUser();
        }
    }
    
}
