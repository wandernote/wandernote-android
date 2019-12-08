package com.app.commons.ui.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.commons.ui.recyclerview.RecyclerViewItemDecoration

@BindingAdapter("itemDecorationSpacing")
fun RecyclerView.setItemDecorationSpacing(spacingPx: Float) {
    addItemDecoration(
        com.app.commons.ui.recyclerview.RecyclerViewItemDecoration(spacingPx.toInt())
    )
}