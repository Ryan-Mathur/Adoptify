package com.ryan.adoptify;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.ryan.adoptify.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void detailActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.searchLocation), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.searchLocation), isDisplayed()));
        appCompatEditText2.perform(replaceText("10010"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.searchButton), withText("Search"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.mainRecyclerView), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.detailImage),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.detailPetName), withText("Pet Name: Moira"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.detailAnimal), withText("Animal: Cat"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.detailBreed), withText("Breed:"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                2),
                        isDisplayed()));
        textView3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.detailStatus), withText("Adoptable: Ready For Adoption"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                3),
                        isDisplayed()));
        textView4.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.detailSex), withText("Sex: F"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                4),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.detailDescription), withText("Description: Hi, there... My name is Moira. I'm a 7 month old, black and white tuxedo stunner with pretty green eyes and white feet. I'm vetted, spayed and up-to-date with all my shots. Very sweet, too, as everyone who sees me tells me that. I had a home once but I was abandoned in the street. I don't know why. I was (and remain!) a good girl. I love my toys and like to be scratched under my chin. Who doesn't like that? I can be a bit shy at first but only wish for a chance in which to show my love and affection. I'm looking for a forever home; I won't ask for much. Food, a warm bed, a few toys and most importantly, a special someone to love me as much as I would love them. Could that special someone be you?\n\n\nIf you are interested in Moira, please call (917) 838-4093 or email nobodysbeez@gmail.com."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                5),
                        isDisplayed()));
        textView6.check(matches(isDisplayed()));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.detailDescription), withText("Description: Hi, there... My name is Moira. I'm a 7 month old, black and white tuxedo stunner with pretty green eyes and white feet. I'm vetted, spayed and up-to-date with all my shots. Very sweet, too, as everyone who sees me tells me that. I had a home once but I was abandoned in the street. I don't know why. I was (and remain!) a good girl. I love my toys and like to be scratched under my chin. Who doesn't like that? I can be a bit shy at first but only wish for a chance in which to show my love and affection. I'm looking for a forever home; I won't ask for much. Food, a warm bed, a few toys and most importantly, a special someone to love me as much as I would love them. Could that special someone be you?\n\n\nIf you are interested in Moira, please call (917) 838-4093 or email nobodysbeez@gmail.com."),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                5),
                        isDisplayed()));
        textView7.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.detailPhone), withText("Phone Number: null"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                6),
                        isDisplayed()));
        textView8.check(matches(isDisplayed()));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.detailEmail), withText("Contact Email: gothamcitykitties@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                7),
                        isDisplayed()));
        textView9.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.detailState), withText("State: NY"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                8),
                        isDisplayed()));
        textView10.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.detailCity), withText("City: New York"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                9),
                        isDisplayed()));
        textView11.check(matches(isDisplayed()));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.detailZip), withText("Zip: 10010"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class),
                                        1),
                                10),
                        isDisplayed()));
        textView12.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
