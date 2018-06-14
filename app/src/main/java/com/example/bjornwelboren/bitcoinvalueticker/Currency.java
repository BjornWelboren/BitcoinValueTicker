package com.example.bjornwelboren.bitcoinvalueticker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    public int currencies; // Commit count.

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("value")
    @Expose
    private long value;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }


}
