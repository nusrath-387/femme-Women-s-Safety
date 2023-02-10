package com.example.femme_womenssafety;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class custom_adapter extends ArrayAdapter<Contact_store> {
    private Activity context;
    private List<Contact_store>contactList;


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);
        Contact_store contact_store=contactList.get(position);
        TextView t1=view.findViewById(R.id.namee);
        TextView t2=view.findViewById(R.id.phone);
        return view;
    }

    public custom_adapter(Activity context , @NonNull List<Contact_store>contactList ) {
        super(context,R.layout.sample_layout,contactList);
        this.context = context;




    }
}
