package com.ljwx.baseapp.response

open class BaseResponse<Data> : IBaseResponse<Data> {

    companion object {

        private var RESPONSE_SUCCESS = 200

        fun setSuccessCode(code: Int) {
            RESPONSE_SUCCESS = code
        }
    }

    var code: Int? = null

    @Deprecated(message = "useless", replaceWith = ReplaceWith(expression = "msg"))
    var message: String? = null

    var msg: String? = null

    var data: Data? = null

    private var errorData: Any? = null

    var isRefresh: Boolean? = null

    var extensionField: Any? = null

    override fun isSuccess(): Boolean {
        return code == RESPONSE_SUCCESS
    }

    open fun isSuccessAndDataNotNull(): Boolean {
        return isSuccess() && data != null
    }

    fun getErrorDataEx(): Any? {
        return errorData
    }

    open fun setErrorDataEx(errorData: Any?) {
        this.errorData = errorData
    }

}