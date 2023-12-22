package piattaforma;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;


/**
 * Classe generale che raccoglie al suo interno il frame principale e tutti i pannelli che rappresentano le
 * varie finestre che potrebbero essere aperte dall'utente o da una struttura di un centro sportivo
 * @author Torros
 *
 */
public class MainFrame{
	
	/**
	 * Queste due variabili sono necessarie per creare un Controller dei vari Pannelli da mostrare nel frame.
	 * Ogni volta che si vuole aggiungere un pannello basta scrivere un container.add(pannello, identificatore)
	 */
	private static JPanel container;
	private static CardLayout cl;
	
	
	protected RegistroStrutture registro;
	
	
	/*
	 * Definizione di tutti i pannelli presenti nell'applicativo, la notazione usata è la seguente
	 * panel_ + U/S + _numero
	 * dove i + sono usati come i segni di concatenazione di stringe in Java. U/S indica la scelta di usare o 
	 * la U che indica un pannello riservato all'utente, o S ovvero un pannello riservato a una struttura. Il 
	 * numero indica invece progressivamente l'oridine in cui potrebbero essere visualizzati i pannelli.
	 * Gli ordini tra i pannelli di U e quelli di S non si sovrappongono, sono l'uno indipendente dall'altro.
	 * Una volta creato il pannello è necessario aggiungerlo al container con il suo identificativo.
	 * Se non è presente U/S significa che il pannello è in comune ad entrambi gli attori.
	 */
	public MainFrame() {
		
		//richiamiamo la funzione per poter settare tutte le classe principali di src
		SettaggioDatabase();
		
		JFrame frame = new JFrame();
		ImageIcon logo = new ImageIcon("grafica/logo.jpg");
		
		cl = new CardLayout();
		container = new JPanel();
		
		Pannello_1 panel_1 = new Pannello_1();
		
		Pannello_U_1 panel_U_1 = new Pannello_U_1();
		
		Pannello_S_1 panel_S_1 = new Pannello_S_1();
		//il pannello S_2 non c'è perchè è dinamico e deve essere istanziato solo quando clicco dei bottoni
		Pannello_S_3 panel_S_3 = new Pannello_S_3();
		Pannello_S_4 panel_S_4 = new Pannello_S_4();
		//il pannello S_5 non c'è perchè è dinamico e deve essere istanziato solo quando clicco dei bottoni
		//il pannello S_6 non c'è perchè è dinamico e deve essere istanziato solo quando clicco dei bottoni
		
		container.setLayout(cl);
		container.add(panel_1, "1");
		container.add(panel_U_1, "U_1");
		container.add(panel_S_1, "S_1");
		container.add(panel_S_3, "S_3");
		container.add(panel_S_4, "S_4");
		cl.show(container,"1");
		
		frame.add(container);

		
		//settaggio frame
		frame.setIconImage(logo.getImage());	
		frame.setTitle("Piattaforma Prenotazioni");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080,720);
		//rendiamo il frame non modificabile perchè le sue dimensioni sono associate ai pannelli che non cambiano dinamicamente
		frame.setResizable(false);
		frame.setVisible(true);
	}



	public static CardLayout getLayout() {
		return cl;
	}



	public static JPanel getContainer() {
		return container;
	}
	
	
	public void SettaggioDatabase() {
		registro = RegistroStrutture.getInstance();
		
		Struttura s1 = new Struttura("Campi Sportivi Stezzano", "Via Isonzo 1", "Stezzano (BG)");
		registro.linkListaStrutture(s1);
		CampoCalcetto cc1 = new CampoCalcetto(50, s1, "Sintetico", true);
		CampoTennis ct1 = new CampoTennis(30, s1, "Terra Battuta");
		CampoTennis ct2 = new CampoTennis(30, s1, "Sintetico");
		Spogliatoio sp1 = new Spogliatoio(15,s1);
		Spogliatoio sp2 = new Spogliatoio(15,s1);
		
		Struttura s2 = new Struttura("Centro Sportivo Levate", "Via Meucci 12", "Levate (BG)");
		registro.linkListaStrutture(s2);
		CampoCalcetto cc2 = new CampoCalcetto(40, s2, "Sintetico", false);
		CampoBasket cb1 = new CampoBasket(35, s2);
		CampoTennis ct3 = new CampoTennis(25, s2, "Terra Battuta");
		Spogliatoio sp3 = new Spogliatoio(10,s2);

		Struttura s3 = new Struttura("Campo CONI", "Via Dante Alighieri 6A", "Bergamo");
		registro.linkListaStrutture(s3);
		CampoCalcetto cc3 = new CampoCalcetto(60, s3, "Sintetico", true);
		CampoCalcetto cc4 = new CampoCalcetto(70, s3, "Parquet", true);
		CampoBasket cb2 = new CampoBasket(50, s3);
		CampoBasket cb3 = new CampoBasket(50, s3);	
		Spogliatoio sp4 = new Spogliatoio(20,s3);
		Spogliatoio sp5 = new Spogliatoio(20,s3);
		
		Struttura s4 = new Struttura("Palestra Comunale Grassobbio", "Via Francesco Petrarca 7", "Grassobbio (BG)");
		registro.linkListaStrutture(s4);
		CampoBasket cb4 = new CampoBasket(45, s4);
		CampoTennis ct4 = new CampoTennis(35, s4, "Sintetico");
		Spogliatoio sp6 = new Spogliatoio(20,s4);
		
		Struttura s5 = new Struttura("Oratorio Seriate", "Via Mario Negri 10B", "Seriate (BG)");
		registro.linkListaStrutture(s5);
		CampoCalcetto cc5 = new CampoCalcetto(45, s5, "Sintetico", true);
		CampoCalcetto cc6 = new CampoCalcetto(35, s5, "Sintetico", false);
		
		LocalDateTime d1 = LocalDateTime.of(2022,12,10, 11, 00);
		LocalDateTime d2 = LocalDateTime.of(2022,12,11, 10, 00);
		LocalDateTime d3 = LocalDateTime.of(2022,2,04, 18, 00);
		LocalDateTime d4 = LocalDateTime.of(2022,12,15, 19, 00);
		LocalDateTime d5 = LocalDateTime.of(2022,12,10, 20, 00);
		
		Prenotazione p1=new Prenotazione(d1,"Calcetto", "TRRLNZ00S16A794D", s1, cc1);
		Prenotazione p2=new Prenotazione(d2,"Calcetto", "CRMMTT00E12A794G", s1, cc1);
		Prenotazione p3=new Prenotazione(d5,"Tennis", "CRMMTT00E12A794G", s1, ct1);
	}

}



