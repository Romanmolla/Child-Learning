package com.roman.clildlearning

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roman.clildlearning.databinding.ActivityMain2Binding
import com.roman.clildlearning.databinding.ActivityMainBinding
import com.roman.clildlearning.model.AlphaBets
import com.roman.clildlearning.view.AlphaBetAdapter

class MainActivity : AppCompatActivity() {




    private lateinit var alphaAdapter: AlphaBetAdapter
    private lateinit var alphaRecycler :RecyclerView
    private lateinit var alphaList:ArrayList<AlphaBets>
    lateinit var binding : ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //video screen
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.vid2 );
        binding.bgVideoView2.setVideoURI(videoUri);
        binding.bgVideoView2.start();
        binding.bgVideoView2.setOnCompletionListener {
            binding.bgVideoView2.start();
        }

        setContentView(R.layout.activity_main)
        /**set find Id and list*/
        alphaList = ArrayList()
        alphaRecycler = findViewById(R.id.alphaRecycler)
        alphaAdapter = AlphaBetAdapter(this,alphaList)
        /**set Adapter*/
        val layoutM = GridLayoutManager(this,2)
        alphaRecycler.layoutManager = layoutM
        alphaRecycler.adapter = alphaAdapter
        /**set dummy List*/
        alphaLists()


    }

    private fun alphaLists() {
        alphaList.add(AlphaBets(R.drawable.a,"A for Apple"))
        alphaList.add(AlphaBets(R.drawable.b,"B for Butterfly"))
        alphaList.add(AlphaBets(R.drawable.c,"C for Carrot"))
        alphaList.add(AlphaBets(R.drawable.d,"D for Duck"))
        alphaList.add(AlphaBets(R.drawable.e,"E for Eggplant"))
        alphaList.add(AlphaBets(R.drawable.f,"F for Fish"))
        alphaList.add(AlphaBets(R.drawable.g,"G for Gloves"))
        alphaList.add(AlphaBets(R.drawable.h,"H for Horse"))
        alphaList.add(AlphaBets(R.drawable.i,"I for Igloo"))
        alphaList.add(AlphaBets(R.drawable.j,"J for Jumping Rope"))
        alphaList.add(AlphaBets(R.drawable.k,"K for Key"))
        alphaList.add(AlphaBets(R.drawable.l,"L for Leaves"))
        alphaList.add(AlphaBets(R.drawable.m,"M for Mouse"))
        alphaList.add(AlphaBets(R.drawable.n,"N for  Nuts"))
        alphaList.add(AlphaBets(R.drawable.o,"O for Ostrich"))
        alphaList.add(AlphaBets(R.drawable.p,"P for Popcorn"))
        alphaList.add(AlphaBets(R.drawable.q,"Q for Quarter"))
        alphaList.add(AlphaBets(R.drawable.r,"R for Rabbit"))
        alphaList.add(AlphaBets(R.drawable.s,"S for Scissors"))
        alphaList.add(AlphaBets(R.drawable.t,"T for Tractor"))
        alphaList.add(AlphaBets(R.drawable.u,"U for Umbrella"))
        alphaList.add(AlphaBets(R.drawable.v,"V for Violin"))
        alphaList.add(AlphaBets(R.drawable.w,"W for Window"))
        alphaList.add(AlphaBets(R.drawable.x,"X for Xylophone"))
        alphaList.add(AlphaBets(R.drawable.y,"Y for Yak"))
        alphaList.add(AlphaBets(R.drawable.z,"z for zebra"))



    }



}