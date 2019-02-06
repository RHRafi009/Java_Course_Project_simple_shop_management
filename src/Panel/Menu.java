package Panel;

import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import eventHandlers.MenuEventhandlers;

public class Menu extends JPanel{
    protected JButton btnDailyBus;
    protected JButton btnHistory;
    protected JButton btnProduct;
    protected JButton btnProfit;
    protected JButton btnUser;
    protected JButton btnLogout;
    private JLabel lblName;
    
    private static Menu ref;
    
    private Menu()
    {
        initializeComponents();
    }
    
    public static Menu getRef()
    {
        if(ref==null)
            ref= new Menu();
        return ref;
    }
    
    private void initializeComponents()
    {
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.btnDailyBus = new JButton("Daily Business");
        this.btnDailyBus.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnDailyBus.setBounds(470,250,200,35);
        this.add(this.btnDailyBus);
        
        this.btnDailyBus.addActionListener(new MenuEventhandlers());
        
        Rectangle r = this.btnDailyBus.getBounds();
        
        this.btnHistory = new JButton("History");
        this.btnHistory.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,45);
        this.btnHistory.setBounds(r);
        this.add(this.btnHistory);
        
        this.btnHistory.addActionListener(new MenuEventhandlers());
        
        this.btnProduct = new JButton("Product List");
        this.btnProduct.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,45);
        this.btnProduct.setBounds(r);
        this.add(this.btnProduct);
        
         this.btnProduct.addActionListener(new MenuEventhandlers());
        
        this.btnProfit = new JButton("Profit Chart");
        this.btnProfit.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,45);
        this.btnProfit.setBounds(r);
        this.add(this.btnProfit);
        
        this.btnProfit.addActionListener(new MenuEventhandlers());
        
        this.btnUser = new JButton("User");
        this.btnUser.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,45);
        this.btnUser.setBounds(r);
        this.add(this.btnUser);
        
        this.btnUser.addActionListener(new MenuEventhandlers());
        
        this.btnLogout = new JButton("Logout");
        this.btnLogout.setFont(new Font("serif", Font.PLAIN, 20));
        r.translate(0,45);
        this.btnLogout.setBounds(r);
        this.add(this.btnLogout);
        
        this.btnLogout.addActionListener(new MenuEventhandlers());

    }
}
