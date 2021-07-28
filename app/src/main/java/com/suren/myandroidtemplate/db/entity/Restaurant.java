package com.suren.myandroidtemplate.db.entity;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;

@Entity(indices = {@Index("id")},
        primaryKeys = {"id"})
public class Restaurant {
    private int id;
    private String uid;
    private String strain;
    private String cannabinoid_abbreviation;
    private String cannabinoid;
    private String terpene;
    private String medical_use;
    private String health_benefit;
    private String category;
    private String type;
    private String buzzword;
    private String brand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getCannabinoid_abbreviation() {
        return cannabinoid_abbreviation;
    }

    public void setCannabinoid_abbreviation(String cannabinoid_abbreviation) {
        this.cannabinoid_abbreviation = cannabinoid_abbreviation;
    }

    public String getCannabinoid() {
        return cannabinoid;
    }

    public void setCannabinoid(String cannabinoid) {
        this.cannabinoid = cannabinoid;
    }

    public String getTerpene() {
        return terpene;
    }

    public void setTerpene(String terpene) {
        this.terpene = terpene;
    }

    public String getMedical_use() {
        return medical_use;
    }

    public void setMedical_use(String medical_use) {
        this.medical_use = medical_use;
    }

    public String getHealth_benefit() {
        return health_benefit;
    }

    public void setHealth_benefit(String health_benefit) {
        this.health_benefit = health_benefit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBuzzword() {
        return buzzword;
    }

    public void setBuzzword(String buzzword) {
        this.buzzword = buzzword;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
