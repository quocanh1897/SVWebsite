package com.example.dell.demoweb.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.dell.demoweb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManhinhchinh;
    NavigationView navigationView;
    ListView listViewManhinhchinh;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ActionBar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShLAjalXT0wCTTNR-Dr6LPIM70Gr9DGl8NrkI7Vn1MJTmooKNJ");
        mangquangcao.add("https://www.aftershockpc.com/backend/public/slider/thumbs/1_proudct%20page%20test.png");
        mangquangcao.add("https://vnptcert.vnpt.vn/wp-content/uploads/2017/05/hp-audio-driver-laptop-keylogger.png");
        mangquangcao.add("https://cdn.tgdd.vn/Files/2015/06/18/656292/macos.jpg");
        mangquangcao.add("https://image3.mouthshut.com/images/Restaurant/Photo/-26300_32506.png");

        for(int i = 0; i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);

        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void Anhxa(){
        toolbar = (Toolbar) findViewById(R.id.toolbarManhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewManhinhchinh = (ListView) findViewById(R.id.listviewManhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);


    }
}
