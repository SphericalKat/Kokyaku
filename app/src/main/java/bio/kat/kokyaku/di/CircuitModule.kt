package bio.kat.kokyaku.di

import com.slack.circuit.foundation.Circuit
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.multibindings.Multibinds

@ContributesTo(AppScope::class)
@Module
interface CircuitModule {
    @Multibinds fun presenterFactories(): Set<Presenter.Factory>

    @Multibinds fun viewFactories(): Set<Ui.Factory>

    companion object {
        fun provideCircuit(
            presenterFactories: @JvmSuppressWildcards Set<Presenter.Factory>,
            uiFactories: @JvmSuppressWildcards Set<Ui.Factory>,
        ): Circuit {
            return Circuit.Builder()
                .addPresenterFactories(presenterFactories)
                .addUiFactories(uiFactories)
                .build()
        }
    }
}