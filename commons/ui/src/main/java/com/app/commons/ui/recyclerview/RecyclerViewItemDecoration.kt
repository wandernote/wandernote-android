package com.app.commons.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecoration(
    @VisibleForTesting(otherwise = PRIVATE)
    internal val spacingPx: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when (val layoutManager = parent.layoutManager) {
            is GridLayoutManager -> configSpacingForGridLayoutManager(
                outRect = outRect,
                layoutManager = layoutManager,
                position = parent.getChildViewHolder(view).adapterPosition,
                itemCount = state.itemCount
            )
            is LinearLayoutManager -> configSpacingForLinearLayoutManager(
                outRect = outRect,
                layoutManager = layoutManager,
                position = parent.getChildViewHolder(view).adapterPosition,
                itemCount = state.itemCount
            )
        }
    }

    private fun configSpacingForGridLayoutManager(
        outRect: Rect,
        layoutManager: GridLayoutManager,
        position: Int,
        itemCount: Int
    ) {
        val cols = layoutManager.spanCount
        val rows = if (itemCount % 2 == 0) itemCount / cols else itemCount / cols + 1

        outRect.top = spacingPx
        outRect.left = spacingPx
        outRect.right = if (position % cols == cols - 1) spacingPx else 0
        outRect.bottom = if (position / cols == rows - 1) spacingPx else 0
    }

    private fun configSpacingForLinearLayoutManager(
        outRect: Rect,
        layoutManager: LinearLayoutManager,
        position: Int,
        itemCount: Int
    ) {
        outRect.top = spacingPx
        outRect.left = spacingPx
        if (layoutManager.canScrollHorizontally()) {
            outRect.right = if (position == itemCount - 1) spacingPx else 0
            outRect.bottom = spacingPx
        } else if (layoutManager.canScrollVertically()) {
            outRect.right = spacingPx
            outRect.bottom = if (position == itemCount - 1) spacingPx else 0
        }
    }
}