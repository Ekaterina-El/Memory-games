package ka.el.memorygames.ui.playground.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ka.el.memorygames.R
import ka.el.memorygames.ui.playground.CardModel

class PlaygroundAdapter(private val onItemClickListener: (CardModel) -> Unit) : RecyclerView.Adapter<CardViewHolder>() {
    private var listOfCards = listOf<CardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playgroud_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = listOfCards[position]
        holder.bindView(item)
        holder.itemView.setOnClickListener { onItemClickListener(item) }
    }

    override fun getItemCount(): Int = listOfCards.size

    fun setCardList(cards: List<CardModel>) {
        listOfCards = cards
        notifyDataSetChanged()
    }
}