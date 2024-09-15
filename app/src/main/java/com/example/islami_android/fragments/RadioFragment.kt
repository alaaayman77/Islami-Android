package com.example.islami_android.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islami_android.R

class RadioFragment : Fragment() {

    lateinit var playImage: ImageView
    lateinit var prevImage: ImageView
    lateinit var nextImage: ImageView
    lateinit var radioText: TextView

    private var mediaPlayer: MediaPlayer? = null
    private var currentTrackIndex = 0


    private val audioFiles = listOf(
        R.raw.alfatiha,
        R.raw.alikhlas,
        R.raw.alfalaq,
        R.raw.alnas
    )


    private val audioNames = listOf(
        "سورة الفاتحة",
        "سورة الاخلاص",
        "سورة الفلق" ,
        "سوره الناس"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playImage = view.findViewById(R.id.ic_play)
        prevImage = view.findViewById(R.id.ic_prev)
        nextImage = view.findViewById(R.id.ic_next)
        radioText = view.findViewById(R.id.radio_text)


        mediaPlayer = MediaPlayer.create(context, audioFiles[currentTrackIndex])
        updateRadioText()


        playImage.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                playImage.setImageResource(R.drawable.ic_play)
            } else {
                mediaPlayer?.start()
                playImage.setImageResource(R.drawable.ic_pause)
            }
        }


        prevImage.setOnClickListener {
            changeTrack(-1)
        }


        nextImage.setOnClickListener {
            changeTrack(1)
        }
    }


    private fun changeTrack(direction: Int) {
        mediaPlayer?.stop()
        mediaPlayer?.release()

        currentTrackIndex += direction


        if (currentTrackIndex < 0) {
            currentTrackIndex = audioFiles.size - 1
        } else if (currentTrackIndex >= audioFiles.size) {
            currentTrackIndex = 0
        }

        mediaPlayer = MediaPlayer.create(context, audioFiles[currentTrackIndex])
        mediaPlayer?.start()

        updateRadioText()
    }

    private fun updateRadioText() {
        radioText.text = audioNames[currentTrackIndex]
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
