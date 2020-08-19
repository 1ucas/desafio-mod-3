package br.com.manobray.desafiomod3.main.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.manobray.desafiomod3.R
import br.com.manobray.desafiomod3.main.MainActivity
import kotlinx.android.synthetic.main.result_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class ResultFragment : Fragment() {

    private val viewModel: ResultViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        processParams()

        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_restart.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun processParams() {
        arguments?.getInt(MainActivity.RESULT_KEY)?.let {
            viewModel.result = it
        }
    }

    override fun onStart() {
        super.onStart()
        tv_acertos.text = viewModel.resultText
    }

}
