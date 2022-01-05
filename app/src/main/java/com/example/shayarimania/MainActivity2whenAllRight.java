//package com.example.shayarimania;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.StaggeredGridLayoutManager;
//
//import android.content.BroadcastReceiver;
//import android.content.IntentFilter;
//import android.net.ConnectivityManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.MotionEvent;
//import android.widget.ListAdapter;
//import android.widget.SearchView;
//import android.widget.SearchView.OnQueryTextListener;
//
//import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
//import com.example.shayarimania.Internet.connReceiver;
////import com.example.shayarimania.PoetryAdapter.FirebaseAdapter;
//import com.example.shayarimania.PoetryAdapter.PoetryAdapter;
//import com.example.shayarimania.PoetryModel.PoetryModel;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    // Internet connectivity lines
//    BroadcastReceiver broadcastReceiver;
//
//    RecyclerView recyclerView;
//    ShimmerRecyclerView dashboardRV;
//    PoetryAdapter adapter;
////    FirebaseAdapter firebaseAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        recyclerView = findViewById(R.id.recyclerView);
//        dashboardRV = findViewById(R.id.dashboardRV);
//
////        recyclerView = findViewById(R.id.recyclerView);
//
//
//        // ERROR    ERROR  Internet Reciever
//        broadcastReceiver = new connReceiver();
////        registerNetworkBroadcast();
//
//
//        ArrayList<PoetryModel> list = new ArrayList<>();
//
//        PoetryAdapter adapter = new PoetryAdapter(list, MainActivity.this);
//        // Doubr Doubt :- here or Downward
////        dashboardRV.setAdapter(adapter);
//
//        // 2 lines doubt
////        GridLayoutManager GridLayoutManager = new GridLayoutManager(this, 2);
////        dashboardRV.setLayoutManager(GridLayoutManager);
//
//        dashboardRV.showShimmerAdapter();
////        dashboardRV.setLayoutManager(new LinearLayoutManager(this));
//
//        FirebaseDatabase.getInstance().getReference().child("books")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//// meaning of below 4 lines:-
//// get SnapShot from Database and add it to ‘adapter’, then from adapter, add this to Arraylist “list” [extends:- created in “Creating a Custom Layout and using and importing it” inside Android Studio notes folder]
//
//                        for (DataSnapshot snapshot1: snapshot.getChildren()){
//// adapter:- java class name created in step-2 of this notes
//                            PoetryModel adapter2 = snapshot1.getValue(PoetryModel.class);
//                            list.add(adapter2);
//                        }
//                        dashboardRV.setAdapter(adapter);
//                        dashboardRV.hideShimmerAdapter();
//                        adapter.notifyDataSetChanged();
//                    }
//                    //
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                    }
//                });
//
////        FirebaseRecyclerOptions<PoetryModel> options = new
////                FirebaseRecyclerOptions.Builder<PoetryModel>()
////                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), PoetryModel.class)
////                .build();
//
////
////        firebaseAdapter = new FirebaseAdapter(options, MainActivity.this);
////        dashboardRV.setAdapter(firebaseAdapter);
////        dashboardRV.hideShimmerAdapter();
//
//
//
//        dashboardRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
//        dashboardRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        // Doubt:- here and above also
//
//        GridLayoutManager GridLayoutManager = new GridLayoutManager(this, 2);
//        dashboardRV.setLayoutManager(GridLayoutManager);
//    }
//
//
//
//
//    //     Internet Connection  code
//    protected void registerNetworkBroadcast(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
////            registerReceiver(broadcastReceiver, new IntentFilter(String.valueOf(AnimationScreen.class)));
////            registerReceiver(broadcastReceiver, new IntentFilter();
////            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//        }
//    }
//
//    protected void unregistorNetwork(){
//        try{
//            unregisterReceiver(broadcastReceiver);
//        }
//        catch (IllegalArgumentException e){
//            e.getStackTrace();
//        }
//    }
//
//    @Override
//    protected void onDestroy(){
//
//        // super..onDestroy)  unconfirm method that's why Commented for 1 time
//        super.onDestroy();
//        unregistorNetwork();
//    }
//
//
//
//    // Menu option of Search View
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.mainmenu, menu);
//        MenuItem item = menu.findItem(R.id.search_name);
//
//        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) item.getActionView();
//
//
////                SearchView searchView = (SearchView) item.getActionView();
////        searchView.setOnQueryTextListener(new OnQueryTextListener() {
//        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                processsearch(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                ArrayList<PoetryModel> list = new ArrayList<>();
//                FirebaseRecyclerOptions<PoetryModel> options = new
//                        FirebaseRecyclerOptions.Builder<PoetryModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("books"), PoetryModel.class)
//                        .build();
////                FirebaseAdapter firebaseAdapter = new FirebaseAdapter(options, MainActivity.this);
//
////                adapter.getFilter().filter(newText);
////                firebaseAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    private void processsearch(String query) {
////        FirebaseRec
//    }
//
//
////    @Override
////    protected void onStart() {
////        super.onStart();
////        firebaseAdapter.startListening();
////    }
////
////    @Override
////    protected void onStop() {
////        super.onStop();
////        firebaseAdapter.stopListening();
////    }
//}
//
//
//
//
//
//
//
////        SearchView searchView = (SearchView) item.getActionView();
////        searchView.setOnQueryTextListener(new OnQueryTextListener() {
////            @Override
////            public boolean onQueryTextSubmit(String query) {
////                return false;
////            }
////
////            @Override
////            public boolean onQueryTextChange(String newText) {
////
//////                adapter.getFilter().filter(newText);
////                return false;
////            }
////
////        });
//
