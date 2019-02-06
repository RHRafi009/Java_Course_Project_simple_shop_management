
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
import javax.swing.JScrollPane;

public class ProductListView extends JPanel {
    private JLabel lblID;
    private JLabel lblProductName;
    private JLabel lblQuantity;
    private JLabel lblBuyCost;
    private JLabel lblSellPrice;
    private JLabel lblIDval;
    private JLabel lblProductNameval;
    private JLabel lblQuantityval;
    private JLabel lblBuyCostval;
    private JLabel lblSellPriceval;
    
    public ProductListView(){
        initializeComponents();
    }    
    
    private void initializeComponents(){
        this.setLayout(null);
        
        this.lblID = new JLabel("ID");
        this.lblID.setFont(new Font("serif", Font.PLAIN, 20));
        this.lblID.setBounds(70,30,70,35);
        this.add(this.lblID);
        
        this.lblProductName = new JLabel("Product name");
        this.lblProductName.setFont(new Font("serif", Font.PLAIN, 20));
        this.lblProductName.setBounds(170,30,150,35);
        this.add(this.lblProductName);
        
        Rectangle r = this.lblProductName.getBounds();
        
        this.lblQuantity = new JLabel("Quantity");
        this.lblQuantity.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(200, 0);
        this.lblQuantity.setBounds(r);
        this.add(this.lblQuantity);
        
        this.lblBuyCost = new JLabel("Buy price");
        this.lblBuyCost.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(150, 0);
        this.lblBuyCost.setBounds(r);
        this.add(this.lblBuyCost);
        
        this.lblSellPrice = new JLabel("Sell price");
        this.lblSellPrice.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(150, 0);
        this.lblSellPrice.setBounds(r);
        this.add(this.lblSellPrice);
        
        try{
            Connection con = DBConnectionProvider.getDBConnection();
            Statement stmnt = con.createStatement();
            String query = "select * from Product_list";
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
            r = this.lblProductName.getBounds();
            while(rs.next()){
                this.lblProductNameval = new JLabel();
                this.lblProductNameval.setText(rs.getString("product_name"));
                this.lblProductNameval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblProductNameval.setBounds(r);
                this.add(this.lblProductNameval);
            }
            
            rs = stmnt.executeQuery(query);
            r = this.lblQuantity.getBounds();
            while(rs.next()){
                this.lblQuantityval = new JLabel();
                this.lblQuantityval.setText(rs.getString("Quantity"));
                this.lblQuantityval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblQuantityval.setBounds(r);
                this.add(this.lblQuantityval);
            }
            
            rs = stmnt.executeQuery(query);
            r = this.lblBuyCost.getBounds();
            while(rs.next()){
                this.lblBuyCostval = new JLabel();
                this.lblBuyCostval.setText(rs.getString("Buy_Cost"));
                this.lblBuyCostval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblBuyCostval.setBounds(r);
                this.add(this.lblBuyCostval);
            }
            
            rs = stmnt.executeQuery(query);
            r = this.lblSellPrice.getBounds();
            while(rs.next()){
                this.lblSellPriceval = new JLabel();
                this.lblSellPriceval.setText(rs.getString("Sell_Price"));
                this.lblSellPriceval.setFont(new Font("serif", Font.PLAIN, 18));
                r.translate(0, 50);
                this.lblSellPriceval.setBounds(r);
                this.add(this.lblSellPriceval);
            }
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    }
}
