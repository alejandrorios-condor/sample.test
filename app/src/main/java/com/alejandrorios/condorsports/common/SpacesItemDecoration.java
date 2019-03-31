package com.alejandrorios.condorsports.common;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
	private final int mSpace;

	public SpacesItemDecoration(final int space) {
		this.mSpace = space;
	}

	@Override
	public void getItemOffsets(final Rect outRect, final View view, final RecyclerView parent, final RecyclerView.State state) {
		outRect.left = mSpace;
		outRect.right = mSpace;
		outRect.bottom = mSpace;

		// Add top margin only for the first item to avoid double space between items
		if (parent.getChildAdapterPosition(view) == 0)
			outRect.top = mSpace;
	}
}
