package live.tek.flow_exceptionhandler.network

import android.util.Log
import live.tek.flow_exceptionhandler.util.NoContextException
import okhttp3.Interceptor
import okhttp3.Response

class ExceptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val result = chain.proceed(request)
        Log.e("request code", result.code.toString())

        if (result.code == 204)
            throw NoContextException()
        return result
    }
}