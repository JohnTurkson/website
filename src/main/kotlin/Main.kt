import io.ktor.application.call
import io.ktor.request.uri
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer

fun main() {
    val website = embeddedServer(CIO, 7777) {
        routing {
            get("/") {
                call.respondText { "Hello World" }
                println("Received request from ${call.request.uri}")
            }
        }
    }
    
    website.start(wait = true)
}
