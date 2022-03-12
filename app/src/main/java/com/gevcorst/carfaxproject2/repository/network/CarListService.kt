package com.gevcorst.carfaxproject2.repository.network


import com.gevcorst.carfaxproject2.model.CarfaxJsonObject
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



private const val BASE_URL = "https://carfax-for-consumers.firebaseio.com"
/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface CarFaxJsonObjectAPIService {
    @GET("/assignment.json")
    suspend fun getCarFaxJsonObjets(): CarfaxJsonObject
}
object CarFaxObjectApi {
    val carFaxObjectRetrofitServices: CarFaxJsonObjectAPIService
            by lazy { retrofit.create(CarFaxJsonObjectAPIService::class.java) }
}
suspend fun allCarObjects():  CarfaxJsonObject = withContext(Dispatchers.Default) {
    val carfaxJsonObjectService = CarFaxObjectApi.carFaxObjectRetrofitServices
    val result = carfaxJsonObjectService.getCarFaxJsonObjets()
    result
}

