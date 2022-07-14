package com.mohammedshahbaz.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//defining specific functions for different button call.
    fun buNumberEvent(view:View){
   if (isNewOp){
        showResult.setText("")
    }
    isNewOp=false
        val buSelect=view as Button
        var buClickValue:String=showResult.text.toString()
        when(buSelect.id){
            
            bu2.id->{
                buClickValue="-"+ buClickValue
            }
            bu5.id->{
                buClickValue+="7"
            }
            bu6.id->{
                buClickValue+="8"
            }
            bu7.id->{
                buClickValue+="9"
            }
            bu9.id->{
                buClickValue+="4"
            }
            bu10.id->{
                buClickValue+="5"
            }
            bu11.id->{
                buClickValue+="6"
            }
            bu13.id->{
                buClickValue+="1"
            }
            bu14.id->{
                buClickValue+="2"
            }
            bu15.id->{
                buClickValue+="3"
            }
            bu17.id->{
                buClickValue+="0"
            }
            bu18.id -> {
                //TODO:prevent adding more than 1 dot
                buClickValue += "."
                Toast.makeText(this, "you can use decimal only once", Toast.LENGTH_LONG).show()
            }
        }
        showResult.setText(buClickValue)
    }


//difining processes for mathematical operations.
    var op="*"
    var oldNumber=""
   var isNewOp=true
    fun buOpEvent(view: View){
        val buSelect=view as Button
        when(buSelect.id) {
            buMult.id -> {
                op = "*"
                Toast.makeText(this, "   ×   ", Toast.LENGTH_SHORT).show()
            }

            buDiv.id -> {
                op="/"
                Toast.makeText(this, "   ÷   ", Toast.LENGTH_SHORT).show()
            }
            buSum.id -> {
                op="+"
                Toast.makeText(this, "   +   ", Toast.LENGTH_SHORT).show()
            }
            buMinus.id -> {
                op="-"
                Toast.makeText(this, "   _   ", Toast.LENGTH_SHORT).show()
            }
        }
        oldNumber=showResult.text.toString()
       isNewOp=true

    }

 //defining the function for equal operator
    fun buEqualEvent(view: View){
        val buSelect=view as Button
     val newNumber=showResult.text.toString()
     var finalNumber:Double?=null
     when(op){
         "*"->{
             finalNumber=oldNumber.toDouble() * newNumber.toDouble()
         }
         "/"->{
             finalNumber=oldNumber.toDouble() / newNumber.toDouble()
         }
         "+"->{
             finalNumber=oldNumber.toDouble() + newNumber.toDouble()
         }
         "-"->{
             finalNumber=oldNumber.toDouble() - newNumber.toDouble()
         }
     }

showResult.setText(finalNumber.toString())
     isNewOp=true

    }

    //function for using percentage operator
    fun buPercent(view: View){
        val number:Double=showResult.text.toString().toDouble()/100
        Toast.makeText(this, "   %   ", Toast.LENGTH_SHORT).show()
        showResult.setText(number.toString())
       isNewOp=true
    }

    //function for cleaning the screen.
    fun buClean(view: View){
        showResult.setText("0")
        isNewOp=true
    }

}