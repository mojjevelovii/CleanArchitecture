package ru.shumilova.mycleanarchitectureapp.view;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import ru.shumilova.mycleanarchitectureapp.model.repository.LocalStorage;
import ru.shumilova.mycleanarchitectureapp.model.repository.LocalStorageImpl;

public class App extends Application {
    public static Context appContext;
    public static LocalStorage localStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        localStorage = new LocalStorageImpl(getApplicationContext());
        increaseCounter();
    }

    private void increaseCounter() {
        int count = localStorage.getStartCount();
        count++;
        localStorage.writeCount(count);
    }
}
