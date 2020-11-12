package com.example.storage_link.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.storage_link.entities.Beverage;

import java.util.List;

@Dao
public interface BeverageDao {

    @Insert
    void insertBeverage(Beverage beverage);

    @Update
    void updateBeverage(Beverage beverage);

    @Delete
    void deleteBeverage(Beverage beverage);

    @Query("Select * from beverage")
    List<Beverage> getAllBeverage();



}
