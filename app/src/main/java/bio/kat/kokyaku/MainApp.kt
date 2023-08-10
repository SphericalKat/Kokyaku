package bio.kat.kokyaku

import android.app.Application
import bio.kat.kokyaku.di.AppComponent

class MainApp : Application() {
    private val appComponent by lazy { AppComponent.create(this) }

    fun appComponent() = appComponent
}