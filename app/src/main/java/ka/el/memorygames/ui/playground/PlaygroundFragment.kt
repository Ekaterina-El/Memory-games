package ka.el.memorygames.ui.playground

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import ka.el.memorygames.R
import ka.el.memorygames.databinding.FragmentPlaygroundBinding
import ka.el.memorygames.ui.playground.list.GridItemDecoration
import ka.el.memorygames.ui.playground.list.PlaygroundAdapter
import ka.el.memorygames.viewModel.PlaygroundViewModel


class PlaygroundFragment : Fragment() {
    private lateinit var binding: FragmentPlaygroundBinding
    private val playgroundViewModel: PlaygroundViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaygroundBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun generateCards(): List<CardModel> {
        val cards = mutableListOf<CardModel>()

        cards.add(CardModel(resources.getDrawable(R.drawable.ditto,), false, "ditto"))
        cards.add(CardModel(resources.getDrawable(R.drawable.jigglypuff), false, "jigglypuff"))
        cards.add(CardModel(resources.getDrawable(R.drawable.meowth), false, "meowth"))
        cards.add(CardModel(resources.getDrawable(R.drawable.pancham), false, "pancham"))
        cards.add(CardModel(resources.getDrawable(R.drawable.pickachu), false, "pickachu"))
        cards.add(CardModel(resources.getDrawable(R.drawable.piplup), false, "piplup"))

        val clones = mutableListOf<CardModel>()
        cards.forEach { card -> clones.add(card.copy()) }
        cards.addAll(clones)

        cards.shuffle()

        return cards
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = this@PlaygroundFragment.playgroundViewModel
            lifecycleOwner = viewLifecycleOwner
            fragment = this@PlaygroundFragment
        }

        val recyclerView = binding.rvCards
        recyclerView.layoutManager = GridLayoutManager(context, 4)
        recyclerView.addItemDecoration(GridItemDecoration(10, 4))

        val playgroundAdapter = PlaygroundAdapter { cardModel ->
            playgroundViewModel.addMovies()
        }
        recyclerView.adapter = playgroundAdapter

        val cards = generateCards()
        playgroundAdapter.setCardList(cards)
    }


}