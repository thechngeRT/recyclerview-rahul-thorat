package com.example.horizontallist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mList1,mList2, mList3, mList4, mList5;
    List<App> appList1, appList2, appList3, appList4, appList5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList1 = findViewById(R.id.list1);
        mList2 = findViewById(R.id.list2);
        mList3 = findViewById(R.id.list3);
        mList4 = findViewById(R.id.list4);
        mList5 = findViewById(R.id.list5);

        appList1 = new ArrayList<>();

        appList1.add(new App(R.drawable.sandeep_feed,"sandeep-maheshwari", 40));
        appList1.add(new App(R.drawable.darr," Darr", 40));
        appList1.add(new App(R.drawable.kyvo,"Kya woh sach", 20));
        appList1.add(new App(R.drawable.ishq,"Ishq Wala Love", 40));
        appList1.add(new App(R.drawable.ek,"Ek Purani Kahani", 40));


        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        mList2 = findViewById(R.id.list2);

        appList2 = new ArrayList<>();

        appList2.add(new App(R.drawable.podcast,"Jansatta Podcast", 40));
        appList2.add(new App(R.drawable.bazzi," Puliyabaazi", 40));
        appList2.add(new App(R.drawable.story,"The Big Story", 40));
        appList2.add(new App(R.drawable.mankibat,"man ki bat", 40));



        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList2.setLayoutManager(manager2);

        appList3 = new ArrayList<>();

        appList3.add(new App(R.drawable.kno,"GK NOTES", 40));
        appList3.add(new App(R.drawable.jobs," Jobs Jankari", 40));

        LinearLayoutManager manager3 = new LinearLayoutManager(this);
        manager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList3.setLayoutManager(manager3);


        appList4 = new ArrayList<>();

        appList4.add(new App(R.drawable.ram,"Ramayan", 40));
        appList4.add(new App(R.drawable.maha," Mahabharat", 40));
        appList4.add(new App(R.drawable.sadguru,"Sadhguru", 40));
        appList4.add(new App(R.drawable.githa,"Bhagavad Gita", 40));
        appList4.add(new App(R.drawable.krishna,"Krishna Wani", 40));

        LinearLayoutManager manager4 = new LinearLayoutManager(this);
        manager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList4.setLayoutManager(manager4);

        appList5 = new ArrayList<>();

        appList5.add(new App(R.drawable.naved,"RJ Naved", 40));
        appList5.add(new App(R.drawable.bauuaa," Bauaa", 40));


        LinearLayoutManager manager5 = new LinearLayoutManager(this);
        manager5.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList5.setLayoutManager(manager5);



        CustomAdaptor adaptor1 = new CustomAdaptor(this,appList1);
        mList1.setAdapter(adaptor1);

        CustomAdaptor adaptor2 = new CustomAdaptor(this,appList2);
        mList2.setAdapter(adaptor2);

        CustomAdaptor adaptor3 = new CustomAdaptor(this,appList3);
        mList3.setAdapter(adaptor3);

        CustomAdaptor adaptor4 = new CustomAdaptor(this,appList4);
        mList4.setAdapter(adaptor4);

        CustomAdaptor adaptor5 = new CustomAdaptor(this,appList5);
        mList5.setAdapter(adaptor5);


    }
}
