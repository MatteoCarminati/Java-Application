package piattaforma;

import static org.junit.Assert.*;

import org.junit.Test;

public class CampoTennisTest {

	Struttura s =new Struttura("CSS","via Asiago","Stezzano");
	CampoTennis campo= new CampoTennis((float)100,s,"terra");

	@Test
	public void testGetTipoTerreno() {
		assertEquals(campo.getTipoTerreno(),"terra");
	}

}
