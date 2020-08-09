package ru.shumilova.mycleanarchitectureapp.domain.use_case;

public class RateMeInteractorImpl implements RateMeInteractor {
    @Override
    public boolean isShowRating(int count) {
        return count == 2 || count % 4 == 0;
    }
}
