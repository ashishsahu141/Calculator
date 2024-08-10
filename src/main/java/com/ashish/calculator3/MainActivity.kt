package com.ashish.calculator3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ashish.calculator3.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private var oldNumber = ""
    private var operator = "+"
    private var isFirstNumber = false
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }


    fun clickEvent(view: View) {
        binding.apply {

            if (isFirstNumber){
                


                answerTextView.text = ""
            }
            isFirstNumber = false
            var currentNumber = answerTextView.text.toString().trim()

            when (view) {

                clear -> {
                    var str: String = answerTextView.text.toString()
                    if (!str.equals("")) {
                        str = str.substring(0, str.length - 1)
                        answerTextView.text = str
                    }
                }

                one -> {
                    currentNumber += "1"
                    answerTextView.text = currentNumber
                }

                two -> {
                    currentNumber += "2"
                    answerTextView.text = currentNumber
                }

                three -> {
                    currentNumber += "3"
                    answerTextView.text = currentNumber
                }

                four -> {
                    currentNumber += "4"
                    answerTextView.text = currentNumber
                }

                five -> {
                    currentNumber += "5"
                    answerTextView.text = currentNumber
                }

                six -> {
                    currentNumber += "6"
                    answerTextView.text = currentNumber
                }

                seven -> {
                    currentNumber += "7"
                    answerTextView.text = currentNumber
                }

                eight -> {
                    currentNumber += "8"
                    answerTextView.text = currentNumber
                }

                nine -> {
                    currentNumber += "9"
                    answerTextView.text = currentNumber
                }

                dot -> {
                    currentNumber += "."
                    answerTextView.text = currentNumber
                }

                doubleZero -> {
                    currentNumber += "00"
                    answerTextView.text = currentNumber
                }

                singleZero -> {
                    currentNumber += "0"
                    answerTextView.text = currentNumber
                }

            }

        }


    }

    fun operatorClicking(view: View) {
        binding.apply {
            oldNumber = binding.answerTextView.text.toString().trim()
            isFirstNumber = true
            when (view) {
                percentage -> {
                    operator = "/"
                }

                divide -> {
                    operator = "/"
                }

                multiply -> {
                    operator = "*"
                }

                minus -> {
                    operator = "-"
                }

                plus -> {
                    operator = "+"


                }
            }

        }
    }


    @SuppressLint("SetTextI18n")
    fun getAnswer(view: View) {
        var result = 0.00
        when (operator) {
            "+" -> {
                result = (oldNumber.toDouble() + binding.answerTextView.text.toString().toDouble())
            }
            "-" -> {
                result = (oldNumber.toDouble() - binding.answerTextView.text.toString().toDouble())
            }
            "*" -> {
                result = (oldNumber.toDouble() * binding.answerTextView.text.toString().toDouble())
            }
            "/" -> {
                result = (oldNumber.toDouble() / binding.answerTextView.text.toString().toDouble())
            }
            "%"->{
                result=(oldNumber.toDouble()*100 / binding.answerTextView.text.toString().toDouble())
            }
        }
        val dotValue = result.toString().split(".")[1]
        if (dotValue.toInt() > 0){
            binding.answerTextView.text = result.toString()
        }else{
            binding.answerTextView.text = result.toInt().toString()
        }

    }


    fun allSetToZero(view: View) {
        binding.answerTextView.text = ""
        isFirstNumber = true
    }

}