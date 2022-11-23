package com.example.swimmingpool_rs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    DatePicker datePicker;
    Button btnConfirm;
    TextView dateShow;
    Button btnSlot1, btnSlot2, btnSlot3, btnSlot4, btnSlot5, btnSlot6;
    Button btnProceed;
    TextView timeShow;
    Spinner ddPool;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dateShow = view.findViewById(R.id.dateShow);
        datePicker = view.findViewById(R.id.bookDatePicker);
        btnConfirm = view.findViewById(R.id.btnConfirm);
        btnSlot1 = view.findViewById(R.id.btnSlot1);
        btnSlot2 = view.findViewById(R.id.btnSlot2);
        btnSlot3 = view.findViewById(R.id.btnSlot3);
        btnSlot4 = view.findViewById(R.id.btnSlot4);
        btnSlot5 = view.findViewById(R.id.btnSlot5);
        btnSlot6 = view.findViewById(R.id.btnSlot6);
        timeShow = view.findViewById(R.id.timeShow);
        btnProceed = view.findViewById(R.id.btnProceed);
        ddPool = view.findViewById(R.id.ddPool);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateShow.setText("Date: " + datePicker.getDayOfMonth() +"/"+ (datePicker.getMonth() + 1) + "/" + datePicker.getYear());
            }
        });

        btnSlot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("Time Slot: " + btnSlot1.getText());
            }
        });

        btnSlot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("Time Slot: " + btnSlot2.getText());
            }
        });

        btnSlot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("Time Slot: " + btnSlot3.getText());
            }
        });

        btnSlot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("Time Slot: " + btnSlot4.getText());
            }
        });

        btnSlot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("Time Slot: " + btnSlot5.getText());
            }
        });

        btnSlot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeShow.setText("Time Slot: " + btnSlot6.getText());
            }
        });


    }
}
