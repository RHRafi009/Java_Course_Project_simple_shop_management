package eventHandlers;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Panel.ApplicationFrame;
import Panel.History;
import Panel.SearchFile;
public class SearchFileEventHandlers implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFrame ref = ApplicationFrame.getRef();
        SearchFile S = SearchFile.getRef();
        S.setAll();
        ref.remove(SearchFile.getRef());
        ref.add(History.getRef());
        ref.paintAll(ref.getGraphics());
    
    }
}
