package com.example.ff;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<Integer> count = new MutableLiveData<>();


    public void setCount(int count) {
        this.count.setValue(count);
    }

    public  MutableLiveData<Integer> getCount() {
        return count;
    }
}

