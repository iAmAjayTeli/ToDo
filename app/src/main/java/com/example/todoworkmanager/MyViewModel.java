package com.example.todoworkmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<WorkModel>> notelist;

    private LiveData<List<WorkModel>> allNotes;

    public MyViewModel(@NonNull Application application) {
        super(application);
      repository=new Repository(application);
    }

    public void addNewNotes(WorkModel workModel){
        repository.addWork(workModel);
    }

    public void deleteNewNotes(WorkModel workModel){
        repository.deleteWork(workModel);
    }



    public void updateNewNodes(WorkModel workModel){
        repository.updateWork(workModel);
    }

    public LiveData<List<WorkModel>> getAllNotes(){
        allNotes=repository.getAllWorks();
        return allNotes;
    }


    // Assuming you have retrieved an existing note with ID from your database



}
