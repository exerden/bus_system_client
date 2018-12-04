package project.pb.bus_system_client

import android.app.Application
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    val TAG = javaClass.simpleName


    override fun onCreate() {
        super.onCreate()
        //TODO : add this to main activity
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://adresURL.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiMap = retrofit.create(ApiClient::class.java)
        apiMap.getMap()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                var clientResponseMap : ClientResponseMap = it
            },
                {

            })
    }
}