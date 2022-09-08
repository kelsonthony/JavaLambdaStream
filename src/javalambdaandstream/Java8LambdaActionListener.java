package javalambdaandstream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Java8LambdaActionListener {

	public static void main(String[] args) {

		
		JButton b1 = new JButton();
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Olá JButton");
				
			}
			
		});
		
		JButton b2 = new JButton();
		b2.addActionListener(e -> System.out.println("Olá JButton"));
		
		
	}
}

// SAM - Single Abstract Method
// Qualquer interface que tenha um método abstratoc
