package example.com.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/made") {
            call.respondText { "Made Reihan" }
        }
        get("/todos/{id}") {
            val id = call.parameters["id"]
            call.respondText { "todo list item $id" }
        }
    }
}
