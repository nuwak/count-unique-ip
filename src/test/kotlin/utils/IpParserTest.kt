package utils

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.net.InetAddress

internal class IpParserTest {

    @ParameterizedTest
    @MethodSource("ips")
//    todo как правильно называть тесты
    fun getBytes(ipString: String) {
        val res = IpParser.getBytes(ipString)
        assertArrayEquals(InetAddress.getByName(ipString).address, res)
    }

    companion object {
        @JvmStatic
        fun ips() = listOf(
            Arguments.of("255.55.23.44"),
            Arguments.of("255.255.255.255"),
            Arguments.of("192.168.1.1"),
            Arguments.of("0.0.0.0"),
            Arguments.of("127.0.0.1"),
            Arguments.of("100.0.10.0"),
        )
    }
}