package com.example.horizontallist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity implements CustomAdaptor.OnItemClickListener {

    GridLayout mainGrid1;


    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";

    private RecyclerView mList1;
    private CustomAdaptor customAdaptor;
    private ArrayList<App> appList1;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid1=findViewById(R.id.mainGrid);


        mList1 = findViewById(R.id.list1);
        mList1 = findViewById(R.id.list2);
        mList1 = findViewById(R.id.list3);
        mList1 = findViewById(R.id.list4);
        mList1= findViewById(R.id.list5);

        mList1.setHasFixedSize(true);
       // **///{** mList1.setHasFixedSize(true);

      //  mList1.setHasFixedSize(true);

       // mList1.setHasFixedSize(true);
      //  mList1.setHasFixedSize(true);

     //   mList1.setLayoutManager(new LinearLayoutManager(this));
     //   mList1.setLayoutManager(new LinearLayoutManager(this));
     //   mList1.setLayoutManager(new LinearLayoutManager(this));
     //   mList1.setLayoutManager(new LinearLayoutManager(this));
        mList1.setLayoutManager(new LinearLayoutManager(this));


        appList1 = new ArrayList<>();
      //  appList2 = new ArrayList<>();
      //  appList3 = new ArrayList<>();
      //  appList4 = new ArrayList<>();
      //  appList5 = new ArrayList<>();


        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://d51md7wh0hu8b.cloudfront.net/android/v1/prod/Radio/hi/show.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject data = jsonArray.getJSONObject(i);

                                String creatorName = data.getString("t");
                                String imageUrl = data.getString("pF");

                                appList1.add(new App(imageUrl, creatorName ));
                            }

                            customAdaptor = new CustomAdaptor(MainActivity.this, appList1);
                            mList1.setAdapter(customAdaptor);
                            customAdaptor.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }





    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, jsonfech.class);
        App clickedItem = appList1.get(position);
        //clickedItem = appList2.get(position);
       // clickedItem = appList3.get(position);
       // clickedItem = appList4.get(position);
        //clickedItem = appList5.get(position);


        detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getCreator());

        startActivity(detailIntent);

    }
}
