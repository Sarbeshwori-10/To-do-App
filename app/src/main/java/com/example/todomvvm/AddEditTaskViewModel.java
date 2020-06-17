package com.example.todomvvm;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Repository;
import com.example.todomvvm.models.TaskEntry;

class AddEditTaskViewModel extends AndroidViewModel {

    public LiveData<TaskEntry> getTask() {
        return task;
    }

    private LiveData<TaskEntry> task;


    Repository repository;

    public AddEditTaskViewModel(Application application, int taskId) {
        super(application);
        repository = new Repository(AppDatabase.getInstance(application));

        if(taskId != -1)
            task = repository.getTaskById(taskId);
    }

    public void insertTask(final TaskEntry task){
        repository.insertTask(task);
    }

    public void updateTask (final TaskEntry task){
        repository.updateTask(task);
    }

    public void deleteTask(final TaskEntry task){
        repository.deleteTask(task);
    }
}
