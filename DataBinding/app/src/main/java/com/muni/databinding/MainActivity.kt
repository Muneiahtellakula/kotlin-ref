package com.muni.databinding

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.muni.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var databinding:ActivityMainBinding
    //for inisilizing
    var p1_score:Int=0
    var p2_score:Int=0
    var p1_roll:Int=0
    var p2_roll:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        databinding.button.setOnClickListener { setName() }
        //for dice task realted databinding
        databinding.btnPlayer1.setOnClickListener { roll_plaer1() }
        databinding.implicitButton.setOnClickListener { openBroswer() }
    }

    private fun openBroswer() {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val i =Intent()
        i.setAction(ACTION_VIEW)
        i.setData((Uri.parse("https://github.com/Muneiahtellakula")))
        startActivity(i)
    }

    private fun roll_plaer1() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /*When player 1 play time*/
        p1_roll=(1..6).random()//for randome
        p1_score=p1_score+p1_roll//for appending the rolled score
        displayDic(p2_roll)
        if (p1_roll==0)
        {
            databinding.imgp1.setImageResource(R.drawable.dice_1)
            databinding.resultp1.text="1"
        }
        else if (p1_roll==6)
        {
            databinding.player1Score.text = p1_roll.toString()
        }else {
            databinding.resultp1.text = p1_roll.toString()
            databinding.player1Score.text = p1_score.toString()

        }

        /*When player 2 play time*/
        p2_roll=(1..6).random()//for randome
        p2_score=p2_score+p2_roll//for appending the rolled score
        if (p2_roll==0)
        {
            databinding.imgp2.setImageResource(R.drawable.dice_1)
            databinding.resultp2.text="1"
        }
        else if (p2_roll==6)
        {
            databinding.player2Score.text = p2_roll.toString()
        }else {
            databinding.resultp2.text = p2_roll.toString()
            databinding.player2Score.text = p2_score.toString()
        }
        displayDicp2(p2_roll)


    }

    private fun setName() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val n = databinding.editText.text.toString()
        databinding.tv.text=n
        val d=Name(n)
        databinding.n=d
      /*  val d = Name(n)
        databinding.n = d*/
        val intent=Intent(this,SecondActivity::class.java)
        intent.putExtra("msg",n)
        startActivity(intent)

    }
    private fun displayDic(r: Int) {
        when (r) {
            1-> databinding.imgp1.setImageResource(R.drawable.dice_1)
            2->databinding.imgp1.setImageResource(R.drawable.dice_2)
            3->databinding.imgp1.setImageResource(R.drawable.dice_3)
            4->databinding.imgp1.setImageResource(R.drawable.dice_4)
            5->databinding.imgp1.setImageResource(R.drawable.dice_5)
            6->databinding.imgp1.setImageResource(R.drawable.dice_6)
            else->{
                databinding.imgp1.setImageResource(R.drawable.empty_dice)
            }

        }
    }
    private fun displayDicp2(r: Int) {
        when (r) {
            1-> databinding.imgp2.setImageResource(R.drawable.dice_1)
            2->databinding.imgp2.setImageResource(R.drawable.dice_2)
            3->databinding.imgp2.setImageResource(R.drawable.dice_3)
            4->databinding.imgp2.setImageResource(R.drawable.dice_4)
            5->databinding.imgp2.setImageResource(R.drawable.dice_5)
            6->databinding.imgp2.setImageResource(R.drawable.dice_6)
            else->{
                databinding.imgp2.setImageResource(R.drawable.empty_dice)
            }

        }
    }
}
