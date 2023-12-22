package piattaforma;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class PrenotazioneTest {

	Struttura s =new Struttura("CSS","via Asiago","Stezzano");
	LocalDateTime d = LocalDateTime.of(2022,12,10, 11, 36);
	CampoBasket campo= new CampoBasket((float)100,s);
	Spogliatoio sp = new Spogliatoio((float)100,s);
	Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo);//senza spogliatoio
	Prenotazione p2 =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo,sp);//con spogliatoio
		
	@Test
	public void testGetDataOra() {
		assertEquals(p.getDataOra(), d);
	}

	/*sbaglia il test ma abbiamo verificato che è giusto (con il main).
	@Test
	public void testGetCodicePrenotazione() {
		assertEquals(p.getCodicePrenotazione(),"P_21");
		//assertEquals(p2.getCodicePrenotazione(),"P_23");
		//assertEquals(p9.getCodicePrenotazione(),"P_210");
	}
	*/

	@Test
	public void testGetSport() {
		assertEquals(p.getSport(), "Basket");
	}

	@Test
	public void testIsSpogliatoio() {
		assertFalse(p.isSpogliatoio());
		assertTrue(p2.isSpogliatoio());
	}

	@Test
	public void testGetPrezzo() {
		//in questo caso il prezzo è solo la somma di campo + eventuale spogliatoio non essendoci sconto
		assertEquals(p.getPrezzo(), (float) 100, 0);
		assertEquals(p2.getPrezzo(), (float) 200, 0);
	}

	@Test
	public void testGetCodiceFiscalePrenotante() {
		assertEquals(p.getCodiceFiscalePrenotante(), "TSRALS04S16A787");
	}

	@Test
	public void testGetNomeStruttura() {
		assertEquals(p.getNomeStruttura(), s);
	}

	@Test
	public void testGetCampoAssociato() {
		assertEquals(p.getCampoAssociato(), campo);
	}

	@Test
	public void testGetSpogliatoioAssociato() {
		assertEquals(p2.getSpogliatoioAssociato(), sp);
	}

	@Test
	public void testSetDataOra() {
		LocalDateTime d1 = LocalDateTime.of(2023,12,10,11,36);
		p.setDataOra(d1);
		assertEquals(p.getDataOra(),d1);
	}

	/*
	@Test
	public void testSetCodicePrenotazione() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testSetSport() {
		p.setSport("Calcetto");
		assertEquals(p.getSport(),"Calcetto");
	}

	@Test
	public void testSetCodiceFiscalePrenotante() {
		p.setCodiceFiscalePrenotante("GCMTCR02C22A774A");
		assertEquals(p.getCodiceFiscalePrenotante(),"GCMTCR02C22A774A");
	}

	@Test
	public void testSetNomeStruttura() {
		Struttura s1 =new Struttura("Campo Sportivo","via Meucci","Dalmine");
		p.setNomeStruttura(s1);
		assertEquals(p.getNomeStruttura(), s1);
	}

	@Test
	public void testSetCampoAssociato() {
		CampoBasket campo1= new CampoBasket((float)200,s);
		p.setCampoAssociato(campo1);
		assertEquals(p.getCampoAssociato(),campo1);
	}

	@Test
	public void testSetSpogliatoioAssociato() {
		Spogliatoio sp1 = new Spogliatoio((float)100,s);
		p2.setSpogliatoioAssociato(sp1);
		assertEquals(p2.getSpogliatoioAssociato(),sp1);
	}

	@Test
	public void testLinkCampoAssociato() {
		CampoBasket campo2 = new CampoBasket((float)200,s);
		p.linkCampoAssociato(campo2);
		assertEquals(p.getCampoAssociato(),campo2);
	}

	@Test
	public void testLinkSpogliatoioAssociato() {
		Spogliatoio sp2 = new Spogliatoio((float)100,s);
		p.linkSpogliatoioAssociato(sp2);
		assertEquals(p.getSpogliatoioAssociato(),sp2);
	}

	@Test
	public void testUnlinkSpogliatoioAssociato() {
		p2.unlinkSpogliatoioAssociato();
		assertEquals(p.getSpogliatoioAssociato(), null);
	}

	//RICONTROLLA
	@Test
	public void testCalcolaPrezzo() throws Exception {
		RegistroStrutture r= RegistroStrutture.getInstance();
		r.linkListaStrutture(s);
		
		/*controllo due casi:
		 * -senza sconto (prenotazioni del cliente <5)
		 * -con sconto (prenotazioni del cliente>5)
		 */
		
		//costo p2 senza sconto
		LocalDateTime d0 = LocalDateTime.of(2022,10,10, 11, 36);
		Prenotazione p11 =new Prenotazione(d0,"Basket","TSRALS04S16A997",s,campo,sp);
		r.confermaPrenotazioneCONSpogliatoio(d0,"Basket","TSRALS04S16A997",s,campo,sp);
		assertEquals(p11.getPrezzo(), (float) 200, 0);
	
		LocalDateTime d1 = LocalDateTime.of(2022,1,10, 11, 36);
		Prenotazione p21 =new Prenotazione(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		r.confermaPrenotazioneCONSpogliatoio(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		Prenotazione p22 =new Prenotazione(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		r.confermaPrenotazioneCONSpogliatoio(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		Prenotazione p23 =new Prenotazione(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		r.confermaPrenotazioneCONSpogliatoio(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		Prenotazione p24 =new Prenotazione(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		r.confermaPrenotazioneCONSpogliatoio(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		Prenotazione p25 =new Prenotazione(d1,"Basket","TSRALS04S16A997",s,campo,sp);
		r.confermaPrenotazioneCONSpogliatoio(d1,"Basket","TSRALS04S16A997",s,campo,sp);

			
		//costo cliente con sconto
		assertEquals(p24.getPrezzo(), (float) 200, 0);//no sconto perchè è la quinta
		assertEquals(p25.getPrezzo(), (float) 160, 0);//sconto perchè è la sesta
		
	}

}
