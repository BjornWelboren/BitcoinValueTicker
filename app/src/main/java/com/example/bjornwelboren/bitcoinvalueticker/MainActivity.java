package com.example.bjornwelboren.bitcoinvalueticker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the API Client with the corresponding API methods/functions
        apiInterface = APIClient.getClient().create(APIInterface.class);


        final Currency currency = new Currency();
        currency.setValue(1);
        currency.setCurrency("USD");


        TextView txtValueUSD = findViewById(R.id.viewUSD);
        TextView txtValueEUR = findViewById(R.id.viewEUR);
        TextView txtValueGBP = findViewById(R.id.viewGBP);


        // Get one article from the API though the internet.
        Call<Currency> call = apiInterface.getCurrency("USD");
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Currency currency = response.body();
                if (null != currency) {
                    txtValueUSD.setText(String.valueOf(currency));
                } else {
                    Log.e(TAG, "Got no article, because:" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
    }


}

//    /**
//     * To ensure text views are emptied before we fresh texts in
//     */
//    private void emptyArticleTextViews(){
//        txtValueUSD.setText("");
//        tvAuthor.setText("");
//        tvArticleText.setText("");
//    }
//    /**
//     * Show article data
//     *
//     * @param articleFromAPI
//     */
//    private void showArticleInTextViews(Article articleFromAPI) {
//
//        tvName.setText(articleFromAPI.getName());
//        tvAuthor.setText(articleFromAPI.getAuthor());
//        tvArticleText.setText(articleFromAPI.getText());
//
//    }








