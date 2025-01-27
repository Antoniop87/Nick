package com.example.nick2.activities.jogos.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.nick2.R
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AudioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudioFragment : Fragment() {
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var recognizerIntent: Intent
    private var targetWord: String? = null
    private var imageResId: Int? = null
    private var onWordMatched: (() -> Unit)? = null

    companion object {
        private const val ARG_WORD = "arg_word"
        private const val ARG_IMAGE = "arg_image"

        fun newInstance(word: String, imageResId: Int): AudioFragment {
            val fragment = AudioFragment()
            val args = Bundle()
            args.putString(ARG_WORD, word)
            args.putInt(ARG_IMAGE, imageResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio, container, false)
        val wordTextView: TextView = view.findViewById(R.id.wordTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val startButton: Button = view.findViewById(R.id.startButton)

        targetWord = arguments?.getString(ARG_WORD)
        imageResId = arguments?.getInt(ARG_IMAGE)

        wordTextView.text = targetWord
        imageResId?.let { imageView.setImageResource(it) }

        setupSpeechRecognizer()

        startButton.setOnClickListener {
            speechRecognizer.startListening(recognizerIntent)
        }

        return view
    }

    private fun setupSpeechRecognizer() {
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(requireContext())
        recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR")
        }

        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (matches != null && matches.isNotEmpty()) {
                    val spokenText = matches[0].lowercase()
                    if (spokenText == targetWord?.lowercase()) {
//                        Toast.makeText(requireContext(), "Acertou!", Toast.LENGTH_SHORT).show()
                        chamaDialog(0)
                    } else {
//                        Toast.makeText(requireContext(), "Tente novamente!", Toast.LENGTH_SHORT)
//                            .show()
                        chamaDialog(1)
                    }
                }
            }

            override fun onError(error: Int) {
//                Toast.makeText(requireContext(), "Erro no reconhecimento", Toast.LENGTH_SHORT)
//                    .show()
                chamaDialog(1)
            }

            override fun onReadyForSpeech(params: Bundle?) {
                Toast.makeText(requireContext(), "Fale agora", Toast.LENGTH_SHORT).show()
            }

            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
    }

    private fun onWordMatched() {

        parentFragmentManager.setFragmentResult("wordMatched", Bundle())
    }

    //o valor da resposta é 1 para resposta errada e 0 para resposta certa
    @SuppressLint("ResourceAsColor")
    private fun chamaDialog(valorResposta: Int) {

        val dialog = BottomSheetDialog(requireContext())

        val view = layoutInflater.inflate(R.layout.dialog_resposta_errada, null)

        val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)
        val resposta = view.findViewById<TextView>(R.id.idTVCourseName)
        val icone = view.findViewById<ImageView>(R.id.idIVCourse)

        if (valorResposta == 0){
            resposta.text = "Certa resposta!"
            resposta.setTextColor(resources.getColor(R.color.green))
            icone.setImageResource(R.drawable.baseline_check_circle_24)
            btnClose.text = "Proximo"
            btnClose.setBackgroundColor(resources.getColor(R.color.green))
            btnClose.setOnClickListener {
                dialog.dismiss()
                onWordMatched?.invoke()
                onWordMatched()
            }

            dialog.setCancelable(false)

            dialog.setContentView(view)

            dialog.show()
        } else {

            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)

            dialog.setContentView(view)

            dialog.show()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer.destroy()
    }

}