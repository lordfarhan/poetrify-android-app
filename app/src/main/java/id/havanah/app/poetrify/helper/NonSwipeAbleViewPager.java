package id.havanah.app.poetrify.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

/**
 * Created by farhan at 21:47
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class NonSwipeAbleViewPager extends ViewPager {
  public NonSwipeAbleViewPager(Context context) {
    super(context);
    setScroller();
  }

  public NonSwipeAbleViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
    setScroller();
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent event) {
    // Never allow swiping to switch between pages
    return false;
  }

  @SuppressLint("ClickableViewAccessibility")
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    // Never allow swiping to switch between pages
    return false;
  }

  //down one is added for smooth scrolling

  private void setScroller() {
    try {
      Class<?> viewpager = ViewPager.class;
      Field scroller = viewpager.getDeclaredField("mScroller");
      scroller.setAccessible(true);
      scroller.set(this, new ExtendedScroller(getContext()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public class ExtendedScroller extends Scroller {
    ExtendedScroller(Context context) {
      super(context, new DecelerateInterpolator());
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
      super.startScroll(startX, startY, dx, dy, 350 /*1 secs*/);
    }
  }
}
