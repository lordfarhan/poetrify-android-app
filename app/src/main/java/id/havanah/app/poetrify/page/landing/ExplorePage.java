package id.havanah.app.poetrify.page.landing;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.lib.materialsearchview.MaterialSearchView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by farhan at 12:42
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class ExplorePage extends Fragment {

  MaterialSearchView searchView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.page_explore, container, false);

    setHasOptionsMenu(true);
    Toolbar toolbar = view.findViewById(R.id.toolbar_explore);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

    // Search view
    searchView = view.findViewById(R.id.materialSearchView_explore);
    searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        //Do some magic
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        //Do some magic
        return false;
      }
    });
    searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
      @Override
      public void onSearchViewShown() {
        //Do some magic
        Toast.makeText(getContext(), "Search view opened", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onSearchViewClosed() {
        //Do some magic
        Toast.makeText(getContext(), "Search view closed", Toast.LENGTH_SHORT).show();
      }
    });
    searchView.setVoiceSearch(true);

    return view;
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    inflater.inflate(R.menu.explore_menu, menu);
    MenuItem item = menu.findItem(R.id.action_search);
    searchView.setMenuItem(item);
    super.onCreateOptionsMenu(menu, inflater);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
      ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
      if (matches != null && matches.size() > 0) {
        String searchWrd = matches.get(0);
        if (!TextUtils.isEmpty(searchWrd)) {
          searchView.setQuery(searchWrd, false);
        }
      }

      return;
    }
    super.onActivityResult(requestCode, resultCode, data);
  }
}
