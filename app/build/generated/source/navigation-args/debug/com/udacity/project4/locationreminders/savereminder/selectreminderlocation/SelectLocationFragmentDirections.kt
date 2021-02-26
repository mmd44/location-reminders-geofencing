package com.udacity.project4.locationreminders.savereminder.selectreminderlocation

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.udacity.project4.R

class SelectLocationFragmentDirections private constructor() {
  companion object {
    fun toSaveReminderFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.to_saveReminderFragment)
  }
}
