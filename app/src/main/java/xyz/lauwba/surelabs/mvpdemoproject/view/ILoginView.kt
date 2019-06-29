package xyz.lauwba.surelabs.mvpdemoproject.view

import xyz.lauwba.surelabs.mvpdemoproject.model.DataItem

interface ILoginView {
    fun onClearText()
    fun onLoginResult(dataItem: List<DataItem?>?, result: Boolean, code: Int?)
    fun onLoginFailed(message : String?)
    fun onSetProgressBarVisibility(visibility: Int?)
}