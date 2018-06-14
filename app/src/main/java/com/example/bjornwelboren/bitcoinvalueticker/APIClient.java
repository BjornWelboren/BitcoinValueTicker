package com.example.bjornwelboren.bitcoinvalueticker;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class APIClient {

    private static Retrofit retrofit = null;

    /**
 * @return Retrofit.Builder
 */

public static Retrofit getClient() {

    Currency currency = new Currency();

    long value = currency.getValue();
    String cr = currency.getCurrency();


    //Maak logging interceptor
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    //Http client
    OkHttpClient.Builder builder = new OkHttpClient.Builder();


    //Logging interceptor naar client, dit logt alles van de http client
    OkHttpClient client = builder
            .addInterceptor(interceptor)
            .build();


    retrofit = new Retrofit.Builder()
            .baseUrl("https://blockchain.info/tobtc?currency="+cr+"&value="+value)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    //geeft waarde terug
    return retrofit;

    }

}
