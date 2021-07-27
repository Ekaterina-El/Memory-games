package ka.el.memorygames.ui.playground.list

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ka.el.memorygames.R
import ka.el.memorygames.ui.playground.CardModel

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.playground_item_image)
    private lateinit var viewModel: CardModel

    fun bindView(viewModel: CardModel) {
        this.viewModel = viewModel
    }

    fun openCard() {
        image.setImageDrawable(viewModel.imageResId)
        viewModel.isOpened = true
    }

    fun closeCard() {
        image.setImageResource(R.drawable.question)
        viewModel.isOpened = false
    }
}