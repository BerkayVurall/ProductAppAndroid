package com.utarit.bayindirhastanesimobil.constants.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.widget.AppCompatImageView
import com.berkay.productapp.R
import com.bumptech.glide.Glide

class LoadingDialog(context: Context, cancelable: Boolean) {
    private var dialog: Dialog
    private var imgProgressBar: AppCompatImageView

    init {
        dialog = Dialog(context)
        dialog.setContentView(R.layout.progress_layout)
        dialog.setCancelable(cancelable)
        imgProgressBar = dialog.findViewById(R.id.img_anim)
        Glide.with(context).asGif().load(R.raw.loading).into(imgProgressBar)
    }

    fun getLoading(): Dialog {
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}