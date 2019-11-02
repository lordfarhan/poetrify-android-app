package id.havanah.app.poetrify.helper;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by farhan at 19:11
 * on 30/10/2019.
 * Havanah Team, ID.
 */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
  private int itemOffset;

  public GridSpaceItemDecoration(int itemOffset) {
    this.itemOffset = itemOffset;
  }

  public GridSpaceItemDecoration(@NonNull Context context, @DimenRes int itemOffset) {
    this(context.getResources().getDimensionPixelSize(itemOffset));
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);
    outRect.set(itemOffset, itemOffset, itemOffset, itemOffset);
  }
}
