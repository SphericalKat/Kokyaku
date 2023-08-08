package bio.kat.kokyaku.di

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope annotation class SingleIn(val scope: KClass<*>)

class AppScope private constructor()