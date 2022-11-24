package com.example.swimmingpool_rs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookSummaryFragment extends Fragment {
    private DBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booksummary, container, false);
    }

    DatePicker datePicker;
    Button btnConfirm;
    TextView dateShow;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateShow.setText("Date: " + datePicker.getDayOfMonth() +"/"+ (datePicker.getMonth() + 1) + "/" + datePicker.getYear());
            }
        });

//        btnSlot1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timeShow.setText("Time Slot: " + btnSlot1.getText());
//            }
//        });
//
//        btnSlot2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timeShow.setText("Time Slot: " + btnSlot2.getText());
//            }
//        });
//
//        btnSlot3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timeShow.setText("Time Slot: " + btnSlot3.getText());
//            }
//        });
//
//        btnSlot4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timeShow.setText("Time Slot: " + btnSlot4.getText());
//            }
//        });
//
//        btnSlot5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timeShow.setText("Time Slot: " + btnSlot5.getText());
//            }
//        });
//
//        btnSlot6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                timeShow.setText("Time Slot: " + btnSlot6.getText());
//            }
//        });
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch(checkedId){
//                    case R.id.poolT1:
//                        poolShow.setText("Pool Type: " + pool1.getText());
//                        break;
//                    case R.id.poolT2:
//                        poolShow.setText("Pool Type: " + pool2.getText());
//                        break;
//                    case R.id.poolT3:
//                        poolShow.setText("Pool Type: " + pool3.getText());
//                        break;
//                }
//            }
//        });
//
//        paxNum.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker numberPicker, int i, int g) {
//                int valuePick = paxNum.getValue();
//                paxShow.setText("Pax No.: " + valuePick);
//            }
//        });
    }
}
