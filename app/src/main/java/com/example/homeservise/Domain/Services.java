package com.example.homeservise.Domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "services_table")
public class Services {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int serPic;
    private String sertitle;
    private String serPrice;

//    private int catId;
    private String serCat;
    private String serDiscribtion;

    public Services(int serPic, String sertitle, String serPrice, String serCat, String serDiscribtion) {
        this.serPic = serPic;
        this.sertitle = sertitle;
        this.serPrice = serPrice;
        this.serCat = serCat;
        this.serDiscribtion = serDiscribtion;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getSerPic() {
        return serPic;
    }

    public void setSerPic(int serPic) {
        this.serPic = serPic;
    }

    public String getSertitle() {
        return sertitle;
    }

    public void setSertitle(String sertitle) {
        this.sertitle = sertitle;
    }

    public String getSerPrice() {
        return serPrice;
    }

    public void setSerPrice(String serPrice) {
        this.serPrice = serPrice;
    }

    public String getSerCat() {
        return serCat;
    }

    public void setSerCat(String serCat) {
        this.serCat = serCat;
    }

    public String getSerDiscribtion() {
        return serDiscribtion;
    }

    public void setSerDiscribtion(String serDiscribtion) {
        this.serDiscribtion = serDiscribtion;
    }
}
