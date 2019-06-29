package xyz.lauwba.surelabs.mvpdemoproject.model


data class LoginResponse(
    val data: List<DataItem?>? = null,
    val message: String? = null,
    val status: Int? = null
)
