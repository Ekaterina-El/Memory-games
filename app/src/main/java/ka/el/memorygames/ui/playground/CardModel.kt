package ka.el.memorygames.ui.playground

import android.graphics.drawable.Drawable

data class CardModel(
    var imageResId: Drawable,
    val isOpened: Boolean = false
)