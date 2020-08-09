package ru.shumilova.mycleanarchitectureapp;

import org.junit.Assert;
import org.junit.Test;

import ru.shumilova.mycleanarchitectureapp.domain.use_case.RateMeInteractor;
import ru.shumilova.mycleanarchitectureapp.domain.use_case.RateMeInteractorImpl;

public class RateMeInteractorTest {
    @Test
    public void isRatingTest(){
        RateMeInteractor rateMeInteractor = new RateMeInteractorImpl();
        Assert.assertFalse("Счетчик =  0", rateMeInteractor.isShowRating(0));
        Assert.assertFalse("Счетчик =  3", rateMeInteractor.isShowRating(3));
        Assert.assertFalse("Счетчик =  55", rateMeInteractor.isShowRating(55));

        Assert.assertTrue("Счетчик =  2", rateMeInteractor.isShowRating(2));
        Assert.assertTrue("Счетчик =  4", rateMeInteractor.isShowRating(4));
        Assert.assertTrue("Счетчик =  8", rateMeInteractor.isShowRating(8));
        Assert.assertTrue("Счетчик =  20", rateMeInteractor.isShowRating(20));
    }
}
