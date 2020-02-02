package `in`.trentweet.basetemplate.common

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ImageView.show() {
    visibility = View.VISIBLE
}

fun TextView.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}

fun ImageView.hide() {
    visibility = View.GONE
}

fun TextView.hide() {
    visibility = View.GONE
}

fun View.snackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackBar ->
        snackBar.setAction("Ok") {
            snackBar.dismiss()
        }
    }.show()
}
