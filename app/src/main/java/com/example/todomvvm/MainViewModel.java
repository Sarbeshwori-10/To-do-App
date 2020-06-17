package com.example.todomvvm;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Repository;
import com.example.todomvvm.models.TaskEntry;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final static String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    Repository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        Log.d(TAG, "Actively retrieving tasks from database.");
        repository = new Repository(AppDatabase.getInstance(application));
        tasks = repository.getTasks();

    }

    public LiveData<List<TaskEntry>> getTasks(){

        return tasks;
    }

    public void deleteTask(final TaskEntry task){
       repository.deleteTask(task);

    }

    public void insertTask(final TaskEntry task){

        repository.insertTask(task);
    }

    public void updateTask(final TaskEntry task){

        repository.updateTask(task);
    }
}
