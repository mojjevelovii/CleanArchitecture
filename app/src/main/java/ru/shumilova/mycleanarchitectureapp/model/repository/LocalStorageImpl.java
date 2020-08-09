package ru.shumilova.mycleanarchitectureapp.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorageImpl implements LocalStorage {
    private final static String FILE_NAME = "RATING_COUNTER";
    private final static String COUNTER = "LAUNCH_COUNTER";
    private SharedPreferences sharedPreferences;

    public LocalStorageImpl(Context context) {
        this.sharedPreferences = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
    }

    @Override
    public int getStartCount() {
        return sharedPreferences.getInt(COUNTER, 0);
    }

    @Override
    public void writeCount(int count) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER, count).apply();
    }
}
