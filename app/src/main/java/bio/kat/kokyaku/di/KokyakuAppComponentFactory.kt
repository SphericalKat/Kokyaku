package bio.kat.kokyaku.di
//
//import androidx.annotation.Keep
//import androidx.core.app.AppComponentFactory
//
//@Keep
//class StarAppComponentFactory : AppComponentFactory() {
//
//    private inline fun <reified T> getInstance(
//        cl: ClassLoader,
//        className: String,
//        providers: Map<Class<out T>, @JvmSuppressWildcards Provider<T>>,
//    ): T? {
//        val clazz = Class.forName(className, false, cl).asSubclass(T::class.java)
//        val modelProvider = providers[clazz] ?: return null
//        return modelProvider.get() as T
//    }
//
//    override fun instantiateActivityCompat(
//        cl: ClassLoader,
//        className: String,
//        intent: Intent?
//    ): Activity {
//        return getInstance(cl, className, activityProviders)
//            ?: super.instantiateActivityCompat(cl, className, intent)
//    }
//
//    override fun instantiateApplicationCompat(cl: ClassLoader, className: String): Application {
//        val app = super.instantiateApplicationCompat(cl, className)
//        activityProviders = (app as StarApp).appComponent().activityProviders
//        return app
//    }
//
//    // AppComponentFactory can be created multiple times
//    companion object {
//        private lateinit var activityProviders: Map<Class<out Activity>, Provider<Activity>>
//    }
//}