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
    private int is_Offer;
    private String serCat;
    private String serDiscribtion;
    private int is_favorite;

    public Services(int serPic, String sertitle, String serPrice, String serCat,int is_Offer,int is_favorite, String serDiscribtion) {
        this.serPic = serPic;
        this.sertitle = sertitle;
        this.serPrice = serPrice;
        this.serCat = serCat;
        this.serDiscribtion = serDiscribtion;
        this.is_Offer=is_Offer;
        this.is_favorite=is_favorite;
    }

    public int getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(int is_favorite) {
        this.is_favorite = is_favorite;
    }

    public int getIs_Offer() {
        return is_Offer;
    }

    public void setIs_Offer(int is_Offer) {
        this.is_Offer = is_Offer;
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
