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

import org.w3c.dom.Text;

public class AnnouncementFragment extends Fragment {

    private DBHandler dbHandler;

    private TextView aTitle;
    private TextView aContent;
    private TextView aDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_announcement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        aTitle = view.findViewById(R.id.annTitle);
        aContent = view.findViewById(R.id.annContent);
        aDate = view.findViewById(R.id.annDate);

        dbHandler = new DBHandler(getActivity());

        Announcement a = dbHandler.getAnnouncement(0, 0);

        if (a != null){
            aTitle.setText(a.getTitle());
            aContent.setText(a.getContent());
            aDate.setText(a.getDatetime());
        }
        else
        {
            aTitle.setText(R.string.notice);
            aContent.setText(R.string.content);
            aDate.setText("2022-11-24");
        }
    }
}
