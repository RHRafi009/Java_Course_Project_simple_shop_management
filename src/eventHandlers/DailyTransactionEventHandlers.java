package eventHandlers;

import java.lang.Math;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Menu;
import Panel.DailyTransaction;

import Database.*;

public class DailyTransactionEventHandlers implements ActionListener{
    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(DailyTransaction.getRef());
        ref.add(Menu.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
    private void calculate(){
        DailyTransaction d = DailyTransaction.getRef();
        int total = 0;
        int i = d.isNull();
        if(i==1){
            setFld1();
            setTotal1();
            d.setFldTotal(d.getTotal1());    
          
        }else if(i==2){
            setFld2();
            setTotal2();
            String t1 = d.getTotal1();
            int _t1 = Integer.parseInt(t1);
            String t2 = d.getTotal2();
            int _t2 = Integer.parseInt(t2);
            total = _t1 + _t2;
            d.setFldTotal(Integer.toString(total));
        }else if(i==3){
            setFld3();
            setTotal3();
            String t1 = d.getTotal1();
            int _t1 = Integer.parseInt(t1);
            String t2 = d.getTotal2();
            int _t2 = Integer.parseInt(t2);
            String t3 = d.getTotal3();
            int _t3 = Integer.parseInt(t3);
            total = _t1 + _t2 + _t3;
            d.setFldTotal(Integer.toString(total));
        }else if(i==4){
            setFld4();
            setTotal4();
            String t1 = d.getTotal1();
            int _t1 = Integer.parseInt(t1);
            String t2 = d.getTotal2();
            int _t2 = Integer.parseInt(t2);
            String t3 = d.getTotal3();
            int _t3 = Integer.parseInt(t3);
            String t4 = d.getTotal4();
            int _t4 = Integer.parseInt(t4);
            total = _t1 + _t2 + _t3 + _t4;
            d.setFldTotal(Integer.toString(total));
        }
        
            
    }
    
    private void setFld1(){
        try{
            Connection con = DBConnectionProvider.getDBConnection(); 
            String query = "select * from product_list where Product_Name= ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            DailyTransaction d = DailyTransaction.getRef();
            String product = d.getPro1();
            stmnt.setString(1,product);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next()){
            d.setFldSell1(rs.getString("Sell_Price"));
            }
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    }
    
    private void setFld2(){
        setFld1();
        try{
            Connection con = DBConnectionProvider.getDBConnection(); 
            String query = "select * from product_list where Product_Name= ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            DailyTransaction d = DailyTransaction.getRef();
            String product = d.getPro2();
            stmnt.setString(1,product);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next()){
            d.setFldSell2(rs.getString("Sell_Price"));
            }
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    }
    
    private void setFld3(){
        setFld1();
        setFld2();
        try{
            Connection con = DBConnectionProvider.getDBConnection(); 
            String query = "select * from product_list where Product_Name= ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            DailyTransaction d = DailyTransaction.getRef();
            String product = d.getPro3();
            stmnt.setString(1,product);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next()){
            d.setFldSell3(rs.getString("Sell_Price"));
            }
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    }
    
    private void setFld4(){
        setFld1();
        setFld2();
        setFld3();
        try{
            Connection con = DBConnectionProvider.getDBConnection(); 
            String query = "select * from product_list where Product_Name = ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            DailyTransaction d = DailyTransaction.getRef();
            String product = d.getPro4();
            stmnt.setString(1,product);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next()){
            d.setFldSell4(rs.getString("Sell_Price"));
            }
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    }
    
    private void setTotal1(){
        DailyTransaction d = DailyTransaction.getRef();
        String pricePU = d.getFldSell1();
        int price = Integer.parseInt(pricePU);
        String amt = d.getamount1();
        Double amount = Double.parseDouble(amt);
        Double total = price*amount;
        int _total = (int) Math.round(total);
        String totalPrice = Integer.toString(_total);
        d.setTotal1(totalPrice);
    }
    
    private void setTotal2(){
        setTotal1();
        DailyTransaction d = DailyTransaction.getRef();
        String pricePU = d.getFldSell2();
        int price = Integer.parseInt(pricePU);
        String amt = d.getamount2();
        double amount = Double.parseDouble(amt);
        double total = price*amount;
        int _total = (int) Math.round(total);
        String totalPrice = Integer.toString(_total);
        d.setTotal2(totalPrice);
    
    }
    
    private void setTotal3(){
       
        
        setTotal1();
        setTotal2();
        DailyTransaction d = DailyTransaction.getRef();
        String pricePU = d.getFldSell3();
        int price = Integer.parseInt(pricePU);
        String amt = d.getamount3();
        Double amount = Double.parseDouble(amt);
        Double total = price*amount;
        int _total = (int) Math.round(total);
        String totalPrice = Integer.toString(_total);
        d.setTotal3(totalPrice);
    }
    
    private void setTotal4(){
        setTotal1();
        setTotal2();
        setTotal3();
        DailyTransaction d = DailyTransaction.getRef();
        String pricePU = d.getFldSell4();
        int price = Integer.parseInt(pricePU);
        String amt = d.getamount4();
        Double amount = Double.parseDouble(amt);
        Double total = price*amount;
        int _total = (int) Math.round(total);
        String totalPrice = Integer.toString(_total);        
        d.setTotal4(totalPrice);
    }
    
    private void _return(){
        DailyTransaction d = DailyTransaction.getRef();
        String cash = d.getCash();
        String total =d.getFldTotal();
        int _cash = Integer.parseInt(cash);
        int _total = Integer.parseInt(total);
        int _return = _cash - _total;
        d.setReturn(Integer.toString(_return));
         
    }
    
    private void insert1(){
            DailyTransaction d = DailyTransaction.getRef();
        String id = d.getID();
        String user = d.getUser();
        String date = d.getDate();
        String year = "20"+date.substring(date.lastIndexOf("/")+1);
        System.out.print(year);
        String month = date.substring(date.indexOf("/")+1, date.lastIndexOf("/"));
        String da = date.substring(0, date.indexOf("/"));
        String _date = year+"-"+month+"-"+da;
        String time = d.getTime();
            String pro1 = d.getPro1();
            String amount1 = d.getamount1();
            String sell1 = d.getFldSell1();
            String total1 = d.getTotal1();
            String buy1 = "";
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "select * from product_list where Product_Name = ?";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,pro1);
                ResultSet rs = stmnt.executeQuery();
                while(rs.next()){
                   buy1 = rs.getString("Buy_Cost");
                }
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "INSERT INTO `daily_tran`(`ID`, `product_name`, `quantity`, `buy_cost`, `sell_price`, total, `date`, `time`, `user`) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,id);
                stmnt.setString(2,pro1);
                stmnt.setString(3,amount1);
                stmnt.setString(4,buy1);
                stmnt.setString(5,sell1);
                stmnt.setString(6,total1);
                stmnt.setString(7,_date);
                stmnt.setString(8,time);
                stmnt.setString(9,user);
                stmnt.executeUpdate();
                
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            updateProduct(pro1,amount1);
    }
    
