//package com.example.shayarimania.PoetryAdapter;
////package com.example.shayarimania.FirebaseAdapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.ScaleAnimation;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.shayarimania.AnimationScreen;
//import com.example.shayarimania.PoetryModel.PoetryModel;
//import com.example.shayarimania.R;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
////public class FirebaseAdapter extends  RecyclerView.Adapter<FirebaseAdapter.viewHolder> implements Filterable {
////public class FirebaseAdapter extends FirebaseRecyclerAdapter {
//public class FirebaseAdapter extends FirebaseRecyclerAdapter<PoetryModel, FirebaseAdapter.viewHolder> {
//
//    Context context;
//    PoetryModel model1;
//    ArrayList<PoetryModel> list;
//    ArrayList<PoetryModel> backup;
//
//    public FirebaseAdapter(@NonNull FirebaseRecyclerOptions<PoetryModel> options, Context context) {
//        super(options);
//        this.context = context;
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull viewHolder holder, int position, @NonNull PoetryModel model) {
//        PoetryModel model1 = list.get(position);
//
//        Picasso.get()
//                .load(model1.getUrl())
//                .into(holder.poetImage);
//
//        holder.itemView.setOnClickListener(v -> {
//
//            Intent intent = new Intent(context, AnimationScreen.class);
//            intent.putExtra("url", model1.getUrl());
//            intent.putExtra("poetName", model1.getPoetName());
//            intent.putExtra("halfPoemFirst", model1.getHalfPoemFirst());
//            intent.putExtra("halfPoemSecond", model1.getHalfPoemSecond());
//            intent.putExtra("fullPoem3", model1.getFullPoem3());
//            intent.putExtra("fullPoem4", model1.getFullPoem4());
//
//            context.startActivity(intent);
//        });
//
//        holder.PoetName.setText(model1.getPoetName());
//        holder.halfPoem1.setText(model1.getHalfPoemFirst());
//        holder.halfPoem2.setText(model1.getHalfPoemSecond());
//    }
//
//    @NonNull
//    @Override
//    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_poetry, parent, false);
//        return new viewHolder(view);
//    }
//
//
//
//
//
//    class viewHolder extends RecyclerView.ViewHolder{
//        ImageView poetImage;
//        TextView PoetName, halfPoem1, halfPoem2, ReadMore;
//        public viewHolder(@NonNull View itemView) {
//            super(itemView);
//
//// finding things (textview and imageview) by FindViewById
//            poetImage = itemView.findViewById(R.id.poetImage);
//            PoetName = itemView.findViewById(R.id.PoetName);
//            halfPoem1 = itemView.findViewById(R.id.Poem2);
//            halfPoem2 = itemView.findViewById(R.id.Poem4);
//            ReadMore = itemView.findViewById(R.id.ReadMore);
//        }
//    }
//
//}
//
