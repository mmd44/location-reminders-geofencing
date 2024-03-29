package com.udacity.project4.locationreminders.data

import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result

//Use FakeDataSource that acts as a test double to the LocalDataSource
class FakeDataSource (var reminders: MutableList<ReminderDTO>? = mutableListOf()) : ReminderDataSource {

    // TODO: Create a fake data source to act as a double to the real data source

    override suspend fun getReminders(): Result<List<ReminderDTO>> {
        // TODO("Return the reminders")
        reminders?.let { return Result.Success(ArrayList(it)) }
        return Result.Error(
            "Reminders not found", -1)
    }

    override suspend fun saveReminder(reminder: ReminderDTO) {
        // TODO("save the reminder")
        reminders?.add(reminder)
    }

    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        // TODO("return the reminder with the id")
        val reminder = reminders?.find {
            reminderDTO -> reminderDTO.id == id
        }
        reminder?.let {
            return Result.Success(it)
        }
        return Result.Error(
                "Reminder with id $id not found", -1)
    }

    override suspend fun deleteAllReminders() {
        reminders?.clear()
    }


}