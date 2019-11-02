package id.havanah.app.poetrify.page.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.adapter.ProfileGridViewAdapter;
import id.havanah.app.poetrify.data.DummyData;
import id.havanah.app.poetrify.helper.GridSpaceItemDecoration;
import id.havanah.app.poetrify.model.Feed;

/**
 * Created by farhan at 18:35
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class GridViewPage extends Fragment {

  private RecyclerView gridView;
  private ArrayList<Feed> arrayList;
  private ProfileGridViewAdapter adapter;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.page_grid_view, container, false);

    // Setup grid
    Feed[] feeds = DummyData.getFeedList();
    gridView = view.findViewById(R.id.recyclerView_gridProfile);
    gridView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    gridView.addItemDecoration(new GridSpaceItemDecoration(getContext(), R.dimen.small_space));
    arrayList = new ArrayList<>();
    arrayList.addAll(Arrays.asList(feeds));
    adapter = new ProfileGridViewAdapter(getContext(), arrayList);
    gridView.setAdapter(adapter);

    return view;
  }
}
