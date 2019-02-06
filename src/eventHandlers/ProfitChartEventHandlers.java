
package eventHandlers;

import java.lang.Math;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Menu;
import Panel.ProfitChart;
import Panel.ChartView;

import Database.*;


public class ProfitChartEventHandlers implements ActionListener {

    ApplicationFrame ref = ApplicationFrame.getRef();
    
    private void back(){
        ref.remove(ProfitChart.getRef());
        ref.add(Menu.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
    private void search(){
        ref.remove(ProfitChart.getRef());
        ProfitChart p = ProfitChart.getRef();
        String date = p.getdate();
        ChartView c = ChartView.getRef();
        c.setField(date);
        ref.add(c);
        ref.paintAll(ref.getGraphics());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if("Back".equals(event)){
            back();
        } else if("Search".equals(event)){
            search();
        }
    }
    
}
