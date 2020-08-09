package ru.shumilova.mycleanarchitectureapp.view.main_screen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.shumilova.mycleanarchitectureapp.domain.use_case.RateMeInteractor;
import ru.shumilova.mycleanarchitectureapp.domain.use_case.RateMeInteractorImpl;
import ru.shumilova.mycleanarchitectureapp.model.repository.LocalStorage;
import ru.shumilova.mycleanarchitectureapp.view.App;

public class MainViewModel extends ViewModel {
    private LocalStorage localStorage = App.localStorage;
    private RateMeInteractor rateMeInteractor = new RateMeInteractorImpl();
    private ViewState viewState = new ViewState();
    private MutableLiveData<ViewState> liveData = new MutableLiveData<>(viewState);

    public void initScreen() {
        boolean isShowRating = rateMeInteractor.isShowRating(localStorage.getStartCount());
        viewState.setShowRating(isShowRating);
        liveData.setValue(viewState);
    }

    public LiveData<ViewState> getViewState() {
        return liveData;
    }
}