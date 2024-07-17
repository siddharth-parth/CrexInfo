package com.example.crexinfo.helper

import android.content.Context
import android.util.TypedValue
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

object ViewHelper {

    // returns shimmer drawable
    fun getShimmer(): ShimmerDrawable {
        val shimmer =
            Shimmer.AlphaHighlightBuilder() // The attributes for a ShimmerDrawable is set by this builder
                .setDuration(1000) // how long the shimmering animation takes to do one full sweep
                .setBaseAlpha(0.9f) //the alpha of the underlying children
                .setHighlightAlpha(0.8f) // the shimmer alpha amount
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setAutoStart(true)
                .build()

        // This is the placeholder for the imageView
        val shimmerDrawable = ShimmerDrawable().apply {
            setShimmer(shimmer)
        }
        return shimmerDrawable
    }

    fun pxToDp(context: Context, px: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px,
            context.resources.displayMetrics
        ).toInt()
    }
}