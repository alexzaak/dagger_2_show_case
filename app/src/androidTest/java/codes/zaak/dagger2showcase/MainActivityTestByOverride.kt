package codes.zaak.dagger2showcase

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import codes.zaak.dagger2showcase.di.DaggerTestAppComponent
import codes.zaak.dagger2showcase.main.di.TestMainModule
import codes.zaak.dagger2showcase.main.domain.GetHeroNamesUseCase
import codes.zaak.dagger2showcase.main.domain.GetSuperPowerUseCase
import codes.zaak.dagger2showcase.testutils.lazyActivityScenarioRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
class MainActivityTestByOverride {

    @get:Rule
    val scenarioRule = lazyActivityScenarioRule<MainActivity>(launchActivity = false)

    @get: Rule
    val testRule = ActivityTestRule(MainActivity::class.java, true, false)

    @MockK(relaxUnitFun = true)
    lateinit var getHeroNamesUseCase: GetHeroNamesUseCase

    @MockK(relaxUnitFun = true)
    lateinit var getSuperPowerUseCase: GetSuperPowerUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        every { getHeroNamesUseCase.execute() } returns "Test Hero"

        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App

        val testAppComponent =
            DaggerTestAppComponent
                .builder()
                .mainModule(TestMainModule(getHeroNamesUseCase))
                .build()

        app.appComponent = testAppComponent
    }

    @Test
    fun launchActivityByUsingActivityTestRule() {
        // Given
        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        testRule.launchActivity(intent)

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { getHeroNamesUseCase.execute() }
    }

    @Test
    fun launchActivityByUsingActivityScenarioRule() {
        // Given
        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        scenarioRule.launch(intent)

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { getHeroNamesUseCase.execute() }
    }

    @Test
    fun onRandomButtonClickGetHeroNameUseCaseIsCalled() {
        // Given
        every { getHeroNamesUseCase.execute() } returns "Test Hero"

        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App

        val testAppComponent =
            DaggerTestAppComponent
                .builder()
                .mainModule(TestMainModule(getHeroNamesUseCase = getHeroNamesUseCase))
                .build()

        app.appComponent = testAppComponent

        scenarioRule.launch()

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { getHeroNamesUseCase.execute() }
    }

    @Test
    fun onRandomButtonClickGetSuperPowerUseCaseIsCalled() {
        // Given
        every { getSuperPowerUseCase.execute() } returns "Test Super Power"

        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App

        val testAppComponent =
            DaggerTestAppComponent
                .builder()
                .mainModule(TestMainModule(getSuperPowerUseCase = getSuperPowerUseCase))
                .build()

        app.appComponent = testAppComponent

        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        scenarioRule.launch(intent)

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { getSuperPowerUseCase.execute() }
    }
}