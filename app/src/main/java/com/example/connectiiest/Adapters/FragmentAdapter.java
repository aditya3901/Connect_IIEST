package com.example.connectiiest.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.connectiiest.Fragments.ChatsFragment;
import com.example.connectiiest.Fragments.NewsFragment;
import com.example.connectiiest.Fragments.MemesFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new MemesFragment();
            case 1: return new NewsFragment();
            case 2: return new ChatsFragment();
            default: return new MemesFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position == 2){
            title = "USERS";
        }
        if(position == 0){
            title = "MEMES";
        }
        if(position == 1){
            title = "BLOG";
        }
        return title;
    }
}
