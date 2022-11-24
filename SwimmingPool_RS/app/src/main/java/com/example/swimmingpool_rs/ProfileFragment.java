package com.example.swimmingpool_rs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class ProfileFragment extends Fragment {
    private DBHandler dbHandler;
    private Profile profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.Nav_Username);
        String name = navUsername.toString();

        TextView pUsername = view.findViewById(R.id.et_username);
        TextView pFname = view.findViewById(R.id.et_fullname);
        TextView pDob = view.findViewById(R.id.et_dob);
        TextView pGender = view.findViewById(R.id.et_gender);
        TextView pEmail = view.findViewById(R.id.et_email);
        TextView pContact = view.findViewById(R.id.et_contact);

        dbHandler = new DBHandler(getActivity());

        if(name != null)
        {
            profile = dbHandler.getUserDetails(name);

            if(profile != null)
            {
                pUsername.setText(profile.getUsername());
                pFname.setText(profile.getUser_fullname());
                pDob.setText(profile.getUser_dob());
                pGender.setText(profile.getUser_gender());
                pEmail.setText(profile.getUser_email());
                pContact.setText(profile.getUser_contact());
            }
        }

        ImageButton editProfile = view.findViewById(R.id.editProfile);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), EditActivity.class);
                startActivity(in);
            }
        });
    }
}
