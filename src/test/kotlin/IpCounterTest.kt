import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import utils.Log
import utils.measure

internal class IpCounterTest : Log {

    @Test
    fun count() {
        measure {
            val ipCounter = IpCounter(arrayOf("ips100.txt"))
            val res = ipCounter.count()
            assertEquals(100, res)
        }
    }

    @Test
    fun count10k() {
        measure {
            val ipCounter = IpCounter(arrayOf("ips10000.txt"))
            ipCounter.count()
        }.also { assertEquals(10000, it) }
    }

    @Test
//    SetStore time: 1402 ms, memory: 243 mb
//    PairStore time: 3505 ms, memory: 134 mb
    fun count1kk() {
        measure {
            val ipCounter = IpCounter(arrayOf("ips1000000.txt"))
            ipCounter.count()
        }.also { assertEquals(999912, it) }
    }
}