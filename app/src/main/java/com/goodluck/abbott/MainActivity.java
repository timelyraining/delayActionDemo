package com.goodluck.abbott;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.goodluck.abbott.valid.DiscountValid;
import com.goodluck.abbott.valid.LoginValid;
import com.goodluck.abbott.valid.RightValid;
import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.CallUnit;

public class MainActivity extends AppCompatActivity implements Action {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CallUnit.newInstance(MainActivity.this)
                        .addValid(new LoginValid(MainActivity.this))
                        .addValid(new DiscountValid(MainActivity.this))
                        .doCall();


            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CallUnit.newInstance(MainActivity.this)
                        .addValid(new LoginValid(MainActivity.this))
                        .addValid(new RightValid(MainActivity.this, "1", "order"))
                        .addValid(new DiscountValid(MainActivity.this))
                        .doCall();

            }
        });

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserConfigCache.setLogin(MainActivity.this, false);


            }
        });
        findViewById(R.id.logoutDis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserConfigCache.setDiscount(MainActivity.this, false);
            }
        });
    }


    @Override
    public void call() {
        OrderDetailActivity.startActivity(MainActivity.this, "1234");
    }
}
