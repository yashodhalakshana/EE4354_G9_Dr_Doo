package com.example.ee4354_g9_dr_doo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return  new FragmentCare();
            case 1:
                return  new FragmentFind();
            case 2:
                return new FragmentVet();
            default:
                return  new FragmentShop();
        }
    }
    @Override
    public int getItemCount() {return 4; }
}