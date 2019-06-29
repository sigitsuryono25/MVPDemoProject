package xyz.lauwba.surelabs.mvpdemoproject.model

class UserModel(val names: String?, val pswd: String?) : IUser {

    override fun getName(): String? {
        return names
    }

    override fun getPassword(): String? {
        return pswd
    }

    override fun checkUserValidity(name: String?, pswd: String?): Int {
        if (name?.isEmpty() == true || pswd?.isEmpty() == true)
            return -1
        else
            return 0
    }
}