package com.example.swimmingpool_rs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditAnnouncementFragment extends Fragment {

    private DBHandler dbHandler;
    private EditText aTitle;
    private EditText aContent;
    private Button btnAddAnn;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String aDate;
    private TextView showDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editann, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        aTitle = view.findViewById(R.id.annTitle);
        aContent = view.findViewById(R.id.annContent);
        btnAddAnn = view.findViewById(R.id.btnAddAnn);
        showDate = view.findViewById(R.id.dateShow);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
        aDate = dateFormat.format(calendar.getTime());
        showDate.setText(aDate);

        dbHandler = new DBHandler(getActivity());

        btnAddAnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get input data from user
                String titleTxt = aTitle.getText().toString();
                String contentTxt = aContent.getText().toString();

                dbHandler.addAnnouncement(titleTxt, contentTxt);
                Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();

                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new EditAnnouncementFragment());
                fragmentTransaction.commit();
            }
        });
    }
}
