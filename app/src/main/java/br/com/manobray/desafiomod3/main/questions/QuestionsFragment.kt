package br.com.manobray.desafiomod3.main.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.main.MainActivity
import br.com.manobray.desafiomod3.main.MainViewModel
import kotlinx.android.synthetic.main.questions_fragment.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class QuestionsFragment : Fragment() {

    private val viewModel: QuestionsViewModel by viewModels()
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.questions_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupView()
    }

    override fun onStart() {
        super.onStart()
        startGame()
    }

    private fun startGame() {
        viewModel.start(mainViewModel.questions)
    }

    private fun setupView() {
        btn_true.setOnClickListener {
            viewModel.answerQuestion(true)
        }

        btn_false.setOnClickListener {
            viewModel.answerQuestion(false)
        }
    }

    private fun setupListeners() {
        viewModel.currentQuestion.observe(this, Observer {
            tv_question.text = it.title
        })

        viewModel.finalResult.observe(this, Observer {
            var bundle = Bundle()
            bundle.putInt(MainActivity.RESULT_KEY, it)
            findNavController().navigate(R.id.resultFragment, bundle)
        })
    }

}
