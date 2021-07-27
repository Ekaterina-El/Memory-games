package ka.el.memorygames.ui.playground.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ka.el.memorygames.R
import ka.el.memorygames.ui.playground.CardModel

class PlaygroundAdapter : RecyclerView.Adapter<CardViewHolder>() {
    private var listOfCards = listOf<CardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playgroud_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindView(listOfCards[position])
    }

    override fun getItemCount(): Int = listOfCards.size

    fun setCardList(cards: List<CardModel>) {
        listOfCards = cards
        notifyDataSetChanged()
    }
}