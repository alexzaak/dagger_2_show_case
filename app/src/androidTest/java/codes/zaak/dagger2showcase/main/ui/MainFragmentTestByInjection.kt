package codes.zaak.dagger2showcase.main.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import codes.zaak.dagger2showcase.App
import codes.zaak.dagger2showcase.MainActivity
import codes.zaak.dagger2showcase.R
import codes.zaak.dagger2showcase.answer.di.InjectableTestAnswerModule
import codes.zaak.dagger2showcase.answer.domain.AnswerRepository
import codes.zaak.dagger2showcase.answer.domain.model.AnswerDomainModel
import codes.zaak.dagger2showcase.main.di.DaggerMainAppComponent
import codes.zaak.dagger2showcase.testutils.lazyActivityScenarioRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
class MainFragmentTestByInjection {

    @get:Rule
    val testRule = lazyActivityScenarioRule<MainActivity>(launchActivity = false)

    @MockK(relaxUnitFun = true)
    lateinit var answerRepository: AnswerRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App

        val testAppComponent = DaggerMainAppComponent
            .builder()
            .injectableTestAnswerModule(InjectableTestAnswerModule(answerRepository = answerRepository))
            .build()

        app.appComponent = testAppComponent
        testAppComponent.inject(this)
    }

    @Test
    fun onRandomizeButtonClickAnswerRepositoryIsCalled() {
        // Given
        every { answerRepository.getAnswer() } returns Single.just(
            AnswerDomainModel(
                "true",
                "https://www.fischerappelt.de/wp-content/uploads/2014/12/nyancat.gif"
            )
        )

        testRule.launch()

        // When
        onView(withId(R.id.randomize_button)).perform(click())

        // Then
        verify(exactly = 1) { answerRepository.getAnswer() }
    }
}