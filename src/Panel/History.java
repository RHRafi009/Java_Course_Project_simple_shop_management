package Panel;

import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.List;


import eventHandlers.HistoryEventHandlers;

public class History extends JPanel{
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblSearch;
    private JTextField txtSearch;
    private JLabel lblPro;
    private JLabel lblAmount;
    private JLabel lblSell;
    private JLabel lblTotal;
    private JLabel lblTotalPrice;
    private JLabel lblProVal;
    private JLabel lblAmountVal;
    private JLabel lblSellVal;
    private JLabel lblTotalVal;
    private JLabel lblTotalpriceVal;
    private JButton btnSearch;
    private JButton btnBack;
    
    private static History r;
    
    private History(){
        initializeComponents();
    }
    
    public static History getRef(){
        if(r == null){
            r = new History();
        }
      return r;
    }
    
    private void initializeComponents(){
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblTi = new JLabel("History");
        this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
        this.lblTi.setBounds(400,150,500,50);
        this.add(this.lblTi);
        
        this.lblSearch = new JLabel("Enter ID:  ");
        this.lblSearch.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblSearch.setBounds(300,250,100,35);
        this.add(this.lblSearch);
        
        this.txtSearch = new JTextField();
        this.txtSearch.setBounds(400,250,200,35);
        this.add(this.txtSearch);
        
        this.btnSearch = new JButton ("Search");
        this.btnSearch.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnSearch.setBounds(400,300,150,35);
        this.add(this.btnSearch);
        this.btnSearch.addActionListener(new HistoryEventHandlers());
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnBack.setBounds(400,350,150,35);
        this.add(this.btnBack);
        this.btnBack.addActionListener(new HistoryEventHandlers());
        
    }
    
    public String getTxtID(){
        return this.txtSearch.getText();
    }
    
   
}
