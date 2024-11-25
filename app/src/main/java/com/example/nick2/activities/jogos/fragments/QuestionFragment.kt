package com.example.nick2.activities.jogos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.nick2.R
import com.example.nick2.model.Question

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {

    private lateinit var question: Question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            question = it.getParcelable(ARG_QUESTION)!! // Recupere o objeto parcelável
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        // Configure o layout com os dados da pergunta
        val textQuestion = view.findViewById<TextView>(R.id.textQuestion)
        val option1 = view.findViewById<ImageView>(R.id.option1)
        val option2 = view.findViewById<ImageView>(R.id.option2)
        val option3 = view.findViewById<ImageView>(R.id.option3)
        val option4 = view.findViewById<ImageView>(R.id.option4)

        textQuestion.text = question.text
        option1.setImageResource(question.imageOptions[0])
        option2.setImageResource(question.imageOptions[1])
        option3.setImageResource(question.imageOptions[2])
        option4.setImageResource(question.imageOptions[3])

        val options = listOf(option1, option2, option3, option4)
        question.imageOptions.forEachIndexed { index, imageRes ->
            options[index].setImageResource(imageRes)
        }

        // Configura os listeners para as opções
        options.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                if (index == question.correctAnswer) {
                    goToNextQuestion() // Passa para a próxima pergunta
                } else {
                    Toast.makeText(requireContext(), "Resposta errada!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }

    private fun goToNextQuestion() {
        // Obtém o ViewPager2 da activity
        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        if (viewPager.currentItem < viewPager.adapter!!.itemCount - 1) {
            viewPager.currentItem = viewPager.currentItem + 1 // Avança para a próxima página
        } else {
            Toast.makeText(requireContext(), "Você terminou o quiz!", Toast.LENGTH_LONG).show()
        }
    }

//    companion object {
//        private const val ARG_QUESTION = "arg_question"
//
//        fun newInstance(question: Question): QuestionFragment {
//            val fragment = QuestionFragment()
//            val args = Bundle()
//            args.putParcelable(ARG_QUESTION, question) // Adicione o objeto parcelável ao Bundle
//            fragment.arguments = args
//            return fragment
//        }
//    }

    companion object {
        private const val ARG_QUESTION = "question"

        fun newInstance(question: Question): QuestionFragment {
            return QuestionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_QUESTION, question)
                }
            }
        }
    }
}
