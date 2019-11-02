package id.havanah.app.poetrify.helper;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by farhan at 14:12
 * on 01/11/2019.
 * Havanah Team, ID.
 */
public class LinearSpaceItemDecoration extends RecyclerView.ItemDecoration {
  private final int itemOffset;
  private int type;
  private static final int HORIZONTAL = 0;
  private static final int VERTICAL = 1;

  public LinearSpaceItemDecoration(int itemOffset) {
    this.itemOffset = itemOffset;
  }

  public LinearSpaceItemDecoration(Context context, int itemOffset) {
    this(context.getResources().getDimensionPixelSize(itemOffset));
  }

  public LinearSpaceItemDecoration(int itemOffset, TYPE type) {
    this.itemOffset = itemOffset;
    switch (type) {
      case HORIZONTAL:
        this.type = HORIZONTAL;
        break;
      case VERTICAL:
        this.type = VERTICAL;
        break;
    }
  }

  public LinearSpaceItemDecoration(Context context, @DimenRes int itemOffset, TYPE type) {
    this(context.getResources().getDimensionPixelSize(itemOffset));
    switch (type) {
      case HORIZONTAL:
        this.type = HORIZONTAL;
        break;
      case VERTICAL:
        this.type = VERTICAL;
        break;
    }
  }

  public enum TYPE {
    HORIZONTAL, VERTICAL
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);

    // Apply offset only to first item
    if (type == HORIZONTAL) {
      if (parent.getChildAdapterPosition(view) == 0) {
        outRect.left += itemOffset;
      }
    } else if (type== VERTICAL) {
      outRect.set(itemOffset, itemOffset, itemOffset, itemOffset);
    } else {
      outRect.set(itemOffset, itemOffset, itemOffset, itemOffset);
    }
  }
}
