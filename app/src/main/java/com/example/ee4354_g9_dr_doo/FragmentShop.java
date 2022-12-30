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
 * Use the {@link FragmentShop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentShop extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<CardShop> shopArrayList;
    private RecyclerView recyclerview;
    private String[] newsHeading;
    private AdapterShop.RecyclerViewClickListener listener;
    public FragmentShop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentShop.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentShop newInstance(String param1, String param2) {
        FragmentShop fragment = new FragmentShop();
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
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle SavedInstanceState){
        super.onViewCreated(view,SavedInstanceState);
        dataInitialize();
        setOnClickListener();
        recyclerview = view.findViewById(R.id.recyclerViewShop);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        AdapterShop myAdapter = new AdapterShop(getContext(),shopArrayList,listener);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
    private void setOnClickListener() {
        listener=new AdapterShop.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent =new Intent(getContext(),Activity_Inside_View.class);
                LatLng latLng = shopArrayList.get(position).getcLocation();
                intent.putExtra("Kind",3);  // just to identify the Care/Find/Vet/Shop
                intent.putExtra("Heading",shopArrayList.get(position).getcHeading());
                intent.putExtra("Lat",latLng.latitude);
                intent.putExtra("Lan",latLng.longitude);
                intent.putExtra("Name",shopArrayList.get(position).getcName());
                intent.putExtra("Contact",shopArrayList.get(position).getcContact());
                intent.putExtra("Image",shopArrayList.get(position).getcImage());

                startActivity(intent);
            }
        };
    }

    private void dataInitialize() {
        shopArrayList = new ArrayList<>();
        newsHeading = new String[]{
                "Shop",
                "LCDFF",
                "215",
                "sds",
                "5489",
                "ysdiso"
        };
        for(int i=0;i<newsHeading.length;i++ ){
            CardShop news = new CardShop(newsHeading[i],new LatLng(6.717989401, 79.93309889),"Date " +i,"Contact "+i,"");
            shopArrayList.add(news);
        }
    }
}