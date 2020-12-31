package live.tek.flow_exceptionhandler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import live.tek.flow_exceptionhandler.util.ContentException
import live.tek.flow_exceptionhandler.util.NoContextException
import live.tek.flow_exceptionhandler.util.showSimpleErrorDialog

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            if (e.cause is NoContextException) {
                runOnUiThread {
                    this.showSimpleErrorDialog(
                        cancelable = true,
                        cancelableTouchOutside = false,
                        errorName = ContentException
                    )

                }
            }
        }
    }
}