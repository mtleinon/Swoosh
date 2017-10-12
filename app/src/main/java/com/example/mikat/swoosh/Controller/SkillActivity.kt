package com.example.mikat.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.mikat.swoosh.R
import com.example.mikat.swoosh.Utilities.EXTRA_LEAGUE
import com.example.mikat.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)

        skillFinishBtn.setOnClickListener{
            if (skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_LEAGUE,league)
                finishActivity.putExtra(EXTRA_SKILL,skill)
                startActivity(finishActivity)
            } else {
                Toast.makeText(this,"Please select skill level", Toast.LENGTH_SHORT).show()
            }
        }

        begingerSkillBtn.setOnClickListener {
            ballerSkillBtn.isChecked = false
            skill = "beginger"
        }

        ballerSkillBtn.setOnClickListener {
            begingerSkillBtn.isChecked = false
            skill = "baller"
        }

    }

}
