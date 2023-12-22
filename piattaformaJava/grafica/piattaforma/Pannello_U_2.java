package piattaforma;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe che rappresenta il primo pannello nell'ambiente dedicato alla struttura. 
 * Il sistema ritorna all'utente i risultati della ricerca della prenotazione. Estende la classe PannelloGenerale per 
 * usufruire anche di quelle attività come la pressione dei bottoni superiori
 * @author Torros
 *
 */

public class Pannello_U_2 extends PannelloGenerale{
	String sport;
	Struttura struttura;
	LocalDateTime orario;
	boolean spogliatoio;
	Cliente c;
	Campo campo;
	Spogliatoio sp = null;
	
	JButton submit;
	
	/*
	 * il costruttore deve creare un pannello sulla base dei possibili risultati della ricerca
	 * - CASO 1: richiesta di solo campo prenotabile all'orario stabilito per quella struttura
	 * 	Display della prenotazione con bottone da premere
	 * - CASO 2: richiesta di campo e spogliatoio prenotabile all'orario stabilito per quella struttura
	 * 	situazione uguale a CASO1
	 * - CASO 3: richiesta di campo e spogliatoio, ma con spogliatio NON prenotabile all'orario stabilito per quella struttura
	 * 	Display di una richiesta per prenotare comunque il campo senza lo spogliatoio
	 */
	public Pannello_U_2(Cliente c, String sport, Struttura strut, LocalDateTime orario, Campo campo, boolean spogliatoio) {
		super(); //si richiama super per dare al pannello le caratteristiche di JPanel e i settaggi generali
		
		//settiamo il Layout che utilizzeremo per questo pannello
		this.setLayout(null);			
		
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */	
		this.sport=sport;
		this.struttura = strut;
		this.orario=orario;
		this.c=c;
		this.campo=campo;
		this.spogliatoio=spogliatoio;
		
		JLabel titolo1 = new JLabel();
		titolo1.setText("La tua ricerca ha avuto esito POSITIVO");
		titolo1.setForeground(new Color(0x8E8D8A));
		titolo1.setHorizontalTextPosition(JLabel.RIGHT);
		titolo1.setFont(new Font("Baskerville", Font.PLAIN, 30));
		titolo1.setBounds(50,100,900,35);
		
		JLabel titolo2 = new JLabel();
		titolo2.setText("Recap prenotazione");
		titolo2.setForeground(new Color(0xE85A4F));
		titolo2.setHorizontalTextPosition(JLabel.RIGHT);
		titolo2.setFont(new Font("Baskerville", Font.PLAIN, 30));
		titolo2.setBounds(50,220,400,35);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Sport: " + sport);
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione1.setBounds(50,260,400,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("Struttura: " + strut.getNome());
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione2.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione2.setBounds(50,290,400,25);
		
		JLabel descrizione3 = new JLabel();
		descrizione3.setText("Data: " + (orario.toString()).split("T")[0]);
		descrizione3.setForeground(new Color(0x8E8D8A));
		descrizione3.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione3.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione3.setBounds(50,320,400,25);
		
		JLabel descrizione4 = new JLabel();
		descrizione4.setText("Ora: " + (orario.toString()).split("T")[1]);
		descrizione4.setForeground(new Color(0x8E8D8A));
		descrizione4.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione4.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione4.setBounds(50,350,400,25);
		
		JLabel descrizione5 = new JLabel();
		descrizione5.setForeground(new Color(0x8E8D8A));
		descrizione5.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione5.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione5.setBounds(50,380,400,25);
		
		JLabel descrizione6 = new JLabel();
		descrizione6.setText("Campo: " + campo.getIDcampo());
		descrizione6.setForeground(new Color(0x8E8D8A));
		descrizione6.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione6.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione6.setBounds(50,410,400,25);
		
		submit = new JButton("Conferma");
		submit.setFont(new Font("Baskerville", Font.BOLD, 10));
		submit.setBounds(490,550,100,30);
		submit.setBackground(new Color(0xD8C3A5));
		submit.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		submit.addActionListener(this);
		
		//stampo 3 immagini diverse a seconda dello sport
		switch(sport) {
		case "Calcetto":
			ImageIcon campoimage = new ImageIcon(new ImageIcon("grafica/calcetto.jpg").getImage().getScaledInstance(400,220,Image.SCALE_DEFAULT));
			JLabel image = new JLabel();
			image.setIcon(campoimage);
			image.setBounds(600,250,400,220);
			this.add(image);
			break;
		case "Basket":
			ImageIcon campoimage1 = new ImageIcon(new ImageIcon("grafica/basket.jpg").getImage().getScaledInstance(400,330,Image.SCALE_DEFAULT));
			JLabel image1 = new JLabel();
			image1.setIcon(campoimage1);
			image1.setBounds(600,250,400,250);
			this.add(image1);
			break;
		case "Tennis":
			ImageIcon campoimage2 = new ImageIcon(new ImageIcon("grafica/tennis.jpeg").getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT));
			JLabel image2 = new JLabel();
			image2.setIcon(campoimage2);
			image2.setBounds(600,250,400,250);
			this.add(image2);
			break;
		}
		
		if(!spogliatoio) {
			//CASO 1
			descrizione5.setText("Spogliatoio: NO");
			this.add(titolo1);
			this.add(titolo2);
			this.add(descrizione1);
			this.add(descrizione2);
			this.add(descrizione3);
			this.add(descrizione4);
			this.add(descrizione5);
			this.add(descrizione6);
			this.add(submit);
			
		}
		else {
			try {
				//CASO 2
				sp=c.controlloDisponibilitaSpogliatoio(orario, strut);
				descrizione5.setText("Spogliatoio: " + sp.getIDspogliatoio());
				this.add(titolo1);
				this.add(titolo2);
				this.add(descrizione1);
				this.add(descrizione2);
				this.add(descrizione3);
				this.add(descrizione4);
				this.add(descrizione5);
				this.add(descrizione6);
				this.add(submit);
				
			} catch (Exception e) {//CASO 3
				// TODO: handle exception
				titolo1.setText("La tua ricerca ha avuto esito POSITIVO per il campo");
				
				JLabel titolo3 = new JLabel();
				titolo3.setText("NEGATIVO per lo spogliatoio");
				titolo3.setForeground(new Color(0x8E8D8A));
				titolo3.setHorizontalTextPosition(JLabel.RIGHT);
				titolo3.setFont(new Font("Baskerville", Font.PLAIN, 30));
				titolo3.setBounds(150,150,900,35);
			
				JLabel descrizione7 = new JLabel();
				descrizione7.setText("Vuoi confermare la prenotazione anche SENZA spogliatoio? (premi su 'UTENTE' per annullare)");
				descrizione7.setForeground(new Color(0x8E8D8A));
				descrizione7.setHorizontalTextPosition(JLabel.RIGHT);
				descrizione7.setFont(new Font("Baskerville", Font.PLAIN, 17));
				descrizione7.setBounds(50,500,900,25);
				
				descrizione5.setText("Spogliatoio: NO");
				
				this.add(titolo1);
				this.add(titolo2);
				this.add(titolo3);
				this.add(descrizione1);
				this.add(descrizione2);
				this.add(descrizione3);
				this.add(descrizione4);
				this.add(descrizione5);
				this.add(descrizione6);
				this.add(descrizione7);
				this.add(submit);
				
			}
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if(e.getSource() == submit) {
				try {
					float prezzo;
					
					if(!spogliatoio) { //CASO 1
						prezzo = RegistroStrutture.getInstance().confermaPrenotazioneNOSpogliatoio(orario, sport, c.getCodiceFiscale(), struttura, campo);	
					}
					else {
						if(sp != null) { //CASO 2
							prezzo = RegistroStrutture.getInstance().confermaPrenotazioneCONSpogliatoio(orario, sport, c.getCodiceFiscale(), struttura, campo, sp);	
						}
						else { //CASO 3
							prezzo = RegistroStrutture.getInstance().confermaPrenotazioneNOSpogliatoio(orario, sport, c.getCodiceFiscale(), struttura, campo);	
						}		
					}
					
					JOptionPane.showMessageDialog(null, "La tua prenotazione è confermata e ha un prezzo totale di "+prezzo+"€","Informazioni finali",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Non puoi prenotare in questa struttura", "Errore Ban", JOptionPane.ERROR_MESSAGE);	
					cl.show(container, "U_1");
					return;
				}
				
				cl.show(container, "1");
			
		}
		
	}
		
}
