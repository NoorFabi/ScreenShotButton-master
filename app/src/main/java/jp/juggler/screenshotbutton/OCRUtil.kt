import android.content.Context
import android.graphics.Bitmap
import android.util.SparseArray
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer

object OCRUtil {

    fun performOCR(context: Context, bitmap: Bitmap): String {
        val textRecognizer = TextRecognizer.Builder(context).build()
        if (!textRecognizer.isOperational) {
            // Handle the error
            return "OCR not available"
        }

        val frame = Frame.Builder().setBitmap(bitmap).build()
        val textBlocks = textRecognizer.detect(frame)

        return processTextBlocks(textBlocks)
    }

    private fun processTextBlocks(textBlocks: SparseArray<TextBlock>): String {
        val result = StringBuilder()

        for (index in 0 until textBlocks.size()) {
            val textBlock = textBlocks.valueAt(index)
            result.append(textBlock.value)
            result.append("\n")
        }

        return result.toString()
    }
}
