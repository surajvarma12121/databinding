package com.example.databinding;

import android.content.Context;

public interface Contractor {
    public interface Model{
        interface OnFinishedListener{
            void onFinished(String date,String time);
        }
        void getNextCourse(OnFinishedListener onFinishedListener, Context context, int i);

    }
    public interface View{
        void setData(String date,String time);
    }
    public interface Presenter{
        void onButtonClick(int i,Context context);
    }
}
