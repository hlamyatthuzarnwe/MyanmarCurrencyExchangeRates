package com.hmtzn.myanmarcurrencyexchangerates.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.hmtzn.myanmarcurrencyexchangerates.model.ExchangeRateModel;

@Dao
public interface ExchangeRatesDAO {

   @Insert
    void addCurrencyExchangeRates(ExchangeRateModel... exchangeRatesModels);

}
