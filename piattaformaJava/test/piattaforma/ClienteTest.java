package piattaforma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	Cliente c= new Cliente("Matteo","Carminati","CRMMTT80A12A794Q");

	@Test
	public void testGetNome() {
		assertEquals(c.getNome(), "Matteo");
	}

	@Test
	public void testGetCognome() {
		assertEquals(c.getCognome(), "Carminati");
	}

	@Test
	public void testGetCodiceFiscale() {
		assertEquals(c.getCodiceFiscale(), "CRMMTT80A12A794Q");
	}

	/*@Test
	public void testControlloDisponibilitaCampo() {
		fail("Not yet implemented");
	}

	@Test
	public void testControlloDisponibilitaSpogliatoio() {
		fail("Not yet implemented");
	}
	 
	 *Essendo metodi richimati, non li testimao nella classse Cliente ma in quelle in cui sono stati definiti
	 */
}
