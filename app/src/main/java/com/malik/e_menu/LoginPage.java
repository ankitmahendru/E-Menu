package com.malik.e_menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText name,pass;
    Button log_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        name = (EditText)findViewById(R.id.userName);
        pass = (EditText)findViewById(R.id.password);
        log_btn = (Button)findViewById(R.id.login_btn);
        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String n =  name.getText().toString();
               String p = pass.getText().toString();
               if(n.equals("admin") && p.equals("12345")){
                   SharedPreferences preferences = getSharedPreferences("mydata",MODE_PRIVATE);
                   SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("valid",true);
                    editor.commit();

                    startActivity(new Intent(getApplicationContext(),DashBoard.class));

               }else{
                   Toast.makeText(LoginPage.this, "Invalid User", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    pass.setText("");
               }

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LoginPage.this,UserSelection.class));
    }
}
