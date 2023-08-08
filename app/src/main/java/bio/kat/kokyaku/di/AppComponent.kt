package bio.kat.kokyaku.di

import android.content.Context
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@MergeComponent(
    scope = AppScope::class,
    modules = [
        CircuitModule::class,
    ]
)
@SingleIn(AppScope::class)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@ApplicationContext @BindsInstance context: Context): AppComponent
    }

    companion object {

    }
}