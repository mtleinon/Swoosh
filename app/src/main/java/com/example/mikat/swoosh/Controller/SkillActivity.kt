package com.example.mikat.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.mikat.swoosh.Model.Player
import com.example.mikat.swoosh.R
import com.example.mikat.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        var player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        skillFinishBtn.setOnClickListener{
            if (player.skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_PLAYER, player)
                startActivity(finishActivity)
            } else {
                Toast.makeText(this,"Please select skill level", Toast.LENGTH_SHORT).show()
            }
        }

        begingerSkillBtn.setOnClickListener {
            ballerSkillBtn.isChecked = false
            player.skill = "beginger"
        }

        ballerSkillBtn.setOnClickListener {
            begingerSkillBtn.isChecked = false
            player.skill = "baller"
        }

    }

}
