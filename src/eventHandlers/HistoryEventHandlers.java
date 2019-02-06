package eventHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Menu;
import Panel.History;

import java.util.ArrayList;
import java.util.List;
import Database.*;
import Panel.ProfitChart;
import Panel.SearchFile;

public class HistoryEventHandlers implements ActionListener {

    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(History.getRef());
        ref.add(Menu.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
    private void search(){
      SearchFile s = SearchFile.getRef();
      History H = History.getRef();
      List<String> product = new ArrayList<String>();
      List<String> amount = new ArrayList<String>();
      List<String> sell = new ArrayList<String>();
      List<String> total = new ArrayList<String>();
      String ID = H.getTxtID();
      try{
          Connection con = DBConnectionProvider.getDBConnection();
          String query = "select * from daily_tran where iD = ?";
          PreparedStatement pstmt = con.prepareStatement(query);
          pstmt.setString(1, ID);
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()){
              product.add(rs.getString("product_name"));
              amount.add(rs.getString("quantity"));
              sell.add(rs.getString("sell_price"));
              total.add(rs.getString("total"));
          }
          s.setProVal(product);
          s.setAmountVal(amount);
          s.setSellVal(sell);
          s.setTotalVal(total);
      }catch(Exception ex){
          System.out.println("Failed to get DBConn:: "+ex.getMessage());
      }
      
      ref.remove(History.getRef());
      ref.add(s.getRef());
      ref.paintAll(ref.getGraphics());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       String event = e.getActionCommand();
       if("Back".equals(event))
           back();
       else if("Search".equals(event))
           search();
        
    }
    
}
