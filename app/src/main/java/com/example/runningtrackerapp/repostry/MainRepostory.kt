package com.example.runningtrackerapp.repostry

import com.example.runningtrackerapp.db.Run
import com.example.runningtrackerapp.db.RunDAO
import javax.inject.Inject

class MainRepostory @Inject constructor(
    var runDAO: RunDAO
) {

    suspend fun insertRun(run:Run) = runDAO.insertRun(run)
    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    fun getAllRunSortedByDate() = runDAO.getAllRunsSortedByDate()

    fun getAllRunSortedByDistance() = runDAO.getAllRunsSortedByDistance()

    fun getAllRunSortedByCaloriesBurned() = runDAO.getAllRunsSortedByCaloriesBurned()

    fun getAllRunSortedByAvgSpeed() = runDAO.getAllRunsSortedByAvgSpeed()

    fun getAllRunSortedByTimeInMlls() = runDAO.getAllRunsSortedByTimeInMills()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalCalories() = runDAO.getTotalCaloriesBurned()

    fun getTotalTimeInMIlls() = runDAO.getTotalTimeInMillis()
}