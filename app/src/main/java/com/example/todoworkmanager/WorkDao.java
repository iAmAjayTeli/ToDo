package com.example.todoworkmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WorkDao {


    @Insert
    public void addWork(WorkModel workModel);

    @Delete
    public void deleteWork(WorkModel workModel);

    @Update
    public void updateWork(WorkModel workModel);

    @Query("SELECT * FROM ToDo_table")
    public LiveData<List<WorkModel>> getAllWorks();
}
