package com.joincoded.apitask.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.apitask.InterfaceAPi.PetsApiService
import com.joincoded.apitask.Model.Pet
import com.joincoded.apitask.Repository.PetsRepository
import com.joincoded.apitask.Singelton.RetroFitHelper
import kotlinx.coroutines.launch

class PetsViewModel : ViewModel() {

    private val PetsApiService = RetroFitHelper.getInstance().create(PetsApiService::class.java)
    private val repository = PetsRepository(PetsApiService)


    var pets by mutableStateOf(listOf<Pet>())

    init {
        fetchPets()
    }

    private fun fetchPets() {
        viewModelScope.launch {
            try {
                pets = repository.getAllPets()
            } catch (e: Exception) {
            }
        }
    }

    fun addPet(pet: Pet) {
        viewModelScope.launch {
            try {
                var response = PetsApiService.addPet(pet)

                if (response.isSuccessful && response.body() != null) {
                } else {

                }
            } catch (e: Exception) {
            }
        }
    }

    fun deletePet(petID: Int) {
        viewModelScope.launch {
            try {
                val response = PetsApiService.deletePet(petID)
                if (response.isSuccessful) {
                }else{
                }
            } catch (e: Exception) {

            }
        }
    }
}


