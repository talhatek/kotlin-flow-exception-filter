package live.tek.flow_exceptionhandler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import live.tek.flow_exceptionhandler.model.AirPlane
import live.tek.flow_exceptionhandler.network.Resource
import live.tek.flow_exceptionhandler.network.ServiceBuilder

class MainActivityViewModel : ViewModel() {
    private val _result: MutableLiveData<AirPlane> = MutableLiveData()
    val result: LiveData<AirPlane>
        get() = _result

    suspend fun getAirplaneById(id: String) = flow<Resource<AirPlane>> {
        val tmp = ServiceBuilder.airplanesApi.getAirPlaneById(id = id)
        emit(Resource.Success(tmp))
    }.onStart {
        emit(Resource.Loading(true))
    }.flowOn(Dispatchers.IO)

}