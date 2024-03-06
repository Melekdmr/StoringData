package com.melekdmr.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.melekdmr.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref:SharedPreferences
    var ageFromPref: Int? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        //sharedPreferences-XML->Key-Value
        //Her kaydettiğimiz veriye anahtar atamak zorundayız
         sharedPref=getSharedPreferences("com.melekdmr.storingdata",Context.MODE_PRIVATE)
        //veri yazıp güncelleyeceksek edit,halihazırda yazılmış bir veriyi almak istiyorsak get fonksiyonunu kullanırız

        val ageFromPref=sharedPref.getInt("age",-1)
        if (ageFromPref==-1){
            binding.textView.text="Your age: "
        }else{
            binding.textView.text="Your age:  ${ ageFromPref}"
        }


    }



    fun save(view:View){
  val  myAge=binding.editTextText.text.toString().toIntOrNull()
        if(myAge != null){

        binding.textView.text="Your age:  ${ myAge}"
            sharedPref.edit().putInt("age",myAge).apply()
    }}
    fun delete(view:View){
        if(ageFromPref != -1){
            sharedPref.edit().remove("age").apply()
            binding.textView.text="Your age: "
        }



    }
}