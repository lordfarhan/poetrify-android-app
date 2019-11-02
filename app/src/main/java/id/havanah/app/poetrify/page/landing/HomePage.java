package id.havanah.app.poetrify.page.landing;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.TextUtils;
import android.view.Gravity;
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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.slideup.SlideUp;
import com.mancj.slideup.SlideUpBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.adapter.FeedAdapter;
import id.havanah.app.poetrify.adapter.FeedTrendingAdapter;
import id.havanah.app.poetrify.data.DummyData;
import id.havanah.app.poetrify.helper.LinearSpaceItemDecoration;
import id.havanah.app.poetrify.lib.materialsearchview.MaterialSearchView;
import id.havanah.app.poetrify.model.Feed;

import static android.app.Activity.RESULT_OK;

/**
 * Created by farhan at 21:40
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class HomePage extends Fragment {

  MaterialSearchView searchView;
  RecyclerView trendingFeedRecyclerView;
  RecyclerView feedRecyclerView;
  FeedTrendingAdapter trendingFeedAdapter;
  FeedAdapter feedAdapter;
  ArrayList<Feed> trendingFeedArrayList;
  ArrayList<Feed> feedArrayList;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.page_home, container, false);

    Toolbar toolbar = view.findViewById(R.id.toolbar_home);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    setHasOptionsMenu(true);

    // Trending feed
    trendingFeedRecyclerView = view.findViewById(R.id.recyclerView_trendingFeed);
    trendingFeedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    trendingFeedRecyclerView.setItemAnimator(new DefaultItemAnimator());
    trendingFeedRecyclerView.addItemDecoration(new LinearSpaceItemDecoration(getContext(), R.dimen.medium_space, LinearSpaceItemDecoration.TYPE.HORIZONTAL));
    initTrendingFeed();
    trendingFeedAdapter = new FeedTrendingAdapter(getContext(), trendingFeedArrayList);
    trendingFeedRecyclerView.setAdapter(trendingFeedAdapter);

    // Feed
    feedRecyclerView = view.findViewById(R.id.recyclerView_feed);
    feedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    initFeed();
    feedAdapter = new FeedAdapter(getContext(), feedArrayList);
    feedRecyclerView.setAdapter(feedAdapter);

    return view;
  }

  private void initTrendingFeed() {
    trendingFeedArrayList = new ArrayList<>();
    Feed[] feeds = DummyData.getFeedList();
    trendingFeedArrayList.addAll(Arrays.asList(feeds));
  }

  private void initFeed() {
    feedArrayList = new ArrayList<>();
    Feed[] feeds = DummyData.getFeedList();
    feedArrayList.addAll(Arrays.asList(feeds));
  }
}
