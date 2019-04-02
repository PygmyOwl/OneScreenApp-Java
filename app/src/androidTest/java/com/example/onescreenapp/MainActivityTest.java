package com.example.onescreenapp;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    int numFromTV;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void plusThreeTest() {
        ViewInteraction teamAPlus3Button = onView(withId(R.id.plus3Abutton));
        teamAPlus3Button.perform(click());
        onView(withId(R.id.TeamAScore)).check(matches(withText("3")));

        ViewInteraction teamBPlus3Button = onView(withId(R.id.plus3Bbutton));
        teamBPlus3Button.perform(click());
        onView(withId(R.id.TeamBScore)).check(matches(withText("3")));
    }

    @Test
    public void plusTwoTest() {
        ViewInteraction teamAPlus2Button = onView(withId(R.id.plus2Abutton));
        teamAPlus2Button.perform(click());
        onView(withId(R.id.TeamAScore)).check(matches(withText("2")));

        ViewInteraction teamBPlus2Button = onView(withId(R.id.plus2Bbutton));
        teamBPlus2Button.perform(click());
        onView(withId(R.id.TeamBScore)).check(matches(withText("2")));
    }

    @Test
    public void resetScoreTest() {
        ViewInteraction resetButton = onView(withId(R.id.resetButton));
        resetButton.perform(click());
        onView(withId(R.id.TeamAScore)).check(matches(withText("0")));
        onView(withId(R.id.TeamBScore)).check(matches(withText("0")));
    }

    @Test
    public void checkFreeAThrow() {
        int numBeforeClick;
        int numAfterClick;
        int freeThrowPoints;
        for (int i = 0; i < 31; i++) {
            getNumFromTV(1);
            numBeforeClick = numFromTV;
            ViewInteraction freeThrowButton = onView(withId(R.id.freeBthrow));
            freeThrowButton.perform(click());
            getNumFromTV(1);
            numAfterClick = numFromTV;
            freeThrowPoints = numAfterClick - numBeforeClick;
            Log.d("MyApp","" + freeThrowPoints);
            if(freeThrowPoints < 0 && freeThrowPoints > 3) {
                onView(withId(R.id.TeamBScore)).check(matches(withText("0")));
            }
        }
    }

    @Test
    public void checkFreeBThrow() {
        int numBeforeClick;
        int numAfterClick;
        int freeThrowPoints;
        for (int i = 0; i < 31; i++) {
            getNumFromTV(2);
            numBeforeClick = numFromTV;
            ViewInteraction freeThrowButton = onView(withId(R.id.freeAthrow));
            freeThrowButton.perform(click());
            getNumFromTV(2);
            numAfterClick = numFromTV;
            freeThrowPoints = numAfterClick - numBeforeClick;
            Log.d("MyApp","" + freeThrowPoints);
            if(freeThrowPoints < 0 && freeThrowPoints > 3) {
                onView(withId(R.id.TeamBScore)).check(matches(withText("0")));
            }
        }
    }

    private void getNumFromTV(int flag) {
        int scoreID = 0;
        if (flag == 1) {
            scoreID = R.id.TeamAScore;
        } else if(flag == 2) {
            scoreID = R.id.TeamBScore;
        }
        onView(withId(scoreID)).check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                String score = ((TextView) view).getText().toString();
                numFromTV = Integer.parseInt(score);
            }
        });
    }

}
