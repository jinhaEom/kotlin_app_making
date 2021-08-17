package com.example.contentresolver

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentresolver.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MusicRecyclerAdapter: RecyclerView.Adapter<MusicRecyclerAdapter.Holder>() {
    var musicList = mutableListOf<Music>() //어댑터 클래스 가장 윗줄에 음악 목록을 저장해둘 변수 생성.
    var mediaPlayer : MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)

        return Holder(binding)
    }
    override fun getItemCount(): Int {
        return musicList.size
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList.get(position)
        holder.setMusic(music)
    }
    inner class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        var musicUri : Uri? = null

        init{
            binding.root.setOnClickListener{
                if (mediaPlayer!=null){
                    mediaPlayer?.release()
                    mediaPlayer= null
                }
                mediaPlayer = MediaPlayer.create(binding.root.context,musicUri)
                mediaPlayer?.start()
            }
        }
        fun setMusic(music:Music){
            binding.run {
                imageAlbum.setImageURI(music.getAlbumUri())
                textArtist.text = music.artist
                textTitle.text = music.title

                val duration = SimpleDateFormat("mm:ss").format(music.duration)
                textDuration.text = duration
            }
            this.musicUri = music.getMusicUri()
        }
    }
}

