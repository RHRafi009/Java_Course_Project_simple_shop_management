package Panel;

import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import eventHandlers.AddNewProductEventHandlers;


public class AddNewProduct extends JPanel {
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblPro;
    private JLabel lblAmount;
    private JLabel lblBuyCost;
    private JLabel lblSellPrice;
    private JTextField fldPro;
    private JTextField fldAmount;
    private JTextField fldBuyCost;
    private JTextField fldSellPrice;
    private JButton btnSave;
    private JButton btnBack;
    
    private static AddNewProduct ref;
    
    private AddNewProduct(){
        initializeComponents();
    }
    
    public static AddNewProduct getRef(){
        if(ref==null)
            ref = new AddNewProduct();
        return ref;
    }
    
    private void initializeComponents(){
            this.setLayout(null);
            
            this.lblName = new JLabel("Daily Business Tracker");
            this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
            this.lblName.setBounds(150,25,1000,100);
            this.add(this.lblName);
			
            this.lblTi = new JLabel("Add New Product");
            this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
            this.lblTi.setBounds(400,150,400,50);
            this.add(this.lblTi);


            this.lblPro = new JLabel("Product");
            this.lblPro.setFont(new Font("serif", Font.PLAIN, 22));
            this.lblPro.setBounds(250,300,150,35);
            this.add(this.lblPro);
            
            Rectangle r = this.lblPro.getBounds();
            
            this.lblAmount = new JLabel("Amount");
            this.lblAmount.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(200, 0);
            this.lblAmount.setBounds(r);
            this.add(this.lblAmount);

            this.lblBuyCost = new JLabel("Buy Price");
            this.lblBuyCost.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(200, 0);
            this.lblBuyCost.setBounds(r);
            this.add(this.lblBuyCost);

            this.lblSellPrice = new JLabel("Sell Price");
            this.lblSellPrice.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(200, 0);
            this.lblSellPrice.setBounds(r);
            this.add(this.lblSellPrice);

            r = this.lblPro.getBounds();
            
            this.fldPro = new JTextField();
            r.translate(0, 50);
            this.fldPro.setBounds(r);
            this.add(this.fldPro);

            this.fldAmount = new JTextField();
            r.translate(200, 0);
            this.fldAmount.setBounds(r);
            this.add(this.fldAmount);

            this.fldBuyCost = new JTextField();
            r.translate(200, 0);
            this.fldBuyCost.setBounds(r);
            this.add(this.fldBuyCost);

            this.fldSellPrice = new JTextField();
            r.translate(200, 0);
            this.fldSellPrice.setBounds(r);
            this.add(this.fldSellPrice);

            this.btnSave = new JButton("Save");
            this.btnSave.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(-300, 100);
            this.btnSave.setBounds(r);
            this.add(this.btnSave);
            
            this.btnSave.addActionListener(new AddNewProductEventHandlers());

            this.btnBack = new JButton("Back");
            this.btnBack.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(0, 50);
            this.btnBack.setBounds(r);
            this.add(this.btnBack);
            
            this.btnBack.addActionListener(new AddNewProductEventHandlers());

    }
    
    public String getProductName(){
        return this.fldPro.getText();
    }
    
    public String getQuantity(){
        return this.fldAmount.getText();
    }
    
    public String getBuyCost(){
        return this.fldBuyCost.getText();
    }
    
    public String getSellPrice(){
        return this.fldSellPrice.getText();
    }
    
}
