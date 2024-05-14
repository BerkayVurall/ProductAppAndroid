package com.utarit.bayindirhastanesimobil.constants.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.berkay.productapp.R
import com.bumptech.glide.Glide

class MessageDialog {
    private var dialog : Dialog
    private var image: ImageView
    private var header : TextView
    private var body : TextView
    private var btnTamam : Button

    constructor(context : Context, pozitif : Boolean, head: String, desc : String){
        dialog = Dialog(context)
        dialog.setContentView(R.layout.message_dialog)
        dialog.setCancelable(true)
        image = dialog.findViewById(R.id.message_Dialog_Img)
        header = dialog.findViewById(R.id.message_Dialog_Header)
        body = dialog.findViewById(R.id.message_Dialog_Body)
        btnTamam = dialog.findViewById<Button>(R.id.message_Dialog_Button_Tamam)
        if(desc.contains("Failed to connect to")){
            body.text = "İnternet bağlantısı yok ya da servise ulaşılamıyor. Lütfen bağlantınızın var olduğundan emin olup tekrar deneyiniz."
        }else{
            body.text = desc
        }
        if (pozitif) {
            Glide.with(context).asBitmap().load(R.drawable.pozitif).into(image)
            header.text = head
            header.setTextColor(Color.parseColor("#44BD32"))
        } else {
            Glide.with(context).asBitmap().load(R.drawable.negatif).into(image)
            header.text = head
            header.setTextColor(Color.parseColor("#D20000"))
        }

        btnTamam.setBackgroundColor(Color.parseColor("#0057B8"))
        btnTamam.setOnClickListener(View.OnClickListener { dialog.dismiss() })
    }

    constructor(
        context: Context,
        pozitif: Boolean,
        head: String,
        desc: String,
        buttonText: String
    ) {
        dialog = Dialog(context)
        dialog.setContentView(R.layout.message_dialog)
        dialog.setCancelable(true)
        image = dialog.findViewById(R.id.message_Dialog_Img)
        header = dialog.findViewById(R.id.message_Dialog_Header)
        body = dialog.findViewById(R.id.message_Dialog_Body)
        btnTamam = dialog.findViewById<Button>(R.id.message_Dialog_Button_Tamam)
        if(desc.contains("Failed to connect to")){
            body.text = "İnternet bağlantısı yok ya da servise ulaşılamıyor. Lütfen bağlantınızın var olduğundan emin olup tekrar deneyiniz."
        }else{
            body.text = desc
        }
        btnTamam.text = buttonText
        header.text = head
        if (pozitif) {
            Glide.with(context).asBitmap().load(R.drawable.pozitif).into(image)
            header.setTextColor(Color.parseColor("#44BD32"))
        } else {
            Glide.with(context).asBitmap().load(R.drawable.negatif).into(image)
            header.setTextColor(Color.parseColor("#D20000"))
        }


        btnTamam.setBackgroundColor(Color.parseColor("#0057B8"))
        btnTamam.setOnClickListener(View.OnClickListener { dialog.dismiss() })
    }

    constructor(
        context: Context?,
        pozitif: Boolean,
        head: String,
        desc: String,
        clickListener: View.OnClickListener?
    ) {
        dialog = Dialog(context!!)
        dialog.setContentView(R.layout.message_dialog)
        dialog.setCancelable(true)
        image = dialog.findViewById(R.id.message_Dialog_Img)
        header = dialog.findViewById(R.id.message_Dialog_Header)
        body = dialog.findViewById(R.id.message_Dialog_Body)
        btnTamam = dialog.findViewById<Button>(R.id.message_Dialog_Button_Tamam)
        if(desc.contains("Failed to connect to")){
            body.text = "İnternet bağlantısı yok ya da servise ulaşılamıyor. Lütfen bağlantınızın var olduğundan emin olup tekrar deneyiniz."
        }else{
            body.text = desc
        }
        if (pozitif) {
            Glide.with(context).asBitmap().load(R.drawable.pozitif).into(image)
            header.text = head
            header.setTextColor(Color.parseColor("#44BD32"))
        } else {
            Glide.with(context).asBitmap().load(R.drawable.negatif).into(image)
            header.text = head
            header.setTextColor(Color.parseColor("#D20000"))
        }
        btnTamam.setBackgroundColor(Color.parseColor("#0057B8"))
        btnTamam.setOnClickListener(clickListener)
    }

    constructor(
        context: Context?,
        pozitif: Boolean,
        head: String,
        desc: String,
        buttonText: String,
        clickListener: View.OnClickListener?
    ) {
        dialog = Dialog(context!!)
        dialog.setContentView(R.layout.message_dialog)
        dialog.setCancelable(true)
        image = dialog.findViewById(R.id.message_Dialog_Img)
        header = dialog.findViewById(R.id.message_Dialog_Header)
        body = dialog.findViewById(R.id.message_Dialog_Body)
        btnTamam = dialog.findViewById<Button>(R.id.message_Dialog_Button_Tamam)
        if(desc.contains("Failed to connect to")){
            body.text = "İnternet bağlantısı yok ya da servise ulaşılamıyor. Lütfen bağlantınızın var olduğundan emin olup tekrar deneyiniz."
        }else{
            body.text = desc
        }
        btnTamam.text = buttonText
        header.text = head
        if (pozitif) {
            Glide.with(context).asBitmap().load(R.drawable.pozitif).into(image)
            header.setTextColor(Color.parseColor("#44BD32"))
        } else {
            Glide.with(context).asBitmap().load(R.drawable.negatif).into(image)
            header.setTextColor(Color.parseColor("#D20000"))
        }
        btnTamam.setBackgroundColor(Color.parseColor("#0057B8"))
        btnTamam.setOnClickListener(clickListener)
    }


    fun getDialog(): Dialog {
        val window = dialog.window
        window!!.setGravity(Gravity.BOTTOM)
        window.setBackgroundDrawableResource(R.drawable.message_background)
        window.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        return dialog
    }

}