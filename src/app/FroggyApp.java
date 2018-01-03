package app;

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.border.SoftBevelBorder;

import javafx.scene.layout.Border;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Program DressUpApp
 * Klasa DressUpApp 
 * @version 1.0 (14.11.2017)
 * @author Małgorzata Zawisza, Izabela Wedmann
*/


public class FroggyApp extends JFrame implements ActionListener{

	JPanel mainPanel, dataInPanel, dataOutPanel, terraPanel;
	JMenuBar menuBar;
	private JTextField textField;
	private JTextField textField_1;
	
	

/* -----------------------------------------------------------------------------------*/	
	
	/**
	 * Konstruktor klasy DressUpApp
	 */
	public FroggyApp() {
		
		setTitle("FroggyApp - program kontroli ...");
		setBounds(100, 100, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
	}

	
/* -----------------------------------------------------------------------------------*/
	
	/**
	 * Metoda tworząca obiekt typu JMenuBar
	 * @param x zmienna określająca położenie komponentu w osi X
	 * @param y zmienna określająca położenie komponentu w osi y
	 * @param width zmienna określająca szerokość komponentu
	 * @param height zmienna określająca wysokość komponentu
	 * @return zwraca obiekt typu JMenuBar
	 */
	public JMenuBar createMenuBar(int x, int y, int width, int height){
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 255, 240));
		menuBar.setBounds(0, 0, 994, 28);
		
		JMenu mnPlik = new JMenu("Plik");
		menuBar.add(mnPlik);
		
		JMenuItem mntmSymuluj = new JMenuItem("Symuluj");
		mnPlik.add(mntmSymuluj);
		
		JSeparator separator = new JSeparator();
		mnPlik.add(separator);
		
		JMenuItem mntmZakocz = new JMenuItem("Zakończ");
		mnPlik.add(mntmZakocz);
		
		JMenu mnNarzdzia = new JMenu("Narzędzia");
		menuBar.add(mnNarzdzia);
		
		JMenuItem mntmPauza = new JMenuItem("Pauza");
		mnNarzdzia.add(mntmPauza);
		
		JMenuItem mntmStart = new JMenuItem("Start");
		mnNarzdzia.add(mntmStart);
		
		JMenu mnPrdko = new JMenu("Prędkość");
		mnNarzdzia.add(mnPrdko);
		
		JMenuItem mntmX = new JMenuItem("x2");
		mnPrdko.add(mntmX);
		
		JMenuItem mntmX_1 = new JMenuItem("x5");
		mnPrdko.add(mntmX_1);
		
		JMenuItem mntmX_2 = new JMenuItem("x10");
		mnPrdko.add(mntmX_2);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmAutorzy = new JMenuItem("Autorzy");
		mnPomoc.add(mntmAutorzy);
		
