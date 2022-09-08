package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Log {
    val log: Logger
        get(): Logger = LoggerFactory.getLogger(javaClass)
}