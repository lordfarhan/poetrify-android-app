package id.havanah.app.poetrify.page.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.helper.OnlyIconItemView;
import id.havanah.app.poetrify.page.profile.BookmarkPage;
import id.havanah.app.poetrify.page.profile.GridViewPage;
import id.havanah.app.poetrify.page.profile.ArchivePage;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * Created by farhan at 21:44
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class ProfilePage extends Fragment {

  private PageNavigationView pageNavigationView;
  private NavigationController navigationController;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.page_profile, container, false);

    pageNavigationView = view.findViewById(R.id.pageNavigationView_profile);
    navigationController = pageNavigationView.custom()
        .addItem(newItem(R.drawable.ic_grid_on_gray_24dp, R.drawable.ic_grid_on_primary_24dp))
        .addItem(newItem(R.drawable.ic_library_books_gray_24dp, R.drawable.ic_library_books_primary_24dp))
        .addItem(newItem(R.drawable.ic_collections_bookmark_gray_24dp, R.drawable.ic_collections_bookmark_primary_24dp))
        .enableAnimateLayoutChanges()
        .build();

    navigationController.setMessageNumber(1, 8);
    navigationController.setHasMessage(0, true);

    // Init fragment
    Fragment grid = new GridViewPage();
    Fragment list = new ArchivePage();
    Fragment bookmark = new BookmarkPage();
    FragmentManager fragmentManager = getFragmentManager();
    if (fragmentManager != null) {
      fragmentManager.beginTransaction().replace(R.id.relativeLayout_profileContainer, grid).commit();
    }

    navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
      @Override
      public void onSelected(int index, int old) {
        // Reset message
        navigationController.setHasMessage(index, false);
        navigationController.setMessageNumber(index, 0);

        // Switch fragment
        switch (index) {
          case 0:
            if (fragmentManager != null) {
              fragmentManager.beginTransaction().replace(R.id.relativeLayout_profileContainer, grid).commit();
            }
            break;
          case 1:
            if (fragmentManager != null) {
              fragmentManager.beginTransaction().replace(R.id.relativeLayout_profileContainer, list).commit();
            }
            break;
          case 2:
            if (fragmentManager != null) {
              fragmentManager.beginTransaction().replace(R.id.relativeLayout_profileContainer, bookmark).commit();
            }
            break;
        }
      }

      @Override
      public void onRepeat(int index) {
      }
    });

    return view;
  }

  private BaseTabItem newItem(int drawable, int checkedDrawable) {
    OnlyIconItemView onlyIconItemView = new OnlyIconItemView(getContext());
    onlyIconItemView.initialize(drawable, checkedDrawable);
    return onlyIconItemView;
  }
}
