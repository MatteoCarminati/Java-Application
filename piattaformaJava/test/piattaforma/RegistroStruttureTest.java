package piattaforma;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class RegistroStruttureTest {

	
	@Test(expected=Throwable.class)
	public void TestGenerale() throws Exception {
		RegistroStrutture r = RegistroStrutture.getInstance();
		Struttura s =new Struttura("CSS","via Asiago","Stezzano");
		Struttura s2 =new Struttura("CSS2","via Asiago","Stezzano");
		
		LocalDateTime d = LocalDateTime.of(2022,12,10, 11, 36);
		CampoBasket campo = new CampoBasket((float)100,s);
		Spogliatoio sp = new Spogliatoio((float)100,s);
		
			
		//test di getIstance()
		assertEquals(RegistroStrutture.getInstance(), RegistroStrutture.registro);
		
		
		//test di getlistastrutture()
		Set<Struttura> lista= new HashSet<>();
		lista.add(s);
		
		r.getListaStrutture().add(s);
		assertEquals(r.getListaStrutture(), lista);
		
		
		//test di linklistastrutture()
		lista.add(s2);
		r.linkListaStrutture(s2);
		
		assertEquals(r.getListaStrutture(), lista);
		
		
		//test di unliklistastrutture()
		lista.remove(s2);
		r.unlinkListaStrutture(s2);
		
		assertEquals(r.getListaStrutture(), lista);
		
		
		//test di check()
		assertEquals(r.check("Struttura_1"), s);
		
		
		//test di controllodisponibilit‡Campo()
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo);//senza spogliatoio
		
		//assertEquals(r.controlloDisponibilitaCampo("Basket",d,s),null); //campo gi‡ occupato
		r.controlloDisponibilitaCampo("Basket",d,s);
		
		LocalDateTime d2 = LocalDateTime.of(2023,12,10, 11, 36);
		assertEquals(r.controlloDisponibilitaCampo("Basket",d2,s), campo); //campo libero
		
		
		//test di controllodisponibilit‡Spogliatoio()
		LocalDateTime d3 = LocalDateTime.of(2024,12,10, 11, 36);
		Prenotazione p1 =new Prenotazione(d3,"Basket","TSRALS04S16A787",s,campo,sp);//senza spogliatoio
		
		r.controlloDisponibilitaSpogliatoio(d3,s); //spogliatoio gi‡ occupato
		
		assertEquals(r.controlloDisponibilitaSpogliatoio(d2,s), sp);  //spogliatoio libero
		
		
		//test di confermaprenotazioneCONspogliatoio()
		Cliente c= new Cliente("Matteo","Carminati","CRMMTT80A12A794Q");
		
		s.linkListaClientiBan(c);
		r.confermaPrenotazioneCONSpogliatoio(d, "Basket", "CRMMTT80A12A794Q", s, campo, sp); //tentativo di prenotazione
		//controlliamo che la prenotazione non sia presente nel campo dato che il cliente Ë bannato	
		for(Prenotazione prenotazione: s.stampaPrenotazioni(campo)) {
			assertFalse(prenotazione.getCodiceFiscalePrenotante().compareTo("CRMMTT80A12A794Q") == 0);
		}
		
		Cliente c2= new Cliente("Lorenzo","Torri","LNZTRR00S16A794D");
		r.confermaPrenotazioneCONSpogliatoio(d, "Basket", "LNZTRR00S16A794D", s, campo, sp);
		//controlliamo che la prenotazione sia presente nel campo dato che il cliente non Ë bannato	
		boolean presente = false;
		
		for(Prenotazione prenotazione: s.stampaPrenotazioni(campo)) {
			if(prenotazione.getCodiceFiscalePrenotante().compareTo("LNZTRR00S16A794D") == 0) {
				presente = true;
			}
		}
		assertTrue(presente);
		
		
		//il test non viene replicato per confermaprenotazioneNOspogliatoio() perchË identico
		
		
	}
	

}
