package com.example.bjornwelboren.bitcoinvalueticker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//created
//by
//your mom

public interface APIInterface {

    @GET("currency={currency}&value={value}")

    //getters
    Call<Currency> getCurrency(@Path("currency") String currency);
    Call<Currency> getValue(@Path("value") long value);



}
