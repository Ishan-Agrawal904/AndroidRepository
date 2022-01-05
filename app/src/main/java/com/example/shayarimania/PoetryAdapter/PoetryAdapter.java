package com.example.shayarimania.PoetryAdapter;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayarimania.AnimationScreen;
import com.example.shayarimania.PoetryModel.PoetryModel;
import com.example.shayarimania.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PoetryAdapter extends  RecyclerView.Adapter<PoetryAdapter.viewHolder> implements Filterable {

    // bookModel:- Class name created as Contact in step-2 in which you have put Getters, Setters and Constructors

    // list :- arraylist name
    ArrayList<PoetryModel> list;
    ArrayList<PoetryModel> backup;
    Context context;
    private ViewGroup parent;
    private int viewType;

    private int lastPostion = -1;

    // bookAdapter:- class name created as Custom adapter
    public PoetryAdapter(ArrayList<PoetryModel> list, Context context) {
        this.list = list;
        this.context = context;

        this.backup = new ArrayList<>(list);
    }

    // sample_books :- Custom layout name created by You
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_poetry, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        PoetryModel model = list.get(position);

// If getting Locally, use Blow code + create Image in step-2 as Int because you can use R.drawable.img1

// set image (using getImage() getter in step-2 of this notes) in Custom Layout inside bookImage
//        holder.bookImage.setImageResource(model.getImage());


// If using Picasso, use Blow code + create Image in step-2 as String

        Picasso.get()
                .load(model.getUrl())
                .into(holder.poetImage);

//        holder.copy.setOnClickListener(v -> {
//            String p1, p2, p3, p4;
//
//            ClipboardManager clipboardManager =
//        });

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, AnimationScreen.class);
            intent.putExtra("url", model.getUrl());
            intent.putExtra("poetName", model.getPoetName());
            intent.putExtra("halfPoemFirst", model.getHalfPoemFirst());
            intent.putExtra("halfPoemSecond", model.getHalfPoemSecond());
            intent.putExtra("fullPoem3", model.getFullPoem3());
            intent.putExtra("fullPoem4", model.getFullPoem4());

            context.startActivity(intent);
        });

        setAnimation(holder.itemView, position);


// first see below code in this
// set bookName (using getBookName() getter in step-2 of this notes) in Custom Layout inside ‘bookText’
        holder.PoetName.setText(model.getPoetName());
        holder.halfPoem1.setText(model.getHalfPoemFirst());
        holder.halfPoem2.setText(model.getHalfPoemSecond());

    }

    public void setAnimation(View viewToAnimate, int position){
        if(position> lastPostion){
            ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

            animation.setDuration(700);
            viewToAnimate.startAnimation(animation);
            lastPostion = position;

        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }


    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
//            List<PoetryModel> filteredList = new ArrayList<>();
            ArrayList<PoetryModel> filterdata = new ArrayList<>();

//            if(keyword.toString().isEmpty()) {
//                filterdata.addAll(backup);
//            }

            if (keyword.toString().isEmpty()) {
                filterdata.addAll(backup);
            } else {
                for (PoetryModel obj : backup) {
                    if (obj.getHalfPoemFirst().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filterdata.add(obj);
//
//                    else if (obj.getHalfPoemSecond().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
//                        filterdata.add(obj);
//
//                    else if (obj.getPoetName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
//                        filterdata.add(obj);

                }
            }
                FilterResults results = new FilterResults();
                results.values = filterdata;
                return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            list.clear();
            list.addAll((ArrayList<PoetryModel>)results.values);
//            list.addAll(results.values);
//            list.addAll((Collection<? extends PoetryModel>) results.values);
            notifyDataSetChanged();
        }
    };




    //can also write this ‘viewHolder extends RecyclerView.ViewHolder’ class above also
    public class viewHolder extends RecyclerView.ViewHolder {

        // finding things (textview and imageview) by their Object type and name
        ImageView poetImage;
        TextView PoetName, halfPoem1, halfPoem2, ReadMore, copy;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

// finding things (textview and imageview) by FindViewById
            poetImage = itemView.findViewById(R.id.poetImage);
            PoetName = itemView.findViewById(R.id.PoetName);
            halfPoem1 = itemView.findViewById(R.id.Poem2);
            halfPoem2 = itemView.findViewById(R.id.Poem4);
            ReadMore = itemView.findViewById(R.id.ReadMore);
//            copy = itemView.findViewById(R.id.copy);
        }
    }
}
