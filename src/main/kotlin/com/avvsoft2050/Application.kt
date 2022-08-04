package com.avvsoft2050

import com.avvsoft2050.plugins.configureRouting
import com.avvsoft2050.plugins.configureSerialization
import com.avvsoft2050.plugins.configureSockets
import com.avvsoft2050.plugins.configureTemplating
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureTemplating()
    configureSockets()
    configureSerialization()
    configureRouting()

}
