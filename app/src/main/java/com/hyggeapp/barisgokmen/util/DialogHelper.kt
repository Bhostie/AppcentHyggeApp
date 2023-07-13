package com.hyggeapp.barisgokmen.util

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.ui.fragments.ProductDetailFragmentDirections

class DialogHelper {

    fun createCustomDialog(
        context: Context,
        message: Int,
        navController: NavController
    ): AlertDialog {

        val dialogView = LayoutInflater.from(context).inflate(R.layout.custom_popup, null)
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()
        dialog.setCancelable(false)

        // Set transparent background
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Customize window attributes for dark and transparent background
        dialog.window?.apply {
            setDimAmount(0.6f)
        }
        // Find the message view inside the dialog
        val messageTextView = dialogView.findViewById<TextView>(R.id.tv_message)
        messageTextView.setText(message)

        // Find the button view inside the dialog
        val button = dialogView.findViewById<Button>(R.id.btn_back_to_main_menu)
        // Handle button click event
        button.setOnClickListener {
            dialog.dismiss()
            val action = ProductDetailFragmentDirections
                .actionProductDetailFragmentToProductListFragment()
            navController.navigate(action)
        }

        return dialog
    }
}