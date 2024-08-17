package example.com

import example.com.plugins.*
import example.com.route.historyRoute
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
//    io.ktor.server.netty.EngineMain.main(args)
    embeddedServer(
        Netty,
        port = 8080,
        host = "192.168.0.141",
        module = Application::module,
    ).start(wait = true)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureRouting()
    historyRoute()
}
