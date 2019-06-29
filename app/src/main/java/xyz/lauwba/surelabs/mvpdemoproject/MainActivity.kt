package xyz.lauwba.surelabs.mvpdemoproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import xyz.lauwba.surelabs.mvpdemoproject.model.DataItem
import xyz.lauwba.surelabs.mvpdemoproject.presenter.ILoginPresenter
import xyz.lauwba.surelabs.mvpdemoproject.presenter.LoginPresenterProc
import xyz.lauwba.surelabs.mvpdemoproject.view.ILoginView

class MainActivity : AppCompatActivity(), ILoginView, View.OnClickListener {
    override fun onLoginResult(dataItem: List<DataItem?>?, result: Boolean, code: Int?) {
        iLoginPresenter?.setProgressBarVisibility(View.GONE)
        btn_login_login.isEnabled = true
        btn_login_clear.isEnabled = true
        dataItem?.forEach {
            Toast.makeText(this@MainActivity, it?.nama, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onLoginFailed(message: String?) {
        btn_login_login.isEnabled = true
        btn_login_clear.isEnabled = true
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    private var iLoginPresenter: ILoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login_login.setOnClickListener(this)
        btn_login_clear.setOnClickListener(this)

        //init the presenter
        iLoginPresenter = LoginPresenterProc(this)
        iLoginPresenter?.setProgressBarVisibility(View.VISIBLE)
    }

    override fun onClearText() {
        username.text = null
        password.text = null
    }

    override fun onSetProgressBarVisibility(visibility: Int?) {
        progress_login.visibility = View.GONE
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login_clear -> {
                iLoginPresenter?.clear()
            }

            R.id.btn_login_login -> {
                iLoginPresenter?.setProgressBarVisibility(View.VISIBLE)
                btn_login_clear.isEnabled = false
                btn_login_login.isEnabled = false
                iLoginPresenter?.doLogin(username.text.toString(), password.text.toString())
            }
        }
    }
}
