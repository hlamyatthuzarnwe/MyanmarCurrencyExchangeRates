package com.hmtzn.myanmarcurrencyexchangerates.helper;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hmtzn.myanmarcurrencyexchangerates.dao.ExchangeRatesDAO;
import com.hmtzn.myanmarcurrencyexchangerates.model.ExchangeRateModel;

@Database(entities = {ExchangeRateModel.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ExchangeRatesDAO getExchangeRatesDAO();


}
