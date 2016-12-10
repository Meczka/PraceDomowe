import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ObliczGestosc extends JDialog implements ActionListener{
	private JLabel masaL,objetoscL,wynikL;
	private JComboBox masaC,objetoscC,wynikC;
	private JTextArea masaT,objetoscT;
	private JButton jb;
	public ObliczGestosc() {
		setSize(800,800);
		setLayout(null);
		setTitle("Oblicz gestosc");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	jb = new JButton("Oblicz");
		
		masaC = new JComboBox();
		masaT = new JTextArea();
		masaL =  new JLabel("Masa:");
		
		objetoscC = new JComboBox();
		objetoscT = new JTextArea();
		objetoscL =  new JLabel("Objetoœæ:");
		
		wynikC = new JComboBox();
		
		wynikL = new JLabel();
		
		jb.setBounds(200,100,70,20);
		
		masaL.setBounds(20,50,70,20);
		masaT.setBounds(95, 50, 70, 20);
		masaC.setBounds(170,50,75,20);
		masaC.addItem("kg");
		masaC.addItem("g");
		
		wynikL.setBounds(20, 100, 70, 20);
		wynikL.setText("Wynik w:");
		
		wynikC.setBounds(100,100,70,20);
		wynikC.addItem("g/cm3");
		wynikC.addItem("g/dm3");
		wynikC.addItem("kg/m3");
		
		objetoscL.setBounds(255, 50, 70, 20);
		objetoscT.setBounds(325,50,70,20);
		objetoscC.setBounds(400,50,70,20);
		objetoscC.addItem("cm3");
		objetoscC.addItem("dm3");
		objetoscC.addItem("m3");
		

		add(masaC);
		add(masaL);
		add(masaT);
		
		add(objetoscC);
		add(objetoscL);
		add(objetoscT);
		add(wynikC);
		add(jb);
		add(wynikL);
		jb.addActionListener(this);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
