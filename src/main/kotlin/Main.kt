import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.cio.CIO

fun main() {
    val website = embeddedServer(CIO,  443) {
        routing {
            get("/") {
                call.respondText { "Hello World" }
            }
        }
    }
    
    website.start(wait = true)
}
