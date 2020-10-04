package codes.zaak.dagger2showcase

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import codes.zaak.dagger2showcase.di.DaggerTestInjectionAppComponent
import codes.zaak.dagger2showcase.main.di.InjectableTestMainModule
import codes.zaak.dagger2showcase.main.domain.GetHeroNamesUseCase
import codes.zaak.dagger2showcase.main.domain.GetSuperPowerUseCase
import codes.zaak.dagger2showcase.testutils.lazyActivityScenarioRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@MediumTest
class MainActivityTestByInjection {

    @get:Rule
    val scenarioRule = lazyActivityScenarioRule<MainActivity>(launchActivity = false)

    @Inject
    lateinit var getHeroNamesUseCase: GetHeroNamesUseCase

    @Inject
    lateinit var getSuperPowerUseCase: GetSuperPowerUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App

        val testAppComponent = DaggerTestInjectionAppComponent
            .builder()
            .injectableTestMainModule(InjectableTestMainModule())
            .build()

        app.appComponent = testAppComponent
        testAppComponent.inject(this)

        every { getHeroNamesUseCase.execute() } returns "Super duper Hero"
        every { getSuperPowerUseCase.execute() } returns "Super duper test super power"
    }

    @Test
    fun onRandomButtonClickGetHeroNameUseCaseIsCalled() {
        // Given
        scenarioRule.launch()

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { getHeroNamesUseCase.execute() }
    }

    @Test
    fun onRandomButtonClickGetSuperPowerUseCaseIsCalled() {
        // Given
        scenarioRule.launch()

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { getSuperPowerUseCase.execute() }
    }
}