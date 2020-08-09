package ru.shumilova.mycleanarchitectureapp.model.repository;

public interface LocalStorage {
    int getStartCount ();
    void writeCount(int count);
}
