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

import eventHandlers.ProfitChartEventHandlers;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfitChart extends JPanel{
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblTodaySell;
    private JLabel lblTodayCost;
    private JLabel lblTodayProfit;
    private JLabel lblTotalSell;
    private JLabel lblTotalCost;
    private JLabel lblTotalProfit;
    private JLabel lblSearch;
    private JLabel lblHint;
    private JTextField txtTodaySell;
    private JTextField txtTodayCost;
    private JTextField txtTodayProfit;
    private JTextField txtTotalSell;
    private JTextField txtTotalCost;
    private JTextField txtTotalProfit;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnBack;
    private static ProfitChart ref;
    
    private ProfitChart(){
        initializeComponents();
    }
    
    public static ProfitChart getRef(){
        if(ref == null)
            ref = new ProfitChart();
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
        
        this.lblTodaySell = new JLabel("Today's sell: ");
        this.lblTodaySell.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblTodaySell.setBounds(100,250,150,35);
        this.add(this.lblTodaySell);
        
        Rectangle r = this.lblTodaySell.getBounds();
        
        this.lblTodayCost = new JLabel("Today's cost: ");
        this.lblTodayCost.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblTodayCost.setBounds(r);
        this.add(this.lblTodayCost);
        
        this.lblTodayProfit = new JLabel("Today's profit: ");
        this.lblTodayProfit.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblTodayProfit.setBounds(r);
        this.add(this.lblTodayProfit);
        
        r = this.lblTodaySell.getBounds();
        
        this.txtTodaySell = new JTextField();
        this.txtTodaySell.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(170, 0);
        this.txtTodaySell.setBounds(r);
        this.add(this.txtTodaySell);
        
        this.txtTodayCost = new JTextField();
        this.txtTodayCost.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.txtTodayCost.setBounds(r);
        this.add(this.txtTodayCost);
        
        this.txtTodayProfit = new JTextField();
        this.txtTodayProfit.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.txtTodayProfit.setBounds(r);
        this.add(this.txtTodayProfit);
        
        r = this.txtTodaySell.getBounds();
        
        this.lblTotalSell = new JLabel("Total Sell: ");
        this.lblTotalSell.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(350, 0);
        this.lblTotalSell.setBounds(r);
        this.add(this.lblTotalSell);
        
        this.lblTotalCost = new JLabel("Total cost: ");
        this.lblTotalCost.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblTotalCost.setBounds(r);
        this.add(this.lblTotalCost);
        
        this.lblTotalProfit = new JLabel("Total profit: ");
        this.lblTotalProfit.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblTotalProfit.setBounds(r);
        this.add(this.lblTotalProfit);
        
        r = this.lblTotalSell.getBounds();
        
        this.txtTotalSell = new JTextField();
        this.txtTotalSell.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(170, 0);
        this.txtTotalSell.setBounds(r);
        this.add(this.txtTotalSell);
        
        this.txtTotalCost = new JTextField();
        this.txtTotalCost.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.txtTotalCost.setBounds(r);
        this.add(this.txtTotalCost);
        
        this.txtTotalProfit = new JTextField();
        this.txtTotalProfit.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0, 50);
        this.txtTotalProfit.setBounds(r);
        this.add(this.txtTotalProfit);
        
        this.lblHint = new JLabel("Enter date as 'yyyy-mm-dd'");
        this.lblHint.setFont(new Font("serif", Font.PLAIN, 20));
        this.lblHint.setBounds(400,450,250,35);
        this.add(this.lblHint);
        
        this.txtSearch = new JTextField();
        this.txtSearch.setFont(new Font("serif", Font.PLAIN, 20));
        this.txtSearch.setBounds(430,500,150,35);
        this.add(this.txtSearch);
        
        this.btnSearch = new JButton("Search");
        this.btnSearch.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnSearch.setBounds(450,550,100,35);
        this.add(this.btnSearch);
        
        this.btnSearch.addActionListener(new ProfitChartEventHandlers());
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnBack.setBounds(450,600,100,35);
        this.add(this.btnBack);
        
        this.btnBack.addActionListener(new ProfitChartEventHandlers());
    }

    public void setField(){
        int sell = 0, cost = 0, profit = 0; 
        Double _amount,_costprice;
        try{ 
            SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date d = new Date();
            String datetime = dFormat.format(d);
            String date = datetime.substring(0, datetime.indexOf(" "));
            String year = "20"+date.substring(date.lastIndexOf("/")+1);
            String month = date.substring(date.indexOf("/")+1, date.lastIndexOf("/"));
            String da = date.substring(0, date.indexOf("/"));
            String _date = year+"-"+month+"-"+da;
            System.out.print(_date);
            Connection con = DBConnectionProvider.getDBConnection();
            String query = "select * from daily_tran where date = ?";
            PreparedStatement stmnt = con.prepareStatement(query);
            stmnt.setString(1,_date);
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
        
        this.txtTodaySell.setText(Integer.toString(sell));
        this.txtTodayCost.setText(Integer.toString(cost));
        profit = sell-cost;
        this.txtTodayProfit.setText(Integer.toString(profit));
        
        int tsell = 0, tcost = 0, tprofit = 0; 
        Double tamount,tcostprice;
        
        try{ 
            Connection con = DBConnectionProvider.getDBConnection();
            Statement stmnt = con.createStatement();
            String query = "select * from daily_tran";
            ResultSet rs = stmnt.executeQuery(query);
            while(rs.next()){
                tsell +=Integer.parseInt( rs.getString("total"));
                tamount = Double.parseDouble(rs.getString("quantity"));
                tcostprice = Double.parseDouble(rs.getString("buy_cost"));
                tcost += (int) Math.round(tamount*tcostprice);
            }
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
        
        this.txtTotalSell.setText(Integer.toString(tsell));
        this.txtTotalCost.setText(Integer.toString(tcost));
        tprofit = tsell-tcost;
        this.txtTotalProfit.setText(Integer.toString(tprofit));
    }

    public String getdate(){
        return this.txtSearch.getText();
    }
}
