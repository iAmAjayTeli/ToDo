package com.example.todoworkmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository extends AndroidViewModel {

    private final WorkDao workDao;
    private ExecutorService executor;
    private Handler handler;

    public Repository(@NonNull Application application) {
        super(application);
        WorkDatabase workDatabase = WorkDatabase.getInstace(application);
        this.workDao = workDatabase.getworkDao();
        this.executor = Executors.newSingleThreadExecutor();
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void addWork(WorkModel workModel) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                workDao.addWork(workModel);
            }
        });
    }

    public void deleteWork(WorkModel workModel) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                workDao.deleteWork(workModel);
            }
        });
    }

    public void updateWork(WorkModel workModel) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                    workDao.updateWork(workModel);
            }
        });
    }

    public LiveData<List<WorkModel>> getAllWorks() {
        return workDao.getAllWorks();
    }


}
