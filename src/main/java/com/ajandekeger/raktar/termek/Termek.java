package com.ajandekeger.raktar.termek;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Termek {

    @Id
    int id;
    String cikkszam;

    String vonalkod;

    String nev;

    Long eladarnetto;

    Long eladarbrutto;

    int db;

    int fogyas;
    String tipus;

    String szin;

    String meret;

    public Termek() {
    }

    public Termek(String cikkszam, String vonalkod, String nev,Long eladarnetto, Long eladarbrutto, int db, int fogyas, String tipus, String szin, String meret) {
        this.cikkszam = cikkszam;
        this.vonalkod = vonalkod;
        this.nev = nev;
        this.eladarnetto = eladarnetto;
        this.eladarbrutto = eladarbrutto;
        this.db = db;
        this.fogyas = fogyas;
        this.tipus = tipus;
        this.szin = szin;
        this.meret = meret;
    }

    public int getId() {
        return id;
    }

    public int getFogyas() {
        return fogyas;
    }

    public void setFogyas(int fogyas) {
        this.fogyas = fogyas;
    }

    public String getCikkszam() {
        return cikkszam;
    }

    public String getVonalkod() {
        return vonalkod;
    }

    public String getNev() {
        return nev;
    }

    public Long getEladarnetto() {
        return eladarnetto;
    }

    public Long getEladarbrutto() {
        return eladarbrutto;
    }

    public int getDb() {
        return db;
    }

    public String getTipus() {
        return tipus;
    }

    public String getSzin() {
        return szin;
    }

    public String getMeret() {
        return meret;
    }

    public void setCikkszam(String cikkszam) {
        this.cikkszam = cikkszam;
    }

    public void setVonalkod(String vonalkod) {
        this.vonalkod = vonalkod;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setEladarnetto(Long eladarnetto) {
        this.eladarnetto = eladarnetto;
    }

    public void setEladarbrutto(Long eladarbrutto) {
        this.eladarbrutto = eladarbrutto;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public void setMeret(String meret) {
        this.meret = meret;
    }
}
