package live.tek.flow_exceptionhandler.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ServiceBuilder {
    companion object {
        val airplanesApi: AirPlanesEndPoints by lazy {
            return@lazy getRetrofit().create(AirPlanesEndPoints::class.java)
        }

        @Volatile
        private var INSTANCE: Retrofit? = null

        private fun getRetrofit(): Retrofit {

            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl("https://api.instantwebtools.net/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().addInterceptor(ExceptionInterceptor()).build())
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}