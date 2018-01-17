package app;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;

import data.Data;

import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

/**
 * Program DressUpApp
 * Klasa DressUpApp 
 * @version 1.0 (14.11.2017)
 * @author Małgorzata Zawisza, Izabela Wedmann
*/


public class FroggyApp extends JFrame implements ActionListener{

	private static final long serialVersionUID = -1625204278558502659L;

	private JPanel mainPanel, dataInPanel, dataOutPanel, terraPanel;
	
	private JTextField textFieldSimulatingTemperatureOut;
	private JTextField textFieldSimulatingHumidityOut;
	private boolean simulationStarted = false;
	
	

/* -----------------------------------------------------------------------------------*/	
	
	/**
	 * Konstruktor klasy DressUpApp
	 */
	public FroggyApp() {
		
		setTitle("FroggyApp - program zarządzający warunkami w terrarium");
		setBounds(100, 100, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Data.init();

		initComponents();
		loadFont("lib/digital-7.ttf");
		loadConfig();
	}

	
/* -----------------------------------------------------------------------------------*/
	
	/**
	 * Metoda inicjalizująca komponenty aplikacji
	 */
	
	private void initComponents(){
		
		mainPanel = (JPanel)getContentPane();
		mainPanel.setBounds(0, 0, 1000, 800);
		mainPanel.setBackground( new Color(143, 188, 143) );
		mainPanel.setBorder(null);
		
	// DATA IN PANEL
		
		dataInPanel = new JPanel();
		dataInPanel.setBackground(new Color(240, 255, 240));
		dataInPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(224, 255, 255), new Color(0, 100, 0), new Color(0, 128, 0), new Color(224, 255, 255)));
		dataInPanel.setBounds(22, 154, 362, 120);
		mainPanel.add(dataInPanel);
		dataInPanel.setLayout(null);
		
		JLabel labelSimulatingTime = new JLabel("Początek symulacji:");
		labelSimulatingTime.setBounds(10, 11, 145, 29);
		labelSimulatingTime.setForeground(new Color(3, 72, 5));
		labelSimulatingTime.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		dataInPanel.add(labelSimulatingTime);
		
		JLabel labelTerraTemperature = new JLabel("Temperatura w terrarium:");
		labelTerraTemperature.setForeground(new Color(3, 72, 5));
		labelTerraTemperature.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		labelTerraTemperature.setBounds(10, 44, 194, 29);
		dataInPanel.add(labelTerraTemperature);
		
		JLabel labelTerraHumidity = new JLabel("Wilgotność w terrarium:");
		labelTerraHumidity.setForeground(new Color(3, 72, 5));
		labelTerraHumidity.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		labelTerraHumidity.setBounds(10, 80, 194, 29);
		dataInPanel.add(labelTerraHumidity);
		
		JSpinner spinnerSimulatingTime = new JSpinner();
		spinnerSimulatingTime.setModel(new SpinnerListModel(HoursList.get()));
		spinnerSimulatingTime.setEditor(new JSpinner.DefaultEditor(spinnerSimulatingTime));
		spinnerSimulatingTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerSimulatingTime.setBounds(241, 13, 75, 26);
		dataInPanel.add(spinnerSimulatingTime);
		
		JTextField textFieldTerraTemperature = new JTextField();
		textFieldTerraTemperature.setHorizontalAlignment(JTextField.RIGHT);
		textFieldTerraTemperature.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTerraTemperature.setBounds(241, 46, 75, 26);
		dataInPanel.add(textFieldTerraTemperature);
		
		JTextField textFieldTerraHumidity = new JTextField();
		textFieldTerraHumidity.setHorizontalAlignment(JTextField.RIGHT);
		textFieldTerraHumidity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTerraHumidity.setBounds(241, 82, 75, 26);
		dataInPanel.add(textFieldTerraHumidity);
		
		JLabel lblh = new JLabel("[ h ]");
		lblh.setForeground(new Color(3, 72, 5));
		lblh.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		lblh.setBounds(320, 11, 42, 29);
		dataInPanel.add(lblh);
		
