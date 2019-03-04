package com.carlosgub.resume.utils

import android.content.Context
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object Tools {

    fun displayImageOriginal(ctx: Context, img: ImageView, @DrawableRes drawable: Int) {
        try {
            Glide.with(ctx).load(drawable)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(img)
        } catch (e: Exception) {
        }

    }
}
