package com.udacity.project4.locationreminders.reminderslist

import android.app.Application
import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.udacity.project4.R
import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.local.RemindersLocalRepositoryTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
//UI Testing
@MediumTest
class ReminderListFragmentTest : AutoCloseKoinTest() {

    //TODO: test the navigation of the fragments. (Done)
    //TODO: test the displayed data on the UI. (Done)
    //TODO: add testing for the error messages. (Done)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var appContext: Application

    private val repository: RemindersLocalRepositoryTest by inject()

    val modules = module {
        stopKoin() // Stop the original app koin
        appContext = getApplicationContext()
        viewModel {
            RemindersListViewModel(
                appContext,
                get() as RemindersLocalRepositoryTest
            )
        }

        single { RemindersLocalRepositoryTest() }
    }

    @Before
    fun init() {
        startKoin {
            modules(listOf(modules))
        }
        repository.observeReminders()
    }

    @Test
    fun clickTask_verifyCountAndNavigateToNewReminderFragment() = runBlockingTest {

        repository.addReminders(ReminderDTO("title1", "description", "location", 34.4536, 36.4523))

        val navController = mock(NavController::class.java)

        // GIVEN - On the reminders list screen
        val scenario = launchFragmentInContainer<ReminderListFragment>(Bundle(), R.style.AppTheme)

        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        // THEN - Verify the items count
        onView(withId(R.id.reminders_recycler))
            .check(matches(hasChildCount(1)))

        // THEN - Verify that item exists with set text (workaround)
        onView(withId(R.id.reminders_recycler))
            .perform(
                RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText("description")), click()))


        // WHEN we click the add reminder button
        onView(withId(R.id.addReminderFAB))
            .perform(click())

        // THEN - Verify that we navigate to the add reminder screen
        verify(navController).navigate(
            ReminderListFragmentDirections.toSaveReminder())

    }

    @Test
    fun invalidateShowNoData_verifyNoDataDisplayed () {
        // GIVEN - On the reminders list screen with empty repo
        launchFragmentInContainer<ReminderListFragment>(Bundle(), R.style.AppTheme)

        // THEN - Verify that no reminders is shown and no error is shown
        onView(withText(R.string.no_data)).check(matches(isDisplayed()))
        onView(withText("An error has occurred!")).check(doesNotExist())
    }

    @Test
    fun showError_verifyAnErrorIsDisplayedWhenRepoReturnsAnError () {
        // GIVEN - On the reminders list screen with empty repo
        repository.testError = true
        launchFragmentInContainer<ReminderListFragment>(Bundle(), R.style.AppTheme)

        // THEN - Verify that a snackBar error is shown
        onView(withText("An error has occurred!")).check(matches(isDisplayed()))
    }

}