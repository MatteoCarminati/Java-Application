package piattaforma;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Classe che rappresenta il menù principale dell'applicativo.
 * E' una zona in comune sia agli utenti che alle strutture e permette di avere una prima visione di cosa fa l'applicativo.
 * Estende la classe PannelloGenerale per usufruire anche di quelle attività come la pressione dei bottoni superiori
 * @author Torros
 *
 */

public class Pannello_1 extends PannelloGenerale{
	
	public Pannello_1() {
		super(); //si richiama super per dare al pannello le caratteristiche di JPanel e i settaggi generali
		
		//settiamo il Layout che utilizzeremo per questo pannello
		this.setLayout(null);
					
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */	
		//creazione della JLabel di benvenuto
		JLabel label_benvenuto = new JLabel();
		label_benvenuto.setText("Benvenuto");
		label_benvenuto.setForeground(new Color(0xE98074));
		label_benvenuto.setHorizontalAlignment(JLabel.CENTER);
		label_benvenuto.setFont(new Font("Baskerville", Font.PLAIN, 45));
		label_benvenuto.setBounds(390,100,300,50);
		
		
		JLabel descrizione = new JLabel();
		descrizione.setText("Questa è la nuova piattaforma per poter prenotare presso le tue strutture sportive prefetite");
		descrizione.setForeground(new Color(0x8E8D8A));
		descrizione.setHorizontalAlignment(JLabel.CENTER);
		descrizione.setFont(new Font("Baskerville", Font.PLAIN, 20));
		descrizione.setBounds(140,170,800,25);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Se desideri fare una prenotazione clicca in alto su 'UTENTE' e procedi a indicare le tue preferenze");
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalAlignment(JLabel.CENTER);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione1.setBounds(90,210,900,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("Se sei un proprietario di una stuttura clicca invece su 'STRUTTURA' per accedere alla tua area personale");
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalAlignment(JLabel.CENTER);
		descrizione2.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione2.setBounds(90,240,900,25);
		
		JLabel descrizione3 = new JLabel();
		descrizione3.setText("Qualora volessi tornare in questo menu in ogni momento clicca su 'MENU'");
		descrizione3.setForeground(new Color(0x8E8D8A));
		descrizione3.setHorizontalAlignment(JLabel.CENTER);
		descrizione3.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione3.setBounds(90,270,900,25);
		
		ImageIcon campo = new ImageIcon(new ImageIcon("grafica/campo1.jpg").getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT));
		JLabel immagine = new JLabel();
		immagine.setIcon(campo);
		immagine.setBounds(90,350,400,300);
		
		
		ImageIcon campo1 = new ImageIcon(new ImageIcon("grafica/campo2.jpg").getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT));
		JLabel immagine1 = new JLabel();
		immagine1.setIcon(campo1);
		immagine1.setBounds(570,350,400,300);

		
		this.add(label_benvenuto);
		this.add(descrizione);
		this.add(descrizione1);
		this.add(descrizione2);
		this.add(descrizione3);
		this.add(immagine);
		this.add(immagine1);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);	
	}

}
