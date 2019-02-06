package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.AddNewProduct;
import Panel.ProductList;

import Database.*;


public class AddNewProductEventHandlers implements ActionListener {

    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(AddNewProduct.getRef());
        ref.add(ProductList.getRef());
        ref.paintAll(ref.getGraphics());
    } 
    
    private void save(){
        AddNewProduct P = AddNewProduct.getRef();
        Connection con = DBConnectionProvider.getDBConnection();
        String query = "INSERT INTO `product_list`(`Product_Name`, `Quantity`, `Buy_Cost`, `Sell_Price`) VALUES (?,?,?,?)";
        try{        
            PreparedStatement pstmt = con.prepareStatement(query);
            String productName = P.getProductName();
            String quantity = P.getQuantity();
            String buyCost = P.getBuyCost();
            String sellPrice = P.getSellPrice();
            pstmt.setString(1, productName);
            pstmt.setString(2, quantity);
            pstmt.setString(3, buyCost);
            pstmt.setString(4, sellPrice);
            pstmt.executeUpdate();
            ref.remove(AddNewProduct.getRef());
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
