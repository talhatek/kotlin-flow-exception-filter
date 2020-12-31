package live.tek.flow_exceptionhandler.network

import live.tek.flow_exceptionhandler.model.AirPlane
import retrofit2.http.GET
import retrofit2.http.Path

interface AirPlanesEndPoints {
    @GET("airlines/{id}")
    suspend fun getAirPlaneById(@Path("id") id: String): AirPlane
}