package com.ctv.utils

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.ctv.utils.dialog.IosDialog

class MainActivity : AppCompatActivity(), IosDialog.CancelListener, IosDialog.ConfirmListener {
    private var context :Context?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        initData()
    }

    private fun initData() {
        val button1 = findViewById<Button>(R.id.dialog_button)
        button1.setOnClickListener {
            val iosDialog = IosDialog(context,this,this)
            iosDialog.show()
        }
    }

    override fun remoteControlDialogConfirm() {
        Toast.makeText(context,R.string.ios_dialog_tip_one,Toast.LENGTH_SHORT).show()
    }

    override fun remoteControlDialogCancel() {
        Toast.makeText(context,R.string.ios_dialog_tip_two,Toast.LENGTH_SHORT).show()
    }
}