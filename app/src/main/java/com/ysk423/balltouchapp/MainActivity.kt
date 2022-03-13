package com.ysk423.balltouchapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //新しいクラスを表示させる
        val ballView = BallView(this)
        setContentView(ballView)
    }

    //1)view1を継承したクラス
    class BallView(context: Context?) : View(context) {
        private var paint: Paint = Paint()
        private var circleX: Float = 200F
        private var circleY: Float = 200F

        //onDraw 描画の準備
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            canvas?.drawColor(Color.RED)//背景色の指定

            //ペイントする色の指定と、丸い図形
            paint.color = Color.YELLOW
            canvas?.drawCircle(circleX,circleY,50F,paint)

        }

        //画面タッチ
        override fun onTouchEvent(event: MotionEvent?): Boolean {

            //タッチポジション
            circleX = event!!.x
            circleY = event.y
            invalidate()

            //return super.onTouchEvent(event)
            return true
        }
    }

}