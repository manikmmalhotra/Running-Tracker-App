package com.example.runningtrackerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repostry.MainRepostory

class StatisticsViewModel @ViewModelInject constructor(
    val mainRepostory: MainRepostory
) : ViewModel() {
}