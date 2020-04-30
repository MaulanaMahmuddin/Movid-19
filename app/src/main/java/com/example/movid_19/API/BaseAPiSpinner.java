package com.example.movid_19.API;

import com.example.movid_19.fragment.ListBerita;
import com.example.movid_19.fragment.listatt;
import com.example.movid_19.fragment.respon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseAPiSpinner {
    @GET("/indonesia/provinsi")
    Call<respon> getSemuaBerita();
}
