package bio.kat.kokyaku

import android.app.Application
import com.deliveryhero.whetstone.app.ApplicationComponentOwner
import com.deliveryhero.whetstone.app.ContributesAppInjector


@ContributesAppInjector(generateAppComponent = true)
class MainApp : Application(), ApplicationComponentOwner {
    override val applicationComponent by lazy {
        GeneratedApplicationComponent.create(this)
    }
}