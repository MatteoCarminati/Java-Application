package piattaforma;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class StrutturaTest {


	Struttura s =new Struttura("CSS","via Asiago","Stezzano");
	LocalDateTime d = LocalDateTime.of(2022,12,10, 11, 36);
	CampoBasket campo= new CampoBasket((float)100,s);
	CampoBasket campo2= new CampoBasket((float)200,s);
	Spogliatoio sp = new Spogliatoio((float)100,s);
	Spogliatoio sp2 = new Spogliatoio((float)60,s);
	Prenotazione p =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo);
	Prenotazione p2 =new Prenotazione(d,"Basket","TSRALS04S16A787",s,campo,sp);
	Cliente c= new Cliente("Matteo","Carminati","CRMMTT80A12A794Q");
	Cliente c2= new Cliente("Mario","Caironi","CRMMTT80A12A754Q");
	
	
	@Test
	public void testGetNome() {
		assertEquals(s.getNome(),"CSS");
	}

	@Test
	public void testGetIndirizzo() {
		assertEquals(s.getIndirizzo(),"via Asiago");
	}

	@Test
	public void testGetCitta() {
		assertEquals(s.getCitta(),"Stezzano");
	}

	/*corretto sul main, nel test numeri di struttura avanti di 1
	@Test
	public void testGetIDstruttura() {
		assertEquals(s.getIDstruttura(),"Struttura_1");
		Struttura s2 =new Struttura("CSS2","via Asiago","Stezzano");
		assertEquals(s2.getIDstruttura(),"Struttura_2");
	}
	 */
	
	@Test
	public void testGetConteggioPrenotazioni() {
		s.aggiornaConteggioPrenotazioni(c.getCodiceFiscale());//simulo prenotazione fatta da c
		s.aggiornaConteggioPrenotazioni(c.getCodiceFiscale());//simulo prenotazione fatta da c
		
		s.aggiornaConteggioPrenotazioni(c2.getCodiceFiscale());//simulo prenotazione fatta da c2
		
		HashMap<String, Integer> lista = new HashMap<>();
		lista.put(c.getCodiceFiscale(), 2);
		lista.put(c2.getCodiceFiscale(), 1);
		
		assertEquals(s.getConteggioPrenotazioni(), lista);
	}

	@Test
	public void testGetListaClientiBan() throws Exception {
		Set<Cliente> lista= new HashSet<>();
		lista.add(c);
		s.linkListaClientiBan(c);
		
		assertEquals(s.getListaClientiBan(), lista);
	}

	@Test
	public void testGetListaCampi() {
		Set<Campo> lista= new HashSet<>();
		lista.add(campo);
		lista.add(campo2);
				
		assertEquals(s.getListaCampi(), lista);
	}

	@Test
	public void testGetListaSpogliatoi() {
		Set<Spogliatoio> lista= new HashSet<>();
		lista.add(sp);
		lista.add(sp2);
			
		assertEquals(s.getListaSpogliatoi(), lista);
	}

	@Test
	public void testSetNome() {
		s.setNome("centro Sportivo");
		assertEquals(s.getNome(), "centro Sportivo");
	}

	@Test
	public void testSetIndirizzo() {
		s.setIndirizzo("via Puccini");
		assertEquals(s.getIndirizzo(), "via Puccini");
	}

	@Test
	public void testSetCitta() {
		s.setCitta("Azzano");
		assertEquals(s.getCitta(), "Azzano");
	}

	@Test
	public void testLinkListaClientiBan() throws Exception {
		s.linkListaClientiBan(c);
		s.linkListaClientiBan(c2);

		Set<Cliente> lista= new HashSet<>();
		lista.add(c);	
		lista.add(c2);
		
		assertEquals(s.getListaClientiBan(), lista);
	}

	@Test
	public void testLinkListaCampi() {
		s.linkListaCampi(campo2);
		
		Set<CampoBasket> lista= new HashSet<>();
		lista.add(campo);	
		lista.add(campo2);
		
		assertEquals(s.getListaCampi(), lista);
	}

	@Test
	public void testLinkListaSpogliatoi() {
		Set<Spogliatoio> lista= new HashSet<>();
		lista.add(sp);	
		lista.add(sp2);
		
		assertEquals(s.getListaSpogliatoi(), lista);
	}

	@Test
	public void testUnlinkListaClientiBan() throws Exception {
		Set<Cliente> lista= new HashSet<>();
		lista.add(c2);
		
		s.linkListaClientiBan(c);
		s.linkListaClientiBan(c2);
		
		s.unlinkListaClientiBan(c);	
		
		assertEquals(s.getListaClientiBan(), lista);
	}

	@Test
	public void testUnlinkListaCampi() {
		Set<Campo> lista= new HashSet<>();
		lista.add(campo2);
		
		s.linkListaCampi(campo);
		s.linkListaCampi(campo2);
		
		s.unlinkListaCampi(campo);	
		
		assertEquals(s.getListaCampi(), lista);
	}

	@Test
	public void testUnlinkListaSpogliatoi() {
		Set<Spogliatoio> lista= new HashSet<>();
		lista.add(sp2);
		
		s.linkListaSpogliatoi(sp);
		s.linkListaSpogliatoi(sp2);
		
		s.unlinkListaSpogliatoi(sp);	
		
		assertEquals(s.getListaSpogliatoi(), lista);
	}

	@Test
	public void testStampaPrenotazioniCampo() {		
		Set<Prenotazione> lista= new HashSet<>();
		lista.add(p);	
		lista.add(p2);
		
		assertEquals(s.stampaPrenotazioni(campo), lista);
	}

	@Test
	public void testStampaPrenotazioniSpogliatoio() {
		Set<Prenotazione> lista= new HashSet<>();
		lista.add(p2);
		
		assertEquals(s.stampaPrenotazioni(sp), lista);
	}

	@Test
	public void testControllaBan() throws Exception {
		s.linkListaClientiBan(c);
		
		assertTrue(s.controllaBan(c.getCodiceFiscale()));
		assertFalse(s.controllaBan(c2.getCodiceFiscale()));
	}

	@Test
	public void testAggiornaConteggioPrenotazioni() {
		s.aggiornaConteggioPrenotazioni(c.getCodiceFiscale());//simulo prenotazione fatta da c
		s.aggiornaConteggioPrenotazioni(c.getCodiceFiscale());//simulo prenotazione fatta da c
		
		s.aggiornaConteggioPrenotazioni(c2.getCodiceFiscale());//simulo prenotazione fatta da c2
		
		Iterator<Entry<String,Integer>> it= s.getConteggioPrenotazioni().entrySet().iterator();
    	
    	while(it.hasNext()) {
    		Map.Entry<String,Integer> set= (Map.Entry<String,Integer>) it.next();
    		if(set.getKey()==c.getCodiceFiscale()) {
    			int n=set.getValue(); 
    			assertEquals(n, 2);
    		}
    		if(set.getKey()==c2.getCodiceFiscale()) {
    			int n=set.getValue(); 
    			assertEquals(n, 1);
    		}
    	}
    	
	}

}
