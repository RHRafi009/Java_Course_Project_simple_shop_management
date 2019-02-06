package Panel;

import java.awt.Rectangle;
import java.awt.Font;
import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import eventHandlers.LoginPageEventHandler;
import java.awt.Color;

public class Login_Page extends JPanel{
    private JLabel lblName;
    private JLabel lblUserName;
    private JLabel lblPassword;
    private JLabel lblPrompt;
    private JTextField txtUserName;
    private JPasswordField passField;
    private JButton btnLogIn;
    private String CurrentUser;
    private String CurrentPass;
    
    private static Login_Page ref;
            
    
    private Login_Page()
    {
        initializeComponents();
    }
    
    public static Login_Page getRef()
    {
        if(ref==null)
            ref= new Login_Page();
        return ref;
        
    }
    
    private void initializeComponents()
    {
        this.setLayout(null);
        
        this.lblName = new JLabel("Daily Business Tracker");
        this.lblName.setFont(new Font("monospaced", Font.BOLD, 62));
        this.lblName.setBounds(100,25,1000,100);
        this.add(this.lblName);
        
        this.lblUserName = new JLabel("User Name:");
        this.lblUserName.setFont(new Font("serif", Font.PLAIN, 22));
        this.lblUserName.setBounds(300,300,300,25);
        this.add(this.lblUserName);
        
        Rectangle r = this.lblUserName.getBounds();
        
        this.lblPassword = new JLabel("Password:");
        this.lblPassword.setFont(new Font("serif", Font.PLAIN, 22));
        r.translate(0,30);
        this.lblPassword.setBounds(r);
        this.add(this.lblPassword);
        
        this.txtUserName = new JTextField();
        r.translate(150,-30);
        this.txtUserName.setBounds(r);
        this.add(this.txtUserName);
        
        this.passField = new JPasswordField(8);
        r.translate(0, 30);
        this.passField.setBounds(r);
        this.add(this.passField);
        
        this.btnLogIn = new JButton("Login");
        this.btnLogIn.setFont(new Font("serif", Font.PLAIN, 20));
        this.btnLogIn.setBounds(530,400,100,35);
        this.add(this.btnLogIn);
        
        this.btnLogIn.addActionListener(new LoginPageEventHandler());
         
        this.lblPrompt = new JLabel();
        r.translate(0, 30);
        this.lblPrompt.setBounds(r);
        this.add(this.lblPrompt);
        this.lblPrompt.setVisible(false);
    }
    
    public String gettxtUserName(){
        return this.txtUserName.getText();
    }
    
    public void settxtUserName(String info){
        this.lblPrompt.setText(info);
        this.lblPrompt.setForeground(Color.red);
        this.lblPrompt.setVisible(true);
    }
    
    public String getpassField(){
        char[] pass=this.passField.getPassword();
        String password = String.valueOf(pass);
        return password;
    }
    
    public void setPassField(){
        this.passField.setText("");
    }
    
    public void setCurrentuser(String u, String p)
    {
        this.CurrentUser = u;
        this.CurrentPass = p;
    }
    
    public String getCurrentuser(){
        return CurrentUser;
    }
    
    public String getCurrentpass(){
        return CurrentPass;
    }
}

