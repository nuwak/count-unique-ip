package utils

interface Measure: Log {
    fun measureMemory(): Long {
        val runtime = Runtime.getRuntime()
        return runtime.totalMemory() / 1024 / 1024 - runtime.freeMemory() / 1024 / 1024
    }

    fun <T> measure(block: () -> T): T {
        val startMemory = measureMemory()
        val start = System.currentTimeMillis()
        try {
            return block()
        } finally {
            val time = System.currentTimeMillis() - start
            val memory = measureMemory() - startMemory
            log.info("time: $time ms, memory: $memory mb")
        }
    }
}