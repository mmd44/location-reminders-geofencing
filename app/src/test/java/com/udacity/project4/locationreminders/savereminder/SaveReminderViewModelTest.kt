package com.udacity.project4.locationreminders.savereminder

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PointOfInterest
import com.udacity.project4.R
import com.udacity.project4.base.NavigationCommand
import com.udacity.project4.locationreminders.MainCoroutineRule
import com.udacity.project4.locationreminders.data.FakeDataSource
import com.udacity.project4.locationreminders.getOrAwaitValue
import com.udacity.project4.locationreminders.reminderslist.ReminderDataItem
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SaveReminderViewModelTest {

    //TODO: provide testing to the SaveReminderView and its live data objects (Done)

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Subject under test
    private lateinit var saveRemindersViewModel: SaveReminderViewModel

    private lateinit var remindersDataSource: FakeDataSource

    private lateinit var reminderDataItem: ReminderDataItem

    @Before
    fun setupViewModel() {
        remindersDataSource = FakeDataSource()
        saveRemindersViewModel = SaveReminderViewModel(ApplicationProvider.getApplicationContext(), remindersDataSource)

        // Setup initial values
        val pointOfInterest = PointOfInterest(LatLng(33.208361, 35.418123), "poiID", "poiLocationName")
        reminderDataItem = ReminderDataItem("title", "description", "location", pointOfInterest.latLng.latitude, pointOfInterest.latLng.longitude)

        saveRemindersViewModel.reminderTitle.value = reminderDataItem.title
        saveRemindersViewModel.reminderDescription.value = reminderDataItem.description
        saveRemindersViewModel.reminderSelectedLocationStr.value = reminderDataItem.location
        saveRemindersViewModel.setPOI(pointOfInterest)
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun onClear_clearTasksSuccessful() {

        // Given a viewModel with values set
        // When the viewModel is cleared
        saveRemindersViewModel.onClear()

        // Then all values should be null
        assertThat(saveRemindersViewModel.reminderTitle.value, `is`(nullValue()))
        assertThat(saveRemindersViewModel.reminderDescription.value, `is`(nullValue()))
        assertThat(saveRemindersViewModel.reminderSelectedLocationStr.value, `is`(nullValue()))
        assertThat(saveRemindersViewModel.latitude.value, `is`(nullValue()))
        assertThat(saveRemindersViewModel.longitude.value, `is`(nullValue()))
        assertThat(saveRemindersViewModel.selectedPOI.value, `is`(nullValue()))
    }

    @Test
    fun validateEnteredData_failedValidation() {

        // Given some values not set
        reminderDataItem.title = null
        reminderDataItem.description = ""


        // When the reminder is validated
        // Then validation should return false
        assertThat(saveRemindersViewModel.validateEnteredData(reminderDataItem), `is`(false))
    }

    @Test
    fun validateEnteredData_successfulValidation() {

        // Given a complete reminder item
        // When the reminder is validated
        // Then validation should return true
        assertThat(saveRemindersViewModel.validateEnteredData(reminderDataItem), `is`(true))
    }

    @Test
    fun validateEnteredData_showSnackbarMissingTitle() {

        // Given some values not set
        reminderDataItem.title = null


        // When the reminder is validated
        saveRemindersViewModel.validateEnteredData(reminderDataItem)


        // Then validation should show a snackbar
        assertThat(saveRemindersViewModel.showSnackBarInt.getOrAwaitValue(), `is`(R.string.err_enter_title))
    }

    @Test
    fun saveReminder_loading() {
        // Pause dispatcher so you can verify initial values.
        mainCoroutineRule.pauseDispatcher()

        // Save the reminder
        saveRemindersViewModel.saveReminder(reminderDataItem)

        // Then assert that loading is shown
        assertThat(saveRemindersViewModel.showLoading.getOrAwaitValue(), `is`(true))

        // Execute pending coroutines actions
        mainCoroutineRule.resumeDispatcher()

        // Then assert that loading is gone
        assertThat(saveRemindersViewModel.showLoading.getOrAwaitValue(), `is`(false))
    }

    @Test
    fun saveReminder_complete() {

        // When reminder is saved
        saveRemindersViewModel.saveReminder(reminderDataItem)

        // Then assert that
        assertThat(saveRemindersViewModel.showToast.getOrAwaitValue(), `is`(getApplicationContext<Context>().getString(R.string.reminder_saved)))
        assertThat(saveRemindersViewModel.showLoading.getOrAwaitValue(), `is`(false))
        //assertThat(saveRemindersViewModel.navigationCommand.getOrAwaitValue(), `is` (NavigationCommand.Back))
        assertEquals(saveRemindersViewModel.navigationCommand.getOrAwaitValue(), NavigationCommand.Back)
    }

}