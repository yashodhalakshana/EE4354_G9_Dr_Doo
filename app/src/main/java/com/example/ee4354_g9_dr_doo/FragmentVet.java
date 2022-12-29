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
 * Use the {@link FragmentVet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVet extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<CardVet> vetArrayList;
    private RecyclerView recyclerview;
    private String[] newsHeading;
    private AdapterVet.RecyclerViewClickListener listener;
    public FragmentVet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentVet.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentVet newInstance(String param1, String param2) {
        FragmentVet fragment = new FragmentVet();
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
        return inflater.inflate(R.layout.fragment_vet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle SavedInstanceState){
        super.onViewCreated(view,SavedInstanceState);
        setOnClickListener();
        dataInitialize();
        recyclerview = view.findViewById(R.id.recyclerViewVet);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        AdapterVet myAdapter = new AdapterVet(getContext(),vetArrayList,listener);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
    private void setOnClickListener() {
        listener=new AdapterVet.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent =new Intent(getContext(),Activity_Inside_View.class);
                LatLng latLng = vetArrayList.get(position).getcLocation();
                intent.putExtra("Kind",4);  // just to identify the Care/Find/Vet/Shop
                intent.putExtra("Heading",vetArrayList.get(position).getcHeading());
                intent.putExtra("Lat",latLng.latitude);
                intent.putExtra("Lan",latLng.longitude);
                intent.putExtra("Name",vetArrayList.get(position).getcName());
                intent.putExtra("Contact",vetArrayList.get(position).getcContact());
                intent.putExtra("Rating",vetArrayList.get(position).getcRating());
                // need a code for image

                startActivity(intent);
            }
        };
    }
    private void dataInitialize() {
        vetArrayList = new ArrayList<>();
        newsHeading = new String[]{
                "Vet",
                "LCDFF",
                "215",
                "sds",
                "5489",
                "ysdiso"
        };
        for(int i=0;i<newsHeading.length;i++ ){
            CardVet news = new CardVet(newsHeading[i],new LatLng(6.717989401, 79.93309889),"Date " +i,"Contact "+i,"Rating "+i);
            vetArrayList.add(news);
        }
    }
}