package Panel;

import java.awt.Rectangle;
import java.awt.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import Panel.Login_Page;
import eventHandlers.DailyTransactionEventHandlers;
import Database.*;



public class DailyTransaction extends JPanel{
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblID;
    private JLabel lblDate;
    private JLabel lblTime;
    private JLabel lblUser;
    private JLabel lblPro;
    private JLabel lblAmount;
    private JLabel lblSellPrice;
    private JLabel lblTotalPrice;
    private JLabel lblTotal;
    private JLabel lblCash;
    private JLabel lblReturn;
    private JTextField fldID;
    private JTextField fldUser;
    private JTextField fldDate;
    private JTextField fldTime;
    private JComboBox<String> fldPro1;
    private JComboBox<String> fldPro2;
    private JComboBox<String> fldPro3;
    private JComboBox<String> fldPro4;
    private JTextField fldAmount1;
    private JTextField fldAmount2;
    private JTextField fldAmount3;
    private JTextField fldAmount4;
    private JTextField fldSellPrice1;
    private JTextField fldSellPrice2;
    private JTextField fldSellPrice3;
    private JTextField fldSellPrice4;
    private JTextField fldTotal1;
    private JTextField fldTotal2;
    private JTextField fldTotal3;
    private JTextField fldTotal4;
    private JTextField fldTotalPrice;
    private JTextField fldCash;
    private JTextField fldReturn;
    private JButton btnBack;
    private JButton btnCalculate;
    private JButton btnReturn;
    private JButton btnSave;
    
    private static DailyTransaction ref;
    
    private DailyTransaction(){
        initializeComponents();
    }
    
    public static DailyTransaction getRef(){
        if(ref==null)
         ref = new DailyTransaction();
        return ref;
    }
    
    private void initializeComponents(){
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(150,25,1000,100);
        this.add(this.lblName);
        
        this.lblTi = new JLabel("Daily Transaction");
        this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
        this.lblTi.setBounds(300,150,500,50);
        this.add(this.lblTi);
        
        this.lblID = new JLabel("ID: ");
        this.lblID.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblID.setBounds(150, 230, 75, 35);
        this.add(this.lblID);
        
        this.lblUser = new JLabel("User: ");
        this.lblUser.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblUser.setBounds(150, 280, 75, 35);
        this.add(this.lblUser);
        
        Rectangle r = this.lblID.getBounds();
        
        this.lblDate = new JLabel("Date: ");
        this.lblDate.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(500, 0);
        this.lblDate.setBounds(r);
        this.add(this.lblDate);
       
        this.lblTime = new JLabel("Time: ");
        this.lblTime.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0, 50);
        this.lblTime.setBounds(r);
        this.add(this.lblTime);
        
