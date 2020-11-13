package com.example.eatathomev2.RestaurantUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.eatathomev2.AdministratorUser.AdministratorSignInActivity;
import com.example.eatathomev2.R;
import com.example.eatathomev2.RestaurantUser.Activities.RestaurantHomeActivity;
import com.example.eatathomev2.RestaurantUser.Model.UserRestaurant;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RestaurantSignInActivity extends AppCompatActivity {

    TextInputEditText edtPhone, edtPassword;
    MaterialButton btnRestaurantSignIn;
    FirebaseDatabase database;
    DatabaseReference adminRestaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_sign_in);

        edtPhone = findViewById(R.id.tiet_restaurant_user_phone);
        edtPassword = findViewById(R.id.tiet_restaurant_user_password);
        btnRestaurantSignIn = findViewById(R.id.btn_restaurant_user_Sign_in);
        btnRestaurantSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start new activity here
                signInAdminRestaurant(edtPhone.getText().toString(), edtPassword.getText().toString());
            }
        });

        database = FirebaseDatabase.getInstance();
        adminRestaurant = database.getReference("UserRestaurantAdmin");
    }

    private void signInAdminRestaurant(String phone, String password) {

        final ProgressDialog mDialog = new ProgressDialog(RestaurantSignInActivity.this);
        mDialog.setMessage("Please waiting..");
        mDialog.show();

        final String localPhone = phone;
        final String localPassword = password;

        adminRestaurant.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(localPhone).exists()) {
                    mDialog.dismiss();
                    UserRestaurant userRestaurant = snapshot.child(localPhone).getValue(UserRestaurant.class);
                    userRestaurant.setPhone(localPhone);
                    if (Boolean.parseBoolean(userRestaurant.getIsadmin())) {
                        //if isAdmin is true
                        if (userRestaurant.getPassword().equals(localPassword)) {
                            Intent intent = new Intent(RestaurantSignInActivity.this, RestaurantHomeActivity.class);
                            ConstantRestaurant.currentUserRestaurant = userRestaurant;
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(RestaurantSignInActivity.this, "wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RestaurantSignInActivity.this, "Please login with admin account", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(RestaurantSignInActivity.this, "User not exist in database", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}