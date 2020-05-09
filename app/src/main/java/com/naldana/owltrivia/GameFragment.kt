package com.naldana.owltrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.naldana.owltrivia.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    data class Question(
        val text:String,
        val answers:List<String>
    )
    private val question: MutableList<Question> = mutableListOf(
        Question(
            text = "pregunta 1",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 2",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 3",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 4",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 5",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 6",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 7",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        ),
        Question(
            text = "pregunta 8",
            answers = listOf("Buena","mala 1", "mala 2", "mala 3" )
        )

    )

    lateinit var currentQuestion: Question
    lateinit var answer: MutableList<String>
    private var questionIndex = 0
    private val numQuestion = Math.min((question.size + 1)/2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,R.layout.fragment_game,container,false )

        randomizeQuestions()

        binding.game=this
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

}
