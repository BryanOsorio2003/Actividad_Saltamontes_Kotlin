package com.example.saltamonteactividad.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.saltamonteactividad.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val button: Button = binding.btnNotas
        button.setOnClickListener{onClick()}
        return root
    }

    private fun onClick(){
        val campoMateria1: EditText =binding.materia1
        val materia1:String=campoMateria1.text.toString()
        val campoMateria2: EditText =binding.materia2
        val materia2:String=campoMateria2.text.toString()
        val campoMateria3: EditText =binding.materia3
        val materia3:String=campoMateria3.text.toString()
        val campoMateria4: EditText =binding.materia4
        val materia4:String=campoMateria4.text.toString()
        val campoMateria5: EditText =binding.materia5
        val materia5:String=campoMateria5.text.toString()


        val campoNumero1: EditText =binding.nota1
        val campoNumero2: EditText =binding.nota2
        val campoNumero3: EditText =binding.nota3
        val campoNumero4: EditText =binding.nota4
        val campoNumero5: EditText =binding.nota5

        var nota1:Double=(campoNumero1.text.toString()).toDouble()
        var nota2:Double=(campoNumero2.text.toString()).toDouble()
        var nota3:Double=(campoNumero3.text.toString()).toDouble()
        var nota4:Double=(campoNumero4.text.toString()).toDouble()
        var nota5:Double=(campoNumero5.text.toString()).toDouble()


        val texto:TextView=binding.textShowGallery
        val texto1:TextView=binding.txtPeriodo
        if(nota1 <0 || nota2 <0 || nota3 <0 || nota4 <0 || nota5 <0){
            texto.text="Nota erronea, las notas deben ser entre 0 y 5"
            texto1.text=""
        }
        else if(nota1 >5 || nota2 >5 || nota3 >5 || nota4 >5 || nota5 >5){
            texto.text="Nota erronea, las notas deben ser entre 0 y 5"
            texto1.text=""
        }
        else{
            var promedio=(nota1+nota2+nota3+nota4+nota5)/5
            texto.text="Materia: $materia1 con nota $nota1\n Materia: $materia2 con nota $nota2\n Materia: $materia3 con nota $nota3\n Materia: $materia4 con nota $nota4\n Materia: $materia5 con nota $nota5\n Promedio: $promedio"
            if(promedio>=3.5){
                texto1.text="EL ESTUDIANTE PASO EL PERIODO, ¡FELICIDADES!"
            }
            else{
                if(promedio>=2.5 && promedio<=3.4){
                    texto1.text="Puede recuperar las materias,¡PONGASE LAS PILAS!"
                }
                else{
                    texto1.text="No puede recuperar, no tiene posibilidades a recuperar, ¡lo siento!"
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}