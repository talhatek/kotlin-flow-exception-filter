package live.tek.flow_exceptionhandler.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import live.tek.flow_exceptionhandler.BaseActivity
import live.tek.flow_exceptionhandler.R
import live.tek.flow_exceptionhandler.network.Status
import live.tek.flow_exceptionhandler.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]


    }


    fun networkCall(@Suppress("UNUSED_PARAMETER") view: View) {

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getAirplaneById("trt").collect { resource ->
                when (resource.status) {
                    Status.LOADING -> Toast.makeText(
                        applicationContext,
                        "Loading",
                        Toast.LENGTH_SHORT
                    ).show()
                    Status.SUCCESS -> Toast.makeText(
                        applicationContext,
                        resource._data?.name,
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }

    }
}