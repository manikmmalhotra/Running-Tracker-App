package com.example.runningtrackerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runningtrackerapp.db.Run
import com.example.runningtrackerapp.others.SortType
import com.example.runningtrackerapp.repostry.MainRepostory
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val mainRepostory: MainRepostory
) : ViewModel() {

   private val runsSortedByDate = mainRepostory.getAllRunSortedByDate()
   private val runsSortedByDistance = mainRepostory.getAllRunSortedByDistance()
   private val runsSortedByCalories = mainRepostory.getAllRunSortedByCaloriesBurned()
   private val runsSortedByTIme = mainRepostory.getAllRunSortedByTimeInMlls()
   private val runsSortedByAvgSpeed = mainRepostory.getAllRunSortedByAvgSpeed()

    val runs = MediatorLiveData<List<Run>>()

    var sortType = SortType.DATE

    init {
        runs.addSource(runsSortedByDate){result ->
            if (sortType == SortType.DATE){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runsSortedByDistance){result ->
            if (sortType == SortType.DISTANCE){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runsSortedByCalories){result ->
            if (sortType == SortType.CALORIES_BURNED){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runsSortedByTIme){result ->
            if (sortType == SortType.RUNNING_TIME){
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runsSortedByAvgSpeed){result ->
            if (sortType == SortType.AVG_SPEED){
                result?.let { runs.value = it }
            }
        }
    }

    fun sortRuns(sortType: SortType) = when(sortType){
        SortType.DATE -> runsSortedByDate.value?.let { runs.value = it }
        SortType.DISTANCE -> runsSortedByDistance.value?.let { runs.value = it }
        SortType.AVG_SPEED -> runsSortedByAvgSpeed.value?.let { runs.value = it }
        SortType.CALORIES_BURNED -> runsSortedByCalories.value?.let { runs.value = it }
        SortType.RUNNING_TIME -> runsSortedByTIme.value?.let { runs.value = it }
    }.also {
        this.sortType = sortType
    }

    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepostory.insertRun(run)
    }
}