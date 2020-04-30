package com.example.movid_19.fragment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class respon {

    @SerializedName("attributes")
    private List<ListBerita> attribut;

    public List<ListBerita> getAttribut() {
        return attribut;
    }

    public void setAttribut(List<ListBerita> attribut) {
        this.attribut = attribut;
    }

    @Override
    public String toString() {
        return "respon{" +
                "attribut=" + attribut +
                '}';
    }
}
