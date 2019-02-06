package Panel;

import java.awt.Rectangle;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import eventHandlers.ProductListEventhandlers;

public class ProductList extends JPanel {
    private JLabel lblName;
    private JLabel lblTi;
    private JButton btnBack;
    private JButton btnAdd;
    private JButton btnUpdate;
    private static JScrollPane scrPane;
    
    private static ProductList ref;
    
    private ProductList(){
        initializeComponents();
    }
    
    public static ProductList getRef(){
        System.out.print("dhuksee");
        if(ref==null)
            ref = new ProductList();
        //initializeProductView();
        return ref;
    }
    
    private void initializeComponents(){
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblTi = new JLabel("Product List");
        this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
        this.lblTi.setBounds(375,150,400,50);
        this.add(this.lblTi);
        
        this.btnAdd = new JButton("Add product");
        this.btnAdd.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnAdd.setBounds(150,250,200,35);
        this.add(this.btnAdd);
        
        this.btnAdd.addActionListener(new ProductListEventhandlers());
        
        Rectangle r = this.btnAdd.getBounds();
        
        this.btnUpdate = new JButton("Update product");
        this.btnUpdate.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(250, 0);
        this.btnUpdate.setBounds(r);
        this.add(this.btnUpdate);
        
        this.btnUpdate.addActionListener(new ProductListEventhandlers());
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(250, 0);
        this.btnBack.setBounds(r);
        this.add(this.btnBack);
        
        this.btnBack.addActionListener(new ProductListEventhandlers());
                
    }
    
    public void initializeProductView(){
        ProductListView view = new ProductListView();
        view.setPreferredSize(new Dimension(600,2000));
        
        this.scrPane = new JScrollPane(view);
        this.scrPane.setBounds(100,350,800,600);
        this.add(this.scrPane, BorderLayout.CENTER);

    }
    
}
