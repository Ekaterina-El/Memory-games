package ka.el.memorygames.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlaygroundViewModel: ViewModel() {

    private var _movies = MutableLiveData<Int>()
    val movies: LiveData<Int> get() = _movies

    init {
        _movies.value = 0
    }

    fun addMovies() {
        _movies.value = _movies.value!!.plus(1)
    }
}