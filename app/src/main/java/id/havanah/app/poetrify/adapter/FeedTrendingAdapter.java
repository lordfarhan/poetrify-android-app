package id.havanah.app.poetrify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.model.Feed;

/**
 * Created by farhan at 1:27
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class FeedTrendingAdapter extends RecyclerView.Adapter<FeedTrendingAdapter.ViewHolder> {

  private Context context;
  private ArrayList<Feed> list;

  public FeedTrendingAdapter(Context context, ArrayList<Feed> list) {
    this.context = context;
    this.list = list;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_trending_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Feed feed = list.get(position);
    Picasso.get().load(feed.getUserAvatar()).into(holder.profileImage);
    holder.username.setText(feed.getUsername());
  }

  @Override
  public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    private CircleImageView profileImage;
    private TextView username;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      profileImage = itemView.findViewById(R.id.circleImageView_profileImage);
      username = itemView.findViewById(R.id.textView_username);
    }
  }
}
