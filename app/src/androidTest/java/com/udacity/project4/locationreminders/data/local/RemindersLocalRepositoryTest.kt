package com.udacity.project4.locationreminders.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.udacity.project4.locationreminders.data.ReminderDataSource
import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result
import com.udacity.project4.locationreminders.data.dto.Result.Success
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
//Medium Test to test the repository
@MediumTest
class RemindersLocalRepositoryTest : ReminderDataSource {

    //TODO: Add testing implementation to the RemindersLocalRepository.kt (Done)
    var testError = false

    var remindersServiceData: LinkedHashMap<String, ReminderDTO> = LinkedHashMap()

    private val observableReminders = MutableLiveData<Result<List<ReminderDTO>>>()

    suspend fun refreshReminders() {
        observableReminders.value = getReminders()
    }

    fun observeReminders(): LiveData<Result<List<ReminderDTO>>> {
        runBlocking { refreshReminders() }
        return observableReminders
    }

    fun addReminders (vararg reminders: ReminderDTO) {
        for (reminder in reminders) {
            remindersServiceData[reminder.id] = reminder
        }
        runBlocking { refreshReminders() }
    }

    override suspend fun getReminders(): Result<List<ReminderDTO>> {
        if (testError) return Result.Error("An error has occurred!")
        return Success(remindersServiceData.values.toList())
    }

    override suspend fun saveReminder(reminder: ReminderDTO) {
        remindersServiceData[reminder.id] = reminder
    }

    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        remindersServiceData[id]?.let {
            return Success(it)
        }
        return Result.Error("Not Found!")
    }

    override suspend fun deleteAllReminders() {
        remindersServiceData.clear()
    }
}