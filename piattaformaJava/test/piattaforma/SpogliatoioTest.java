package piattaforma;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SpogliatoioTest {

	Struttura s =new Struttura("CSS","via Asiago","Stezzano");
	Spogliatoio sp = new Spogliatoio((float)100,s);
	Spogliatoio sp2 = new Spogliatoio((float)10,s);

	@Test
	public void testGetIDspogliatoio() {
		assertEquals(sp.getIDspogliatoio(), "S_1");
		assertEquals(sp2.getIDspogliatoio(), "S_2");
	}

	@Test
	public void testGetPrezzo() {
		assertEquals(sp.getPrezzo(), (float)100, 0);
	}

	@Test
	public void testGetListaPrenotazioni() {
		Set<Prenotazione> lista= new HashSet<>();
		LocalDateTime d= LocalDateTime.of(2022,12,10, 11, 36);
		CampoBasket campo= new CampoBasket((float)100,s);
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo,sp);
		lista.add(p);
		sp.linkListaPrenotazioni(p);
		
		assertEquals(sp.getListaPrenotazioni(), lista);
	}

	@Test
	public void testGetStrutturaProprietaria() {
		assertEquals(sp.getStrutturaProprietaria(), s);
	}

	@Test
	public void testSetStrutturaProprietaria() {
		Struttura s2 =new Struttura("campiSport","via Puccini", "Bergamo");
		sp.setStrutturaProprietaria(s2);
		
		assertEquals(sp.getStrutturaProprietaria(), s2);
	}

	@Test
	public void testLinkListaPrenotazioni() {
		LocalDateTime d= LocalDateTime.of(2022,12,10, 11, 36);
		CampoBasket campo= new CampoBasket((float)100,s);
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo,sp);
		sp.linkListaPrenotazioni(p);
		
		Set<Prenotazione> lista= new HashSet<>();
		lista.add(p);

		assertEquals(sp.getListaPrenotazioni(), lista);
	}

	@Test
	public void testLinkStrutturaProprietaria() {
		Struttura s2 =new Struttura("campiSport","via Puccini", "Bergamo");
		sp.linkStrutturaProprietaria(s2);
		
		assertEquals(sp.getStrutturaProprietaria(),s2);
	}

	@Test
	public void testUnlinkListaPrenotazioni() {
		LocalDateTime d= LocalDateTime.of(2022,12,10, 11, 36);
		CampoBasket campo= new CampoBasket((float)100,s);
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo,sp);
		Prenotazione p2 =new Prenotazione(d,"Basket","TSRALS04S16A797",s,campo,sp);
		sp.linkListaPrenotazioni(p);
		sp.linkListaPrenotazioni(p2);
		
		sp.unlinkListaPrenotazioni(p);
		
		Set<Prenotazione> lista= new HashSet<>();
		lista.add(p2);

		assertEquals(sp.getListaPrenotazioni(), lista);
	}

	/*
	@Test
	public void setIDSpogliatoio() {    	
		fail("Not yet implemented");
    }
    */

}
