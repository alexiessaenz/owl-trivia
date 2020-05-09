package com.naldana.owltrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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

    private val questions: MutableList<Question> = mutableListOf(
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
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1)/2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )


        randomizeQuestions()


        binding.game = this


        binding.submitButton.setOnClickListener {
            val checkId = binding.radioGroupQuestion.checkedRadioButtonId

            if (-1 != checkId) {
                var answerIndex = 0
                when (checkId) {
                    R.id.radioOptionB -> answerIndex = 1
                    R.id.radioOptionC -> answerIndex = 2
                    R.id.radioOptionD -> answerIndex = 3
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++

                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.radioGroupQuestion.clearCheck()
                        binding.invalidateAll()
                    } else {
                        // Won
                    }
                } else {
                    // Over
                }
            }
        }

        return binding.root
    }

    private fun randomizeQuestions(){
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion(){
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity)
            .supportActionBar?.title =
            getString(R.string.title_owl_trivia_question,
            questionIndex + 1, numQuestions)
    }
}
