package com.kabouzeid.gramophone
import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import java.util.*
import java.util.EnumSet.allOf



class en_nexus_5_emulator_tests {
    @get:Rule
    var activityTestRule = ActivityTestRule(com.kabouzeid.gramophone.ui.activities.MainActivity::class.java)

    @Test
    fun check_add_to_playlist(){
        //code
    }
    fun delete_from_playlist(){
        //code
    }
}