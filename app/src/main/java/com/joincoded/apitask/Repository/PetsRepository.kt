package com.joincoded.apitask.Repository

import com.joincoded.apitask.InterfaceAPi.PetsApiService

class PetsRepository(private val api: PetsApiService) {
    suspend fun getAllPets() = api.getAllPets()
}