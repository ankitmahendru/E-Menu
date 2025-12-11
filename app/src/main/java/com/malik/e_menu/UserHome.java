package com.malik.e_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome extends AppCompatActivity {
Button news_btn,menu_btn,wthr_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        news_btn=(Button)findViewById(R.id.new_btn);
        wthr_btn=(Button)findViewById(R.id.wthr_btn);
        menu_btn=(Button)findViewById(R.id.menu_btn);
        wthr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHome.this,weather.class));
            }
        });
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHome.this,MenuTab.class));
            }
        });
        news_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHome.this,CategoryActivity.class));
            }
        });
    }
}
