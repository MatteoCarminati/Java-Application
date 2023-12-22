/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package piattaforma;

import java.util.*;
import java.util.Map.Entry;
import java.time.*;



// ----------- << imports@AAAAAAF+h+SsyALiE3I= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAF+h+SsyALiE3I= >>
// ----------- >>
public class Struttura {
	private static int contaStruttura=0;
    // ----------- << attribute.annotations@AAAAAAF+h+SsyALmvyA= >>
    // ----------- >>
    private String Nome;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALnspQ= >>
    // ----------- >>
    private String Indirizzo;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALo/5s= >>
    // ----------- >>
    private String Citta;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALp7xQ= >>
    // ----------- >>
    private String IDstruttura;

    // ----------- << attribute.annotations@AAAAAAF/G/HPwGbFGOw= >>
    // ----------- >>
    private HashMap<String, Integer> ConteggioPrenotazioni;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALlXF8= >>
    // ----------- >>
    private Set<Cliente> ListaClientiBan;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyALvLyc= >>
    // ----------- >>
    private Set<Campo> ListaCampi;

    // ----------- << attribute.annotations@AAAAAAF+h+SsyAL4npc= >>
    // ----------- >>
    private Set<Spogliatoio> ListaSpogliatoi;
    

    
    /*
     * costruttore della classe Struttura
     */
    
    public Struttura(String nome, String indirizzo, String citta) {
		// TODO Auto-generated constructor stub
    	contaStruttura++;
    	Nome=nome;
    	Indirizzo=indirizzo;
    	Citta=citta;
    	ListaClientiBan= new HashSet<>();
    	ListaCampi= new HashSet<>();
    	ListaSpogliatoi= new HashSet<>();
    	ConteggioPrenotazioni= new HashMap<>();
    	setIDstruttura();
	}
    
    /*
     * serie dei metodi per ottenere gli attributi della classe
     */
    public String getNome() {
        return Nome;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public String getCitta() {
        return Citta;
    }

    protected String getIDstruttura() {
        return IDstruttura;
    }

    protected HashMap<String, Integer> getConteggioPrenotazioni() {
        return ConteggioPrenotazioni;
    }

    public Set<Cliente> getListaClientiBan() {
        return ListaClientiBan;
    }

    public Set<Campo> getListaCampi() {
        return ListaCampi;
    }

    public Set<Spogliatoio> getListaSpogliatoi() {
        return ListaSpogliatoi;
    }

    /*
     * serie di metodi per settare gli attributi della classe
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setIndirizzo(String Indirizzo) {
        this.Indirizzo = Indirizzo;
    }

    public void setCitta(String Citta) {
        this.Citta = Citta;
    }

    private void setIDstruttura() {
    	IDstruttura="Struttura_"+contaStruttura;
    }

    /*
     * aggiunge un nuovo cliente alla ListaBan
     */
    public void linkListaClientiBan(Cliente cliente) throws Exception {
        if (cliente != null) {
        	for(Cliente c: ListaClientiBan)
        	{
        		if(c.getCodiceFiscale().compareTo(cliente.CodiceFiscale)==0)
        			throw new Exception("ban gi� inserito");
        	}
        		
            getListaClientiBan().add(cliente);
        }
    }

    /*
     * aggiunge un campo alla struttura e setta al campo il parametro StrutturaProprietaria
     */
    public void linkListaCampi(Campo campo) {
        if (campo != null) {
        	campo.setStrutturaProprietaria(this);
            getListaCampi().add(campo);
        }
    }

    /*
     * aggiunge uno spogliatoio alla struttura e setta allo spogliatoio il parametro StrutturaProprietaria
     */
    public void linkListaSpogliatoi(Spogliatoio spogliatoio) {
        if (spogliatoio != null) {
        	spogliatoio.setStrutturaProprietaria(this);
            getListaSpogliatoi().add(spogliatoio);
        }
    }

    /*
     * rimuove un cliente dalla ListaBan
     */
    public void unlinkListaClientiBan(Cliente cliente) {
        if (cliente != null) {
            getListaClientiBan().remove(cliente);
        }
    }

    /*
     * rimuove un campo dalla lista della struttura e setta l'attributo StrutturaProrpietaria di campo = null
     */
    public void unlinkListaCampi(Campo campo) {
        if (campo != null) {
        	campo.setStrutturaProprietaria(null);
            getListaCampi().remove(campo);
        }
    }

    /*
     * rimuove uno spogliatoio dalla lista della struttura e setta l'attributo StrutturaProrpietaria di spogliatoio = null
     */
    public void unlinkListaSpogliatoi(Spogliatoio spogliatoio) {
        if (spogliatoio != null) {
        	spogliatoio.setStrutturaProprietaria(null);
            getListaSpogliatoi().remove(spogliatoio);
        }
    }
  
    // ----------- << method.annotations@AAAAAAF/AeFs0EnWX1E= >>
    /**
     * il metodo stampa le prenotazioni associate ad un campo della struttura
     * @param campo � il campo associato alla struttura di cui voglio consultare le prenotazioni
     * @return restituisce la lista di prenotazioni del campo
     */
    // ----------- >>
    public Set<Prenotazione> stampaPrenotazioni(Campo campo) {
   // ----------- << method.body@AAAAAAF/AeFs0EnWX1E= >>
    	return campo.getListaPrenotazioni();
    // ----------- >>
    }
    
    /**
     * il metodo stampa le prenotazioni associate ad uno spogliatoio della struttura
     * @param spogliatoio � lo spogliatoio associato alla struttura di cui voglio consultare le prenotazioni
     * @return restituisce la lista di prenotazioni dello spogliatoio
     */
    public Set<Prenotazione> stampaPrenotazioni(Spogliatoio spogliatoio) {
    	return spogliatoio.getListaPrenotazioni();
    }
    
    // ----------- << method.annotations@AAAAAAF/Aept5Ez0NzU= >>
    /**
     * restituisce il risultato del controllo del ban di un cliente 
     * @param cf � il codice fiscale da controllare
     * @return restituisce il risultato del controllo
     */
    // ----------- >>
    protected boolean controllaBan(String cf) {
    // ----------- << method.body@AAAAAAF/Aept5Ez0NzU= >>
    	for(Cliente c : ListaClientiBan) {
    		if(c.getCodiceFiscale().compareTo(cf) == 0) {
    			return true;
    		}
    	}
    	return false;
    // ----------- >>
    }
    
    // ----------- << method.annotations@AAAAAAF/G/L4AWjwnek= >>
    /**
     * aggiorna la lista ConteggioPrenotazione 
     * @param cf � il codice fiscale del cliente che prenota
     */
    // ----------- >>
    protected void aggiornaConteggioPrenotazioni(String cf) {
    // ----------- << method.body@AAAAAAF/G/L4AWjwnek= >>
    	Iterator<Entry<String,Integer>> it= ConteggioPrenotazioni.entrySet().iterator();
    	
    	while(it.hasNext()) {
    		Map.Entry<String,Integer> set= (Map.Entry<String,Integer>) it.next();
    		if(set.getKey().compareTo(cf) == 0) {
    			int n=set.getValue(); //salva il numero di prenotazioni fatte dal cliente fino ad ora
    			ConteggioPrenotazioni.remove(cf);
    			ConteggioPrenotazioni.put(cf, (n+1));
    			return;
    		}
    	}
    	ConteggioPrenotazioni.put(cf, 1);//aggiunge un nuovo elemento e lo inizializza a 1
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAF+h+SsyALiE3I= >>
// ----------- >>
}