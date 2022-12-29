package com.example.ee4354_g9_dr_doo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ee4354_g9_dr_doo.databinding.ActivityMainTabBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainTabActivity extends AppCompatActivity {

    private ActivityMainTabBinding binding;
    private int currentPosition=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FloatingActionButton fab = binding.fab;
        TabLayout tabLayout = findViewById(R.id.tabs);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Im on tab " + currentPosition, Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
                Intent intent =new Intent(getApplicationContext(),Activity_Inside_Register.class);
                intent.putExtra("Kind",currentPosition+1);
                startActivity(intent);
            }
        });



        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("Care");
                                break;
                            case 1:
                                tab.setText("Find");
                                break;
                            case 3:
                                tab.setText("Vet");
                                break;
                            default:
                                tab.setText("Shop");
                                break;
                        }

                    }
                }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentPosition = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Nothing to do
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Nothing to do
            }
        });
    }


}