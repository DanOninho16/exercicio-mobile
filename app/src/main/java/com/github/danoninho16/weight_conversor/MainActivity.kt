package com.github.danoninho16.weight_conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.danoninho16.weight_conversor.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateConvert()}
    }
    fun calculateConvert() {
        val stringInTextField = binding.converterValue.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.conversionOption.checkedRadioButtonId
        val conversionValue = when(selectedId) {
            R.id.kg_to_pounds -> 2.2
            else 0.45
        }
        var convertedValue = conversionValue * cost
        val formattedTip = NumberFormat.getCurrencyInstance().format(convertedValue)
        binding.conversionResult.text = getString(R.string.conversion_amount, formattedTip)
    }
}