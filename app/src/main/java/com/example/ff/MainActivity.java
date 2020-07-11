package com.example.ff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView number;
    Button addOne;
    CounterViewModel counterViewModel;
    private final Observer<Integer> countObserver = new Observer<Integer>() {


        @Override
        public void onChanged(Integer integer) {
            setNumber(integer);

        }
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
            counterViewModel.getCount().observe(this,countObserver);
            number = findViewById(R.id.number);
        addOne = findViewById(R.id.button);

      //  setNumber(counterViewModel.getCount());
        addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterViewModel.setCount(counterViewModel.getCount().getValue()+1);
               // setNumber(counterViewModel.getCount());
            }
        });
    }

    private void setNumber(int value){
        number.setText(String.valueOf(value));
    }
}

