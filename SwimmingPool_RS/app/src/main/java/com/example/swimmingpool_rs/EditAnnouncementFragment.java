package com.example.swimmingpool_rs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditAnnouncementFragment extends Fragment {

    private DBHandler dbHandler;
    private EditText aTitle;
    private EditText aContent;
    private EditText aDate;
    private Button btnAddAnn;

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
        aDate = view.findViewById(R.id.annDate);
        btnAddAnn = view.findViewById(R.id.btnAddAnn);

        btnAddAnn.setOnClickListener(views->{
            on_btn_clicked();
        });
    }

    public void on_btn_clicked(){
        dbHandler.addAnnouncement(aTitle.getText().toString(), aContent.getText().toString());
    }
}
