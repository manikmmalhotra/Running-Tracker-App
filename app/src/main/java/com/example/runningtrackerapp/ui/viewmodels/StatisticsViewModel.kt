package com.example.runningtrackerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtrackerapp.repostry.MainRepostory

class StatisticsViewModel @ViewModelInject constructor(
    val mainRepostory: MainRepostory
) : ViewModel() {

    val totalTimeRun = mainRepostory.getTotalTimeInMIlls()
    val totalDistance = mainRepostory.getTotalDistance()
    val totalCaloriesBurned = mainRepostory.getTotalCalories()
    val totalAvgSpeed = mainRepostory.getTotalAvgSpeed()

    val runSortedByDate = mainRepostory.getAllRunSortedByDate()

}