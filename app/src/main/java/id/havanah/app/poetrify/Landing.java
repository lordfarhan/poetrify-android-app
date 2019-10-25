package id.havanah.app.poetrify;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import id.havanah.app.poetrify.adapter.LandingAdapter;
import id.havanah.app.poetrify.helper.OnlyIconItemView;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * Created by farhan at 21:27
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class Landing extends AppCompatActivity {
  private PageNavigationView pageNavigationView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.landing);

//    pageNavigationView = findViewById(R.id.pageNavigationView_landing);
//    final NavigationController navigationController = pageNavigationView.custom()
//        .addItem(newItem(R.drawable.ic_home_gray_24dp, R.drawable.ic_home_primary_24dp, getResources().getString(R.string.home)))
//        .addItem(newItem(R.drawable.ic_timeline_gray_24dp, R.drawable.ic_timeline_primary_24dp, getResources().getString(R.string.activity)))
//        .addItem(newItem(R.drawable.ic_person_gray_24dp, R.drawable.ic_person_primary_24dp, getResources().getString(R.string.profile)))
//        .build();

//    final NavigationController navigationController = pageNavigationView.material()
//        .addItem(R.drawable.ic_home_gray_24dp, R.drawable.ic_home_primary_24dp, getResources().getString(R.string.home))
//        .addItem(R.drawable.ic_timeline_gray_24dp, R.drawable.ic_timeline_primary_24dp, getResources().getString(R.string.activity))
//        .addItem(R.drawable.ic_person_gray_24dp, R.drawable.ic_person_primary_24dp, getResources().getString(R.string.profile))
//        .setMode(MaterialMode.HIDE_TEXT)
//        .dontTintIcon()
//        .build();

    pageNavigationView = findViewById(R.id.pageNavigationView_landing);
    final NavigationController navigationController = pageNavigationView.custom()
        .addItem(newItem(R.drawable.ic_home_gray_24dp, R.drawable.ic_home_primary_24dp))
        .addItem(newItem(R.drawable.ic_search_gray_24dp, R.drawable.ic_search_primary_24dp))
        .addItem(newItem(R.drawable.ic_create_gray_24dp, R.drawable.ic_create_primary_24dp))
        .addItem(newItem(R.drawable.ic_timeline_gray_24dp, R.drawable.ic_timeline_primary_24dp))
        .addItem(newItem(R.drawable.ic_person_gray_24dp, R.drawable.ic_person_primary_24dp))
        .enableAnimateLayoutChanges()
        .build();

    LandingAdapter pagerAdapter = new LandingAdapter(getSupportFragmentManager(), navigationController.getItemCount());

    ViewPager viewPager = findViewById(R.id.viewPager_landing);
    navigationController.setupWithViewPager(viewPager);
    viewPager.setAdapter(pagerAdapter);
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i1) {
      }

      @Override
      public void onPageSelected(int i) {
      }

      @Override
      public void onPageScrollStateChanged(int i) {
      }
    });

    navigationController.setMessageNumber(1, 8);
    navigationController.setHasMessage(0, true);
    navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
      @Override
      public void onSelected(int index, int old) {
        navigationController.setHasMessage(index, false);
        navigationController.setMessageNumber(index, 0);
      }

      @Override
      public void onRepeat(int index) {
      }
    });
  }

  private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
    NormalItemView normalItemView = new NormalItemView(this);
    normalItemView.initialize(drawable, checkedDrawable, text);
    normalItemView.setTextDefaultColor(0x88CACACA);
    normalItemView.setTextCheckedColor(0x13D3B4);
    return normalItemView;
  }

  private BaseTabItem newItem(int drawable, int checkedDrawable) {
    OnlyIconItemView onlyIconItemView = new OnlyIconItemView(this);
    onlyIconItemView.initialize(drawable, checkedDrawable);
    return onlyIconItemView;
  }
}
