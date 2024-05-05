package com.example.testbrilliant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements settingPageAdapter.OnItemClickListener {
    private Button loadWebViewButton;
    RecyclerView recyclerView;
    ArrayList<settingPageModel> settingPageModel = new ArrayList<>();
    int[] settingsIcon = {R.drawable.extended_services_icon, R.drawable.extended_services_icon,R.drawable.extended_services_icon,R.drawable.extended_services_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpSettingsPageModels();
        settingPageAdapter settingPageAdapter = new settingPageAdapter(this,settingPageModel);
        recyclerView.setAdapter(settingPageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        settingPageAdapter.setOnItemClickListener(this);

    }
    //Setting Page Model Setup
    private void setUpSettingsPageModels() {
        String[] settingsItemNames = getResources().getStringArray(R.array.settingsItemNames);
        for(int i = 0; i<settingsItemNames.length; i++) {
            settingPageModel.add(new settingPageModel(settingsItemNames[i], settingsIcon[i]));
        }
    }

    //Page Intent
    public void onItemClick(int position) {
        switch (position) {
            case 1:
                Intent intent = new Intent(MainActivity.this, ExtendedService.class);
                startActivity(intent);
                break;
        }
    }
    }