package com.hmtzn.myanmarcurrencyexchangerates.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Rates")
public class ExchangeRateModel {
    @PrimaryKey
    @NonNull
    String exchangeRateId;

    @NonNull
    public String getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(@NonNull String exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }
}
