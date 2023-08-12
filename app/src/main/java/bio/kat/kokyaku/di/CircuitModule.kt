package bio.kat.kokyaku.di

import android.util.Log
import com.deliveryhero.whetstone.app.ApplicationScope
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds

@Module
@ContributesTo(ApplicationScope::class)
interface CircuitModule {

    companion object {
        @Provides
        fun provideCircuit(
            presenterFactories: Set<@JvmSuppressWildcards Presenter.Factory>,
            uiFactories: Set<@JvmSuppressWildcards Ui.Factory>,
        ): Circuit {
            return Circuit.Builder()
                .addPresenterFactories(presenterFactories)
                .addUiFactories(uiFactories)
                .build()
        }
    }
}