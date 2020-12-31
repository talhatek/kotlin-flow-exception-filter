package live.tek.flow_exceptionhandler.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import live.tek.flow_exceptionhandler.R

fun Context.showSimpleErrorDialog(
    cancelable: Boolean = false,
    cancelableTouchOutside: Boolean = false,
    errorName: String,

    ) {
    val builder = AlertDialog.Builder(this, R.style.ThemeOverlay_MaterialComponents_Dialog)
    builder.setNeutralButton(
        "Okay"
    ) { dialog, _ -> dialog.dismiss() }

    val dialog = builder.create()
    dialog.setCancelable(cancelable)
    dialog.setCanceledOnTouchOutside(cancelableTouchOutside)
    dialog.setTitle("Error")
    dialog.setMessage(errorName)
    dialog.show()

}