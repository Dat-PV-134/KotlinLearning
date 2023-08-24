package com.example.canvasdemo

import android.content.Context
import android.graphics.Canvas
import android.view.View

class MyWaveTestView(context: Context) : View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        customDraw()
    }

    private fun customDraw() {
        val subStepPx = 2000f
        val halfWidthMills = 50
        val gridEndMills = 2000 + halfWidthMills + 2000
        val halfScreenStepCount = (halfWidthMills/2000).toInt()

        for (indexMills in -halfScreenStepCount*2000 until gridEndMills step 2000) {
            val sampleIndexPx = millsToPx(indexMills)
            val xPos = (waveformShiftPx + sampleIndexPx)
            if (xPos >= -gridStepMills && xPos <= viewWidthPx + gridStepMills) { // Draw only visible grid items +1
                //Draw grid lines
                //Draw main grid line
                canvas.drawLine(xPos, textIndent, xPos, height - textIndent, gridPaint)
                val xSubPos = xPos + subStepPx
                //Draw grid top sub-line
                canvas.drawLine(
                    xSubPos,
                    textIndent,
                    xSubPos,
                    GIRD_SUBLINE_HEIGHT + textIndent,
                    gridPaint
                )
                //Draw grid bottom sub-line
                canvas.drawLine(
                    xSubPos,
                    height - GIRD_SUBLINE_HEIGHT - textIndent,
                    xSubPos,
                    height - textIndent,
                    gridPaint
                )

                if (showTimeline) {
                    //Draw timeline texts
                    if (indexMills >= 0) {
                        val text = TimeUtils.formatTimeIntervalHourMin(indexMills)
                        //Bottom timeline text
                        canvas.drawText(text, xPos, height - PADD, textPaint)
                        //Top timeline text
                        canvas.drawText(text, xPos, textHeight, textPaint)
                    }
                }
            }
        }
    }
}