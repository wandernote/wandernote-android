package com.app.commons.views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.bottomappbar.BottomAppBar

class CustomBottomAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.bottomAppBarStyle
) : BottomAppBar(context, attrs, defStyleAttr) {

    private var onSlideDown: ((child: BottomAppBar?) -> Unit)? = null
    private var onSlideUp: ((child: BottomAppBar?) -> Unit)? = null
    private var behavior: Behavior? = null

    override fun getBehavior(): Behavior {
        if (behavior == null) {
            behavior = BottomAppBarBehavior()
        }
        return behavior!!
    }

    fun onSlideDown(listener: (BottomAppBar?) -> Unit) {
        onSlideDown = { listener(it) }
    }

    fun onSlideUp(listener: (BottomAppBar?) -> Unit) {
        onSlideUp = { listener(it) }
    }

    inner class BottomAppBarBehavior : Behavior() {

        override fun slideDown(child: BottomAppBar) {
            super.slideDown(child)
            onSlideDown?.invoke(child)
        }

        override fun slideUp(child: BottomAppBar) {
            super.slideUp(child)
            onSlideUp?.invoke(child)
        }
    }
}