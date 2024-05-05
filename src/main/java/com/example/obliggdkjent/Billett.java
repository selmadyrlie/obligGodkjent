package com.example.obliggdkjent;

public class Billett {

    private String filmvalg;
    private int antall;
    private String fornavn;
    private String etternavn;
    private String tlf;
    private String epost;

    public Billett(){}

    public Billett(String filmvalg, int antall, String fornavn, String etternavn, String tlf, String epost) {
        this.filmvalg = filmvalg;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.tlf = tlf;
        this.epost = epost;
    }

    public String getFilmvalg() {
        return filmvalg;
    }

    public void setFilmvalg(String filmvalg) {
        this.filmvalg = filmvalg;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}
