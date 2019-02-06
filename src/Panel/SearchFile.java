package Panel;

import eventHandlers.HistoryEventHandlers;
import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.List;


import eventHandlers.SearchFileEventHandlers;


public class SearchFile extends JPanel {
    private JLabel lblName;
    private JLabel lblTi;
    private JLabel lblPro;
    private JLabel lblAmount;
    private JLabel lblSell;
    private JLabel lblTotal;
    private JLabel lblTotalPrice;
    private JTextField txtProVal;
    private JTextField txtAmountVal;
    private JTextField txtSellVal;
    private JTextField txtTotalVal;
    private JTextField txtTotalpriceVal;
    private JButton btnBack;
    private List<String> length;
    int _total= 0;
    private static SearchFile r;
    
    private SearchFile(){
        System.out.println("two");
        initializeComponents();
    }
    
    public static SearchFile getRef(){
        if(r == null){
            System.out.println("one");
            r = new SearchFile();
        }
      return r;
    }
        private void initializeComponents(){
        System.out.print("dhuksee");
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblTi = new JLabel("History");
        this.lblTi.setFont(new Font("monospaced", Font.BOLD, 42));
        this.lblTi.setBounds(400,150,500,50);
        this.add(this.lblTi);
        
        this.btnBack = new JButton("Back");
        this.btnBack.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnBack.setBounds(400,350,150,35);
        this.add(this.btnBack);
        this.btnBack.addActionListener(new SearchFileEventHandlers());
        
        this.lblPro = new JLabel ("Product");
        this.lblPro.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblPro.setBounds(250,400,150,35);
        this.add(this.lblPro);
        
        this.lblAmount = new JLabel ("Amount");
        this.lblAmount.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblAmount.setBounds(400,400,150,35);
        this.add(this.lblAmount);
        
        this.lblSell = new JLabel ("Price per unit");
        this.lblSell.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblSell.setBounds(550,400,150,35);
        this.add(this.lblSell);
        
        this.lblTotal = new JLabel ("Total");
        this.lblTotal.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblTotal.setBounds(750,400,150,35);
        this.add(this.lblTotal);
        
        this.lblTotalPrice = new JLabel("Total price: ");
        this.lblTotalPrice.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblTotalPrice.setBounds(650,650,150,35);
        this.add(this.lblTotalPrice);

}
      
    public void setProVal(List<String> val){
        this.length = val;
        Rectangle r = this.lblPro.getBounds();
        for(String s: val){
            this.txtProVal = new JTextField();
            this.txtProVal.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(0, 50);
            this.txtProVal.setBounds(r);
            this.add(this.txtProVal);
            this.txtProVal.setText(s);
        }
    }
    
    public void setAmountVal(List<String> val){
        Rectangle r = this.lblAmount.getBounds();
        for(String s: val){
            this.txtAmountVal = new JTextField();
            this.txtAmountVal.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(0, 50);
            this.txtAmountVal.setBounds(r);
            this.add(this.txtAmountVal);
            this.txtAmountVal.setText(s);
        }
    }
    
    public void setSellVal(List<String> val){
        Rectangle r = this.lblSell.getBounds();
        for(String s: val){
            this.txtSellVal = new JTextField();
            this.txtSellVal.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(0, 50);
            this.txtSellVal.setBounds(r);
            this.add(this.txtSellVal);
            this.txtSellVal.setText(s);
        }
    }
    
    public void setTotalVal(List<String> val){
        Rectangle r = this.lblTotal.getBounds();
        for(String s: val){
            this.txtTotalVal = new JTextField(s);
            this.txtTotalVal.setFont(new Font("serif", Font.PLAIN, 22));
            r.translate(0, 50);
            this.txtTotalVal.setBounds(r);
            this.add(this.txtTotalVal);
            this.txtTotalVal.setText(s);
            _total += Integer.parseInt(s);
        }
        r = this.lblTotalPrice.getBounds();
        r.translate(150,0);
        this.txtTotalpriceVal = new JTextField();
        this.txtTotalpriceVal.setText(Integer.toString(_total));
        this.txtTotalpriceVal.setFont(new Font("serif", Font.PLAIN, 22));
        this.txtTotalpriceVal.setBounds(r);
        this.add(this.txtTotalpriceVal);
    }
    
    public void setAll(){
            this._total = 0;
            this.txtTotalpriceVal.setText("");
    }
   
}
