package androidsamples.java.whatday

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnCheck: Button = findViewById(R.id.btn_check)
        var text: TextView = findViewById(R.id.txt_display)
        var date: EditText = findViewById(R.id.editDate)
        var month: EditText = findViewById(R.id.editMonth)
        var year: EditText = findViewById(R.id.editYear)

        btnCheck.setOnClickListener {
            DateModel.initialize(year.text.toString(), month.text.toString(), date.text.toString())
            Log.d("DATE TIME ENTERED", "onCreate: ${date.text} ${month.text} ${year.text}")
            text.text = DateModel.message
        }
    }
}