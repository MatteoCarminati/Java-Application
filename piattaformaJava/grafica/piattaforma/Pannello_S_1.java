package piattaforma;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Classe che rappresenta il primo pannello nell'ambiente dedicato alla struttura. 
 * E' un login dove il proprietario deve inserire una password; in caso di password corretta potrà accedere alla sua area 
 * personale, in caso contrario viene mostrato un popup di errore. Estende la classe PannelloGenerale per usufruire anche
 * di quelle attività come la pressione dei bottoni superiori
 * @author Torros
 *
 */
public class Pannello_S_1 extends PannelloGenerale{
	
	JTextField field;
	JButton submit;
	
	public Pannello_S_1() {
		super(); //si richiama super per dare al pannello le caratteristiche di JPanel e i settaggi generali
		
		//settiamo il Layout che utilizzeremo per questo pannello
		this.setLayout(null);
					
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */	
		JLabel area = new JLabel();
		area.setText("Area Struttura");
		area.setForeground(new Color(0xE98074));
		area.setHorizontalAlignment(JLabel.CENTER);
		area.setFont(new Font("Baskerville", Font.PLAIN, 45));
		area.setBounds(390,100,300,50);
		
		JLabel descrizione = new JLabel();
		descrizione.setText("Inserire la password per accedere all'area privata della struttura");
		descrizione.setForeground(new Color(0x8E8D8A));
		descrizione.setHorizontalAlignment(JLabel.CENTER);
		descrizione.setFont(new Font("Baskerville", Font.PLAIN, 20));
		descrizione.setBounds(140,190,800,25);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Se la tua struttura non è ancora salvata nel nostro database dovrai attendere un aggiornamento futuro");
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalAlignment(JLabel.CENTER);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 20));
		descrizione1.setBounds(90,220,900,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("Hai a disposizione un numero illimitato di tentativi");
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalAlignment(JLabel.CENTER);
		descrizione2.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione2.setBounds(90,250,900,25);
		
		
		field = new JTextField("");
		field.setFont(new Font("Baskerville", Font.PLAIN, 17));
		field.setForeground(new Color(0x8E8D8A));
		field.setBounds(540,350,140,30);
		
		JLabel password = new JLabel();
		password.setText("Password: ");
		password.setForeground(new Color(0x8E8D8A));
		password.setHorizontalAlignment(JLabel.CENTER);
		password.setFont(new Font("Baskerville", Font.PLAIN, 17));
		password.setBounds(420,352,90,25);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Baskerville", Font.BOLD, 10));
		submit.setBounds(490,400,100,30);
		submit.setBackground(new Color(0xD8C3A5));
		submit.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		submit.addActionListener(this);
		
		
		this.add(area);
		this.add(descrizione);
		this.add(descrizione1);
		this.add(descrizione2);
		this.add(field);
		this.add(password);
		this.add(submit);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
			
		//quando premiamo il bottone di submit
		if(e.getSource() == submit){
			String valorepassword = field.getText();
			//risettiamo il field
			field.setText("Password");
			
			RegistroStrutture registro = RegistroStrutture.getInstance();
		
			//controllo esistenza struttura in registro con id = password
			try {
				PannelloGeneraleStruttura.privata = registro.check(valorepassword);
				
				
				
				Pannello_S_2 panel_S_2 = new Pannello_S_2();
				container.add(panel_S_2, "S_2");
				
				cl.show(container, "S_2");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "La password inserita non è corretta, ritenta.", "Errore Passord", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
}
