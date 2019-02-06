package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.ProductList;
import Panel.Menu;
import Panel.AddNewProduct;
import Panel.UpdateProduct;

import Database.*;

public class ProductListEventhandlers implements ActionListener {
    ApplicationFrame ref = ApplicationFrame.getRef();
    private void back(){
        ref.remove(ProductList.getRef());
        ref.add(Menu.getRef());
        ref.paintAll(ref.getGraphics());
    } 
    
    private void addProduct(){
        ref.remove(ProductList.getRef());
        ref.add(AddNewProduct.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
    private void updateProduct(){
        ref.remove(ProductList.getRef());
        ref.add(UpdateProduct.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if("Back".equals(event)){
            back();
        } else if("Add product".equals(event)){
            addProduct();
        } else if("Update product".equals(event)){
            updateProduct();
        }
    }
    
}
