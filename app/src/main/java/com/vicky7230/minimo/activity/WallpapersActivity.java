package com.vicky7230.minimo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vicky7230.minimo.R;
import com.vicky7230.minimo.adapter.RecyclerViewAdapter;
import com.vicky7230.minimo.adapter.WallpaperViewHolder;
import com.vicky7230.minimo.model.Wallpaper;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WallpapersActivity extends AppCompatActivity {

    public static final String DATA = "Data";

    private RecyclerView wallpapersRecyclerView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        init();
    }

    private void init() {


        wallpapersRecyclerView = (RecyclerView) findViewById(R.id.wallpapers);
        wallpapersRecyclerView.setHasFixedSize(true);
        wallpapersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(DATA);

        recyclerViewAdapter = new RecyclerViewAdapter(WallpapersActivity.this, Wallpaper.class, R.layout.wallpaper, WallpaperViewHolder.class, databaseReference);

        wallpapersRecyclerView.setAdapter(recyclerViewAdapter);

    }

}