package com.otterland.data.system

internal class SysConfig {

    companion object {

        private external fun nativeInit()

        init {
            nativeInit()
        }
    }

}