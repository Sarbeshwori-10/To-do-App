package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;

import com.example.todomvvm.models.TaskEntry;

import java.util.List;

public class Repository {

    TaskDao dao;

    public Repository (AppDatabase database){
        dao = database.taskDao();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return dao.loadAllTasks();
    }

    public LiveData<TaskEntry> getTaskById(int taskId){
        return dao.loadTaskById(taskId);
    }

    public void updateTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });
    }

    public void deleteTask (final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteTask(task);
            }
        });
    }

    public void insertTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteTask(task);
            }
        });
    }
}
