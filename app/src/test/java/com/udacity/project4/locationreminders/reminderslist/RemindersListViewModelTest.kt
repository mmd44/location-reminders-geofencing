package com.udacity.project4.locationreminders.reminderslist

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.udacity.project4.locationreminders.MainCoroutineRule
import com.udacity.project4.locationreminders.data.FakeDataSource
import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class RemindersListViewModelTest {

    //TODO: provide testing to the RemindersListViewModel and its live data objects (Done)

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Subject under test
    private lateinit var remindersViewModel: RemindersListViewModel

    private lateinit var remindersDataSource: FakeDataSource

    @Before
    fun setupViewModel() {
        // We initialise to 2 reminders
        remindersDataSource = FakeDataSource()
        val reminder1 = ReminderDTO ("Title1", "Description1", "Hospital", 33.196895, 35.415644)
        val reminder2 = ReminderDTO ("Title2", "Description2", "Post Office", 33.192554, 35.410779)

        runBlocking {
            remindersDataSource.saveReminder(reminder1)
            remindersDataSource.saveReminder(reminder2)
        }

        remindersViewModel =  RemindersListViewModel (getApplicationContext(), remindersDataSource)
    }

    @Test
    fun loadReminders(){
        remindersViewModel.loadReminders()
        assertThat(remindersViewModel.remindersList.getOrAwaitValue()?.size, `is`(2))
    }
}