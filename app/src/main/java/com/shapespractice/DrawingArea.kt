package com.shapespractice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import java.util.Random

// link https://stackoverflow.com/questions/45685026/how-can-i-get-a-random-number-in-kotlin
fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start

class DrawingArea(context: Context, private val paint: Paint) : View(context) {

    val canvasInfo = StringBuilder()

    private fun paintPropsForClockHands(): Paint
    {
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 16f
        paint.strokeCap = Paint.Cap.ROUND

        return paint
    }

    @SuppressLint("NewApi")
    public fun drawBarChartHorizontal(canvas: Canvas?)
    {
        canvas?.drawPaint(paint)
        canvas?.drawColor(Color.WHITE)

        var newWidth = 0f
        for (i in 0..4)
        {
            Log.i("newWidth", newWidth.toString())
            paint.color = Color.argb(100, (10..255).random(), (0..255).random(), (100..255).random() )
            canvas?.drawRect(newWidth, ((100..canvas.height).random()).toFloat(), (i+1)*270f, canvas.height.toFloat(), paint)
            newWidth += 270
        }
//        paint.color = Color.BLUE
//        canvas?.drawRect(0f, 300f, 270f, canvas.height.toFloat(), paint)
//
//        paint.color = Color.RED
//        canvas?.drawRect(270f, 300f, 2*270f, canvas.height.toFloat(), paint)

    }

    public fun drawClock(canvas: Canvas?)
    {
        canvas?.drawPaint(paint)
        canvas?.drawColor(Color.WHITE)

        paint.strokeWidth = 10f
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE

        val largeCircleRadius = 400f
        val smallCircleRadius = 20f

        // Clock circle
        canvas?.drawCircle(
                (canvas.width/2).toFloat(),
                (canvas.height/2).toFloat(),
                largeCircleRadius,
                paint)

        // Center dot
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        canvas?.drawCircle(
                (canvas.width/2).toFloat(),
                (canvas.height/2).toFloat(),
                smallCircleRadius,
                paint)

        // Long hand
        canvas?.drawLine(
                (canvas.width/2).toFloat(),
                (canvas.height/2).toFloat(),
                (canvas.width/2).toFloat(),
                (canvas.height/2).toFloat() - (largeCircleRadius - 40),
                paintPropsForClockHands())

        // Short hand
        canvas?.drawLine(
                (canvas.width/2).toFloat(),
                (canvas.height/2).toFloat(),
                (canvas.width/2).toFloat(),
                (canvas.height/2 + (largeCircleRadius - 140 )),
                paintPropsForClockHands())

        paint.textSize = 50f
        canvas?.drawText(
                String.format(
                        "Canvas width: %d | Canvas height: %d",
                        canvas.width,
                        canvas.height),
                100f,
                (canvas.height - 100).toFloat(),
                paint)

        paint.strokeWidth = 5f
        paint.color = Color.GRAY
        paint.style = Paint.Style.STROKE

        for (i in 1..12)
        {
            val angle = ((Math.PI*2)/12) * (i - Math.PI)

            canvas?.drawText(
                    ".", //i.toString(),
                    ( canvas.width/2  + Math.cos(angle) * (largeCircleRadius - 40) ).toFloat(),
                    ( canvas.height/2 + Math.sin(angle) * (largeCircleRadius - 40) ).toFloat(),
                    paint)

            Log.i("Counting", i.toString())
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        drawClock(canvas)
        drawBarChartHorizontal(canvas)
    }
}