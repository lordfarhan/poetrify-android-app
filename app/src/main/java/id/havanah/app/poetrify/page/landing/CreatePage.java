package id.havanah.app.poetrify.page.landing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import id.havanah.app.poetrify.R;

/**
 * Created by farhan at 23:13
 * on 25/10/2019.
 * Havanah Team, ID.
 */
public class CreatePage extends Fragment {
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.page_create, container, false);
    CardView toImageEditor = view.findViewById(R.id.cardView_toImageEditor);
    toImageEditor.setOnClickListener(v -> {

    });
    return view;
  }
}
