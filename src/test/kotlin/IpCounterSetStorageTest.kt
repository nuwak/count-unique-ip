import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import storages.SetStorage
import utils.Measure

internal class IpCounterSetStorageTest : Measure {
    @ParameterizedTest
    @MethodSource("params")
    fun count(file: String, expected: Long) {
        measure {
            val ipCounter = IpCounter(file, SetStorage())
            ipCounter.count()
        }.also {
            assertEquals(expected, it)
        }
    }

    companion object {
        @JvmStatic
        fun params() = listOf(
//            time: 18 ms, memory: 1 mb
            Arguments.of("ips100.txt", 100),
//            time: 71 ms, memory: 12 mb
            Arguments.of("ips10000.txt", 10000),
//            time: 1648 ms, memory: 68 mb
            Arguments.of("ips1000000.txt", 999912),
        )
    }
}