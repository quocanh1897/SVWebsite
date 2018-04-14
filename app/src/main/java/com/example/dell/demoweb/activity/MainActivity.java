package com.example.dell.demoweb.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.dell.demoweb.R;
import com.example.dell.demoweb.adapter.LoaispAdapter;
import com.example.dell.demoweb.model.Loaisp;
import com.example.dell.demoweb.model.sp;
import com.example.dell.demoweb.ultil.checkConnection;
import com.example.dell.demoweb.ultil.server;
import com.example.dell.demoweb.adapter.spadapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManhinhchinh = null;
    NavigationView navigationView;
    ListView listViewManhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    spadapter spadapter;
    int id = 0;
    String tenloaisp = "";
    String hinhanhloaisp = "";
    ArrayList<sp> mangsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        
        if(checkConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            getDulieuloaisp();
            getdulieuspmoinhat();
        }else{
            checkConnection.showToast_short(getApplicationContext(),"Kiem tra lai ket noi");
            finish();
        }
        
        
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
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0, new Loaisp(0, "Trang chính",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqkcsBGRen05NCuMSOvyUjw0QUfGpIAKn9DUk1ktd4L-XGvzva"));
        recyclerViewManhinhchinh = (RecyclerView) findViewById(R.id.recycleView);
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        listViewManhinhchinh.setAdapter(loaispAdapter);

        mangsp = new ArrayList<>();
        spadapter = new spadapter(getApplicationContext(),mangsp);
        recyclerViewManhinhchinh.setHasFixedSize(true);
        recyclerViewManhinhchinh.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerViewManhinhchinh.setAdapter(spadapter);

    }

    public void getDulieuloaisp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.urlLoaisp,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    for (int i = 0; i < response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("tenloaisp");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisp");
                            mangloaisp.add(new Loaisp(id, tenloaisp,hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangloaisp.add(3, new Loaisp(0,"Liên hệ",
                            "https://cdn1.iconfinder.com/data/icons/mix-color-3/502/Untitled-12-512.png"));
                    mangloaisp.add(4, new Loaisp(0,"Thông tin",
                            "https://www.icon2s.com/wp-content/uploads/2014/03/Contact-Icon.png"));

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                checkConnection.showToast_short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    public void getdulieuspmoinhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.urlspmoinhat,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response != null) {
                            int ID = 0;
                            String tensp = "";
                            Integer giasp = 0;
                            String hinhanhsp = "";
                            String motasp = "";
                            int IDsp = 0;
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    ID = jsonObject.getInt("id");
                                    tensp = jsonObject.getString("tensp");
                                    giasp = jsonObject.getInt("giasp");
                                    hinhanhsp = jsonObject.getString("hinhanhsp");
                                    motasp = jsonObject.getString("motasp");
                                    IDsp = jsonObject.getInt("idsp");
                                    mangsp.add(new sp(ID,tensp,giasp,hinhanhsp,motasp,IDsp));

                                    spadapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
