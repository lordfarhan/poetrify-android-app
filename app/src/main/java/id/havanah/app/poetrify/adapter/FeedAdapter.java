package id.havanah.app.poetrify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mancj.slideup.SlideUp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import id.havanah.app.poetrify.R;
import id.havanah.app.poetrify.helper.OnDoubleClickListener;
import id.havanah.app.poetrify.lib.shapeimageview.PorterShapeImageView;
import id.havanah.app.poetrify.model.Feed;

/**
 * Created by farhan at 0:12
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
  private Context context;
  private ArrayList<Feed> list;
  private SlideUp slideUp;
  private View dim, slideView, rootView;

  public FeedAdapter(Context context, ArrayList<Feed> list) {
    this.context = context;
    this.list = list;
  }

  public FeedAdapter(Context context, ArrayList<Feed> list, SlideUp slideUp, View dim, View slideView, View rootView) {
    this.context = context;
    this.list = list;
    this.slideUp = slideUp;
    this.dim = dim;
    this.slideView = slideView;
    this.rootView = rootView;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Feed feed = list.get(position);

    // Action button
    holder.actionMore.setOnClickListener(v -> Toast.makeText(context, "Show more", Toast.LENGTH_SHORT).show());
    holder.actionLike.setOnClickListener(v -> {
      holder.actionLike.setImageResource(R.drawable.ic_favorite_red_24dp);
      Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
    });
    // Comment trigger
//    if (slideUp != null) {
//    slideUp = new SlideUpBuilder(slideView)
//        .withListeners(new SlideUp.Listener.Events() {
//          @Override
//          public void onSlide(float percent) {
//            dim.setAlpha(1 - (percent / 100));
//          }
//
//          @Override
//          public void onVisibilityChanged(int visibility) {
//            if (visibility == View.VISIBLE){
//            }
//          }
//        })
//        .withStartGravity(Gravity.BOTTOM)
//        .withLoggingEnabled(true)
//        .withGesturesEnabled(true)
//        .withStartState(SlideUp.State.HIDDEN)
//        .withSlideFromOtherView(rootView)
//        .build();
//      holder.actionComment.setOnClickListener(v -> slideUp.show());
//    } else {
    holder.actionComment.setOnClickListener(v -> Toast.makeText(context, "Comment", Toast.LENGTH_SHORT).show());
//    }

    holder.actionShare.setOnClickListener(v -> Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show());
    holder.actionBookmark.setOnClickListener(v -> {
      holder.actionBookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
      Toast.makeText(context, "Bookmark", Toast.LENGTH_SHORT).show();
    });

    Picasso.get().load(feed.getUserAvatar()).into(holder.userAvatar);
    Picasso.get().load(feed.getFeedImage()).into(holder.feedImage);
    holder.feedImage.setOnClickListener(new OnDoubleClickListener() {
      @Override
      public void onDoubleClick() {
        holder.actionLike.setImageResource(R.drawable.ic_favorite_red_24dp);
        Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
      }
    });
    holder.username.setText(feed.getUsername());
    holder.likes.setText(feed.getLikes());
    if (!(feed.getCaption() == null)) {
      holder.captionUsername.setText(feed.getUsername());
      holder.caption.setText(feed.getCaption());
    }
    if (feed.getUpdated_at() == null) {
      holder.timestamp.setText(feed.getCreated_at());
    } else {
      holder.timestamp.setText(String.format("Edited %s", feed.getUpdated_at()));
    }
  }

  @Override
  public int getItemCount() {
    return list != null ? list.size() : 0;
  }

  public void swap(ArrayList list) {
    if (this.list != null) {
      this.list.clear();
      this.list.addAll(list);
    } else {
      this.list = list;
    }
    notifyDataSetChanged();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    CircleImageView userAvatar;
    PorterShapeImageView feedImage;
    TextView username, likes, captionUsername, caption, timestamp;
    ImageView actionMore, actionLike, actionComment, actionShare, actionBookmark;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      actionMore = itemView.findViewById(R.id.imageView_actionMore);
      actionLike = itemView.findViewById(R.id.imageView_actionLike);
      actionComment = itemView.findViewById(R.id.imageView_actionComment);
      actionShare = itemView.findViewById(R.id.imageView_actionShare);
      actionBookmark = itemView.findViewById(R.id.imageView_actionBookmark);

      userAvatar = itemView.findViewById(R.id.circleImageView_profileImage);
      feedImage = itemView.findViewById(R.id.porterShapeImageView_feed);
      username = itemView.findViewById(R.id.textView_username);
      likes = itemView.findViewById(R.id.textView_likes);
      captionUsername = itemView.findViewById(R.id.textView_captionName);
      caption = itemView.findViewById(R.id.textView_caption);
      timestamp = itemView.findViewById(R.id.textView_feedTimestamp);
    }
  }
}
