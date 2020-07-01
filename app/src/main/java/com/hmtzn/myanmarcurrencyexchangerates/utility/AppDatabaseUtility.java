package com.hmtzn.myanmarcurrencyexchangerates.utility;

import android.content.Context;

import androidx.room.Room;

import com.hmtzn.myanmarcurrencyexchangerates.helper.AppDatabase;

public class AppDatabaseUtility {

    public static AppDatabase getAppDatabase(Context context){

        AppDatabase appDatabase =Room.databaseBuilder(context,AppDatabase.class,"db_myancer")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        return appDatabase;
    }
}
