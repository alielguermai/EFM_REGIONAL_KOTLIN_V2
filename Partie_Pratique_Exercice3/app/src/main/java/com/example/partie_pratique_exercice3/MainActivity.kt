package com.example.partie_pratique_exercice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val String.sigle: String
    get() {
        var resultat = ""
        for (x in this.split(" ")){
            resultat+=x[0].uppercase()
        }
        return resultat
    }
private val String.estVideOuBlanche: Boolean
    get() {return this.isEmpty() || this.trim().isEmpty()}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun afficher(v: View) {
        if (v is Button){
            var edit = findViewById<EditText>(R.id.edit)
            var txt1 = findViewById<TextView>(R.id.txt1)
            var txt2 = findViewById<TextView>(R.id.txt2)
            if (edit.text.toString().estVideOuBlanche)
                txt1.text="Oui, la chaine est vide ou blanche."
            else
                txt1.text="Non, la chaine n'est ni vide ni blanche."
            txt2.text=edit.text.toString().sigle
        }
    }
}