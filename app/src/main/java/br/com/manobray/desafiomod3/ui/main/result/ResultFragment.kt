package br.com.manobray.desafiomod3.ui.main.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.manobray.desafiomod3.R
import kotlinx.android.synthetic.main.result_fragment.*

class ResultFragment : Fragment() {

    companion object {
        fun newInstance() =
            ResultFragment()
    }

    private val viewModel: ResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        tv_acertos.text = "100% acertos"
    }

}
