import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Main extends JFrame implements ActionListener
{
	private static HashMap<Integer,Integer> masa = new HashMap<Integer,Integer>();
	private static HashMap<Integer,Integer> dlugosc = new HashMap<Integer,Integer>();
	JMenuBar menuBar;
	JMenu matematyka,zapisz,ChemiaIfizyka,Narzedzia;
	JMenuItem srednia, potega,pierwiastek,dzielenie,Konwerter, notatnik,wynik,notatnikI,objetoscSzescianu,obliczMasê,obliczGêstoœæ,obliczObjêtoœæ;
	JLabel sredniaLabel;
	JTextArea NotatnikT;
	public void init()
	{
		masa.put(2, 1000);
		
		dlugosc.put(2, 10);
		dlugosc.put(3, 10);
	}
	public Main()
	{
		init();
		
		setSize(1000,1000);
		setTitle("Test");
		setLayout(null);
		menuBar = new JMenuBar();
		matematyka = new JMenu("Matematyka");
		srednia = new JMenuItem("Srednia");
		potega = new JMenuItem("Potega");
		pierwiastek = new JMenuItem("PierwiastekKw");
		dzielenie = new JMenuItem("Dzielenie");
		notatnik = new JMenuItem("Notatnik");
		sredniaLabel = new JLabel();
		objetoscSzescianu = new JMenuItem("Objêtoœæ szeœcianu");
		sredniaLabel.setBounds(10,10,100,20);
		NotatnikT = new JTextArea("");
		NotatnikT.setBounds(10,50,700,800);
		notatnikI = new JMenuItem("Notatnik");
		wynik = new JMenuItem("Wynik");
		Konwerter = new JMenuItem("Konwerter");
		zapisz = new JMenu("Zapisz");
		Narzedzia = new JMenu("Narzedzia");
		ChemiaIfizyka = new JMenu("Chemia i Fizyka");
		obliczGêstoœæ = new JMenuItem("Oblicz Gêstoœæ");
		obliczMasê = new JMenuItem("Oblicz Masê");
		obliczObjêtoœæ = new JMenuItem("Oblicz objêtoœæ");
		
		
		
		setJMenuBar(menuBar);
		menuBar.add(matematyka);
		menuBar.add(ChemiaIfizyka);
		menuBar.add(zapisz);
		menuBar.add(Narzedzia);
		zapisz.add(wynik);
		zapisz.add(notatnikI);
		matematyka.add(srednia);
		matematyka.add(potega);
		matematyka.add(pierwiastek);
		matematyka.add(dzielenie);
		matematyka.add(objetoscSzescianu);
		ChemiaIfizyka.add(obliczGêstoœæ);
		ChemiaIfizyka.add(obliczMasê);
		ChemiaIfizyka.add(obliczObjêtoœæ);
		Narzedzia.add(Konwerter);
		//matematyka.add(notatnik);
		add(sredniaLabel);
		add(NotatnikT);
		pierwiastek.addActionListener(this);
		srednia.addActionListener(this);
		potega.addActionListener(this);
		dzielenie.addActionListener(this);
		notatnik.addActionListener(this);
		notatnikI.addActionListener(this);
		objetoscSzescianu.addActionListener(this);
		wynik.addActionListener(this);
		obliczGêstoœæ.addActionListener(this);
		obliczObjêtoœæ.addActionListener(this);
		obliczMasê.addActionListener(this);
		Konwerter.addActionListener(this);
	}
	public static void main(String[] args)
	{
		
		
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if(z==srednia)
		{
			try
			{
				sredniaLabel.setText("Œrednia: ");
				float suma = 0;
			
				float ilosc  = Float.parseFloat(JOptionPane.showInputDialog("Podaj iloœæ liczb"));
				for(int i = 1; ilosc>=i;i++)
				{
					float temp = Float.parseFloat(JOptionPane.showInputDialog("Podaj " + i + " ocenê"));
					suma+=temp;
				}
				float s = suma/ilosc;
				sredniaLabel.setText(Float.toString(s));
			}catch(NumberFormatException ex)
			{
				sredniaLabel.setText("B³¹d");
			}
		}
		else if(z==potega)
		{
			float potega1,potega2 = 0;
			potega1 = Float.parseFloat(JOptionPane.showInputDialog("Potaj jaka liczbe chcesz wziazc do potegi"));
			potega2 = Float.parseFloat(JOptionPane.showInputDialog("Do ktorej potegi"));
			double out = Math.pow(potega1, potega2);
			sredniaLabel.setText("Wynik: "+ out);
		}
		else if(z==pierwiastek)
		{
			float a1,a2;
			a1 = Float.parseFloat(JOptionPane.showInputDialog("Liczba: "));
			sredniaLabel.setText("Wynik: "+Math.sqrt(a1));
		}
		else if(z==dzielenie)
		{
			float a1, a2;
			a1=Float.parseFloat(JOptionPane.showInputDialog("Dzielna"));
			a2=Float.parseFloat(JOptionPane.showInputDialog("Dzielnik"));
			a1/=a2;
			sredniaLabel.setText("Wynik :" + a1);
		}
		else if(z==notatnik)
		{
			NotatnikT.setVisible(true);
		}
		else if(z==notatnikI)
		{
			JFileChooser choose = new JFileChooser();
			if(choose.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
			{
				File plik = choose.getSelectedFile();
				try {
					PrintWriter pw = new PrintWriter(plik);
					Scanner skaner = new Scanner(NotatnikT.getText());
					while(skaner.hasNext())
					{
						pw.println(skaner.nextLine()+"\n");
					}
					pw.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(z==objetoscSzescianu)
		{
			float a1,a2,a3;
			a1=Float.parseFloat(JOptionPane.showInputDialog("Podaj szerkoœæ szeœcianu"));
			a2=Float.parseFloat(JOptionPane.showInputDialog("Podaj d³ugoœæ szeœcianu"));
			a3=Float.parseFloat(JOptionPane.showInputDialog("Podaj wysokoœæ szeœcianu"));
			float wynik;
			wynik=a1*a2*a3;
			sredniaLabel.setText("Wynik: " + wynik);
		}
		else if(z==obliczMasê)
		{
			ObliczMase om = new ObliczMase();
			om.setVisible(true);
		}
		else if(z==obliczGêstoœæ)
		{
			float masa,objetosc;
			masa=Float.parseFloat(JOptionPane.showInputDialog("Podaj masê(g)"));
			objetosc=Float.parseFloat(JOptionPane.showInputDialog("Podaj objêtoœæ(cm3)"));
			float wynik = masa/objetosc;
			sredniaLabel.setText("Wynik: "+wynik+" (g/cm3)");
		}
	}
	public static int extractMasaToInt(String gestosc)
	{
		if(gestosc.charAt(0)=='g')
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	public static int extractDlugoscToInt(String gestosc)
	{
		char temp = gestosc.charAt(gestosc.length()-3);
		switch(temp)
		{
		case 'c':
			return 1;
		case '/':
			return 3;
		case 'd':
			return 2;
		default:
			return 0;
		}
		
	}
	public static double dlugosc(int teraz,int cel)
	{
		if(teraz<cel)
		{
			teraz++;
			double temp =(double) 1/dlugosc.get(teraz);
			BigDecimal ile = new BigDecimal(Double.toString(temp));
			while(teraz<cel)
			{
				teraz++;
				double temp1=(double)1/dlugosc.get(teraz);
				BigDecimal bc = new BigDecimal(Double.toString(temp1));
				ile = ile.multiply(bc);
				
			}
			return ile.doubleValue();
		}
		else if(cel<teraz)
		{
			int ile;
			ile=dlugosc.get(teraz);
			teraz--;
			while(cel<teraz)
			{
				
				ile*=dlugosc.get(teraz);
				teraz--;
			}
			return ile;
		}
		else
		{
			return 0;
		}
	}
	public static double masa(int teraz,int cel)
	{
		if(teraz<cel)
		{
			teraz++;
			double temp = (double) 1/masa.get(teraz);
			BigDecimal ile = new BigDecimal(Double.toString(temp));
			while(teraz<cel)
			{
				teraz++;
				double temp1=(double) 1/masa.get(teraz);
				BigDecimal bc = new BigDecimal(Double.toString(temp1));
				ile= ile.multiply(bc);
			}
			return ile.doubleValue();
		}
		else if(cel<teraz)
		{
			int ile;
			ile=masa.get(teraz);
			teraz--;
			while(cel<teraz)
			{
				ile*=masa.get(teraz);
				teraz--;
			}
			return ile;
		}
		else
		{
			return 0;
		}
	}
}
class ObliczMase extends JDialog implements ActionListener
{
	private JComboBox left,right;
	private JLabel leftL,rightL;
	private JTextArea leftT,rightT;
	private JButton jb;
	
	public	ObliczMase()
	{
		setSize(800,800);
		setLayout(null);
		setTitle("Oblicz masê");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jb = new JButton("Oblicz");
		
		left = new JComboBox();
		leftT = new JTextArea();
		leftL =  new JLabel("Gêstoœæ:");
		
		right = new JComboBox();
		rightT = new JTextArea();
		rightL =  new JLabel("Objetoœæ:");
		
		jb.setBounds(200,100,70,20);
		
		leftL.setBounds(20,50,70,20);
		leftT.setBounds(95, 50, 70, 20);
		left.setBounds(170,50,75,20);
		left.addItem("kg/m3");
		left.addItem("g/cm3");
		left.addItem("g/dm3");
		
		
		rightL.setBounds(255, 50, 70, 20);
		rightT.setBounds(325,50,70,20);
		right.setBounds(400,50,70,20);
		right.addItem("m3");
		right.addItem("cm3");

		add(left);
		add(leftL);
		add(leftT);
		
		add(right);
		add(rightL);
		add(rightT);
		
		add(jb);
		
		jb.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if(z==jb)
		{
			String leftChoose = left.getSelectedItem().toString();
			String rightChoose = right.getSelectedItem().toString();
			System.out.println(Main.dlugosc(Main.extractDlugoscToInt(leftChoose), 1));
			System.out.println(Main.masa(Main.extractMasaToInt(leftChoose), 2));
			double leftText=0,rightText = 0;
			try
			{
				
				leftText = Double.parseDouble(leftT.getText());
				rightText = Double.parseDouble(rightT.getText());
			}catch(Exception e1)
			{
				
			}
			if(leftChoose.equals("kg/m3"))
			{
				if(rightChoose=="cm3")
				{
					rightText/=1000;
					double wynik = rightText*leftText;
					System.out.println(wynik);
				}
			}
		}
		
	}
	
}