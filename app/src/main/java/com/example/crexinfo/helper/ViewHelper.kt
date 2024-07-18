package com.example.crexinfo.helper

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.widget.ImageView
import com.bumptech.glide.Glide
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

    // converts pixel to DP and returns the DP value
    fun pxToDp(context: Context, px: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px,
            context.resources.displayMetrics
        ).toInt()
    }

    /**
     * @param imageView: Image view where the image is to be loaded
     * @param src: Source for the image data. This can be a url, drawable, bitmap, resourceId, etc
     * @param placeholderDrawable: Drawable to be set as the placeholder till the image loads
     * */
    fun loadImage(
        imageView: ImageView,
        src: Any,
        placeholderDrawable: Drawable? = null
    ) {
        Glide.with(imageView.context)
            .load(src)
            .placeholder(placeholderDrawable)
            .into(imageView)
    }
}