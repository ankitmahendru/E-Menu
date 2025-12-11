package com.malik.e_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {
    Button lgo_btn,mng_stf_btn,mng_ord_btn,mng_itm_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        lgo_btn=(Button)findViewById(R.id.lgo_btn);
        mng_itm_btn=(Button)findViewById(R.id.mng_itm_btn);
        mng_ord_btn=(Button)findViewById(R.id.mng_ord_btn);
        mng_stf_btn=(Button)findViewById(R.id.mng_stf_btn);
        lgo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this,LoginPage.class));
            }
        });
        mng_itm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this,ManageItem.class));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
