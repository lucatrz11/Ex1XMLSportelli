/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsesportelli;

/**
 *
 * 
 * @author trezzi_luca
 */
public class Giorno {

    private String giorno;
    private String oraInizio;
    private String oraFine;

    public Giorno() {
        giorno = "";
        oraInizio = "";
        oraFine = "";
    }

    public Giorno(String giorno, String oraInizio, String oraFine) {
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }

}
