import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import storages.PairStorage
import utils.Measure

internal class IpCounterPairStorageTest : Measure {
    @ParameterizedTest
    @MethodSource("params")
    fun count(file: String, expected: Long) {
        measure {
            val ipCounter = IpCounter(file, PairStorage())
            ipCounter.count()
        }.also {
            assertEquals(expected, it)
        }
    }

    companion object {
        @JvmStatic
        fun params() = listOf(
//            time: 20 ms, memory: 2 mb
            Arguments.of("ips100.txt", 100),
//            time: 194 ms, memory: 14 mb
            Arguments.of("ips10000.txt", 10000),
//            time: 3310 ms, memory: 246 mb
            Arguments.of("ips1000000.txt", 999912),
        )
    }
}