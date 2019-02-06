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
import Panel.Users;
import Panel.ProductList;
import Panel.DailyTransaction;
import Panel.History;
import Panel.ProfitChart;

import Database.*;
import java.sql.SQLException;

public class MenuEventhandlers implements ActionListener {

    ApplicationFrame ref= ApplicationFrame.getRef();
    
    private void logout(){
                    Login_Page L = Login_Page.getRef();
                    L.settxtUserName("Enter your user name and password");
                    L.setPassField();
                    ref.remove(Menu.getRef());
                    ref.add(Login_Page.getRef(), BorderLayout.CENTER);
                    ref.paintAll(ref.getGraphics());
    }
    
    private void users(){
        ref.remove(Menu.getRef());
        ref.add(Users.getRef(), BorderLayout.CENTER);
        ref.paintAll(ref.getGraphics());

    }
    
    private void productList(){
        ref.remove(Menu.getRef());
        ref.add(ProductList.getRef(), BorderLayout.CENTER);
        ProductList r = ProductList.getRef();
        r.initializeProductView();
        ref.paintAll(ref.getGraphics());
    }
    
    private void dailyTran(){
        ref.remove(Menu.getRef());
        ref.add(DailyTransaction.getRef(), BorderLayout.CENTER);
        DailyTransaction r = DailyTransaction.getRef();
        r.setDateTimeUserID();
        ref.paintAll(ref.getGraphics());
    }
    
    private void _history(){
        ref.remove(Menu.getRef());
        ref.add(History.getRef(), BorderLayout.CENTER);
        ref.paintAll(ref.getGraphics());
    }
    
    private void profitChart(){
        ref.remove(Menu.getRef());
        ProfitChart p = ProfitChart.getRef();
        p.setField();
        ref.add(ProfitChart.getRef(), BorderLayout.CENTER);
        ref.paintAll(ref.getGraphics());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if("Logout".equals(event)){
            logout();
        } else if("User".equals(event)){
            users();
        } else if("Product List".equals(event)){
            productList();
        } else if("Daily Business".equals(event)){
            dailyTran();
        } else if("History".equals(event)){
            _history();
        } else if("Profit Chart".equals(event)){
            profitChart();
        }
    }
    
}
