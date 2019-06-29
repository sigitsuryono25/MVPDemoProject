package xyz.lauwba.surelabs.mvpdemoproject.presenter

interface ILoginPresenter {
    fun clear()
    fun doLogin(username: String?, pswd: String?)
    fun setProgressBarVisibility(v: Int)
}