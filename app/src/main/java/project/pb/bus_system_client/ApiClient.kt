package project.pb.bus_system_client

import io.reactivex.Observable
import retrofit2.http.GET


interface ApiClient {

    @GET("/po adresieurl/map.json")
    fun getMap() : Observable<ClientResponseMap>
    @GET("/po adresieurl/rozkladjazdy.json")
    fun getRozklad() : Observable<ClientResponseRozkladJazdy>
}