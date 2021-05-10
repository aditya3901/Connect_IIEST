package com.example.connectiiest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.connectiiest.databinding.ActivityUserProfileBinding;
import com.squareup.picasso.Picasso;

public class UserProfileActivity extends AppCompatActivity {

    ActivityUserProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserProfileBinding.inflate(getLayoutInflater());

        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        String status = i.getStringExtra("STATUS");
        String pPic = i.getStringExtra("PROFILE_PIC");

        binding.Status.setText(status);
        binding.Username.setText(name);
        Picasso.get().load(pPic).placeholder(R.drawable.ic_user).into(binding.userImage);

        setContentView(binding.getRoot());
    }
}