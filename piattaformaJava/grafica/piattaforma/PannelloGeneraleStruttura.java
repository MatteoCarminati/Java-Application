package piattaforma;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Classe che crea il pannello generale privato di una struttura registrata nel sistema. Da qui il proprietario può compiere una serie di attività
 * Inerenti la sua struttura che possono essere visualizzate nella parte di sinistra, e a ogni momento è sempre possibile abbandonare la sua area
 * privata e tornare ai menu inziali rappresentati sopra
 * @author Torros
 *
 */
public class PannelloGeneraleStruttura extends PannelloGenerale{
	
	/*
	 * questo parametro è fondamentale perchè serve per sapere di che struttura si stia parlando quando si entra
	 * nella zona privata della struttura.
	 * Viene associato nel pannello S_1 una volta che la chiave di riconoscimento sia corretta
	 */
	static Struttura privata;
		
	JButton aggiungi;
	JButton banna;
	JButton controllaprenotazioni;
	JButton menustruttura;
	
	
	public PannelloGeneraleStruttura() {
		super(); //si richiama super per dare al pannello le caratteristiche di JPanel e i settaggi generali
		
		//settiamo il Layout che utilizzeremo per questo pannello
		this.setLayout(null);
			
	
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */	
		JPanel pannellosx = new JPanel();
		pannellosx.setBackground(new Color(0xE98074));
		pannellosx.setBounds(0,55,180,665);
		
		aggiungi = new JButton("Aggiungi");
		aggiungi.setFont(new Font("Baskerville", Font.BOLD, 10));
		aggiungi.setBounds(20,95,140,30);
		aggiungi.setBackground(new Color(0xD8C3A5));
		aggiungi.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		aggiungi.addActionListener(this);
		
		
		banna = new JButton("Ban Utente");
		banna.setFont(new Font("Baskerville", Font.BOLD, 10));
		banna.setBounds(20,145,140,30);
		banna.setBackground(new Color(0xD8C3A5));
		banna.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		banna.addActionListener(this);
		
		controllaprenotazioni = new JButton("Controlla Prenotazioni");
		controllaprenotazioni.setFont(new Font("Baskerville", Font.BOLD, 10));
		controllaprenotazioni.setBounds(20,195,140,30);
		controllaprenotazioni.setBackground(new Color(0xD8C3A5));
		controllaprenotazioni.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		controllaprenotazioni.addActionListener(this);
		
		menustruttura = new JButton("Menu Struttura");
		menustruttura.setFont(new Font("Baskerville", Font.BOLD, 10));
		menustruttura.setBounds(20,575,140,30);
		menustruttura.setBackground(new Color(0xD8C3A5));
		menustruttura.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		menustruttura.addActionListener(this);
		
		this.add(aggiungi);
		this.add(banna);
		this.add(controllaprenotazioni);
		this.add(menustruttura);
		this.add(pannellosx);
	}


	/*
	 * in questo caso non richiamiamo nessun super perchè vogliamo che il metodo venga eseguito in modo differente, ovvero mostrando il popup
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		cl = MainFrame.getLayout();
		container = MainFrame.getContainer();
		
		if(e.getSource() == bottoneUtente) {
			int ans = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler abbandonare la sessione attiva? Una volta uscito ti verranno richieste nuovamente le tue credenziali", "Abbandonare sessione", JOptionPane.WARNING_MESSAGE);
			
			if(ans == 0) {
				cl.show(container,"U_1");
			}
			
		}
		else if(e.getSource() == bottoneStruttura) {
			int ans = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler abbandonare la sessione attiva? Una volta uscito ti verranno richieste nuovamente le tue credenziali", "Abbandonare sessione", JOptionPane.WARNING_MESSAGE);
			
			if(ans == 0) {
				cl.show(container,"S_1");
			}
		}
		else if(e.getSource() == bottoneMenu) {
			int ans = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler abbandonare la sessione attiva? Una volta uscito ti verranno richieste nuovamente le tue credenziali", "Abbandonare sessione", JOptionPane.WARNING_MESSAGE);
			
			if(ans == 0) {
				cl.show(container,"1");
			}
		}
		//bottoni a sinistra
		else if(e.getSource() == aggiungi) {
			cl.show(container, "S_3");
		}
		else if(e.getSource() == banna) {
			cl.show(container, "S_4");
		}
		else if(e.getSource() == controllaprenotazioni) {
			//creiamo una nuova istanza perchè pannello speciale
			
			//qui bisogna passare il nome della struttura che abbiamo gia in questo pannello
			Pannello_S_5 panel_S_5= new Pannello_S_5(privata.getNome());
			container.add(panel_S_5, "S_5");
			
			cl.show(container, "S_5");
			
		}
		else if(e.getSource() == menustruttura) {
			//in questo caso sarà necessario andare a aggiornare i vari campi ogni volta perchè potrebbero esserci dei cambiamenti
			//quindi il nome indirizzo e città possono essere anche non risalvati perchè già contenuti nella PannelloGeneraleStruttura

			//PannelloGeneraleStruttura.numerocampibasket = getnumerocampiBasket()
			//per ora non lo facciamo che non serve
			
			Pannello_S_2 panel_S_2 = new Pannello_S_2();
			container.add(panel_S_2, "S_2");
			
			cl.show(container, "S_2");
		}
	}

}
