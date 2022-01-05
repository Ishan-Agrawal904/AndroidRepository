package com.example.shayarimania.Internet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shayarimania.MainActivity;
import com.example.shayarimania.R;

import static android.widget.Toast.makeText;

public class connReceiver extends BroadcastReceiver {
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        if (isConnected(context)) {
            Toast toast = makeText(mContext, "Internet Connected", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 5, 5);
            toast.show();
        }
        else{
            showDialog();
        }
    }


    public boolean isConnected(Context context){
        try{
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }

    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.internet_check, null);
        Button dismiss = view.findViewById(R.id.dismiss);
        builder.setView(view);

        final Dialog dialog = builder.create();

        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
