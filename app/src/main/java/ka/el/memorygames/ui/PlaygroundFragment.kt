package ka.el.memorygames.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ka.el.memorygames.databinding.FragmentPlaygroundBinding
import ka.el.memorygames.viewModel.PlaygroundViewModel


class PlaygroundFragment : Fragment() {
    private lateinit var binding: FragmentPlaygroundBinding
    private val playgroundViewModel: PlaygroundViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlaygroundBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = this@PlaygroundFragment.playgroundViewModel
            lifecycleOwner = viewLifecycleOwner
            fragment = this@PlaygroundFragment
        }
    }

    fun count() {
        playgroundViewModel.addMovies()
    }
}