package ka.el.memorygames.ui.playground.list

import android.animation.ObjectAnimator
import android.view.View
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import androidx.recyclerview.widget.RecyclerView
import ka.el.memorygames.R
import ka.el.memorygames.ui.playground.CardModel

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.playground_item_image)
    private lateinit var viewModel: CardModel

    private val animationStart1 = ObjectAnimator.ofFloat(itemView, "rotationY", 0.0f, 90f)
    private val animationStart2 = ObjectAnimator.ofFloat(itemView, "rotationY", 90f, 180f)

    private val animationEnd1 = ObjectAnimator.ofFloat(itemView, "rotationY", 180f, 90f)
    private val animationEnd2 = ObjectAnimator.ofFloat(itemView, "rotationY", 90f, 0f)

    fun bindView(viewModel: CardModel) {
        this.viewModel = viewModel

        animationStart1.doOnEnd {
            image.setImageDrawable(viewModel.imageResId)
            animationStart2.start()
        }

        animationEnd1.doOnEnd {
            image.setImageResource(R.drawable.question)
            animationEnd2.start()
        }
    }

    fun openCard() {
        animationStart1.start()
        viewModel.isOpened = true
    }

    fun closeCard() {
        animationEnd1.start()
        viewModel.isOpened = false
    }
}