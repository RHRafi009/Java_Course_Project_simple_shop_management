
package eventHandlers;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.ProfitChart;
import Panel.ChartView;


public class ChartViewEventHandlers implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFrame ref = ApplicationFrame.getRef();
        ref.remove(ChartView.getRef());
        ref.add(ProfitChart.getRef());
        ref.paintAll(ref.getGraphics());
    }
    
}
