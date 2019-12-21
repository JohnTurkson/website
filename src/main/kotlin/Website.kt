import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.HSTS
import io.ktor.features.HttpsRedirect
import io.ktor.request.uri
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.cio.CIO
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer

fun main() {
    val environment = applicationEngineEnvironment {
        module {
            main()
        }
        
        connector {
            host = "0.0.0.0"
            port = 443
        }
        
        connector {
            host = "0.0.0.0"
            port = 80
        }
    }
    
    val website = embeddedServer(CIO, environment)
    
    website.start(wait = true)
}

fun Application.main () {
    // install(HSTS)
    // install(HttpsRedirect) {
    //     sslPort = 80
    //     permanentRedirect = true
    // }
    
    println("Website running")
    
    routing {
        get("/") {
            println(call.request.uri)
            call.respondText { "Hello World" }
        }
    }
}
