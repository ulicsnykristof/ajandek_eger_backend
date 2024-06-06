package com.ajandekeger.raktar.image;

import com.ajandekeger.raktar.termek.Termek;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Image {

    @Id
    int imgid;

    String img;

    String cikkszam;

    public Image() {
    }

    public Image(String img, String cikkszam) {
        this.img = img;
        this.cikkszam = cikkszam;
    }

    public Image(int imgid, String img, String cikkszam) {
        this.imgid = imgid;
        this.img = img;
        this.cikkszam = cikkszam;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
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

    public void setCikkszam(String cikkszam) {
        this.cikkszam = cikkszam;
    }
}
