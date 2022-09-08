import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import storages.ShortStorage
import utils.Log
import utils.measure

internal class IpCounterShortStorageTest : Log {
    @ParameterizedTest
    @MethodSource("params")
    fun count(file: String, expected: Long) {
        measure {
            val ipCounter = IpCounter(file, ShortStorage())
            ipCounter.count()
        }.also {
            assertEquals(expected, it)
        }
    }

    companion object {
        @JvmStatic
        fun params() = listOf(
//            time: 20 ms, memory: 3 mb
            Arguments.of("ips100.txt", 100),
//            time: 52 ms, memory: 16 mb
            Arguments.of("ips10000.txt", 10000),
//            time: 1178 ms, memory: 28 mb
            Arguments.of("ips1000000.txt", 999912),
        )
    }
}