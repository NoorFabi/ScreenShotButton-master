package jp.juggler.screenshotbutton

import jp.juggler.util.LogCategory
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.File
import java.io.IOException

object ImageUploader {
    private val log = LogCategory("${App1.tagPrefix}/Capture")

    fun uploadImage(filePath: String) {
        val client = OkHttpClient()

        // Create a file object from the given file path
        val file = File(filePath)

        // Create the request body
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart(
                "file",
                file.name,
                RequestBody.create("image/*".toMediaTypeOrNull(), file)
            )
            .build()

        // Create the request
        val request: Request = Request.Builder()
            .url("http://192.168.70.182:5000/receive_image") // Update with your actual IP address
            .post(requestBody)
            .build()

        // Execute the request asynchronously
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    throw IOException("Unexpected code " + response)
                }

                // Handle the response here if needed
                val responseData = response.body?.string()
                println(responseData)
                log.d(responseData.toString())
            }
        })
    }
}
