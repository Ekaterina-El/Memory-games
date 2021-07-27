package ka.el.memorygames.ui.playground

import android.graphics.drawable.Drawable

data class CardModel(
    var imageResId: Drawable,
    var isOpened: Boolean = false,
    var name: String = ""
)