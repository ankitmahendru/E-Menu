package com.malik.e_menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.usb.UsbRequest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSelection extends AppCompatActivity {
    Button admin,user,geturlfromuser;
    EditText urlfromuser;
    public static String urlget="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);
        admin=(Button)findViewById(R.id.admin_btn);
        urlfromuser=(EditText)findViewById(R.id.getUrl);
        geturlfromuser=(Button)findViewById(R.id.button4);
        geturlfromuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlmain=urlfromuser.getText().toString();
                Log.i("ENTERED : ", urlmain);
                urlget=urlmain;
                Toast.makeText(UserSelection.this, urlget, Toast.LENGTH_SHORT).show();
            }
        });
        user=(Button)findViewById(R.id.user_btn);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserSelection.this,LoginPage.class));
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserSelection.this,UserHome.class));

            }
        });
    }
}
