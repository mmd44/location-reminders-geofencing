package com.udacity.project4.locationreminders.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
//Unit test the DAO
@SmallTest
class RemindersDaoTest {

    //TODO: Add testing implementation to the RemindersDao.kt (Done)
    private lateinit var database: RemindersDatabase

    @Before
    fun initDb() {
        // Using an in-memory database so that the information stored here disappears when the
        // process is killed.
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RemindersDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() = database.close()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun saveReminderAndGetById() = runBlockingTest {

        // GIVEN we insert a reminder
        val reminder = ReminderDTO("title", "description", "location", 34.4536, 36.4523)
        database.reminderDao().saveReminder(reminder)

        // WHEN the reminder is retrieved by id from the database
        val loaded = database.reminderDao().getReminderById(reminder.id) as ReminderDTO

        // THEN the loaded data should contain the expected values
        assertThat<ReminderDTO>(loaded, IsNull.notNullValue())
        assertThat(loaded.id, `is`(reminder.id))
        assertThat(loaded.title, `is`(reminder.title))
        assertThat(loaded.description, `is`(reminder.description))
        assertThat(loaded.latitude, `is`(reminder.latitude))
        assertThat(loaded.longitude, `is`(reminder.longitude))
    }

    @Test
    fun getReminders() = runBlockingTest {

        // GIVEN we save some reminders
        val reminder = ReminderDTO("title", "description", "location", 31.4536, 31.4523)
        val reminder2 = ReminderDTO("title2", "description2", "location2", 32.4536, 32.4523)
        val reminder3 = ReminderDTO("title3", "description3", "location3", 33.4536, 33.4523)
        database.reminderDao().saveReminder(reminder)
        database.reminderDao().saveReminder(reminder2)
        database.reminderDao().saveReminder(reminder3)

        // WHEN we get all the reminders
        val remindersList = database.reminderDao().getReminders()

        // THEN the loaded list should be of size 3
        assertThat<Int>(remindersList.size, `is`(3))
    }

    @Test
    fun deleteAndGetReminders() = runBlockingTest {

        // GIVEN we save a reminder
        val reminder = ReminderDTO("title", "description", "location", 34.4536, 36.4523)
        database.reminderDao().saveReminder(reminder)

        // WHEN we delete all the reminders
        database.reminderDao().deleteAllReminders()
        val remindersList = database.reminderDao().getReminders()

        // THEN the loaded data should be an empty list
        assertThat<List<ReminderDTO>>(remindersList, `is`(emptyList()))
    }


}