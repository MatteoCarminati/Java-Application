package piattaforma;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe Generale dei pannelli che implementa ciò che accomuna tutti i pannelli, del tipo le due variabili che si rifanno al MainFrame e alcuni
 * settaggi come il colore dello sfondo e le dimensioni
 * @author Torros
 *
 */
public class PannelloGenerale extends JPanel implements ActionListener{
	
	/*
	 * variabili che si rifanno alla classe MainFrame.java
	 */
	JPanel container;
	CardLayout cl;
	
	/*
	 * bottoni in alto 
	 */
	JButton bottoneUtente;
	JButton bottoneStruttura;
	JButton bottoneMenu;
	
	public PannelloGenerale() {
		this.setBounds(0,0,1080,720); //settiamo il pannello in base alle dimensioni del frame
		this.setBackground(new Color(0xEAE7DC));
		
		JPanel pannellosopra = new JPanel();
		pannellosopra.setBackground(new Color(0xD8C3A5));
		pannellosopra.setBounds(0,0,1080,55);
		
		//creazione dei bottoni del menu
		bottoneUtente = new JButton("UTENTE");
		bottoneUtente.setFont(new Font("Baskerville", Font.BOLD, 10));
		bottoneUtente.setBounds(310,15,120,30);
		bottoneUtente.setBackground(new Color(0xD8C3A5));
		bottoneUtente.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		
		bottoneStruttura = new JButton("STRUTTURA");
		bottoneStruttura.setFont(new Font("Baskerville", Font.BOLD, 10));
		bottoneStruttura.setBounds(480,15,120,30);
		bottoneStruttura.setBackground(new Color(0xD8C3A5));
		bottoneStruttura.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		
		
		bottoneMenu = new JButton("MENU");
		bottoneMenu.setFont(new Font("Baskerville", Font.BOLD, 10));
		bottoneMenu.setBounds(650,15,120,30);
		bottoneMenu.setBackground(new Color(0xD8C3A5));
		bottoneMenu.setBorder(BorderFactory.createLineBorder(new Color(0xE98074),1));
		
		bottoneUtente.addActionListener(this);
		bottoneStruttura.addActionListener(this);
		bottoneMenu.addActionListener(this);
		
		
		this.add(bottoneUtente);
		this.add(bottoneStruttura);
		this.add(bottoneMenu);
		//il pannello va inserito per ultimo se no Swing lo mette sopra a tutti e tre i bottoni
		this.add(pannellosopra);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cl = MainFrame.getLayout();
		container = MainFrame.getContainer();
				
		if(e.getSource() == bottoneUtente) {
			cl.show(container, "U_1");
		}
		else if(e.getSource() == bottoneStruttura) {
			cl.show(container, "S_1");
		}
		else if(e.getSource() == bottoneMenu){
			cl.show(container,"1");
		}	
		//non mettiamo un else, perchè se no quando viene richiamato da una sotto classe va a eseguire sempre quell'else, quando invece magari è specificato
		//meglio dal metodo della sottoclasse
	}

}
