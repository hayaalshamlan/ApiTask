package com.joincoded.apitask.Composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.joincoded.apitask.Model.Pet
import com.joincoded.apitask.ViewModel.PetsViewModel
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun PetListScreen(modifier: Modifier = Modifier,  viewModel: PetsViewModel = viewModel()){
    val pets = viewModel.pets

    LazyColumn(modifier = modifier) {
        items(pets) { pets ->
            PetItem(pets)
        }
    }
}