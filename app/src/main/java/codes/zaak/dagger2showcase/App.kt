package codes.zaak.dagger2showcase

import android.app.Application
import codes.zaak.dagger2showcase.di.AppComponent
import codes.zaak.dagger2showcase.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    open lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = getApplicationComponent()
        appComponent.inject(this)
    }

    open fun getApplicationComponent(): AppComponent =
        DaggerAppComponent.builder().application(this).build()

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}