    private void insert2(){
        DailyTransaction d = DailyTransaction.getRef();
        String id = d.getID();
        String user = d.getUser();
        String date = d.getDate();
        String year = "20"+date.substring(date.lastIndexOf("/")+1);
        String month = date.substring(date.indexOf("/")+1, date.lastIndexOf("/"));
        String da = date.substring(0, date.indexOf("/"));
        String _date = year+"-"+month+"-"+da;
        String time = d.getTime();
        String pro2 = d.getPro2();
            String amount2 = d.getamount2();
            String sell2 = d.getFldSell2();
            String total2 = d.getTotal2();
            String buy2 = "";
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "select * from product_list where Product_Name = ?";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,pro2);
                ResultSet rs = stmnt.executeQuery();
                while(rs.next()){
                   buy2 = rs.getString("Buy_Cost");
                }
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "INSERT INTO `daily_tran`(`ID`, `product_name`, `quantity`, `buy_cost`, `sell_price`, total, `date`, `time`, `user`) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,id);
                stmnt.setString(2,pro2);
                stmnt.setString(3,amount2);
                stmnt.setString(4,buy2);
                stmnt.setString(5,sell2);
                stmnt.setString(6,total2);
                stmnt.setString(7,_date);
                stmnt.setString(8,time);
                stmnt.setString(9,user);
                stmnt.executeUpdate();
                
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            updateProduct(pro2,amount2);
    }
    
    private void insert3(){
        
        DailyTransaction d = DailyTransaction.getRef();
        String id = d.getID();
        String user = d.getUser();
        String date = d.getDate();
        String year = "20"+date.substring(date.lastIndexOf("/")+1);
        String month = date.substring(date.indexOf("/")+1, date.lastIndexOf("/"));
        String da = date.substring(0, date.indexOf("/"));
        String _date = year+"-"+month+"-"+da;
        String time = d.getTime();
            String pro3 = d.getPro3();
            String amount3 = d.getamount3();
            String sell3 = d.getFldSell3();
            String total3= d.getTotal3();
            String buy3 = "";
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "select * from product_list where Product_Name = ?";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,pro3);
                ResultSet rs = stmnt.executeQuery();
                while(rs.next()){
                   buy3 = rs.getString("Buy_Cost");
                }
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "INSERT INTO `daily_tran`(`ID`, `product_name`, `quantity`, `buy_cost`, `sell_price`, total, `date`, `time`, `user`) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,id);
                stmnt.setString(2,pro3);
                stmnt.setString(3,amount3);
                stmnt.setString(4,buy3);
                stmnt.setString(5,sell3);
                stmnt.setString(6,total3);
                stmnt.setString(7,_date);
                stmnt.setString(8,time);
                stmnt.setString(9,user);
                stmnt.executeUpdate();
                
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            updateProduct(pro3,amount3);
    }
    
    private void insert4(){
        DailyTransaction d = DailyTransaction.getRef();
        String id = d.getID();
        String user = d.getUser();
        String date = d.getDate();
        String year = "20"+date.substring(date.lastIndexOf("/")+1);
        String month = date.substring(date.indexOf("/")+1, date.lastIndexOf("/"));
        String da = date.substring(0, date.indexOf("/"));
        String _date = year+"/"+month+"/"+da;
        String time = d.getTime();
        String pro4 = d.getPro4();
            String amount4 = d.getamount4();
            String sell4 = d.getFldSell4();
            String total4= d.getTotal4();
            String buy4 = "";
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "select * from product_list where Product_Name = ?";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,pro4);
                ResultSet rs = stmnt.executeQuery();
                while(rs.next()){
                   buy4 = rs.getString("Buy_Cost");
                }
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            try{
                Connection con = DBConnectionProvider.getDBConnection();
                String query = "INSERT INTO `daily_tran`(`ID`, `product_name`, `quantity`, `buy_cost`, `sell_price`, total, `date`, `time`, `user`) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmnt = con.prepareStatement(query);
                stmnt.setString(1,id);
                stmnt.setString(2,pro4);
                stmnt.setString(3,amount4);
                stmnt.setString(4,buy4);
                stmnt.setString(5,sell4);
                stmnt.setString(6,total4);
                stmnt.setString(7,date);
                stmnt.setString(8,time);
                stmnt.setString(9,user);
                stmnt.executeUpdate();
                
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
            updateProduct(pro4,amount4);
    }
    
    private void save (){
        DailyTransaction d = DailyTransaction.getRef();
        //String total = d.getTotalPrice();
        int i = d.isNull();
        if(i==1){
            insert1();
            d.setDateTimeUserID();
            d.setFld();
        }else if(i==2){
            insert1();
            insert2();
            
            d.setDateTimeUserID();
            d.setFld();
        
        }else if(i==3){
            insert1();
            insert2();
            insert3();
            d.setDateTimeUserID();
            d.setFld();
        
        }else if(i==4){
            insert1();
            insert2();
            insert3();
            insert4();
            
            d.setDateTimeUserID();
            d.setFld();
        }
    }
    
    private void updateProduct(String proName, String amount){
        try{
            Connection con = DBConnectionProvider.getDBConnection();
            String query = "UPDATE `product_list` SET `Quantity`= Quantity-? WHERE `Product_Name` = ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            stmnt.setString(1,amount);
            stmnt.setString(2,proName);
            stmnt.executeUpdate();
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    }
    
     
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if("Back".equals(event)){
            back();
        } else if("Calculate".equals(event)){
          calculate();  
        } else if("Return".equals(event)){
          _return(); 
        } else if("Save".equals(event)){
            save();
        }
        
    }
    
}
