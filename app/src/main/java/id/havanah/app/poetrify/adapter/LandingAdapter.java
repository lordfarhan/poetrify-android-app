package id.havanah.app.poetrify.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import id.havanah.app.poetrify.fragment.ActivityFragment;
import id.havanah.app.poetrify.fragment.CreateFragment;
import id.havanah.app.poetrify.fragment.HomeFragment;
import id.havanah.app.poetrify.fragment.ProfileFragment;
import id.havanah.app.poetrify.fragment.SearchFragment;

/**
 * Created by farhan at 21:39
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class LandingAdapter extends FragmentPagerAdapter {

  private int size;

  public LandingAdapter(FragmentManager fm, int size) {
    super(fm);
    this.size = size;
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return new HomeFragment();
      case 1:
        return new SearchFragment();
      case 2:
        return new CreateFragment();
      case 3:
        return new ActivityFragment();
      case 4:
        return new ProfileFragment();
    }
    return null;
  }

  @Override
  public int getCount() {
    return size;
  }
}
