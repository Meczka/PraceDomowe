
	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


	public class ObliczObjetosc extends JDialog implements ActionListener{
		
		
			private JLabel masaL,gestoscL,wynikL;
			private JComboBox masaC,gestoscC,wynikC;
			private JTextArea masaT,gestoscT;
			private JButton jb;
		
		
		public ObliczObjetosc()
		{
			setSize(800,800);
			setLayout(null);
			setTitle("Oblicz gestosc");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			jb = new JButton("Oblicz");
			
			masaC = new JComboBox();
			masaT = new JTextArea();
			masaL =  new JLabel("Masa:");
			
			gestoscC = new JComboBox();
			gestoscT = new JTextArea();
			gestoscL =  new JLabel("Gêstoœæ:");
			
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
			wynikC.addItem("cm3");
			wynikC.addItem("dm3");
			wynikC.addItem("m3");
			
			gestoscL.setBounds(255, 50, 70, 20);
			gestoscT.setBounds(325,50,70,20);
			gestoscC.setBounds(400,50,70,20);
			gestoscC.addItem("g/cm3");
			gestoscC.addItem("g/dm3");
			gestoscC.addItem("kg/m3");
			
			
			add(masaC);
			add(masaL);
			add(masaT);
			
			add(gestoscC);
			add(gestoscL);
			add(gestoscT);
			add(wynikC);
			add(jb);
			add(wynikL);
			jb.addActionListener(this);
		}


		@Override
		public void actionPerformed(ActionEvent arg0) {
			BigDecimal masaText = null,gestoscText = null;
			try{
			masaText = new BigDecimal(masaT.getText());
			gestoscText = new BigDecimal(gestoscT.getText());
			}catch(Exception ex){}
			
			
			
			
			String masaChoose = masaC.getSelectedItem().toString();
			String gestoscChoose = gestoscC.getSelectedItem().toString();
			String wynikChoose = wynikC.getSelectedItem().toString();
			
			double a,b;
			
			a = Main.dlugosc(Main.extractDlugoscToIntFromGestosc(gestoscChoose), Main.extractDlugoscToIntFromObjetosc(wynikChoose));
			BigDecimal powtemp = new BigDecimal(Double.toString(a));
			powtemp = powtemp.pow(3);
			a = powtemp.doubleValue();
			b = Main.masa(Main.extractMasaToIntFromGestosc(gestoscChoose), Main.exportMasaToIntFromMasa(masaChoose));
			double d  =a/b;
			
			BigDecimal divideTemp = new BigDecimal(Double.toString(d));
			gestoscText=gestoscText.divide(divideTemp);
			
			BigDecimal wynik = masaText.divide(gestoscText);
			System.out.println(wynik.doubleValue());
			
		}
	}

