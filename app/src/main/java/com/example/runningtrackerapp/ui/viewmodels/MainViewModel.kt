package com.example.runningtrackerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repostry.MainRepostory

class MainViewModel @ViewModelInject constructor(
    val mainRepostory: MainRepostory
) : ViewModel() {
}