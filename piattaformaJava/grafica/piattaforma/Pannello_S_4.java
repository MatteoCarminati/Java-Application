package piattaforma;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * Questo è uno dei pannelli delle attività fruibili nella area privata della struttura. Da qui l'utente può scegliere
 * se bannare un utente andando a specificare il suo codice fiscale nell'apposito TextField e inoltre può fare tutte 
 * le azioni implementate da PannelloGeneraleStruttura
 * @author Torros
 *
 */
public class Pannello_S_4 extends PannelloGeneraleStruttura{

	JTextField field_nome;
	JTextField field_cognome;
	JTextField field_cf;
	JButton submit;
	
	
	public Pannello_S_4() {
		super();
		
		this.setLayout(null);
		
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */
		JLabel titolo = new JLabel();
		titolo.setText("Ban per un utente");
		titolo.setForeground(new Color(0xE98074));
		titolo.setHorizontalTextPosition(JLabel.RIGHT);
		titolo.setFont(new Font("Baskerville", Font.PLAIN, 35));
		titolo.setBounds(240,90,700,50);
		
		JLabel titolo1 = new JLabel();
		titolo1.setText("In questa area puoi assegnare un ban a un utente per impedigli future prenotazioni");
		titolo1.setForeground(new Color(0x8E8D8A));
		titolo1.setHorizontalTextPosition(JLabel.RIGHT);
		titolo1.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo1.setBounds(240,150,800,25);
		
		JLabel titolo2 = new JLabel();
		titolo2.setText("presso la tua struttura");
		titolo2.setForeground(new Color(0x8E8D8A));
		titolo2.setHorizontalTextPosition(JLabel.RIGHT);
		titolo2.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo2.setBounds(240,180,800,25);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Si prega di usare il ban con cautela e solo in situazioni giustificate, in quanto azione non reversibile													");
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione1.setBounds(240,210,900,25);
		
		JLabel titolo3 = new JLabel();
		titolo3.setText("Inserire il codice fiscale della persona da bannare");
		titolo3.setForeground(new Color(0x8E8D8A));
		titolo3.setHorizontalTextPosition(JLabel.RIGHT);
		titolo3.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo3.setBounds(240,300,800,25);
		
		JLabel descrizione3 = new JLabel();
		descrizione3.setText("Nome:");
		descrizione3.setForeground(new Color(0x8E8D8A));
		descrizione3.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione3.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione3.setBounds(240,350,200,25);
		
		JLabel descrizione4 = new JLabel();
		descrizione4.setText("Cognome:");
		descrizione4.setForeground(new Color(0x8E8D8A));
		descrizione4.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione4.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione4.setBounds(240,380,200,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("Codice Fiscale:");
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione2.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione2.setBounds(240,410,200,25);
		
		field_nome = new JTextField("");
		field_nome.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field_nome.setBounds(390,350,300,30);
		
		field_cognome = new JTextField("");
		field_cognome.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field_cognome.setBounds(390,380,300,30);
		
		field_cf = new JTextField("");
		field_cf.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field_cf.setBounds(390,410,300,30);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Baskerville", Font.BOLD, 10));
		submit.setBounds(490,500,100,30);
		submit.setBackground(new Color(0xD8C3A5));
		submit.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		submit.addActionListener(this);
		
		this.add(titolo);
		this.add(titolo1);
		this.add(titolo2);
		this.add(titolo3);
		this.add(descrizione1);
		this.add(descrizione2);
		this.add(descrizione3);
		this.add(descrizione4);
		this.add(field_nome);
		this.add(field_cognome);
		this.add(field_cf);
		this.add(submit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		
		if(e.getSource() == submit) {
			String nome = field_nome.getText();
			String cognome = field_cognome.getText();
			String cf = field_cf.getText();
			
			//caso in cui l'utente non abbia scritto un codice
			if(nome.length() == 0 | cognome.length() == 0| cf.length() == 0) {
				JOptionPane.showMessageDialog(null, "Devi settare correttamente tutti i campi prima di confermare", "Errore Creazione Ban", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
				
				Cliente c = new Cliente(nome, cognome, cf);
				
				//eccezione qualora il cf inserito sia già presente nella lista dei ban della struttura
				try {
					privata.linkListaClientiBan(c);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Ban già presente per questo Utente", "Errore Creazione Ban", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//int ans = JOptionPane.showConfirmDialog(null, "Confermi il ban? Una volta aggiunto non sarà più possibile eliminarlo", "Conferma Creazione Ban", JOptionPane.WARNING_MESSAGE);
				
				//if(ans == 0) {

					
					field_nome.setText("");
					field_cognome.setText("");
					field_cf.setText("");
					
					Pannello_S_2 panel_S_2 = new Pannello_S_2();
					container.add(panel_S_2, "S_2");
					
					cl.show(container, "S_2");
				//}
			}
		}
	}
}
