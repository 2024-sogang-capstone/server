package emotion.wave.muselyctale.common.logging

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.util.UUID

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
class ReqResLoggingFilter : OncePerRequestFilter() {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        MDC.put("traceId", UUID.randomUUID().toString())
        val cacheRequestWrapper = ContentCachingRequestWrapper(request)
        val cacheResponseWrapper = ContentCachingResponseWrapper(response)

        filterChain.doFilter(cacheRequestWrapper, cacheResponseWrapper)

        runCatching {
            val httpLog = HttpLogMessage.createInstance(cacheRequestWrapper, cacheResponseWrapper)
            log.info(httpLog.toPrettierLog())
        }.onFailure {
            log.error("Failed to log request and response", it)
        }

        cacheResponseWrapper.copyBodyToResponse()
        MDC.remove("traceId")
    }
}
