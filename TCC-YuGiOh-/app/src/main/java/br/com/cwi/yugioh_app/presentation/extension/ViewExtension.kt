package br.com.cwi.yugioh_app.presentation.extension

import android.view.View
import android.view.View.*

fun View.visibleOrGone(isVisible: Boolean) {
    visibility = if(isVisible) VISIBLE else GONE
}