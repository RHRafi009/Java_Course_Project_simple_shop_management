
package Panel;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class ApplicationFrame extends JFrame {
	private static ApplicationFrame ref;
	
	private ApplicationFrame(){
		ref = this;
		this.add(Login_Page.getRef(), BorderLayout.CENTER);
                this.setTitle("Daily Business Tracker");
		this.setBounds(100, 50, 1100, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static ApplicationFrame getRef(){
		if(ref==null)
			ref = new ApplicationFrame();
		return ref;
	}

}