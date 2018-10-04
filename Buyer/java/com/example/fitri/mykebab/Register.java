package com.example.fitri.mykebab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    DatabaseReference mydatabase = FirebaseDatabase.getInstance().getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText userphone = (EditText) findViewById(R.id.phonenymber);
        Button joinButton = (Button) findViewById(R.id.joinbutton);
        username.setText("");
        userphone.setText("");

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals(""))
                {
                    Toast.makeText(Register.this,"Username Cannot be Empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(userphone.getText().toString().equals(""))
                    {
                        Toast.makeText(getBaseContext(),"Phone Number must not Empty",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        String id = mydatabase.push().getKey();
                        Users adduser = new Users(id,username.getText().toString(),userphone.getText().toString());
                        mydatabase.child(id).setValue(adduser);
                        Bundle returnBundle = new Bundle();
                        returnBundle.putString("NAME", username.getText().toString());
                        returnBundle.putString("PHONE", userphone.getText().toString());
                        returnBundle.putString("USER_ID",id);
                        Intent returnIntent = new Intent();
                        returnIntent.putExtras(returnBundle);
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                    }
                }
            }
        });

    }

}
