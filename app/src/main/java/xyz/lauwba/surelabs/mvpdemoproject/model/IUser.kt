package xyz.lauwba.surelabs.mvpdemoproject.model

interface IUser {
    fun getName(): String?
    fun getPassword(): String?
    fun checkUserValidity(name: String?, pswd: String?): Int
}