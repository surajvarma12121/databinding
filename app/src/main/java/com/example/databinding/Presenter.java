package com.example.databinding;

import android.content.Context;

public class Presenter implements Contractor.Model.OnFinishedListener, Contractor.Presenter
{
    Contractor.View mainview;
    Contractor.Model model;

    public Presenter(Contractor.View mainview, Contractor.Model model) {
        this.mainview = mainview;
        this.model = model;
    }

    @Override
    public void onFinished(String date, String time) {
        mainview.setData(date,time);
    }
    @Override
    public void onButtonClick(int i,Context context) {
        model.getNextCourse(this,context,i);
    }
}
