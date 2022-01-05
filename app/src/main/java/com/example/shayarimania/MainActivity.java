package com.example.shayarimania;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DnsResolver;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
//import com.example.shayarimania.Internet.connReceiver;
//import com.example.shayarimania.PoetryAdapter.FirebaseAdapter;
import com.example.shayarimania.Internet.connReceiver;
import com.example.shayarimania.PoetryAdapter.PoetryAdapter;
import com.example.shayarimania.PoetryModel.PoetryModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Internet connectivity lines
    BroadcastReceiver broadcastReceiver;

    DatabaseReference ref;
    RecyclerView recyclerView;
    ShimmerRecyclerView dashboardRV;
    ArrayList<PoetryModel> list;
    PoetryAdapter adapter;
    SearchView searchView;
//    BroadcastReceiver broadcastReceiver;
//    FirebaseAdapter firebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Maain working method of 1st done video, in which  "connReciever"  class was also created
        broadcastReceiver = new connReceiver();
        registerNetworkBroadcast();

//        recyclerView = findViewById(R.id.recyclerView);
        ref = FirebaseDatabase.getInstance().getReference().child("books");
        dashboardRV = findViewById(R.id.dashboardRV);
        searchView = findViewById(R.id.searchView);

        searchView.setQueryHint("Search your Favourite Shayari's by it's 1st line !!!");


//        checkConnection();


//        // ERROR    ERROR  Internet Reciever
//        broadcastReceiver = new connReceiver();
////        registerNetworkBroadcast();


        ArrayList<PoetryModel> list = new ArrayList<>();
        PoetryAdapter adapter = new PoetryAdapter(list, MainActivity.this);
        dashboardRV.showShimmerAdapter();

        FirebaseDatabase.getInstance().getReference().child("books")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

// meaning of below 4 lines:-
// get SnapShot from Database and add it to ‘adapter’, then from adapter, add this to Arraylist “list” [extends:- created in “Creating a Custom Layout and using and importing it” inside Android Studio notes folder]

                        for (DataSnapshot snapshot1: snapshot.getChildren()){
// adapter:- java class name created in step-2 of this notes
                            PoetryModel adapter2 = snapshot1.getValue(PoetryModel.class);
                            list.add(adapter2);
                        }
                        dashboardRV.setAdapter(adapter);
                        dashboardRV.hideShimmerAdapter();
                        adapter.notifyDataSetChanged();
                    }
//
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });


        onStart();


        dashboardRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        dashboardRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // Doubt:- here and above also

        GridLayoutManager GridLayoutManager = new GridLayoutManager(this, 2);
        dashboardRV.setLayoutManager(GridLayoutManager);
    }



    // Correct method :- checkconnection()

//    public void checkConnection() {
//        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
//
//        if(null != activeNetwork) {
//            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                Toast.makeText(this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
//            }
//
//            else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                Toast.makeText(this, "Data Network Enabled", Toast.LENGTH_SHORT).show();
//            }
//        }
//        else {
//            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
////            Snackbar snackbar = Snackbar.make(MainActivity.this, "Tech Projects", Snackbar.LENGTH_LONG);
//        }
//
//    }




//
//     Internet Connection  code
    protected void registerNetworkBroadcast(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//            registerReceiver(broadcastReceiver, new IntentFilter(String.valueOf(AnimationScreen.class)));
//            registerReceiver(broadcastReceiver, new IntentFilter();
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregistorNetwork(){
        try{
            unregisterReceiver(broadcastReceiver);
        }
        catch (IllegalArgumentException e){
            e.getStackTrace();
        }
    }

    @Override
    protected void onDestroy(){

        // super..onDestroy)  unconfirm method that's why Commented for 1 time
        super.onDestroy();
        unregistorNetwork();
    }







    @Override
    protected void onStart() {
        super.onStart();

        if(ref != null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()) {
                        list = new ArrayList<>();
                        for(DataSnapshot ds : snapshot.getChildren()) {
                            list.add(ds.getValue(PoetryModel.class));
                        }
                        PoetryAdapter adapterClass = new PoetryAdapter(list, MainActivity.this);
//                        dashboardRV.setAdapter(adapter);
                        dashboardRV.hideShimmerAdapter();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(searchView != null) {
            searchView.setOnQueryTextListener(new OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }

    }

    private void search(String str) {
        ArrayList<PoetryModel> myList = new ArrayList<>();
        for (PoetryModel object : list) {
            if(object.getHalfPoemFirst().toLowerCase().contains(str.toLowerCase())) {
                myList.add(object);
            }

        }
        PoetryAdapter adapterClass = new PoetryAdapter(myList, MainActivity.this);
        dashboardRV.setAdapter(adapterClass);
    }


}




