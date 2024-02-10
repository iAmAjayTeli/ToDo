package com.example.todoworkmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ToDo_table")
public class WorkModel {

    @ColumnInfo(name = "Id")
     @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "Work_title")
    String Title;

    @ColumnInfo(name = "Work_Description")
    String Discription;

    public WorkModel(String title, String discription) {
        Title = title;
        Discription = discription;
    }

    public WorkModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }
}
