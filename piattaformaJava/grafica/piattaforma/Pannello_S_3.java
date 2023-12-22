package piattaforma;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Questo è uno dei pannelli delle attività fruibili nella area privata della struttura. Da qui l'utente può scegliere
 * cosa andare ad aggiungere alla propria struttura e inoltre può fare tutte le azioni implementate da PannelloGeneraleStruttura
 * @author Torros
 *
 */
public class Pannello_S_3 extends PannelloGeneraleStruttura{
	
	JRadioButton tennis;
	JRadioButton calcetto;
	JRadioButton basket;
	JRadioButton spogliatoio;
	JButton submit;
	
	JTextField field;
	JComboBox<String> comboterreno;
	JComboBox<String> comboterreno2;
	JCheckBox boxcoperto;
	/*
	 * questa variabile è un intero inizialmente settato a -1 che cambia valore in base a quale dei quattro pulsanti si va
	 * a premere per aggiungere un campo o spogliatoio. I valori sono i seguenti
	 * - -1 nessun aggiunta
	 * - 0 tennis
	 * - 1 calcetto
	 * - 2 basket
	 * - 3 spogliatoio
	 */
	int valorerisposta = -1;
	int prezzo;
	String terreno1;
	String terreno2;
	boolean coperto;
	
	
	public Pannello_S_3() {
		super();
		
		this.setLayout(null);
		
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */
		
		JLabel titolo = new JLabel();
		titolo.setText("Aggiungi Campi o Spogliatoi");
		titolo.setForeground(new Color(0xE98074));
		titolo.setHorizontalTextPosition(JLabel.RIGHT);
		titolo.setFont(new Font("Baskerville", Font.PLAIN, 35));
		titolo.setBounds(240,90,700,50);
		
		JLabel titolo1 = new JLabel();
		titolo1.setText("In questa area puoi aggiungere nuovi campi o spogliatoi per la tua struttura");
		titolo1.setForeground(new Color(0x8E8D8A));
		titolo1.setHorizontalTextPosition(JLabel.RIGHT);
		titolo1.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo1.setBounds(240,150,800,25);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Attenzione, eventuali aggiunte non potranno essere poi eliminate dal database");
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione1.setBounds(240,180,900,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("E' possibile aggiungere un solo campo o spogliatoio alla volta");
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione2.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione2.setBounds(240,200,900,25);
		
		JLabel titolo2 = new JLabel();
		titolo2.setText("Cosa si desidera aggiungere?");
		titolo2.setForeground(new Color(0x8E8D8A));
		titolo2.setHorizontalTextPosition(JLabel.RIGHT);
		titolo2.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo2.setBounds(240,280,800,25);
	
		
		//variabile per raggruppare tennis basket e calcetto dato che vogliamo che solo uno di questi possa essere scelto
		ButtonGroup group = new ButtonGroup();
				
		tennis = new JRadioButton("Un campo da tennis");
		tennis.setBounds(260,320,180,25);
		tennis.setBackground(new Color(0xEAE7DC));
		tennis.setFont(new Font("Baskerville", Font.BOLD, 13));
		tennis.addActionListener(this);
		group.add(tennis);
		
		JLabel descrizione4 = new JLabel();
		descrizione4.setText("Tipo terreno:");
		descrizione4.setForeground(new Color(0x8E8D8A));
		descrizione4.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione4.setFont(new Font("Baskerville", Font.PLAIN, 14));
		descrizione4.setBounds(480,320,900,25);
		
		String[] lista = {"Sintetico", "Terra Battuta", "Cemento"};
		comboterreno = new JComboBox<String>(lista);
		comboterreno.setBounds(590,325,100,20);
		comboterreno.setBackground(new Color(0xEAE7DC));
		comboterreno.addActionListener(this);
		comboterreno.setSelectedIndex(-1);
				
		calcetto = new JRadioButton("Un campo da calcetto");
		calcetto.setBounds(260,370,180,25);
		calcetto.setBackground(new Color(0xEAE7DC));
		calcetto.setFont(new Font("Baskerville", Font.BOLD, 13));
		calcetto.addActionListener(this);
		group.add(calcetto);
		
		JLabel descrizione5 = new JLabel();
		descrizione5.setText("Tipo terreno:");
		descrizione5.setForeground(new Color(0x8E8D8A));
		descrizione5.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione5.setFont(new Font("Baskerville", Font.PLAIN, 14));
		descrizione5.setBounds(480,370,900,25);
		
		String[] lista2 = {"Sintetico", "Parquet"};
		comboterreno2 = new JComboBox<String>(lista2);
		comboterreno2.setBounds(590,375,100,20);
		comboterreno2.setBackground(new Color(0xEAE7DC));
		comboterreno2.addActionListener(this);
		comboterreno2.setSelectedIndex(-1);
		
		JLabel descrizione6 = new JLabel();
		descrizione6.setText("Coperto:");
		descrizione6.setForeground(new Color(0x8E8D8A));
		descrizione6.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione6.setFont(new Font("Baskerville", Font.PLAIN, 14));
		descrizione6.setBounds(750,370,900,25);
		
		boxcoperto= new JCheckBox();
		boxcoperto.setBounds(820,375,900,15);
		boxcoperto.setBackground(new Color(0xEAE7DC));
		boxcoperto.setFocusable(false);
		
				
		basket = new JRadioButton("Un campo da basket");
		basket.setBounds(260,420,180,25);
		basket.setBackground(new Color(0xEAE7DC));
		basket.setFont(new Font("Baskerville", Font.BOLD, 13));
		basket.addActionListener(this);
		group.add(basket);
		
		spogliatoio = new JRadioButton("Uno spogliatoio");
		spogliatoio.setBounds(260,470,180,25);
		spogliatoio.setBackground(new Color(0xEAE7DC));
		spogliatoio.setFont(new Font("Baskerville", Font.BOLD, 13));
		spogliatoio.addActionListener(this);
		group.add(spogliatoio);
		
		
		JLabel descrizione3 = new JLabel();
		descrizione3.setText("Prezzo orario:");
		descrizione3.setForeground(new Color(0x8E8D8A));
		descrizione3.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione3.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione3.setBounds(265,530,900,25);
		
		field = new JTextField("prezzo (in euro)");
		field.setFont(new Font("Baskerville", Font.PLAIN, 14));
		field.setForeground(new Color(0x8E8D8A));
		field.setBounds(390,530,110,30);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Baskerville", Font.BOLD, 10));
		submit.setBounds(490,600,100,30);
		submit.setBackground(new Color(0xD8C3A5));
		submit.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		submit.addActionListener(this);
		
		this.add(titolo);
		this.add(titolo1);
		this.add(descrizione1);
		this.add(descrizione2);
		this.add(descrizione3);
		this.add(descrizione4);
		this.add(titolo2);
		this.add(descrizione5);
		this.add(descrizione6);
		this.add(comboterreno);
		this.add(comboterreno2);
		this.add(field);
		this.add(boxcoperto);
		this.add(tennis);
		this.add(calcetto);
		this.add(basket);
		this.add(spogliatoio);
		this.add(submit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if(e.getSource() == tennis) {
			valorerisposta = 0;
		}
		else if(e.getSource() == calcetto) {
			valorerisposta = 1;
		}
		else if(e.getSource() == basket) {
			valorerisposta = 2;
		}
		else if(e.getSource() == spogliatoio) {
			valorerisposta = 3;
		}
		else if(e.getSource() == submit){
			try {
				prezzo=Integer.parseInt(field.getText());
				if(prezzo<0) prezzo*=(-1);//prezzo positivo
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Devi indicare un prezzo valido", "Errore Set", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//caso in cui non abbia selezionato nulla allora messaggio di errore
			if(valorerisposta == -1) {
				JOptionPane.showMessageDialog(null, "Devi scegliere cosa aggiungere prima di premere submit", "Errore Aggiunta", JOptionPane.ERROR_MESSAGE);
			}
			//caso invece in cui abbia selezionato o ci sia già qualcosa di selezionato
			else {
				
				//controllo per verificare se nel caso di calcio e tennis sia stato settato tutto
				switch(valorerisposta)
				{
				case 0:
					terreno1=(String)comboterreno.getSelectedItem();
					if(terreno1 == null) {
						JOptionPane.showMessageDialog(null, "Devi scegliere il tipo di terreno per i campo da tennis", "Errore Set", JOptionPane.ERROR_MESSAGE);
						return;
					}
					break;
				
				case 1:
					terreno2=(String)comboterreno2.getSelectedItem();
					coperto=boxcoperto.isSelected();
					if(terreno2 == null) {
						JOptionPane.showMessageDialog(null, "Devi scegliere il tipo di terreno per i campo da calcetto", "Errore Set", JOptionPane.ERROR_MESSAGE);
						return;
					}
					break;
				}
				
				
				int ans = JOptionPane.showConfirmDialog(null, "Confermi la tua aggiunta? Una volta confermata non potrai più eliminarla", "Conferma Aggiunta", JOptionPane.WARNING_MESSAGE);
				
				if(ans == 0) {
					switch(valorerisposta) {
					case 0:
						CampoTennis ct=new CampoTennis(prezzo, privata, terreno1);
						break;
					
					case 1:
						CampoCalcetto cc= new CampoCalcetto(prezzo, privata, terreno2, coperto);
						break;
					
					case 2:
						CampoBasket cb= new CampoBasket(prezzo, privata);
						break;
					
					case 3:
						Spogliatoio sp= new Spogliatoio(prezzo, privata);
						break;
					}
					
					Pannello_S_2 panel_S_2 = new Pannello_S_2();
					container.add(panel_S_2, "S_2");
					
					cl.show(container, "S_2");
				}
			}
		}
	}
}
