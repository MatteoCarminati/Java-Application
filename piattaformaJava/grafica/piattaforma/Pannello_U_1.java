package piattaforma;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

/**
 * Classe che rappresenta il primo pannello nell'ambiente dedicato all'utente. 
 * Il pannello propone all'utente varie caratteristiche da dare alla propria prenotazione, di modo tale che una volta
 * premuto il pulsante di submit, il sistema procederà a fare una ricerca per stabilire se la prenotazione richiesta
 * dall'utente sia fattibile. Estende la classe PannelloGenerale per usufruire anche di quelle attività come la pressione 
 * dei bottoni superiori
 * @author Torros
 *
 */
public class Pannello_U_1 extends PannelloGenerale{
	
	JRadioButton tennis;
	JRadioButton calcetto;
	JRadioButton basket;
	JComboBox<String> combostrutture;
	JComboBox<String> comboorari;
	JRadioButton si_spogliatoio;
	JRadioButton no_spogliatoio;
	JButton submit;
	JTextField field_nome;
	JTextField field_cognome;
	JTextField field_cf;

	
	
	/*
	 * variabili che assumono i valori espressi dalle preferenze dell'utente, dovranno poi essere passate all'applicativo vero e propio per 
	 * fare le varie ricerche
	 */
	String sport = new String();
	String struttura = new String();
	String orario = new String();
	boolean spogliatoio;
	JTextField field;

	
	public Pannello_U_1() {
		super(); //si richiama super per dare al pannello le caratteristiche di JPanel e i settaggi generali
		
		//settiamo il Layout che utilizzeremo per questo pannello
		this.setLayout(null);
					
		
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */			
		JLabel titolo = new JLabel();
		titolo.setText("Inserisci le tue preferenze per la prenotazione");
		titolo.setForeground(new Color(0xE98074));
		titolo.setHorizontalTextPosition(JLabel.RIGHT);
		titolo.setFont(new Font("Baskerville", Font.PLAIN, 30));
		titolo.setBounds(20,70,700,40);
		
		JLabel titolo1 = new JLabel();
		titolo1.setText("Scegli lo sport che desideri praticare, la struttura che preferisci e l'orario che ti è più comodo");
		titolo1.setForeground(new Color(0x8E8D8A));
		titolo1.setHorizontalTextPosition(JLabel.RIGHT);
		titolo1.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo1.setBounds(20,130,900,25);
		
		JLabel titolo2 = new JLabel();
		titolo2.setText("Specifica inoltre se sei interessato a prenotare anche uno spogliatoio presso la medesima struttura");
		titolo2.setForeground(new Color(0x8E8D8A));
		titolo2.setHorizontalTextPosition(JLabel.RIGHT);
		titolo2.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo2.setBounds(20,160,1000,25);
		
		JLabel titolo3 = new JLabel();
		titolo3.setText("Questa è solo una fase di ricerca, dopo aver cliccato su sumbit la piattaforma proporrà alcune scelte sulla base delle preferenze.");
		titolo3.setForeground(new Color(0x8E8D8A));
		titolo3.setHorizontalTextPosition(JLabel.RIGHT);
		titolo3.setFont(new Font("Baskerville", Font.PLAIN, 17));
		titolo3.setBounds(20,190,1000,25);
		
		JLabel titolo4 = new JLabel();
		titolo4.setText("E 'possibile che non si riesca a prenotare presso una certa struttura se si è stati bannati");
		titolo4.setForeground(new Color(0x8E8D8A));
		titolo4.setHorizontalTextPosition(JLabel.RIGHT);
		titolo4.setFont(new Font("Baskerville", Font.PLAIN, 17));
		titolo4.setBounds(20,210,1000,25);
		
		JLabel titolo5 = new JLabel();
		titolo5.setText("La richiesta di spogliatoio può anche essere trascurata, in tal caso il sistema comprende che non si è interessati a prenotarlo");
		titolo5.setForeground(new Color(0x8E8D8A));
		titolo5.setHorizontalTextPosition(JLabel.RIGHT);
		titolo5.setFont(new Font("Baskerville", Font.PLAIN, 17));
		titolo5.setBounds(20,230,1000,25);
		
		JLabel descrizione8 = new JLabel();
		descrizione8.setText("Nome:");
		descrizione8.setForeground(new Color(0x8E8D8A));
		descrizione8.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione8.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione8.setBounds(65,270,200,25);
		
		JLabel descrizione6 = new JLabel();
		descrizione6.setText("Cognome:");
		descrizione6.setForeground(new Color(0x8E8D8A));
		descrizione6.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione6.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione6.setBounds(65,300,200,25);
		
		JLabel descrizione7 = new JLabel();
		descrizione7.setText("Codice Fiscale:");
		descrizione7.setForeground(new Color(0x8E8D8A));
		descrizione7.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione7.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione7.setBounds(65,330,200,25);
		
		field_nome = new JTextField("");
		field_nome.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field_nome.setBounds(215,270,300,30);
		
		field_cognome = new JTextField("");
		field_cognome.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field_cognome.setBounds(215,300,300,30);
		
		field_cf = new JTextField("");
		field_cf.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field_cf.setBounds(215,330,300,30);
		
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Tipologia Sport");
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione1.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione1.setBounds(65,400,200,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("Scelta Struttura");
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione2.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione2.setBounds(315,400,300,25);
		
		
		JLabel descrizione5 = new JLabel();
		descrizione5.setText("Scelta Data (gg-mm-aaaa)");
		descrizione5.setForeground(new Color(0x8E8D8A));
		descrizione5.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione5.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione5.setBounds(630,400,300,25);
		
		JLabel descrizione3 = new JLabel();
		descrizione3.setText("Scelta Orario");
		descrizione3.setForeground(new Color(0x8E8D8A));
		descrizione3.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione3.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione3.setBounds(630,480,300,25);
		
		JLabel descrizione4 = new JLabel();
		descrizione4.setText("Spogliatoio?");
		descrizione4.setForeground(new Color(0x8E8D8A));
		descrizione4.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione4.setFont(new Font("Baskerville", Font.BOLD, 17));
		descrizione4.setBounds(875,400,300,25);
		
		
		//variabile per raggruppare tennis basket e calcetto dato che vogliamo che solo uno di questi possa essere scelto
		ButtonGroup group = new ButtonGroup();
		
		tennis = new JRadioButton("Tennis");
		tennis.setBounds(65,430,100,25);
		tennis.setBackground(new Color(0xEAE7DC));
		tennis.setFont(new Font("Baskerville", Font.BOLD, 13));
		tennis.addActionListener(this);
		group.add(tennis);
		
		calcetto = new JRadioButton("Calcetto");
		calcetto.setBounds(65,460,100,25);
		calcetto.setBackground(new Color(0xEAE7DC));
		calcetto.setFont(new Font("Baskerville", Font.BOLD, 13));
		calcetto.addActionListener(this);
		group.add(calcetto);
		
		basket = new JRadioButton("Basket");
		basket.setBounds(65,490,100,25);
		basket.setBackground(new Color(0xEAE7DC));
		basket.setFont(new Font("Baskerville", Font.BOLD, 13));
		basket.addActionListener(this);
		group.add(basket);
		
		
		/*
		 * Qua ci sarà bisongo di un metodo che richiama una classe del progetto che mi restituisce tutte le strutture, per ora metto una lista di Stringhe
		 */
		Set<Struttura>lista =RegistroStrutture.getInstance().getListaStrutture();
		Set<String>lista_strutture = new HashSet<String>();
		for(Struttura s : lista) {
			lista_strutture.add(s.getNome());
		}
		String[] lista_string= lista_strutture.toArray(new String[lista_strutture.size()]);
		combostrutture = new JComboBox<String>(lista_string);
		combostrutture.setBounds(315,430,200,25);
		combostrutture.setBackground(new Color(0xEAE7DC));
		combostrutture.addActionListener(this);
		combostrutture.setSelectedIndex(-1);
		
		field = new JTextField("");
		field.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field.setForeground(new Color(0x8E8D8A));
		field.setBounds(630,430,140,30);
		
		String[] listaorari = {"09:00", "10:00", "11:00","16:00","17:00","18:00","19:00","20:00","21:00"};
		comboorari = new JComboBox<String>(listaorari);
		comboorari.setBounds(630,510,90,25);
		comboorari.setBackground(new Color(0xEAE7DC));
		comboorari.addActionListener(this);
		comboorari.setSelectedIndex(-1);
		
		
		ButtonGroup group1 = new ButtonGroup();
		
		si_spogliatoio = new JRadioButton("Sì");
		si_spogliatoio.setBounds(875,430,300,25);
		si_spogliatoio.setBackground(new Color(0xEAE7DC));
		si_spogliatoio.setFont(new Font("Baskerville", Font.BOLD, 13));
		si_spogliatoio.addActionListener(this);
		group1.add(si_spogliatoio);
		
		no_spogliatoio = new JRadioButton("No");
		no_spogliatoio.setBounds(875,460,300,25);
		no_spogliatoio.setBackground(new Color(0xEAE7DC));
		no_spogliatoio.setFont(new Font("Baskerville", Font.BOLD, 13));
		no_spogliatoio.addActionListener(this);
		group1.add(no_spogliatoio);
		
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Baskerville", Font.BOLD, 10));
		submit.setBounds(490,610,100,30);
		submit.setBackground(new Color(0xD8C3A5));
		submit.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		submit.addActionListener(this);
		
		this.add(titolo);
		this.add(titolo1);
		this.add(titolo2);
		this.add(titolo3);
		this.add(titolo4);
		this.add(titolo5);
		this.add(tennis);
		this.add(calcetto);
		this.add(basket);
		this.add(combostrutture);
		this.add(comboorari);
		this.add(si_spogliatoio);
		this.add(no_spogliatoio);
		this.add(descrizione1);
		this.add(descrizione2);
		this.add(descrizione3);
		this.add(descrizione4);
		this.add(descrizione5);
		this.add(descrizione6);
		this.add(descrizione7);
		this.add(descrizione8);
		this.add(field_nome);
		this.add(field_cognome);
		this.add(field_cf);
		this.add(submit);
		this.add(field);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		//inzio bottoni tipici del pannello
		if(e.getSource() == tennis) {
			sport ="Tennis";
		}
		else if(e.getSource() == calcetto) {
			sport = "Calcetto";
		}
		else if(e.getSource() == basket) {
			sport = "Basket";
		}
		else if(e.getSource() == combostrutture) {
			struttura = (String) combostrutture.getSelectedItem();
		}
		else if(e.getSource() == comboorari) {
			orario = (String) comboorari.getSelectedItem();
		}
		else if(e.getSource() == si_spogliatoio) {
			spogliatoio = true;
		}
		else if(e.getSource() == no_spogliatoio) {
			spogliatoio = false;
		}
		//pressione pulsante di submit
		else if(e.getSource() == submit){
			String nome = field_nome.getText();
			String cognome = field_cognome.getText();
			String cf = field_cf.getText();
			
			//caso in cui l'utente non abbia scritto un codice
			if(nome.length() == 0 | cognome.length() == 0| cf.length() == 0) {
				JOptionPane.showMessageDialog(null, "Devi settare correttamente tutti i campi anagrafici", "Errore Compilazione Dati Anagrafici", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
	
			String stringa_data = field.getText();
			LocalDateTime d;
			
					
			//controlli per verificare che tutto sia corretto
			if(sport == null | struttura == null | orario == null) {
				JOptionPane.showMessageDialog(null, "Campi non settati correttamente", "Errore Settaggio", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				
				//controlli legati alla data
				try {
					d = LocalDateTime.of(Integer.valueOf(stringa_data.split("-")[2]),Integer.valueOf(stringa_data.split("-")[1]),Integer.valueOf(stringa_data.split("-")[0]),Integer.valueOf(orario.split(":")[0]),Integer.valueOf(orario.split(":")[1]));
					if(d.compareTo(LocalDateTime.now())<=0) {
						JOptionPane.showMessageDialog(null, "Devi mettere una data futura", "Errore Settaggio", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Errore nel settaggio della data", "Errore Settaggio", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				//troviamo la struttura con il nome settato dall'utente
				Struttura s1 = null;
							
				for(Struttura s: RegistroStrutture.getInstance().getListaStrutture()) {
					if(s.getNome().compareTo(struttura) == 0) {
						s1 = s;
						break;
					}
				}
				
				Cliente cliente = new Cliente(nome,cognome,cf);
				Campo c = null;
				
				try {					
					//controllo se esiste un campo dello sport specificato nella struttura indicata
					boolean esistecamposport = false;
										
					for(Campo c1: s1.getListaCampi()) {
						if(c1.getSport().compareTo(sport) == 0) {
							esistecamposport = true;
						}
					}
					
					if(!esistecamposport) {
						JOptionPane.showMessageDialog(null, "Non esiste un campo di "+sport+" in questa struttura", "Errore Ricerca", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					//controlliamo se è possibile prenotare un campo della struttura all'orario definito
					c =cliente.controlloDisponibilitaCampo(sport, d, s1);
					
					
					
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Campo non disponibile nell'orario richiesto", "Errore Ricerca", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//si passa al pannello dei risultati della ricerca solo se c'è un campo disponibile all'orario richiesto
				Pannello_U_2 panel_U_2 = new Pannello_U_2(cliente, sport, s1, d, c, spogliatoio);
				container.add(panel_U_2, "U_2");
				cl.show(container,"U_2");
			}
	
		}
	}

}
