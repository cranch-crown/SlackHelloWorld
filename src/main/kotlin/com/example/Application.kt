package com.example

import com.slack.api.bolt.App
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.slack.api.bolt.util.SlackRequestParser

fun main() {
    val app = App()
    val requestParser = SlackRequestParser(app.config())

    app.command("/hello") { req, ctx ->
        ctx.ack("Hello World")
    }

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}
