package com.example.receiptbudgeterapp.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.receiptbudgeterapp.R;
import com.example.receiptbudgeterapp.ui.main.ui.finance.FinanceFragment;
import com.example.receiptbudgeterapp.ui.main.ui.finance.FinanceDisplayFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        Log.e("wow", "this shit is retarded");
    }

    @Override
    public Fragment getItem(int position){
        Fragment fragment = null;
        Log.e("wow", "switching tabs now, jesus");
        switch (position)
        {
            case 0:
                fragment = FinanceFragment.newInstance();
                break;
            case 1:
                fragment = FinanceDisplayFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}