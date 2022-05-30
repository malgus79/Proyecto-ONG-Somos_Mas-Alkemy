package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
<<<<<<< HEAD
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
=======
import com.melvin.ongandroid.model.APIServices
import com.melvin.ongandroid.model.data.news.New
import com.melvin.ongandroid.model.data.slides.Slide
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.Testimonial
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {
<<<<<<< HEAD
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932


    init {
        getSlides()
        getTestimonials()
    }

    /* ---------------------------SLIDES REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _slidesList = MutableLiveData<SlidesList>()
<<<<<<< HEAD
<<<<<<< HEAD

    //External LiveData
    val slidesList: LiveData<SlidesList> = _slidesList




=======
    //External LiveData

    val slidesList: LiveData<SlidesList> = _slidesList


>>>>>>> 08a6025 (slider compiling)
=======
    //External LiveData

    val slidesList: LiveData<SlidesList> = _slidesList


>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
    fun getSlides() {
        var homeSlides: SlidesList
        viewModelScope.launch {

            try {
                homeSlides = homeRepository.getHomeSlides()
                _slidesList.value = homeSlides

            } catch (e: Exception) {
                homeSlides = SlidesList(emptyList(), "Error retrieving slides", false)
                _slidesList.value = homeSlides

            }
        }
    }

    /* ---------------------------TESTIMONIALS REQUEST--------------------------- */
    //Internal MutableLiveData
<<<<<<< HEAD
<<<<<<< HEAD
    private val _testimonialsList = MutableLiveData<TestimonialsList>()

    //External LiveData
    val testimonialsList: LiveData<TestimonialsList> = _testimonialsList



    fun getTestimonials() {
=======

=======

>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
    private val _testimonialsList = MutableLiveData<TestimonialsList>()
    //External LiveData

    val testimonialsList: LiveData<TestimonialsList> = _testimonialsList

    fun getTestimonials(){
<<<<<<< HEAD
>>>>>>> 08a6025 (slider compiling)
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
        var homeTestimonials: TestimonialsList
        viewModelScope.launch {

            try {
                homeTestimonials = homeRepository.getTestimonials()
                _testimonialsList.value = homeTestimonials

            } catch (e: Exception) {
                homeTestimonials = TestimonialsList(false,null,"Error retrieving testimonials")
                _testimonialsList.value = homeTestimonials
            }
        }
    }
}

<<<<<<< HEAD
<<<<<<< HEAD
=======
    /* ---------------------------NEWS REQUEST--------------------------- */
=======
/*

    */
/* ---------------------------NEWS REQUEST--------------------------- *//*

>>>>>>> 08a6025 (slider compiling)
    //Internal MutableLiveData
    private val _newsStatus = MutableLiveData<State>()
    private val _newsList = MutableLiveData<List<New>?>()
    //External LiveData
    val newsStatus: LiveData<State> = _newsStatus
    val newsList: LiveData<List<New>?> = _newsList

    suspend fun getNews(){
        _newsStatus.value = State.Loading()
        viewModelScope.launch {
            try {
                // val news = homeRepository.getNews().data
                _newsStatus.value = State.Success()
                // _newsList.value = news
            }
            catch (e: Exception){
                _newsStatus.value = State.Failure(e)
            }
        }
    }
*/

/*

    */
/* ---------------------------NEWS REQUEST--------------------------- *//*

    //Internal MutableLiveData
    private val _newsStatus = MutableLiveData<State>()
    private val _newsList = MutableLiveData<List<New>?>()
    //External LiveData
    val newsStatus: LiveData<State> = _newsStatus
    val newsList: LiveData<List<New>?> = _newsList

    suspend fun getNews(){
        _newsStatus.value = State.Loading()
        viewModelScope.launch {
            try {
                // val news = homeRepository.getNews().data
                _newsStatus.value = State.Success()
                // _newsList.value = news
            }
            catch (e: Exception){
                _newsStatus.value = State.Failure(e)
            }
        }
    }
*/

    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
}
>>>>>>> 5e4589c (Testimony fragment added)
