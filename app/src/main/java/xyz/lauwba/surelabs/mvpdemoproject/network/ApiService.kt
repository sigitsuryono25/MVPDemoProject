package xyz.lauwba.surelabs.mvpdemoproject.network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import xyz.lauwba.surelabs.mvpdemoproject.model.LoginResponse

interface ApiService {
    @FormUrlEncoded
    @POST("to_hacked/")
    fun goLogin(
        @Field("username") username: String?,
        @Field("pswd") password: String?
    ): Call<LoginResponse>
}