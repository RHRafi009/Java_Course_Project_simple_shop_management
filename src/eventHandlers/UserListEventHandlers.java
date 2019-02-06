package eventHandlers;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panel.ApplicationFrame;
import Panel.Users;
import Panel.UserList;

public class UserListEventHandlers implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("back");
        ApplicationFrame ref = ApplicationFrame.getRef();
        ref.remove(UserList.getRef());
        ref.add(Users.getRef());
        ref.paintAll(ref.getGraphics());

    }
    
}
