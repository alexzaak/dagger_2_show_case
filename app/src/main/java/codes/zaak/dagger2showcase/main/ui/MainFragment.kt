package codes.zaak.dagger2showcase.main.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import codes.zaak.dagger2showcase.App
import codes.zaak.dagger2showcase.R
import codes.zaak.dagger2showcase.ViewModelFactory
import codes.zaak.dagger2showcase.answer.ui.AnswerViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject


class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: MainViewModel
    private lateinit var answerViewModel: AnswerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomize_button.setOnClickListener {
            mainViewModel.getRandomHeroName()
            mainViewModel.getSuperPower()

            answerViewModel.getAnswer()
        }
    }

    override fun onAttach(context: Context) {
        (context.applicationContext as App).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.also {
            mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
            answerViewModel =
                ViewModelProvider(this, viewModelFactory)[AnswerViewModel::class.java]

            mainViewModel.heroNames.observe(viewLifecycleOwner, {
                hero_name.text = it
            })

            mainViewModel.superPower.observe(viewLifecycleOwner, {
                super_power.text = it
            })

            answerViewModel.answer.observe(viewLifecycleOwner, {
                loadGifFromURL(it.image)
            })
        }
    }

    private fun loadGifFromURL(url: String) {
        Glide.with(this)
            .load(url)
            .into(answer_image)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}