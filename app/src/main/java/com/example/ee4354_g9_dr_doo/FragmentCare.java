package com.example.ee4354_g9_dr_doo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentCare extends Fragment {

    private View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization p arameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<CardCare> careArrayList;
    private RecyclerView recyclerview;
    private String[] newsHeading;
    private AdapterCare.RecyclerViewClickListener listener;
    public FragmentCare() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentCare.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCare newInstance(String param1, String param2) {
        FragmentCare fragment = new FragmentCare();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_care, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle SavedInstanceState){
        super.onViewCreated(view,SavedInstanceState);
        setOnClickListener();
        dataInitialize();
        recyclerview = view.findViewById(R.id.recyclerViewCare);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        AdapterCare myAdapter = new AdapterCare(getContext(),careArrayList,listener);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void setOnClickListener() {
        listener=new AdapterCare.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent =new Intent(getContext(),Activity_Inside_View.class);
                intent.putExtra("Kind",1);  // just to identify the Care/Find/Vet/Shop
                intent.putExtra("Heading",careArrayList.get(position).getcHeading());
                intent.putExtra("Location",careArrayList.get(position).getcLocation());
                intent.putExtra("Date",careArrayList.get(position).getcDate());
                intent.putExtra("Contact",careArrayList.get(position).getcContact());
                // need a code for image

                startActivity(intent);
            }
        };
    }

    private void dataInitialize() {
        careArrayList = new ArrayList<>();
        newsHeading = new String[]{
                "Care",
                "LCDFF",
                "215",
                "sds",
                "5489",
                "ysdiso"
        };
        for(int i=0;i<newsHeading.length;i++ ){
            CardCare news = new CardCare(newsHeading[i],"Locate "+i,"Date " +i,"Contact "+i);
            careArrayList.add(news);
        }
    }


}