package k.bs.calculator.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

open class TestBase(private val modules: Module) : KoinTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Force tests to be executed synchronously

    @Before
    fun before() {
        startKoin {
            modules(modules)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun dryRunTest() {
        koinApplication {
            printLogger(Level.DEBUG)
            modules(modules)
        }.checkModules()
    }

}