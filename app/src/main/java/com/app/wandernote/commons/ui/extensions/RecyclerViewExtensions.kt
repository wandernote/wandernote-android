package com.app.wandernote.commons.ui.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val RecyclerView.linearLayoutManager: LinearLayoutManager?
    get() = layoutManager as? LinearLayoutManager
