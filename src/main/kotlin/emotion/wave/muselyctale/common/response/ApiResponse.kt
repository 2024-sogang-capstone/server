package emotion.wave.muselyctale.common.response

data class ApiResponse<T> internal constructor(
    val data: T?,
    val message: String?,
    val status: String,
) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(data, null, "success")
        }

        fun error(message: String): ApiResponse<Unit> {
            return ApiResponse(Unit, message, "error")
        }

        fun success(): ApiResponse<Unit> {
            return success(Unit)
        }
    }
}
