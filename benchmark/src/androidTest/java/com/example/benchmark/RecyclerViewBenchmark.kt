package com.example.benchmark

import android.view.View
import android.view.ViewGroup
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.lifecycle.Lifecycle
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.mybenchmark.MainActivity
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RecyclerViewBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setup() {
        val scenario = activityScenarioRule.scenario
        scenario.moveToState(Lifecycle.State.RESUMED)
    }


    @UiThreadTest
    @Test
    fun scroll() {
        activityScenarioRule.scenario.onActivity {
            val recyclerView = it.mBinding.contentRv
            assertTrue("RecyclerView expected to have children", recyclerView.childCount > 0)
//            assertEquals("RecyclerView must have height = 1", 1, recyclerView.height)

            // RecyclerView has children, its items are attached, bound, and have gone through layout.
            // Ready to benchmark!
            benchmarkRule.measureRepeated {
                // Scroll RecyclerView by one item
                // this will synchronously execute: attach / detach(old item) / bind / layout
                recyclerView.scrollBy(0, recyclerView.getLastChild().height)
            }
        }

    }

    private fun ViewGroup.getLastChild(): View = getChildAt(childCount - 1)
}
