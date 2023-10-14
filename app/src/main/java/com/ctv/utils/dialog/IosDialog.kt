package com.ctv.utils.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ctv.utils.R


class IosDialog(
    context: Context?,
    cancelListener: CancelListener,
    confirmListener: ConfirmListener,
    private val dContext: Context? = context
) : Dialog(
    context!!), View.OnClickListener {
    private var dialogTitle: TextView? = null
    private var dialogContext: TextView? = null
    private var dialogCancel: TextView? = null
    private var dialogConfirm: TextView? = null
    private var confirmListener: ConfirmListener? = confirmListener
    private var cancelListener: CancelListener? = cancelListener


    interface ConfirmListener {
        fun remoteControlDialogConfirm()
    }

    interface CancelListener {
        fun remoteControlDialogCancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ios_dialog)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        initViews()
    }

    override fun show() {
        super.show()
        dialogTitle!!.text =  dContext?.getString(R.string.ios_dialog_tip)
        dialogContext!!.text = dContext?.getString(R.string.ios_dialog_context)
        dialogCancel!!.text = dContext?.getString(R.string.ios_dialog_cancel)
        dialogConfirm!!.text = dContext?.getString(R.string.ios_dialog_confirm)
    }

    private fun initViews() {
        dialogTitle = findViewById(R.id.dialog_title)
        dialogContext = findViewById(R.id.dialog_context)
        dialogCancel = findViewById(R.id.dialog_cancel)
        dialogConfirm = findViewById(R.id.dialog_confirm)
        dialogCancel?.setOnClickListener(this)
        dialogConfirm?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.dialog_confirm -> {
                confirmListener!!.remoteControlDialogConfirm()
                dismiss()
            }
            R.id.dialog_cancel -> {
                cancelListener!!.remoteControlDialogCancel()
                dismiss()
            }
            else -> {}
        }
    }
}