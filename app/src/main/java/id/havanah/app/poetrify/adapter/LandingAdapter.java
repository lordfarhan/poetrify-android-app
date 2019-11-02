package id.havanah.app.poetrify.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import id.havanah.app.poetrify.page.landing.ActivityPage;
import id.havanah.app.poetrify.page.landing.CreatePage;
import id.havanah.app.poetrify.page.landing.ExplorePage;
import id.havanah.app.poetrify.page.landing.HomePage;
import id.havanah.app.poetrify.page.landing.ProfilePage;

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
        return new HomePage();
      case 1:
        return new ExplorePage();
      case 2:
        return new CreatePage();
      case 3:
        return new ActivityPage();
      case 4:
        return new ProfilePage();
    }
    return null;
  }

  @Override
  public int getCount() {
    return size;
  }
}
