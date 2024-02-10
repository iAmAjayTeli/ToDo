package com.example.todoworkmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WorkModel.class}, version = 1)
public abstract class WorkDatabase extends RoomDatabase {

    private static WorkDatabase instace;
    public abstract WorkDao getworkDao();



    public static synchronized WorkDatabase getInstace(Context context){
              if(instace==null){
                  instace=Room.databaseBuilder(context, WorkDatabase.class, "Work_db").
                          fallbackToDestructiveMigration()
                          .build();
              }

              return  instace;
    }
}
