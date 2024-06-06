package com.ajandekeger.raktar.termek;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Termek {

    @Id
    String cikkszam;

    String vonalkod;

    String nev;
    String img;

    Long eladarnetto;

    Long eladarbrutto;

    int db;

    String tipus;

    String szin;

    String meret;

    String image;
    public Termek() {
    }

    public Termek(String cikkszam, String vonalkod, String nev, String img, Long eladarnetto, Long eladarbrutto, int db, String tipus, String szin, String meret, String image) {
        this.cikkszam = cikkszam;
        this.vonalkod = vonalkod;
        this.nev = nev;
        this.img = img;
        this.eladarnetto = eladarnetto;
        this.eladarbrutto = eladarbrutto;
        this.db = db;
        this.tipus = tipus;
        this.szin = szin;
        this.meret = meret;
        this.image = image;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
