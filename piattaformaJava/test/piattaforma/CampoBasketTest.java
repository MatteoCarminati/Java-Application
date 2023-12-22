package piattaforma;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class CampoBasketTest {
	
	Struttura s =new Struttura("CSS","via Asiago","Stezzano");
	CampoBasket campo= new CampoBasket((float)100,s);
	CampoBasket campo2= new CampoBasket((float)10,s);
	
	@Test
	public void testGetAltezzaCanestro() {
		assertEquals((double)campo.getAltezzaCanestro(),(double)3.05,0);
	}

	@Test
	public void testGetnroGiocatori() {
		assertEquals(campo.getnroGiocatori(), 10);
	}

	@Test
	public void testSetAltezzaCanestro() {
		campo.setAltezzaCanestro((double)4.00);
		assertEquals((double)campo.getAltezzaCanestro(),(double)4.00,0);
	}


	@Test
	public void testGetSport() {
		assertEquals(campo.getSport(),"Basket");
	}

	@Test
	public void testGetPrezzo() {
		assertEquals(campo.getPrezzo(),(float)100,0);
	}


	@Test
	public void testGetListaPrenotazioni() {
		Set<Prenotazione> lista= new HashSet<>();
		LocalDateTime d= LocalDateTime.of(2022,12,10, 11, 36);
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo);
		lista.add(p);
		campo.linkListaPrenotazioni(p);
		
		assertEquals(campo.getListaPrenotazioni(), lista);
	}

	@Test
	public void testGetStrutturaProprietaria() {
		assertEquals(campo.getStrutturaProprietaria(), s);
	}

	@Test
	public void testSetStrutturaProprietaria() {
		Struttura s2 =new Struttura("campiSport","via Puccini", "Bergamo");
		campo.setStrutturaProprietaria(s2);
		
		assertEquals(campo.getStrutturaProprietaria(), s2);
	}

	@Test
	public void testLinkListaPrenotazioni() {
		LocalDateTime d= LocalDateTime.of(2022,12,10, 11, 36);
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo);
		campo.linkListaPrenotazioni(p);
		Set<Prenotazione> lista= new HashSet<>();
		lista.add(p);
		
		assertEquals(campo.getListaPrenotazioni(),lista);
	}

	@Test
	public void testLinkStrutturaProprietaria() {
		Struttura s2 =new Struttura("campiSport","via Puccini", "Bergamo");
		campo.linkStrutturaProprietaria(s2);
		
		assertEquals(campo.getStrutturaProprietaria(),s2);
	}

	@Test
	public void testUnlinkListaPrenotazioni() {
		LocalDateTime d= LocalDateTime.of(2022,12,10, 11, 36);
		Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo);
		Prenotazione p2 =new Prenotazione(d,"Basket","TSRALS04S16A887",s,campo);
		campo.linkListaPrenotazioni(p);
		campo.linkListaPrenotazioni(p2);
		
		Set<Prenotazione> lista= new HashSet<>();
		lista.add(p2);
	
		campo.unlinkListaPrenotazioni(p);
		
		assertEquals(campo.getListaPrenotazioni(),lista);
	}
	
	@Test
	public void testGetIDcampo() {
		assertEquals(campo.getIDcampo(),"C_1");
		assertEquals(campo2.getIDcampo(),"C_2");
	}
	
	/*
	@Test
	public void setIDSpogliatoio() {    	
		fail("Not yet implemented");
    }
    */


}
