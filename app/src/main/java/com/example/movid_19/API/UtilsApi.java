package com.example.movid_19.API;

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "https://api.kawalcorona.com";

    // Mendeklarasikan Interface BaseApiService
    public static BaseAPiSpinner getAPISpiner(){
        return RetrofitSpinner.getRetrofit(BASE_URL_API).create(BaseAPiSpinner.class);
    }
}
