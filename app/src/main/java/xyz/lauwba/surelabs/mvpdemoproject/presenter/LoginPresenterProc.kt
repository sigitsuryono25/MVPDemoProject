package xyz.lauwba.surelabs.mvpdemoproject.presenter

import android.os.Handler
import android.os.Looper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.lauwba.surelabs.mvpdemoproject.model.LoginResponse
import xyz.lauwba.surelabs.mvpdemoproject.network.NetworkModule
import xyz.lauwba.surelabs.mvpdemoproject.view.ILoginView

class LoginPresenterProc(private val iLoginView: ILoginView) : ILoginPresenter {
    var handler: Handler? = null

    init {
        handler = Handler(Looper.getMainLooper())
    }

    override fun clear() {
        iLoginView.onClearText()
    }

    override fun doLogin(username: String?, pswd: String?) {
        //retrofit
        NetworkModule.getService().goLogin(username, pswd)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val code = response.body()?.status
                        val message = response.body()?.message
                        if (code == 200) {
                            iLoginView.onLoginResult(response.body()?.data, true, 0)
                        } else {
                            iLoginView.onLoginFailed(message)
                        }
                    } else {
                        iLoginView.onLoginFailed(response.errorBody().toString())
                    }
                }
            })
    }

    override fun setProgressBarVisibility(v: Int) {
        iLoginView.onSetProgressBarVisibility(v)
    }

}