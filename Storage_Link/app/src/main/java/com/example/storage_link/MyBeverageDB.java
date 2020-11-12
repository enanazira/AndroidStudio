package com.example.storage_link;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.storage_link.dao.BeverageDao;
import com.example.storage_link.entities.Beverage;


@Database(entities = {Beverage.class},version = 1)
public  abstract class MyBeverageDB extends RoomDatabase {

    public  abstract BeverageDao beverageDao();



}
