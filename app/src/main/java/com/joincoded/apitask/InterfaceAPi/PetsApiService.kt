package com.joincoded.apitask.InterfaceAPi

import com.joincoded.apitask.Model.Pet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PetsApiService {

    @GET("Pets")
    suspend fun getAllPets(): List<Pet>

    @POST("Pets")
    suspend fun addPet(@Body pet: Pet) : Response<Pet>

    @DELETE("Pets/{petID}")
    suspend fun deletePet(@Path("petID") petID: Int): Response<Unit>
}