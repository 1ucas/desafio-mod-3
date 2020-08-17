package br.com.manobray.desafiomod3.ui.main.questions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.ui.main.MainActivity

class QuestionsFragment : Fragment() {

    companion object {
        fun newInstance() = QuestionsFragment()
    }

    private val viewModel: QuestionsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.questions_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
    }

    private fun answeredAllQuestions() {
        viewModel.finalResult?.let {
            var bundle = Bundle()
            bundle.putInt(MainActivity.RESULT_KEY, it)
            findNavController().navigate(R.id.resultFragment, bundle)
        }
    }

}
