package id.havanah.app.poetrify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.lib.shapeimageview.PorterShapeImageView;
import id.havanah.app.poetrify.model.Feed;

/**
 * Created by farhan at 18:51
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class ProfileGridViewAdapter extends RecyclerView.Adapter<ProfileGridViewAdapter.ViewHolder> {
  private Context context;
  private ArrayList<Feed> list;

  public ProfileGridViewAdapter(Context context, ArrayList<Feed> list) {
    this.context = context;
    this.list = list;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_grid_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Feed feed = list.get(position);
    Picasso.get().load(feed.getFeedImage()).into(holder.imageView);
    holder.imageView.setOnClickListener(v -> Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show());
  }

  @Override
  public int getItemCount() {
    return list != null ? list.size() : 0;
  }


  public class ViewHolder extends RecyclerView.ViewHolder {
    private PorterShapeImageView imageView;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      imageView = itemView.findViewById(R.id.porterShapeImageView_profileGrid);
    }
  }
}
