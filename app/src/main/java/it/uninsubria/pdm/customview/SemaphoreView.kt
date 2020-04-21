package it.uninsubria.pdm.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class SemaphoreView(context: Context, attrs:AttributeSet):View(context, attrs) {

    private val paint:Paint = Paint()
    var lightOn:String = "RED"
        get() = field
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        val max_size = min(width, height)
        var cx = 0f
        var cy = 0f
        var radius = 0f
        if(height<=3*width){
            cx = width.toFloat()/2
            cy = height.toFloat()/2
            radius = height.toFloat()/6
        }else{
            cx = width.toFloat()/2
            cy = height.toFloat()/2
            radius = width.toFloat()/2
        }
        canvas?.drawColor(resources.getColor(R.color.colorBackgroundSemaphore))
        when(lightOn){
            "RED"-> {
                paint.color = resources.getColor(R.color.RED)
                canvas?.drawCircle(cx, cy-(2*radius), radius, paint)
                paint.color = resources.getColor(R.color.LIGHT_GREY)
                canvas?.drawCircle(cx, cy, radius, paint)
                canvas?.drawCircle(cx, cy+(2*radius), radius, paint)
            }
            "YELLOW"-> {
                paint.color = resources.getColor(R.color.LIGHT_GREY)
                canvas?.drawCircle(cx, cy-(2*radius), radius, paint)
                paint.color = resources.getColor(R.color.YELLOW)
                canvas?.drawCircle(cx, cy, radius, paint)
                paint.color = resources.getColor(R.color.LIGHT_GREY)
                canvas?.drawCircle(cx, cy+(2*radius), radius, paint)
            }
            "GREEN"-> {
                paint.color = resources.getColor(R.color.LIGHT_GREY)
                canvas?.drawCircle(cx, cy-(2*radius), radius, paint)
                canvas?.drawCircle(cx, cy, radius, paint)
                paint.color = resources.getColor(R.color.GREEN)
                canvas?.drawCircle(cx, cy+(2*radius), radius, paint)
            }
        }
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f
        paint.color = Color.BLACK
        canvas?.drawCircle(cx, cy-(2*radius), radius, paint)
        canvas?.drawCircle(cx, cy, radius, paint)
        canvas?.drawCircle(cx, cy+(2*radius), radius, paint)
    }
}