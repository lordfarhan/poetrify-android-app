package id.havanah.app.poetrify.page.landing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import id.havanah.app.poetrify.R;

/**
 * Created by farhan at 21:43
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class ActivityPage extends Fragment {
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.page_activity, container, false);
    return view;
  }
}
