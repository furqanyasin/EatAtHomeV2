package com.example.eatathomev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton clientUser, restaurantUser, riderUser, administratorUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientUser = findViewById(R.id.btn_client_SignIn);
        clientUser.setOnClickListener(this);

        restaurantUser = findViewById(R.id.btn_restaurent_SignIn);
        restaurantUser.setOnClickListener(this);

        riderUser = findViewById(R.id.btn_rider_SignIn);
        riderUser.setOnClickListener(this);

        administratorUser = findViewById(R.id.btn_administrator_SignIn);
        administratorUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == clientUser) {

            Toast.makeText(this, "Clicked clientUser", Toast.LENGTH_SHORT).show();
        } else if (view == restaurantUser) {

            Toast.makeText(this, "Clicked restaurantUser", Toast.LENGTH_SHORT).show();
            // start activity here
        } else if (view == riderUser) {

            Toast.makeText(this, "Clicked riderUser", Toast.LENGTH_SHORT).show();
            // start activity here
        } else if (view == administratorUser) {

            Toast.makeText(this, "Clicked administratorUser", Toast.LENGTH_SHORT).show();
            // start activity here
        }
    }
}