package com.example.demologinpage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

//package com.google.firebase.referencecode.database;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DummyDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DummyDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_data);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<DummyData> dummyDataList = createDummyData();

        adapter = new DummyDataAdapter(dummyDataList);
        recyclerView.setAdapter(adapter);
    }

    private List<DummyData> createDummyData() {

//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setProjectId("demologinpage-c62d8")
//                .setApplicationId("1:27992087142:android:ce3b6448250083d1")
//                .setApiKey("AIzaSyADUe90ULnQDuGShD9W23RDP0xmeDc6Mvw")
//                // setDatabaseURL(...)
//                // setStorageBucket(...)
//                .build();

        // Write a message to the database
//        FirebaseApp.initializeApp(this /* Context */);

        /////////////////////////
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
        ///////////////////////////
//        Log.d(myRef, "myRef: ");

//        FirebaseApp.initializeApp(this /* Context */, options, "secondary");

        // Retrieve secondary FirebaseApp
//        FirebaseApp secondary = FirebaseApp.getInstance("secondary");

        List<DummyData> dummyDataList = new ArrayList<>();
        dummyDataList.add(new DummyData("Samad", 25, "Nellore"));
        dummyDataList.add(new DummyData("Shahina", 23, "Nellore"));
        dummyDataList.add(new DummyData("Nobita", 25, "Tokyo"));
        dummyDataList.add(new DummyData("Shizuka", 23, "Tokyo"));
//
        return dummyDataList;
//        return [{data:"myRef"}];
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
    //onOptionsItemSelected





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.sortByName) {
            sortDataByName();
            return true;
        } else if (itemId == R.id.sortByAge) {
            sortDataByAge();
            return true;
        } else if (itemId == R.id.sortByCity) {
            sortDataByCity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sortDataByName() {

        List<DummyData> sortedData = adapter.getData();
        Collections.sort(sortedData, new Comparator<DummyData>() {
            @Override
            public int compare(DummyData d1, DummyData d2) {
                return d1.getName().compareToIgnoreCase(d2.getName());
            }
        });
        adapter.setData(sortedData);
        adapter.notifyDataSetChanged();
    }

    private void sortDataByAge() {
        List<DummyData> sortedData = adapter.getData();
        Collections.sort(sortedData, new Comparator<DummyData>() {
            @Override
            public int compare(DummyData d1, DummyData d2) {
                return Integer.compare(d1.getAge(), d2.getAge());
            }
        });
        adapter.setData(sortedData);
        adapter.notifyDataSetChanged();
    }

    private void sortDataByCity() {
        List<DummyData> sortedData = adapter.getData();
        Collections.sort(sortedData, new Comparator<DummyData>() {
            @Override
            public int compare(DummyData d1, DummyData d2) {
                return d1.getCity().compareToIgnoreCase(d2.getCity());
            }
        });
        adapter.setData(sortedData);
        adapter.notifyDataSetChanged();
    }


}