package com.example.ee4354_g9_dr_doo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFind#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFind extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<CardFind> FindArrayList;
    private RecyclerView recyclerview;
    private String[] newsHeading2;
    private AdapterFind.RecyclerViewClickListener listener;
    public FragmentFind() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFind.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFind newInstance(String param1, String param2) {
        FragmentFind fragment = new FragmentFind();
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
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle SavedInstanceState){

        super.onViewCreated(view,SavedInstanceState);
        setOnClickListener();
        dataInitialize();
        recyclerview = view.findViewById(R.id.recyclerViewFind);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        AdapterFind myAdapter = new AdapterFind(getContext(),FindArrayList,listener);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    private void setOnClickListener() {
        listener=new AdapterFind.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent =new Intent(getContext(),Activity_Inside_View.class);
                LatLng latLng = FindArrayList.get(position).getcLocation();
                intent.putExtra("Kind",2);  // just to identify the Care/Find/Vet/Shop
                intent.putExtra("Heading",FindArrayList.get(position).getcHeading());
                intent.putExtra("Lat",latLng.latitude);
                intent.putExtra("Lan",latLng.longitude);
                intent.putExtra("Date",FindArrayList.get(position).getcDate());
                intent.putExtra("Contact",FindArrayList.get(position).getcContact());
                intent.putExtra("Rewards",FindArrayList.get(position).getcRewards());
                // need a code for image

                startActivity(intent);
            }
        };
    }

    private void dataInitialize() {
        FindArrayList = new ArrayList<>();
        newsHeading2 = new String[]{
                "Find",
                "LCDFF",
                "215",
                "sds",
                "5489",
                "ysdiso"
        };
        for(int i=0;i<newsHeading2.length;i++ ){
            CardFind news = new CardFind(newsHeading2[i],new LatLng(6.717989401, 79.93309889),"Date " +i,"Contact "+i,"Reward "+i);
            FindArrayList.add(news);
        }
    }
}