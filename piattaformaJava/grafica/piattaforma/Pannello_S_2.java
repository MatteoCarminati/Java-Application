package piattaforma;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



/**
 * Questo è il pannello del menu principale dela struttura. E' un area privata che viene mostrata solo dopo aver usato la 
 * giusta credenziale. Il pannello e da questo momento tutti quelli con S_n con n>2 estendono il PannelloGeneraleStruttura
 * per avere già i comportamenti associati al premere i pulsati sopra e quelli legati a premere i pulsanti laterali che sono
 * una specifica dei pannelli associati all'area privata della struttura.
 * Il pannello deve essere istanziato ogni volta perchè deve essere aggirnato sempre con il numero dei campi qualora si 
 * dovessero effettuare modifiche
 * @author Torros
 *
 */
public class Pannello_S_2 extends PannelloGeneraleStruttura{

	public Pannello_S_2() {
		super();
		
		this.setLayout(null);
		
		/*
		 * Da questo punto inzia la customizzazione vera e propria del pannello
		 */
		
		JLabel titolo = new JLabel();
		titolo.setText("Area Privata");
		titolo.setForeground(new Color(0xE98074));
		titolo.setHorizontalTextPosition(JLabel.RIGHT);
		titolo.setFont(new Font("Baskerville", Font.PLAIN, 35));
		titolo.setBounds(240,90,700,50);
		
		JLabel nome = new JLabel();
		nome.setText(privata.getNome());
		nome.setForeground(new Color(0xE85A4F));
		nome.setHorizontalTextPosition(JLabel.RIGHT);
		nome.setFont(new Font("Baskerville", Font.BOLD, 38));
		nome.setBounds(440,90,700,50);
		
		JLabel titolo1 = new JLabel();
		titolo1.setText("Puoi effettuare le azioni del menu presente sulla sinistra per la tua struttura");
		titolo1.setForeground(new Color(0x8E8D8A));
		titolo1.setHorizontalTextPosition(JLabel.RIGHT);
		titolo1.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo1.setBounds(240,150,800,25);
		
		JLabel titolo2 = new JLabel();
		titolo2.setText("Informazioni Generali");
		titolo2.setForeground(new Color(0x8E8D8A));
		titolo2.setHorizontalTextPosition(JLabel.RIGHT);
		titolo2.setFont(new Font("Baskerville", Font.PLAIN, 20));
		titolo2.setBounds(240,220,800,25);
		
		JLabel descrizione1 = new JLabel();
		descrizione1.setText("Nome Struttura: "+privata.getNome());
		descrizione1.setForeground(new Color(0x8E8D8A));
		descrizione1.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione1.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione1.setBounds(250,250,900,25);
		
		JLabel descrizione2 = new JLabel();
		descrizione2.setText("Indirizzo: "+privata.getIndirizzo());
		descrizione2.setForeground(new Color(0x8E8D8A));
		descrizione2.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione2.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione2.setBounds(250,280,900,25);
		
		JLabel descrizione3 = new JLabel();
		descrizione3.setText("Città: "+privata.getCitta());
		descrizione3.setForeground(new Color(0x8E8D8A));
		descrizione3.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione3.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione3.setBounds(250,310,900,25);
		
		int nroCalcetto=0, nroTennis=0, nroBasket=0;
		for(Campo c : privata.getListaCampi()) {
			switch (c.getSport())
			{
			case "Calcetto":
				nroCalcetto++;
				break;
			case "Basket":
				nroBasket++;
				break;
			case "Tennis":
				nroTennis++;
				break;
			}
		}
		
		JLabel descrizione4 = new JLabel();
		descrizione4.setText("Numero Campi Calcetto: "+nroCalcetto);
		descrizione4.setForeground(new Color(0x8E8D8A));
		descrizione4.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione4.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione4.setBounds(250,400,300,25);
		
		JLabel descrizione5 = new JLabel();
		descrizione5.setText("Numero Campi Tennis: "+nroTennis);
		descrizione5.setForeground(new Color(0x8E8D8A));
		descrizione5.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione5.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione5.setBounds(250,430,300,25);
		
		JLabel descrizione6 = new JLabel();
		descrizione6.setText("Numero Campi Basket: "+nroBasket);
		descrizione6.setForeground(new Color(0x8E8D8A));
		descrizione6.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione6.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione6.setBounds(250,460,300,25);
		
		JLabel descrizione7 = new JLabel();
		descrizione7.setText("Numero Spogliatoi: "+privata.getListaSpogliatoi().size());
		descrizione7.setForeground(new Color(0x8E8D8A));
		descrizione7.setHorizontalTextPosition(JLabel.RIGHT);
		descrizione7.setFont(new Font("Baskerville", Font.PLAIN, 17));
		descrizione7.setBounds(250,490,300,25);
		
		ImageIcon campo = new ImageIcon(new ImageIcon("grafica/camposportivo.jpg").getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT));
		JLabel immagine = new JLabel();
		immagine.setIcon(campo);
		immagine.setBounds(550,350,700,340);
		
		this.add(titolo);
		this.add(nome);
		this.add(titolo1);
		this.add(titolo2);
		this.add(descrizione1);
		this.add(descrizione2);
		this.add(descrizione3);
		this.add(descrizione4);
		this.add(descrizione5);
		this.add(descrizione6);
		this.add(descrizione7);
		this.add(immagine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

	}
}
