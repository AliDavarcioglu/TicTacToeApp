package com.example.xox


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.xox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var combinationList = mutableListOf<IntArray>()
    private var boxPositions= arrayOf(0,0,0,0,0,0,0,0,0)
    private var playerTurn = 1
    private var totalSelectedBoxes= 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        combinationList.add(intArrayOf(0, 1, 2))
        combinationList.add(intArrayOf(3, 4, 5))
        combinationList.add(intArrayOf(6, 7, 8))
        combinationList.add(intArrayOf(0, 3, 6))
        combinationList.add(intArrayOf(1, 4, 7))
        combinationList.add(intArrayOf(2, 5, 8))
        combinationList.add(intArrayOf(2, 4, 6))
        combinationList.add(intArrayOf(0, 4, 8))





    }
    fun click0 (view: View){
        if (isBoxSelectable(0)){
            performAction(view as ImageView,0)
        }



    }

    fun click1 (view: View){
        if (isBoxSelectable(1)){
            performAction(view as ImageView,1)
        }



    }
    fun click2 (view: View){
        if (isBoxSelectable(2)){
            performAction(view as ImageView,2)
        }



    }
    fun click3 (view: View){
        if (isBoxSelectable(3)){
            performAction(view as ImageView,3)
        }



    }
    fun click4 (view: View){
        if (isBoxSelectable(4)){
            performAction(view as ImageView,4)
        }



    }
    fun click5 (view: View){
        if (isBoxSelectable(5)){
            performAction(view as ImageView,5)
        }



    }
    fun click6 (view: View){
        if (isBoxSelectable(6)){
            performAction(view as ImageView,6)
        }



    }
    fun click7 (view: View){
        if (isBoxSelectable(7)){
            performAction(view as ImageView,7)
        }



    }
    fun click8 (view: View){
    if (isBoxSelectable(8)){
        performAction(view as ImageView,8)
    }

    }

    fun restart (view: View){
        boxPositions= arrayOf(0,0,0,0,0,0,0,0,0)
        playerTurn=1
        totalSelectedBoxes=1
        binding.view0.setImageResource(0)
        binding.view1.setImageResource(0)
        binding.view2.setImageResource(0)
        binding.view3.setImageResource(0)
        binding.view4.setImageResource(0)
        binding.view5.setImageResource(0)
        binding.view6.setImageResource(0)
        binding.view7.setImageResource(0)
        binding.view8.setImageResource(0)
        binding.textView.setText("")

    }


    fun isBoxSelectable(boxPosition: Int):Boolean{
    var response= false
        if (boxPositions[boxPosition]==0){
            response=true
        }
        return response
    }
    fun checkResults():Boolean{
        var response:Boolean = false
        for (i in 0 until combinationList.size){
            val combination: IntArray = combinationList[i]
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]] == playerTurn &&
                boxPositions[combination[2]] == playerTurn){
                response=true
            }
        }
        return response
    }


    fun performAction (imageView:ImageView,selectedBoxPosition:Int){
        boxPositions[selectedBoxPosition] = playerTurn

        if (playerTurn==1){
            imageView.setImageResource(R.drawable.x)
            if (checkResults()){
                binding.textView.setText("X Kazandı")
            }else if (totalSelectedBoxes==9){
                binding.textView.setText("Berabere")
            }else{
                totalSelectedBoxes++
                playerTurn=2
            }

        }else{
            imageView.setImageResource(R.drawable.oo)
            if (checkResults()){
                binding.textView.setText("O kazandı")
            }else if (totalSelectedBoxes==9){
                binding.textView.setText("Berabere")
            }else{
                totalSelectedBoxes++
                playerTurn=1
            }
        }


    }






}
