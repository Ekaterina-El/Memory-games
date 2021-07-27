package ka.el.memorygames.ui.playground.list

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ka.el.memorygames.R
import ka.el.memorygames.ui.playground.CardModel

class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.playground_item_image)

    fun bindView(viewModel: CardModel) {

//        image.setImageResource(R.id.ditto)
    }
}