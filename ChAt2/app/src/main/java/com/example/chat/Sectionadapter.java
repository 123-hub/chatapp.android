package com.example.chat;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class Sectionadapter extends FragmentPagerAdapter {

    public Sectionadapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                requestfrag requestFragment = new requestfrag();
                return requestFragment;
            case 1:
                chatfrag chatfragment = new chatfrag();
                return chatfragment;
            case 2:
                frindfrg friendfragment = new frindfrg();
                return friendfragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:

                return "ReQuEsT";
            case 1:

                return "ChAt";
            case 2:

                return "FrIeNd";
            default :
                return null;
        }

}}
