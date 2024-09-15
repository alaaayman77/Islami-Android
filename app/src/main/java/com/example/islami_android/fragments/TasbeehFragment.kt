package com.example.islami_android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islami_android.R
import android.animation.ObjectAnimator
import android.view.animation.DecelerateInterpolator

class TasbeehFragment : Fragment() {
    private lateinit var sebhaImageView: ImageView
    private lateinit var counterTextView: TextView
    private lateinit var tasbeehTextView: TextView
    private lateinit var tasbeehList: MutableList<String>
    private var counter: Int = 0
    var index :Int =0;
    private var currentRotation: Float = 0f // Keeps track of the current rotation angle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intializeList()
        initViews(view)
        sebhaRotation()
    }

    private fun initViews(view: View) {
        sebhaImageView = view.findViewById(R.id.sebha_image)
        counterTextView = view.findViewById(R.id.sebha_counter)
        tasbeehTextView = view.findViewById(R.id.tasbeeh_text)
        counterTextView.text = "0"
        tasbeehTextView.text = tasbeehList.get(0)
    }
   private fun intializeList(){
       tasbeehList = mutableListOf()
       tasbeehList.add("الحمدالله")
       tasbeehList.add("سبحان الله")
       tasbeehList.add("لا حول و لا قوة الا بالله")
   }



    private fun sebhaRotation() {
        sebhaImageView.setOnClickListener {
            val rotationAnimator = ObjectAnimator.ofFloat(sebhaImageView, "rotation", currentRotation, currentRotation + 45f)
            rotationAnimator.duration = 500 // Set duration for smoothness
            rotationAnimator.interpolator = DecelerateInterpolator() // Add a decelerating effect at the end
            rotationAnimator.start()

            // Update current rotation after animation completes
            currentRotation += 45f

            // Update counter and handle Tasbeeh text change
            counter++
            counterTextView.text = counter.toString()
            if (counter % 33 == 0 && index < tasbeehList.size - 1) {
                index++
                tasbeehTextView.text = tasbeehList[index]
            } else if (counter % 33 == 0 && index >= tasbeehList.size - 1) {
                index = 0
                tasbeehTextView.text = tasbeehList[index]
            }
        }
    }

}
