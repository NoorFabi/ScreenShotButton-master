package jp.juggler.screenshotbutton

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.WindowManager
import android.widget.ImageButton

@SuppressLint("AppCompatCustomView")
class MyImageButton : ImageButton {

    var windowLayoutParams : WindowManager.LayoutParams? = null

    //    private val myExclusionRects = listOf(Rect())

    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun updateExclusion() {
//        if( Build.VERSION.SDK_INT >= API_SYSTEM_GESTURE_EXCLUSION ){
//            val maxSize = (200f * resources.displayMetrics.density).toInt()
//            myExclusionRects[0].set(
//                windowLayoutParams?.x ?: left,
//                windowLayoutParams?.y ?: top,
//                maxSize,
//                maxSize
//            ) // x,y,w,h なのか…？
//            systemGestureExclusionRects = myExclusionRects
//        }
    }

//    override fun onLayout(changedCanvas: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
//        super.onLayout(changedCanvas, left, top, right, bottom)
//        if( Build.VERSION.SDK_INT >= API_SYSTEM_GESTURE_EXCLUSION ){
//            val maxSize = (200f * resources.displayMetrics.density).toInt()
//            myExclusionRects[0].set(
//                windowLayoutParams?.x ?: left,
//                windowLayoutParams?.y ?: top,
//                maxSize,
//                maxSize
//            ) // x,y,w,h なのか…？
//            systemGestureExclusionRects = myExclusionRects
//        }
//    }

}
