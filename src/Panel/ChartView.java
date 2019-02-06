package Panel;

import java.awt.Rectangle;
import java.awt.Font;
import java.lang.Math;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Database.*;

import eventHandlers.ChartViewEventHandlers;

public class ChartView extends JPanel{
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblSell;
    private JLabel lblCost;
    private JLabel lblProfit;
    private JTextField txtSell;
    private JTextField txtCost;
    private JTextField txtProfit;
    private JButton btnBack;
    private static ChartView ref;
    
    private ChartView(){
        initializeComponents();
    }
    
    public static ChartView getRef(){
        if(ref==null)
            ref = new ChartView();
        return ref;
    }
    
    private void initializeComponents(){
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblTi = new JLabel("Profit Chart");
        this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
        this.lblTi.setBounds(400,150,500,50);
        this.add(this.lblTi);
        
        this.lblSell = new JLabel("Sell: ");
        this.lblSell.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblSell.setBounds(300,250,150,35);
        this.add(this.lblSell);
        
        Rectangle r = this.lblSell.getBounds();
        
        this.lblCost = new JLabel("Cost: ");
        this.lblCost.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblCost.setBounds(r);
        this.add(this.lblCost);
        
        this.lblProfit = new JLabel("Profit: ");
        this.lblProfit.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblProfit.setBounds(r);
        this.add(this.lblProfit);
        
        r = this.lblSell.getBounds();
        
        this.txtSell = new JTextField();
        this.txtSell.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(170, 0);
        this.txtSell.setBounds(r);
        this.add(this.txtSell);
        
        this.txtCost = new JTextField();
        this.txtCost.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.txtCost.setBounds(r);
        this.add(this.txtCost);
        
        this.txtProfit = new JTextField();
        this.txtProfit.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.txtProfit.setBounds(r);
        this.add(this.txtProfit);
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.btnBack.setBounds(r);
        this.add(this.btnBack);
        
        this.btnBack.addActionListener(new ChartViewEventHandlers());
    }
    
    public void setField(String date){
        int sell = 0, cost = 0, profit = 0; 
        Double _amount,_costprice;
        try{
            Connection con = DBConnectionProvider.getDBConnection();
            String query = "select * from daily_tran where date = ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            stmnt.setString(1,date);
            ResultSet rs = stmnt.executeQuery();
            while(rs.next()){
                sell +=Integer.parseInt( rs.getString("total"));
                _amount = Double.parseDouble(rs.getString("quantity"));
                _costprice = Double.parseDouble(rs.getString("buy_cost"));
                cost += (int) Math.round(_amount*_costprice);
            }
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
        
        this.txtSell.setText(Integer.toString(sell));
        this.txtCost.setText(Integer.toString(cost));
        profit = sell-cost;
        this.txtProfit.setText(Integer.toString(profit));
    }

}

