package edu.ktu.bindingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.ktu.bindingapp.databinding.FragmentDogBinding

class DogFragment : Fragment() {

    val dogs = listOf(
        Dog("Sparky",
                5,
                DogBreed.GERMAN_SHEPHERD,
                R.drawable.german_shepherd_192),
        Dog("Brian",
                7,
                DogBreed.LABRADOR_RETRIEVER,
                R.drawable.labrador_retriever_192),
        Dog("Walter",
                1,
                DogBreed.GOLDEN_RETRIEVER,
                R.drawable.golden_retriever_192)
    )

    var dogIndex = 0

    val binding by lazy { FragmentDogBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.nextBtn.setOnClickListener { nextDog() }
        binding.prevBtn.setOnClickListener { previousDog() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDog()
    }

    fun showDog() {
        binding.nameText.text = dogs[dogIndex].name
        binding.ageText.text = dogs[dogIndex].age.toString()
        binding.breedText.text = dogs[dogIndex].breed.breedName
        binding.breedImg.setImageResource(dogs[dogIndex].image)
    }

    fun nextDog() {
        dogIndex++
        if(dogIndex > dogs.lastIndex)
            dogIndex = 0
        showDog()
    }

    fun previousDog() {
        dogIndex--
        if(dogIndex < 0)
            dogIndex = dogs.lastIndex
        showDog()
    }
}