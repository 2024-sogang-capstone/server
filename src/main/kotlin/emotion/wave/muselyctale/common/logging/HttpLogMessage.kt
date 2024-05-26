package emotion.wave.muselyctale.common.logging

import org.apache.commons.io.IOUtils
import org.springframework.http.HttpStatus
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper

data class HttpLogMessage(
    val httpMethod: String,
    val requestUri: String,
    val httpStatus: HttpStatus,
    val headers: Map<String, String>,
    val requestBody: String,
    val responseBody: String,
) {
    companion object {
        fun createInstance(
            requestWrapper: ContentCachingRequestWrapper,
            responseWrapper: ContentCachingResponseWrapper,
        ): HttpLogMessage {
            return HttpLogMessage(
                httpMethod = requestWrapper.method,
                requestUri = requestWrapper.requestURI,
                httpStatus = HttpStatus.valueOf(responseWrapper.status),
                headers = requestWrapper.headerNames.toList().associateWith { requestWrapper.getHeader(it) },
                requestBody = IOUtils.toString(requestWrapper.contentAsByteArray),
                responseBody = IOUtils.toString(responseWrapper.contentAsByteArray),
            )
        }
    }

    fun toPrettierLog(): String {
        return """
        |
        |[REQUEST] ${this.httpMethod} ${this.requestUri} ${this.httpStatus})
        |>> HEADERS: ${this.headers}
        |>> REQUEST_BODY: ${this.requestBody}
        |>> RESPONSE_BODY: ${this.responseBody}
            """.trimMargin()
    }
}
