/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package piattaforma;

import java.util.*;
import java.util.Map.*;
import java.time.*;


// ----------- << imports@AAAAAAF+h+SsyALPzog= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAF+h+SsyALPzog= >>
// ----------- >>
public class Prenotazione {
	private static int contPrenotazioni=0;
    // ----------- << attribute.annotations@AAAAAAF+h+SsyALaojI= >>
    // ----------- >>
    private LocalDateTime DataOra;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALb16k= >>
    // ----------- >>
    private String CodicePrenotazione;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALcE08= >>
    // ----------- >>
    private String Sport;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALdHSo= >>
    // ----------- >>
    private boolean Spogliatoio;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALe6QE= >>
    // ----------- >>
    private float Prezzo;

    // ----------- << attribute.annotations@AAAAAAF/G//c6YdTHV0= >>
    // ----------- >>
    private String CodiceFiscalePrenotante;

    // ----------- << attribute.annotations@AAAAAAF/HAijB6u3ZZU= >>
    // ----------- >>
    private Struttura NomeStruttura;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALS8Ac= >>
    // ----------- >>
    private Campo CampoAssociato;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALVPUU= >>
    // ----------- >>
    private Spogliatoio SpogliatoioAssociato;
       
    
    /*
     * costrutture della classe con Spogliatoio
     */
    public Prenotazione(LocalDateTime data, String sport, String cf, Struttura struttura, Campo campo, Spogliatoio spogliatoio ) {
		// TODO Auto-generated constructor stub
    	contPrenotazioni++;
    	DataOra=data;
    	Sport=sport;
    	Spogliatoio=true;
    	CodiceFiscalePrenotante=cf;
    	NomeStruttura=struttura;
    	linkCampoAssociato(campo);
    	linkSpogliatoioAssociato(spogliatoio);
    	setCodicePrenotazione();
    	calcolaPrezzo();
	}
    
    /*
     * costrutture della classe senza Spogliatoio
     */
    public Prenotazione(LocalDateTime data, String sport, String cf, Struttura struttura, Campo campo) {
		// TODO Auto-generated constructor stub
    	contPrenotazioni++;
    	DataOra=data;
    	Sport=sport;
    	Spogliatoio=false;
    	CodiceFiscalePrenotante=cf;
    	NomeStruttura=struttura;
    	linkCampoAssociato(campo);
    	setCodicePrenotazione();
    	calcolaPrezzo();
	}
    
    /*
     * serie di get per ottenere gli attributi della classe
     */
    public LocalDateTime getDataOra() {
        return DataOra;
    }

    protected String getCodicePrenotazione() {
       return CodicePrenotazione;
    }

    public String getSport() {
        return Sport;
    }

    public boolean isSpogliatoio() {
        return Spogliatoio;
    }

    public float getPrezzo() {
        return Prezzo;
    }

    public String getCodiceFiscalePrenotante() {
        return CodiceFiscalePrenotante;
    }

    public Struttura getNomeStruttura() {
        return NomeStruttura;
    }

    public Campo getCampoAssociato() {
        return CampoAssociato;
    }

    public Spogliatoio getSpogliatoioAssociato() {
        return SpogliatoioAssociato;
    }

    /*
     * serie di set per settare gli attributi della classe
     */
    public void setDataOra(LocalDateTime DataOra) {
        this.DataOra = DataOra;
    }

    
    protected void setCodicePrenotazione() {
        CodicePrenotazione ="P_"+contPrenotazioni;
    }

    public void setSport(String Sport) {
        this.Sport = Sport;
    }


    public void setCodiceFiscalePrenotante(String CodiceFiscalePrenotante) {
        this.CodiceFiscalePrenotante = CodiceFiscalePrenotante;
    }

    public void setNomeStruttura(Struttura NomeStruttura) {
        this.NomeStruttura = NomeStruttura;
    }

    public void setCampoAssociato(Campo CampoAssociato) {
        this.CampoAssociato = CampoAssociato;
    }

    public void setSpogliatoioAssociato(Spogliatoio SpogliatoioAssociato) {
        this.SpogliatoioAssociato = SpogliatoioAssociato;
    }

    /*
     * metodo per cambiare il campo associato a questa prenotazione e per aggiungere al campo questa prenotazione nella sua lista
     */
    public void linkCampoAssociato(Campo campoAssociato) {
        if (campoAssociato != null) {
            campoAssociato.getListaPrenotazioni().add(this);
        }

        setCampoAssociato(campoAssociato);
    }

    /*
     * metodo per cambiare lo spogliatoio associato a questa prenotazione e per aggiungere allo spogliatoio questa prenotazione nella sua lista
     */
    public void linkSpogliatoioAssociato(Spogliatoio spogliatoioAssociato) {
        if (spogliatoioAssociato != null) {
            spogliatoioAssociato.getListaPrenotazioni().add(this);
        }

        unlinkSpogliatoioAssociato();
        setSpogliatoioAssociato(spogliatoioAssociato);
    }


    /*
     * metodo per togliere lo spogliatoio alla prenotazione e togliere anche allo spogliatoio questa prenotazione dalla sua lista
     */
    public void unlinkSpogliatoioAssociato() {
        if (getSpogliatoioAssociato() != null) {
            getSpogliatoioAssociato().getListaPrenotazioni().remove(this);
            setSpogliatoioAssociato(null);
            Spogliatoio=false;
        }
    }

    // ----------- << method.annotations@AAAAAAF+h+SsyALhZdw= >>
    // ----------- >>
    protected void calcolaPrezzo() {
    // ----------- << method.body@AAAAAAF+h+SsyALhZdw= >>
    	float costoPrenotazione=CampoAssociato.getPrezzo();
    	
    	if(Spogliatoio) {
    		costoPrenotazione+=SpogliatoioAssociato.getPrezzo();
    	}
    	
    	//calcolo di un possibile sconto
    	Map<String,Integer> lista = NomeStruttura.getConteggioPrenotazioni();
    	Iterator<Entry<String,Integer>> it= lista.entrySet().iterator();
    	
    	while(it.hasNext()) {
    		Map.Entry<String,Integer> set= (Map.Entry<String,Integer>) it.next();
    		if(set.getKey().compareTo(CodiceFiscalePrenotante) == 0 && set.getValue()>=5) {
    			costoPrenotazione = costoPrenotazione * (float) 0.8;//sconto 20 %
    			break;
    		}
    	}
    	
    	Prezzo = costoPrenotazione;
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAF+h+SsyALPzog= >>
// ----------- >>
}