		JMenuItem mntmOProgramie = new JMenuItem("O programie");
		mnPomoc.add(mntmOProgramie);

		
		return menuBar;
	}
	
	/**
	 * Metoda tworząca obiekt typu JPanel
	 * @param x zmienna określająca położenie komponentu w osi X
	 * @param y zmienna określająca położenie komponentu w osi y
	 * @param width zmienna określająca szerokość komponentu
	 * @param height zmienna określająca wysokość komponentu
	 * @param backgroundColor zmienna określająca kolor tła komponentu
	 * @param border zmienna określająca typ granicy komponentu
	 * @return zwraca obiekt typu JPanel
	 */
	public JPanel createPanel(int x, int y, int width, int height, Color backgroundColor, Border border){
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setLayout(null);
		panel.setBounds(x, y, width, height);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(224, 255, 255), new Color(0, 100, 0), new Color(0, 128, 0), new Color(224, 255, 255)));
		panel_1.setBounds(22, 154, 362, 120);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCzasSymulacji = new JLabel("Czas symulacji:");
		lblCzasSymulacji.setBounds(10, 11, 145, 29);
		lblCzasSymulacji.setForeground(new Color(3, 72, 5));
		lblCzasSymulacji.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		panel_1.add(lblCzasSymulacji);
		
		JLabel lblTemperaturaWTerrarium = new JLabel("Temperatura w terrarium:");
		lblTemperaturaWTerrarium.setForeground(new Color(3, 72, 5));
		lblTemperaturaWTerrarium.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		lblTemperaturaWTerrarium.setBounds(10, 44, 194, 29);
		panel_1.add(lblTemperaturaWTerrarium);
		
		JLabel lblWilgotnoWTerrarium = new JLabel("Wilgotność w terrarium:");
		lblWilgotnoWTerrarium.setForeground(new Color(3, 72, 5));
		lblWilgotnoWTerrarium.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		lblWilgotnoWTerrarium.setBounds(10, 80, 194, 29);
		panel_1.add(lblWilgotnoWTerrarium);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(241, 13, 75, 26);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_1.setBounds(241, 46, 75, 26);
		panel_1.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_2.setBounds(241, 82, 75, 26);
		panel_1.add(spinner_2);
		
		JLabel lblh = new JLabel("[ h ]");
		lblh.setForeground(new Color(3, 72, 5));
		lblh.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		lblh.setBounds(320, 11, 42, 29);
		panel_1.add(lblh);
		
		JLabel lblc = new JLabel("[°C]");
		lblc.setForeground(new Color(3, 72, 5));
		lblc.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 19));
		lblc.setBounds(320, 43, 42, 29);
		panel_1.add(lblc);
		
		JLabel label_1 = new JLabel("[ % ]");
		label_1.setForeground(new Color(3, 72, 5));
		label_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		label_1.setBounds(320, 80, 42, 29);
		panel_1.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(224, 255, 255), new Color(0, 100, 0), new Color(0, 128, 0), new Color(224, 255, 255)));
		panel_3.setBackground(new Color(240, 255, 240));
		panel_3.setBounds(22, 354, 950, 372);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon("img/lamp/LampState1.png"));
		lblNewLabel_3.setBounds(-69, -87, 682, 611);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon("img/clock/clockDay.png"));
		lblNewLabel_4.setBounds(723, 231, 217, 141);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon("img/navigation/pause.png"));
		lblNewLabel_5.setBounds(685, 0, 42, 51);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setIcon(new ImageIcon("img/navigation/play.png"));
		lblNewLabel_6.setBounds(762, 0, 48, 51);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setIcon(new ImageIcon("img/navigation/forward.png"));
		lblNewLabel_7.setBounds(820, 0, 55, 51);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setIcon(new ImageIcon("img/navigation/fastForward.png"));
		lblNewLabel_8.setBounds(885, 0, 55, 51);
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(224, 255, 255), new Color(0, 100, 0), new Color(0, 128, 0), new Color(224, 255, 255)));
		panel_2.setBackground(new Color(240, 255, 240));
		panel_2.setBounds(623, 154, 349, 120);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblOgrzewanieUstawioneNa = new JLabel("Matę grzewczą ustaw na:");
		lblOgrzewanieUstawioneNa.setForeground(new Color(3, 72, 5));
		lblOgrzewanieUstawioneNa.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		lblOgrzewanieUstawioneNa.setBounds(10, 11, 198, 29);
		panel_2.add(lblOgrzewanieUstawioneNa);
		
		JLabel lblPa = new JLabel("Generator pary ustaw na:");
		lblPa.setForeground(new Color(3, 72, 5));
		lblPa.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		lblPa.setBounds(10, 45, 198, 29);
		panel_2.add(lblPa);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(206, 13, 75, 26);
		textField.setEditable(false);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(206, 47, 75, 26);
		textField_1.setEditable(false);
		panel_2.add(textField_1);
		
		JLabel lblc_1 = new JLabel("[°C]");
		lblc_1.setForeground(new Color(3, 72, 5));
		lblc_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 19));
		lblc_1.setBounds(286, 11, 53, 29);
		panel_2.add(lblc_1);
		
		JLabel label_2 = new JLabel("[ % ]");
		label_2.setForeground(new Color(3, 72, 5));
		label_2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		label_2.setBounds(286, 45, 53, 29);
		panel_2.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 240));
		panel_4.setBounds(0, 750, 994, 21);
		panel.add(panel_4);
		
		JLabel lblDaneWejciowe = new JLabel("Dane wejściowe:");
		lblDaneWejciowe.setForeground(new Color(3, 72, 5));
		lblDaneWejciowe.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		lblDaneWejciowe.setBounds(52, 122, 165, 21);
		panel.add(lblDaneWejciowe);
		
		JLabel lblDaneWyjciowe = new JLabel("Dane wyjściowe:");
		lblDaneWyjciowe.setForeground(new Color(3, 72, 5));
		lblDaneWyjciowe.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		lblDaneWyjciowe.setBounds(655, 122, 165, 21);
		panel.add(lblDaneWyjciowe);
		
		JLabel lblSymulacjaTerrarium = new JLabel("Symulacja terrarium:");
		lblSymulacjaTerrarium.setForeground(new Color(3, 72, 5));
		lblSymulacjaTerrarium.setFont(new Font("Sitka Display", Font.PLAIN, 24));
		lblSymulacjaTerrarium.setBounds(52, 321, 245, 28);
		panel.add(lblSymulacjaTerrarium);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/zabieLogo.png"));
		lblNewLabel.setBounds(10, 32, 984, 89);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/glowaZaby.png"));
		lblNewLabel_1.setBounds(725, 290, 235, 134);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("img/buttonSymuluj.png"));
		lblNewLabel_2.setBounds(371, 160, 284, 102);
		panel.add(lblNewLabel_2);
		
		return panel;
	}
	
	/**
	 * Metoda tworząca obiekt typu JLabel
	 * @param name zmienna określająca tekst wyświetlany w polu
	 * @param font zmienna określająca rodzaj czcionki
	 * @param x zmienna określająca położenie komponentu w osi X
	 * @param y zmienna określająca położenie komponentu w osi y
	 * @param width zmienna określająca szerokość komponentu
	 * @param height zmienna określająca wysokość komponentu
	 * @return zwraca obiekt typu JLabel
	 */
	public JLabel createLabel(String name, Font font, int x, int y, int width, int height){
		
		JLabel label = new JLabel(name);
		label.setFont(font);
		label.setBounds(x, y, width, height);
		
		return label;
	}
	
/* -----------------------------------------------------------------------------------*/	
	
	/**
	 * Metoda inicializująca komponenty aplikacji
	 */
	private void initComponents() {
	
	JPanel Panel = (JPanel)getContentPane();
	
	mainPanel = createPanel(0, 0, 1000, 800, new Color(143, 188, 143), null);
	
	menuBar = createMenuBar(0, 0, 994, 21);
	
	
	Panel.add(mainPanel);
	mainPanel.add(menuBar);
	}

/* -----------------------------------------------------------------------------------*/	
	
	/**
	 * Metoda obsługująca zdarzenia akcji
	 * @param e zmienna typu ActionEvent
	 */
	public void actionPerformed(ActionEvent e){
		
		try{
			//Object source = e.getSource();
			//if (source == btnOK){
		}
		catch(Exception ee){	
			ee.printStackTrace();
		}
	}
	
/* -----------------------------------------------------------------------------------*/	
		
	/**
	 * Publiczna metoda uruchomieniowa tworząca obiekt klasy
	 * @param args tablica zmiennych typu String
	 */
	public static void main(String[] args){
		try{
			
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        UIManager.put("TextField.inactiveBackground",Color.white);
			FroggyApp window = new FroggyApp();
			window.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
