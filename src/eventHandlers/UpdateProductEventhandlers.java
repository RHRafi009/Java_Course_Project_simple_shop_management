package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.UpdateProduct;
import Panel.ProductList;

import Database.*;

public class UpdateProductEventhandlers implements ActionListener {

    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(UpdateProduct.getRef());
        ref.add(ProductList.getRef());
        ref.paintAll(ref.getGraphics());
    } 
    
    private void save(){
        UpdateProduct P = UpdateProduct.getRef();
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "UPDATE product_list SET Quantity= Quantity + ?,Buy_Cost = ?,Sell_Price=? WHERE Product_Name = ?";
        try{        
            PreparedStatement pstmt = con.prepareStatement(query);
            String productName = P.getProductName();
            int quantity = P.getQuantity();
            String buyCost = P.getBuyCost();
            String sellPrice = P.getSellPrice();
            pstmt.setInt(1, quantity);
            pstmt.setString(2, buyCost);
            pstmt.setString(3, sellPrice);
            pstmt.setString(4, productName);
            pstmt.executeUpdate();
            ref.remove(UpdateProduct.getRef());
            ref.add(ProductList.getRef());
            ProductList r = ProductList.getRef();
            r.initializeProductView();
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
