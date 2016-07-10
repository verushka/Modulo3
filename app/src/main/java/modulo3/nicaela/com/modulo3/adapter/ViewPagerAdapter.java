package modulo3.nicaela.com.modulo3.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import modulo3.nicaela.com.modulo3.PostFragmnet;
import modulo3.nicaela.com.modulo3.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PostFragmnet();
            case 1:
                return new UserFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
