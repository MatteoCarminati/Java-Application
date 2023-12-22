package piattaforma;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

/**
 * Questo è uno dei pannelli delle attività fruibili nella area privata della struttura. Da qui l'utente può scegliere
 * di stampare le prenotazoni di un certo campo o spogliatoio e inoltre può fare tutte le azioni implementate da PannelloGeneraleStruttura
 * E' un pannello speciale come S_2 in quanto essendo dinamico necessita di dover essere sempre istanziato nuovamente per 
 * poterlo tenere aggiornato
 * @author Torros
 *
 */
public class Pannello_S_5 extends PannelloGeneraleStruttura{
	
	JComboBox<String> combocampi;
	JButton submit;
	Set<String> lista=new HashSet<>();
	
	/*
	 * questa variabile viene settata nel costruttore e contiene il nome della struttura di cui si sta visualizzando l'area
	 * privata, è necessario perchè poi serve nel pannello dove si stamperanno tutte le prenotazioni per fare le ricerche
	 * rispetto a tale struttura
	 */
	String struttura;
	
	/*
	 * questa variabile serve per tenere sotto controllo quello che viene selezionato con il combobox;
	 */
	String campo;

	
	public Pannello_S_5(String nomestruttura) {
		super();
		
		this.setLayout(null);
		
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */
		struttura = nomestruttura;
		
		JLabel titolo = new JLabel();
		titolo.setText("Controlla le prenotazioni di un campo o spogliatoio");
		titolo.setForeground(new Color(0xE98074));
		titolo.setHorizontalTextPosition(JLabel.RIGHT);
		titolo.setFont(new Font("Baskerville", Font.PLAIN, 35));
		titolo.setBounds(240,90,800,50);
		
		JLabel titolo1 = new JLabel();
		titolo1.setText("In questa area puoi visualizzare le prenotazioni associate ai tuoi campi o spogliatoi");
		titolo1.setForeground(new Color(0x8E8D8A));
		titolo1.setHorizontalTextPosition(JLabel.RIGHT);
		titolo1.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo1.setBounds(240,150,800,25);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Seleziona il campo o lo spogliatoio di cui vuoi vedere la lista di prenotazioni e premi Sumbit");
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione1.setBounds(240,180,900,25);
		
		/*
		 * Qua ci sarà bisongo di un metodo che richiama una classe del progetto che mi restituisce tutte le strutture, per ora metto una lista di Stringhe
		 */
		for(Campo c : privata.getListaCampi()) {
			lista.add(c.getIDcampo() +" "+ "("+c.getSport()+")");
		}
		for(Spogliatoio sp : privata.getListaSpogliatoi()) {
			lista.add(sp.getIDspogliatoio());
		}
		String[] lista_string= lista.toArray(new String[lista.size()]);
		combocampi = new JComboBox<String>(lista_string);
		combocampi.setBounds(240,250,200,25);
		combocampi.setBackground(new Color(0xEAE7DC));
		combocampi.addActionListener(this);
		combocampi.setSelectedIndex(-1);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Baskerville", Font.BOLD, 10));
		submit.setBounds(600,250,100,30);
		submit.setBackground(new Color(0xD8C3A5));
		submit.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		submit.addActionListener(this);
				
		
		this.add(titolo);
		this.add(titolo1);
		this.add(descrizione1);
		this.add(combocampi);
		this.add(submit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if(e.getSource() == combocampi) {
			campo = (String) combocampi.getSelectedItem();
		}
		else if(e.getSource() == submit) {
			//situazione di errore quando non si è scelto nessun campo
			if(combocampi.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Devi scegliere un campo o spogliatoio prima di premere submit", "Errore Ricerca", JOptionPane.ERROR_MESSAGE);
			}
			else {
				Pannello_S_6 panel_S_6 = new Pannello_S_6(campo);
				container.add(panel_S_6, "S_6");
				cl.show(container, "S_6");
			}
		}
	}
	
}