		JLabel lblc = new JLabel("[°C]");
		lblc.setForeground(new Color(3, 72, 5));
		lblc.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 19));
		lblc.setBounds(320, 43, 42, 29);
		dataInPanel.add(lblc);
		
		JLabel lblprocent = new JLabel("[ % ]");
		lblprocent.setForeground(new Color(3, 72, 5));
		lblprocent.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		lblprocent.setBounds(320, 80, 42, 29);
		dataInPanel.add(lblprocent);
		
		
		terraPanel = new JPanel();
		terraPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(224, 255, 255), new Color(0, 100, 0), new Color(0, 128, 0), new Color(224, 255, 255)));
		terraPanel.setBackground(new Color(240, 255, 240));
		terraPanel.setBounds(22, 354, 950, 372);
		mainPanel.add(terraPanel);
		terraPanel.setLayout(null);
		
	// TERRA PANEL
		
		JLabel labelClock = new JLabel(Time.getTime());
		labelClock.setFont(new Font("digital-7", Font.BOLD, 34));
		labelClock.setBounds(762, 280, 100, 60);
		terraPanel.add(labelClock);
		
		JLabel labelLampImage = new JLabel(" ");
		labelLampImage.setIcon(new ImageIcon("img/lamp/LampState1.png"));
		labelLampImage.setBounds(-102, -16, 472, 468);
		terraPanel.add(labelLampImage);
		
		JLabel labelClockImage = new JLabel(" ");
		labelClockImage.setIcon(new ImageIcon("img/clock/clockDay.png"));
		labelClockImage.setBounds(726, 249, 214, 133);
		terraPanel.add(labelClockImage);
		
		JLabel labelHeatingMatImage = new JLabel("");
		labelHeatingMatImage.setIcon(new ImageIcon("img/heatingMat/HeatingMatStateNull.png"));
		labelHeatingMatImage.setBounds(-59, 125, 963, 265);
		terraPanel.add(labelHeatingMatImage);
		
		JLabel labelThermometerImage = new JLabel("");
		labelThermometerImage.setIcon(new ImageIcon("img/thermometer/ThermometerStateLow.png"));
		labelThermometerImage.setBounds(688, 111, 111, 108);
		terraPanel.add(labelThermometerImage);
		
		JLabel labelTerrariumimage = new JLabel("");
		labelTerrariumimage.setIcon(new ImageIcon("img/terrarium/Terrarium.png"));
		labelTerrariumimage.setBounds(21, 62, 888, 286);
		terraPanel.add(labelTerrariumimage);
		
		JLabel labelFoggerImage = new JLabel("");
		labelFoggerImage.setIcon(new ImageIcon("img/fogger/FoggerStateLow.png"));
		labelFoggerImage.setBounds(142, 96, 874, 286);
		terraPanel.add(labelFoggerImage);
		
		JLabel labelDeskImage = new JLabel("");
		labelDeskImage.setIcon(new ImageIcon("img/terrarium/Desk.png"));
		labelDeskImage.setBounds(0, 282, 950, 90);
		terraPanel.add(labelDeskImage);
		
		JButton buttonPause = new JButton();
		buttonPause.setIcon(new ImageIcon("img/navigation/pause.png"));
		buttonPause.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		buttonPause.setContentAreaFilled(false);
		buttonPause.setBounds(685, 0, 42, 51);
		buttonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClockThread.toStop = true;		
			}});
			buttonPause.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonPause.setBounds(685, 0, 42, 51);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonPause.setBounds(686, 1, 42, 51);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		terraPanel.add(buttonPause);
		
		JButton buttonPlay = new JButton();
		buttonPlay.setIcon(new ImageIcon("img/navigation/play.png"));
		buttonPlay.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		buttonPlay.setContentAreaFilled(false);
		buttonPlay.setBounds(762, 0, 48, 51);
		buttonPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!ClockThread.running && simulationStarted) {
					ClockThread.toStop = false;
					(new Thread(new ClockThread())).start();
				}
			}
		});
		buttonPlay.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonPlay.setBounds(762, 0, 48, 51);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonPlay.setBounds(763, 1, 48, 51);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		terraPanel.add(buttonPlay);
		
		JButton buttonForward = new JButton();
		buttonForward.setIcon(new ImageIcon("img/navigation/forward.png"));
		buttonForward.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		buttonForward.setContentAreaFilled(false);
		buttonForward.setBounds(820, 0, 55, 51);
		
		buttonForward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClockThread.speedUp = 60;				
			}
		});
		buttonForward.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonForward.setBounds(820, 0, 55, 51);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonForward.setBounds(821, 1, 55, 51);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		terraPanel.add(buttonForward);
		
		JButton buttonFastForward = new JButton();
		buttonFastForward.setIcon(new ImageIcon("img/navigation/fastForward.png"));
		buttonFastForward.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		buttonFastForward.setContentAreaFilled(false);
		buttonFastForward.setBounds(885, 0, 55, 51);
		
		buttonFastForward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClockThread.speedUp = 1000;				
			}
		});
		buttonFastForward.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonFastForward.setBounds(885, 0, 55, 51);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonFastForward.setBounds(886, 1, 55, 51);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		terraPanel.add(buttonFastForward);
		
	// DATA OUT PANEL
		
		dataOutPanel = new JPanel();
		dataOutPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(224, 255, 255), new Color(0, 100, 0), new Color(0, 128, 0), new Color(224, 255, 255)));
		dataOutPanel.setBackground(new Color(240, 255, 240));
		dataOutPanel.setBounds(623, 154, 349, 120);
		mainPanel.add(dataOutPanel);
		dataOutPanel.setLayout(null);
		
		JLabel labelSimulatingTemperatureOut = new JLabel("Matę grzewczą ustaw na:");
		labelSimulatingTemperatureOut.setForeground(new Color(3, 72, 5));
		labelSimulatingTemperatureOut.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		labelSimulatingTemperatureOut.setBounds(10, 11, 198, 29);
		dataOutPanel.add(labelSimulatingTemperatureOut);
		
		JLabel labelSimulatingHumidityOut = new JLabel("Generator pary ustaw na:");
		labelSimulatingHumidityOut.setForeground(new Color(3, 72, 5));
		labelSimulatingHumidityOut.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		labelSimulatingHumidityOut.setBounds(10, 45, 198, 29);
		dataOutPanel.add(labelSimulatingHumidityOut);
		
		textFieldSimulatingTemperatureOut = new JTextField();
		textFieldSimulatingTemperatureOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSimulatingTemperatureOut.setBounds(206, 13, 75, 26);
		textFieldSimulatingTemperatureOut.setEditable(false);
		dataOutPanel.add(textFieldSimulatingTemperatureOut);
		textFieldSimulatingTemperatureOut.setColumns(10);
		
		textFieldSimulatingHumidityOut = new JTextField();
		textFieldSimulatingHumidityOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSimulatingHumidityOut.setColumns(10);
		textFieldSimulatingHumidityOut.setBounds(206, 47, 75, 26);
		textFieldSimulatingHumidityOut.setEditable(false);
		dataOutPanel.add(textFieldSimulatingHumidityOut);
		
		JLabel lblc_1 = new JLabel("[°C]");
		lblc_1.setForeground(new Color(3, 72, 5));
		lblc_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 19));
		lblc_1.setBounds(286, 11, 53, 29);
		dataOutPanel.add(lblc_1);
		
		JLabel labelprocent_1 = new JLabel("[ % ]");
		labelprocent_1.setForeground(new Color(3, 72, 5));
		labelprocent_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 21));
		labelprocent_1.setBounds(286, 45, 53, 29);
		dataOutPanel.add(labelprocent_1);
		
	//DATA MAIN PANEL
		
		JLabel labelDataIn = new JLabel("Dane wejściowe:");
		labelDataIn.setForeground(new Color(3, 72, 5));
		labelDataIn.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		labelDataIn.setBounds(52, 122, 165, 21);
		mainPanel.add(labelDataIn);
		
		JLabel labelDataOut = new JLabel("Dane wyjściowe:");
		labelDataOut.setForeground(new Color(3, 72, 5));
		labelDataOut.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		labelDataOut.setBounds(655, 122, 165, 21);
		mainPanel.add(labelDataOut);
		
		JLabel labelSimulatingTheTerra = new JLabel("Symulacja terrarium:");
		labelSimulatingTheTerra.setForeground(new Color(3, 72, 5));
		labelSimulatingTheTerra.setFont(new Font("Sitka Display", Font.PLAIN, 24));
		labelSimulatingTheTerra.setBounds(52, 321, 245, 28);
		mainPanel.add(labelSimulatingTheTerra);
		
		JLabel labelFroggyLogoImage = new JLabel("");
		labelFroggyLogoImage.setIcon(new ImageIcon("img/zabieLogo.png"));
		labelFroggyLogoImage.setBounds(10, 32, 984, 89);
		mainPanel.add(labelFroggyLogoImage);
		
		JLabel labelFroggyHeadImage = new JLabel("");
		labelFroggyHeadImage.setIcon(new ImageIcon("img/glowaZaby.png"));
		labelFroggyHeadImage.setBounds(725, 290, 235, 134);
		mainPanel.add(labelFroggyHeadImage);
		
		JButton buttonSimulate = new JButton();
		
		buttonSimulate.setIcon(new ImageIcon("img/buttonSimulate.png"));
		buttonSimulate.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		buttonSimulate.setContentAreaFilled(false);
		buttonSimulate.setBounds(371, 160, 284, 102);
		
		buttonSimulate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				double temperature;
				double humidity;
				
				try {
					temperature = Double.parseDouble(textFieldTerraTemperature.getText());
					
					try {
						humidity = Double.parseDouble(textFieldTerraHumidity.getText());
						
						Time.setTimeFromString((String) spinnerSimulatingTime.getValue());
						
						ClockThread.speedUp = 1;
						
						if(!ClockThread.running) {
							ClockThread.toStop = false;
							simulationStarted = true;
							(new Thread(new ClockThread())).start();
						}
						
						Data.DayTemperature.set(temperature);
						Data.DayHumidity.set(humidity);
						Data.NightTemperature.set(temperature);
						Data.NightHumidity.set(humidity);

						spinnerSimulatingTime.setEnabled(false);
						textFieldTerraTemperature.setEditable(false);
						textFieldTerraHumidity.setEditable(false);
						
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Złe dane dla wilgotności", "Błąd", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Złe dane dla temperatury", "Błąd", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		buttonSimulate.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonSimulate.setBounds(371, 160, 284, 102);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonSimulate.setBounds(373, 162, 284, 102);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		mainPanel.add(buttonSimulate);
		
	//DATA IN MENUBAR
		
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
		
		JMenu mnPrdko = new JMenu("Przyspieszenie");
		mnNarzdzia.add(mnPrdko);
		
		JMenuItem mntmX = new JMenuItem("Brak");
		mntmX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClockThread.speedUp = 1;				
			}
		});
		mnPrdko.add(mntmX);
		
		JMenuItem mntmX_1 = new JMenuItem("Tryb minutowy");
		mntmX_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClockThread.speedUp = 60;
			}
		});
		mnPrdko.add(mntmX_1);
		
		JMenuItem mntmX_2 = new JMenuItem("Tryb godzinny");
		mntmX_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClockThread.speedUp = 1000;
			}
		});
		mnPrdko.add(mntmX_2);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmAutorzy = new JMenuItem("Autorzy");
		mnPomoc.add(mntmAutorzy);
		
		JMenuItem mntmOProgramie = new JMenuItem("O programie");
		mnPomoc.add(mntmOProgramie);
		
		mainPanel.add(menuBar);
		this.setJMenuBar(menuBar);
			
		ClockThread.textFieldTerraTemperature = textFieldTerraTemperature;
		ClockThread.textFieldTerraHumidity = textFieldTerraHumidity;
		ClockThread.textFieldSimulatingTemperatureOut = textFieldSimulatingTemperatureOut;
		ClockThread.textFieldSimulatingHumidityOut = textFieldSimulatingHumidityOut;
		
		ClockThread.labelClock = labelClock;
		ClockThread.labelClockImage = labelClockImage;
		ClockThread.labelThermometerImage = labelThermometerImage;		
		ClockThread.labelFoggerImage = labelFoggerImage;		
		ClockThread.labelHeatingMatImage = labelHeatingMatImage;		
		ClockThread.labelLampImage = labelLampImage;
		ClockThread.terraPanel = terraPanel;
		
		
		
		
	}
	
/* -----------------------------------------------------------------------------------*/
	
	/**
	 * Metoda do ładowania ustawień konfiguracyjnych
	 */
	
	private void loadConfig() {
		
		File file = new File("config/config.txt");
		
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.contains("delay")) {
					Data.config.put("delay", Integer.parseInt(line.substring(6)));
				} else if (line.contains("backgroundChangeSpeed")) {
					Data.config.put("backgroundChangeSpeed", Integer.parseInt(line.substring(22)));
				}
			}

			scanner.close();

		} catch (IOException | NumberFormatException e) {
			Data.config.put("delay", 60);
			Data.config.put("backgroundChangeSpeed", 30);
		}
	}
	
/* -----------------------------------------------------------------------------------*/	
	
	/**
	 * Metoda służąca do ładowania czcionek
	 * @param pathToFont zmienna typu String przechowująca ścieżkę do pliku czcionki
	 */
	
	private void loadFont(String pathToFont){
		try {
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(pathToFont)));
		} catch (IOException | FontFormatException e) {}
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
			
	        UIManager.put("TextField.inactiveBackground",Color.white);
			FroggyApp window = new FroggyApp();
			window.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
