package com.example.realestateproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    EditText mFullName;
    EditText mEmail;
    EditText mPassword;
    EditText mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullName= findViewById(R.id.PersonName);
        mEmail= findViewById((R.id.PersonId));
        mPassword= findViewById(R.id.PersonPass);
        mPhone= findViewById(R.id.PersonPhone);
        mRegisterBtn= findViewById(R.id.login);
        mLoginBtn= findViewById(R.id.createText);

        fAuth=FirebaseAuth.getInstance();
        progressBar= findViewById(R.id.progressBar);



        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                String edtName=mFullName.getText().toString().trim();
                if(TextUtils.isEmpty(edtName)){
                    mFullName.setError("Name not entered");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }
                if(password.length() < 6 ){
                    mPassword.setError("Password should be atleast of 8 charactors");
                    return;
                }


                if(mPhone.getText().toString().length()==0){
                    mPhone.setError("Phone no. not entered");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this, "User Created.",Toast.LENGTH_SHORT).show() ;
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(),login.class));

                        }else{
                            Toast.makeText(register.this, "Error!" +task.getException().getMessage(),Toast.LENGTH_SHORT).show() ;
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


            }


        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, login.class));
            }
        });

    }

}