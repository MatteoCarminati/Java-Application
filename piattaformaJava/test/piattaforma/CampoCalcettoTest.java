package piattaforma;

import static org.junit.Assert.*;

import org.junit.Test;

public class CampoCalcettoTest {

	Struttura s =new Struttura("CSS","via Asiago","Stezzano");
	CampoCalcetto campo= new CampoCalcetto((float)100,s,"sintetico",false);
	
	@Test
	public void testGetTipoTerreno() {
		assertEquals(campo.getTipoTerreno(), "sintetico");
	}

	@Test
	public void testIsCampoCoperto() {
		assertFalse(campo.isCampoCoperto());
	}

}
