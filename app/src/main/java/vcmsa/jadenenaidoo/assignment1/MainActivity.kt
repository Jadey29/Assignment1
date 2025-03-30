package vcmsa.jadenenaidoo.assignment1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        //Display fields
        val inputTime = findViewById<EditText>(R.id.inputTime) //Input field for user to enter time of day
        val btnSuggest = findViewById<Button>(R.id.btnSuggest) //Button to get meal suggestion
        val btnReset = findViewById<Button>(R.id.btnReset)//Button to rest app
        val txtSuggestion = findViewById<TextView>(R.id.txtSuggestion) //Text view to display meal suggestions

        //Set an OnClickListener for the suggest button
        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            var mealSuggestion = "" //Variable to store meal suggestion

            //Asked AI to find an error reguarding brackets
            if (timeOfDay == "morning") {
                mealSuggestion = "Eggs,Toast,Bacon,Sausages,Oatmeal,Cereals,Hot beverages"
            } else if (timeOfDay == "mid morning") {
                mealSuggestion = "Fruit,Fruit Juices,Smoothies,Greek yogurt,Fruit Bowl"
            } else if (timeOfDay == "lunch") {
                mealSuggestion = "Sandwich's,Chicken Salad,Stir-fries,Cold or Hot Beverages or water "
            } else if (timeOfDay == "dinner") {
                mealSuggestion = "Pasta,Steaks,curries,Roast,Vegtables,A serve of lean meat, skinless chicken or fish or a meat,beverages"
            } else if (timeOfDay == "snack")  {
                mealSuggestion = "A dessert based on fruit and low fat milk or yogurt"
            } else {
                mealSuggestion = "Invalid time of day. Please enter a valid time."
            }

            //Display meal suggestion in text view
            txtSuggestion.text = mealSuggestion
        }

        //Set an OnClickListener for the reset button
        btnReset.setOnClickListener {
            inputTime.text.clear()   //Clear the input field
            txtSuggestion.text = ""  //Clear output text view
        }
    }
}
