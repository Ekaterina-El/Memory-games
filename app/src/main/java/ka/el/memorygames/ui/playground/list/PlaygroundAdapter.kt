package ka.el.memorygames.ui.playground.list

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ka.el.memorygames.R
import ka.el.memorygames.ui.playground.CardModel

class PlaygroundAdapter(private val onItemClickListener: (CardModel) -> Unit) :
    RecyclerView.Adapter<CardViewHolder>() {
    private var listOfCards = listOf<CardModel>()
    private var openedCard: CardViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.playgroud_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = listOfCards[position]
        holder.bindView(item)
        holder.itemView.setOnClickListener {
            if (!item.isOpened) {
                onItemClickListener(item)
                openCard(holder)
            }
        }
    }

    private fun openCard(holder: CardViewHolder) {
        holder.openCard()
        if (openedCard == null) {
            openedCard = holder
        } else {
            if (listOfCards[holder.adapterPosition].name == listOfCards[openedCard!!.adapterPosition].name) {
                openedCard = null
            } else {
                val handler = Handler()
                handler.postDelayed(Runnable {
                    val positionsForClose = listOf(holder, openedCard)
                    closeCards(positionsForClose)
                    openedCard = null
                }, 500)
            }
        }
    }

    private fun closeCards(positionsForClose: List<CardViewHolder?>) {
        positionsForClose.forEach { card ->
            card?.closeCard()
        }
    }

    override fun getItemCount(): Int = listOfCards.size

    fun setCardList(cards: List<CardModel>) {
        listOfCards = cards
        notifyDataSetChanged()
    }
}