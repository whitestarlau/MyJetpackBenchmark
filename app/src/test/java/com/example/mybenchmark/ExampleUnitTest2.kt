package com.example.mybenchmark

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Test {
    val mStr = "one"

//    @Test
//    fun foo() {
//        testInline {
//            val str = mStr
//        }
//    }


    fun foo(){
//        testLambda {
//            val str = mStr
//        }

        testLambda {
            val str = "one"
        }
    }
}

//inline fun testInline(action: () -> Unit) {
//    action.invoke()
//}

fun testLambda( action: () -> Unit) {
    action.invoke()
}