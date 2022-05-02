package com.kabouzeid.gramophone

import android.app.Activity
import android.widget.PopupWindow
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.PressBackAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.PositionAssertions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.kabouzeid.gramophone.ui.activities.MainActivity
import org.hamcrest.Matchers.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.junit.Rule
import org.junit.Test
import java.util.*

/**********************************************************
 *
 *
 *
 * Before start app & start 1 track
 *
 *
 *
 * *******************************************************/


class test_playlist_create {

    val onboarding: String? = "GET STARTED"
    var menu_list = arrayOf("SONGS", "ALBUMS", "ARTISTS", "GENRES", "PLAYLISTS")

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)




    @Test
    fun run_in_first_tab() {
        for (i in menu_list.indices) {
            menu_list[i] = menu_list[i].toUpperCase()
            print(menu_list[i])
        }

        onView(withText(menu_list[2])).perform(click())
        onView(withText(menu_list[3])).perform(click())
        onView(withText(menu_list[4])).perform(click())
        onView(withText(menu_list[4])).check(matches(isDisplayed()))
    }
/*IF START WITH ONBOARDING TEST FAILS*/
    @Test
    fun skip_onboarding() {
        onView(withText("Get started")).check(matches(isDisplayed()))
    }


    @Test
    fun test_add_track_to_playlist() {
        /*
        APP RUNNING BEFORE
        ONBOARDING SKIPPED
        PlayList has created before
        Song body app
        Mini player display
         */

        val playlistname:String? = "HOLLY_MARY"
        val song_title:String? = "bad0"

        Thread.sleep(1000)
        onView(withId(R.id.mini_player_title)).perform(click())

        Thread.sleep(10000)


        //Dropdown is up BAD MATCHES
        onData(allOf())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(2)
                .perform(click())
        Thread.sleep(5000)
        onView(allOf(withId(R.id.md_title), withText(playlistname)))
                .perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText(menu_list[2])).perform(click())
        onView(withText(menu_list[3])).perform(click())
        onView(withText(menu_list[4])).perform(click())
        onView(withText(menu_list[4])).check(matches(isDisplayed()))
        onView(withText(playlistname)).perform(click())
        //need to write
        //onView(allOf(withId(R.id.title), withText(song_title))).check(matches(isDisplayed()))
        //check her with other matches




    }

    @Test

    fun test_delete_track_from_playlist(){
        onView(withText("HOLLY_MARY")).check(matches(isDisplayed()))
        onView(withText("HOLLY_MARY")).perform(click())
        Thread.sleep(5000)
        onData(allOf())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(0)
                .perform(click())
    }
    //Check is not displayed

    @Test
    fun test_cancel_rename_playlist(){

        var test_str:String? = "Test_rename"
        onView(withText("HOLLY_MARY")).check(matches(isDisplayed()))
        Thread.sleep(5000)
        //dropdown open
        onData(allOf())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(1)
                .perform(click())
        onView(withText("HOLLY_MARY")).perform(replaceText(test_str))
        onView(withText("CANCEL")).perform(click())
        Thread.sleep(1000)
        onView(withText("HOLLY_MARY")).check(matches(isDisplayed()))


    }


    @Test
    fun test_rename_playlist(){

        var test_str:String? = "Test_rename"
        onView(withText("HOLLY_MARY")).check(matches(isDisplayed()))
        Thread.sleep(5000)
        //dropdown open
        onData(allOf())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(4)
                .perform(click())
        onView(withText("HOLLY_MARY")).perform(replaceText(test_str))
        onView(withText("RENAME")).perform(click())
        Thread.sleep(1000)
        onView(withText(test_str)).check(matches(isDisplayed()))


    }

    @Test
    fun button_click(){
        onView(withText("Test_rename")).check(matches(isDisplayed()))
        Thread.sleep(5000)
        //dropdown open
        onData(allOf())
                .inRoot(RootMatchers.isPlatformPopup())
                .atPosition(5)
                .perform(click())

        onView(withText("DELETE"))
                .perform(click())
//NEED CONTROL WHAT IS NOT DISPLAYED
      //  onView(withId(R.id.title)).check(matches(not((hasDescendant(withText("Test_rename"))))))




    }

}