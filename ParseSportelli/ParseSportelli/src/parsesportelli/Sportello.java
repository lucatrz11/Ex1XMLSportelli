/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsesportelli;

/**
 *
 * @author trezzi_luca
 */
public class Sportello {

    private String materia;
    private String docente;
    private String email;
    private Giorno giorno1;
    private Giorno giorno2;

    public Sportello() {
        this.materia = "";
        this.docente = "";
        this.email = "";
        this.giorno1 = new Giorno();
        this.giorno2 = new Giorno();
    }

    public Sportello(String materia, String docente, String email, Giorno giorno1, Giorno giorno2) {
        this.materia = materia;
        this.docente = docente;
        this.email = email;
        this.giorno1 = giorno1;
        this.giorno2 = giorno2;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Giorno getGiorno1() {
        return giorno1;
    }

    public void setGiorno1(Giorno giorno1) {
        this.giorno1 = giorno1;
    }

    public Giorno getGiorno2() {
        return giorno2;
    }

    public void setGiorno2(Giorno giorno2) {
        this.giorno2 = giorno2;
    }

    public String toString() {
        return materia + ";" + docente + ";" + email + ";" + giorno1 + ";" + giorno2;
    }

}