        this.fldID = new JTextField();
        this.fldID.setBounds(200, 230, 150, 35);
        this.fldID.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldID);
        
        this.fldUser = new JTextField();
        this.fldUser.setBounds(200, 280, 150, 35);
        this.fldUser.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldUser);
        
        r = this.fldID.getBounds();
        
        this.fldDate = new JTextField();
        r.translate(520, 0);
        this.fldDate.setBounds(r);
        this.fldDate.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldDate);
        
        this.fldTime = new JTextField();
        r.translate(0, 50);
        this.fldTime.setBounds(r);
        this.fldTime.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldTime);
        
        this.lblPro = new JLabel("Product");
        this.lblPro.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblPro.setBounds(150,350,200,35);
        this.add(this.lblPro);
        
        r = this.lblPro.getBounds();
        
        this.lblAmount = new JLabel("Amount");
        this.lblAmount.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(230, 0);
        this.lblAmount.setBounds(r);
        this.add(this.lblAmount);
        
        this.lblSellPrice = new JLabel("Price per unit");
        this.lblSellPrice.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(230, 0);
        this.lblSellPrice.setBounds(r);
        this.add(this.lblSellPrice);
        
        this.lblTotalPrice = new JLabel("Total Price");
        this.lblTotalPrice.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(240, 0);
        this.lblTotalPrice.setBounds(r);
        this.add(this.lblTotalPrice);
        
        r = this.lblPro.getBounds();
        
        this.fldPro1 = new JComboBox<String>();
        r.translate(0, 50);
        this.fldPro1.setBounds(r);
        this.fldPro1.setFont(new Font("serif", Font.PLAIN, 22));
        productList(fldPro1);
        this.add(this.fldPro1);
        
        this.fldPro2 = new JComboBox<String>();
        r.translate(0, 50);
        this.fldPro2.setBounds(r);
        this.fldPro2.setFont(new Font("serif", Font.PLAIN, 22));
        productList(fldPro2);
        this.add(this.fldPro2);
        
        this.fldPro3 = new JComboBox<String>();
        r.translate(0, 50);
        this.fldPro3.setBounds(r);
        this.fldPro3.setFont(new Font("serif", Font.PLAIN, 22));
        productList(fldPro3);
        this.add(this.fldPro3);
        
        this.fldPro4 = new JComboBox<String>();
        r.translate(0, 50);
        this.fldPro4.setBounds(r);
        this.fldPro4.setFont(new Font("serif", Font.PLAIN, 22));
        productList(fldPro4);
        this.add(this.fldPro4);
        
        r = this.lblAmount.getBounds();
        
        this.fldAmount1 = new JTextField();
        r.translate(-10, 50);
        this.fldAmount1.setBounds(r);
        this.fldAmount1.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldAmount1);
        
        this.fldAmount2 = new JTextField();
        r.translate(0, 50);
        this.fldAmount2.setBounds(r);
        this.fldAmount2.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldAmount2);
        
        this.fldAmount3 = new JTextField();
        r.translate(0, 50);
        this.fldAmount3.setBounds(r);
        this.fldAmount3.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldAmount3);
        
        this.fldAmount4 = new JTextField();
        r.translate(0, 50);
        this.fldAmount4.setBounds(r);
        this.fldAmount4.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldAmount4);
        
        r = this.lblSellPrice.getBounds();
        
        this.fldSellPrice1 = new JTextField();
        r.translate(-10, 50);
        this.fldSellPrice1.setBounds(r);
        this.fldSellPrice1.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldSellPrice1);
        
        this.fldSellPrice2 = new JTextField();
        r.translate(0, 50);
        this.fldSellPrice2.setBounds(r);
        this.fldSellPrice2.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldSellPrice2);
        
        this.fldSellPrice3 = new JTextField();
        r.translate(0, 50);
        this.fldSellPrice3.setBounds(r);
        this.fldSellPrice3.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldSellPrice3);
        
        this.fldSellPrice4 = new JTextField();
        r.translate(0, 50);
        this.fldSellPrice4.setBounds(r);
        this.fldSellPrice4.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldSellPrice4);
        
        r = this.lblTotalPrice.getBounds();
        
        this.fldTotal1 = new JTextField();
        r.translate(-10, 50);
        this.fldTotal1.setBounds(r);
        this.fldTotal1.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldTotal1);
        
        this.fldTotal2 = new JTextField();
        r.translate(0, 50);
        this.fldTotal2.setBounds(r);
        this.fldTotal2.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldTotal2);
        
        this.fldTotal3 = new JTextField();
        r.translate(0, 50);
        this.fldTotal3.setBounds(r);
        this.fldTotal3.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldTotal3);
        
        this.fldTotal4 = new JTextField();
        r.translate(0, 50);
        this.fldTotal4.setBounds(r);
        this.fldTotal4.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldTotal4);
        
        this.lblTotal = new JLabel("Total: ");
        r.translate(-60, 50);
        this.lblTotal.setBounds(r);
        this.lblTotal.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.lblTotal);
        
        this.fldTotalPrice = new JTextField();
        r.translate(60, 0);
        this.fldTotalPrice.setBounds(r);
        this.fldTotalPrice.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldTotalPrice);
        
        this.lblCash = new JLabel("Cash: ");
        r.translate(-60, 50);
        this.lblCash.setBounds(r);
        this.lblCash.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.lblCash);
        
        this.fldCash = new JTextField();
        r.translate(60, 0);
        this.fldCash.setBounds(r);
        this.fldCash.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldCash);
        
        this.lblReturn = new JLabel("Return: ");
        r.translate(-75, 50);
        this.lblReturn.setBounds(r);
        this.lblReturn.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.lblReturn);
        
        this.fldReturn = new JTextField();
        r.translate(75, 0);
        this.fldReturn.setBounds(r);
        this.fldReturn.setFont(new Font("serif", Font.PLAIN, 22));
        this.add(this.fldReturn);
        
        this.btnBack = new JButton("Back");
        this.btnBack.setBounds(150,700,100,35);
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        this.add(this.btnBack);
        
        this.btnBack.addActionListener(new DailyTransactionEventHandlers());
        
        this.btnCalculate = new JButton("Calculate");
        this.btnCalculate.setBounds(300,700,150,35);
        this.btnCalculate.setFont(new Font("serif", Font.PLAIN, 20));
        this.add(this.btnCalculate);
        
        this.btnCalculate.addActionListener(new DailyTransactionEventHandlers());
        
        this.btnReturn = new JButton("Return");
        this.btnReturn.setBounds(500,700,100,35);
        this.btnReturn.setFont(new Font("serif", Font.PLAIN, 20));
        this.add(this.btnReturn);
        
        this.btnReturn.addActionListener(new DailyTransactionEventHandlers());
        
        this.btnSave = new JButton("Save");
        this.btnSave.setBounds(650,700,100,35);
        this.btnSave.setFont(new Font("serif", Font.PLAIN, 20));
        this.add(this.btnSave);
        
        this.btnSave.addActionListener(new DailyTransactionEventHandlers());
    }
    
    private void productList(JComboBox<String> box){
        try{
            Connection con = DBConnectionProvider.getDBConnection();
            Statement stmnt = con.createStatement();
            String query = "select * from Product_list";
            ResultSet rs = stmnt.executeQuery(query);
            
            while(rs.next()){
                box.addItem(rs.getString("Product_Name"));
            }
            
            }catch(Exception ex){
                System.out.println("Failed to get DBConn:: "+ex.getMessage());
            }
    }
    
    public void setDateTimeUserID(){
        int iID;
        String sID= "";
        
        try{
            Connection con = DBConnectionProvider.getDBConnection();
            Statement stmnt = con.createStatement();
            String query = "select * from daily_tran";
            ResultSet rs = stmnt.executeQuery(query);
          
            while(rs.next()){
                sID = rs.getString(1);
            }
            
        }catch(Exception ex){
            System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }
    iID = Integer.parseInt(sID);
    iID++;
    sID = Integer.toString(iID);
    this.fldID.setText(sID);
    
    Login_Page L = Login_Page.getRef();
    this.fldUser.setText(L.getCurrentuser());
    
    SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date d = new Date();
    String datetime = dFormat.format(d);
    String date = datetime.substring(0, datetime.indexOf(" "));
    String time = datetime.substring(datetime.indexOf(" ")+1);
    
    this.fldDate.setText(date);
    this.fldTime.setText(time);
    
    }
    
    public int isNull(){
        int i = 0;
        if(!this.fldAmount1.getText().isEmpty())
            i++;
        if(!this.fldAmount2.getText().isEmpty())
            i++;
        if(!this.fldAmount3.getText().isEmpty())
            i++;
        if(!this.fldAmount4.getText().isEmpty())
            i++;
        return i;
    }
    
    public void setFld(){
        this.fldAmount1.setText("");
        this.fldAmount2.setText("");
        this.fldAmount3.setText("");
        this.fldAmount4.setText("");
        this.fldSellPrice1.setText("");
        this.fldSellPrice2.setText("");
        this.fldSellPrice3.setText("");
        this.fldSellPrice4.setText("");
        this.fldTotal1.setText("");
        this.fldTotal2.setText("");
        this.fldTotal3.setText("");
        this.fldTotal4.setText("");
        this.fldTotalPrice.setText("");
        this.fldCash.setText("");
        this.fldReturn.setText("");
    }
    
    public void setFldSell1(String val){
        this.fldSellPrice1.setText(val);
    }
    
    public void setFldSell2(String val){
        this.fldSellPrice2.setText(val);
    }
    
    public void setFldSell3(String val){
        this.fldSellPrice3.setText(val);
    }
    
    public void setFldSell4(String val){
        this.fldSellPrice4.setText(val);
    }
    
    public String getFldSell1(){
        return this.fldSellPrice1.getText();
    }
    
    public String getFldSell2(){
        return this.fldSellPrice2.getText();
    }
    
    public String getFldSell3(){
        return this.fldSellPrice3.getText();
    }
    
    public String getFldSell4(){
        return this.fldSellPrice4.getText();
    }
    
    public String getPro1(){
        return this.fldPro1.getSelectedItem().toString();
    }
    
    public String getPro2(){
        return this.fldPro2.getSelectedItem().toString();
    }
    
    public String getPro3(){
        return this.fldPro3.getSelectedItem().toString();
    }
    
    public String getPro4(){
        return this.fldPro4.getSelectedItem().toString();
    }
    
    public String getamount1(){
        return this.fldAmount1.getText();
    }
    
    public String getamount2(){
        return this.fldAmount2.getText();
    }
    
    public String getamount3(){
        return this.fldAmount3.getText();
    }
    
    public String getamount4(){
        return this.fldAmount4.getText();
    }
    
    public void setTotal1(String val){
        this.fldTotal1.setText(val);
    }
    
    public void setTotal2(String val){
        this.fldTotal2.setText(val);
    }
    
    public void setTotal3(String val){
        this.fldTotal3.setText(val);
    }
    
    public void setTotal4(String val){
        this.fldTotal4.setText(val);
    }
    
    public String getTotal1(){
        return this.fldTotal1.getText();
    }
    
    public String getTotal2(){
        return this.fldTotal2.getText();
    }
    
    public String getTotal3(){
        return this.fldTotal3.getText();
    }
    
    public String getTotal4(){
        return this.fldTotal4.getText();
    }
    
    public void setFldTotal(String val){
        this.fldTotalPrice.setText(val);
    }
    
    public String getFldTotal(){
        return this.fldTotalPrice.getText();
    }
    
    public String getCash()
    { 
        return this.fldCash.getText();
    }
    public void setReturn(String value)
    {
        this.fldReturn.setText(value);
    }
    
    public String getID(){
        return this.fldID.getText();
    }
    
    public String getUser(){
        return this.fldUser.getText();
    }
    
    public String getDate(){
        return this.fldDate.getText();
    }
    
    public String getTime(){
        return this.fldTime.getText();
    }
    
   
}
    
    

