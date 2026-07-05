package com.xkhallas.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xkhallas.app.R
import com.xkhallas.app.adapter.GameAdapter
import com.xkhallas.app.model.Game
import com.xkhallas.app.service.BotFloatingService

class GameListActivity : AppCompatActivity() {

    private lateinit var gameAdapter: GameAdapter
    private val games = mutableListOf<Game>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_list)
        
        val gamesRecyclerView = findViewById<RecyclerView>(R.id.gamesRecyclerView)
        val addGameButton = findViewById<Button>(R.id.addGameButton)
        val logoutButton = findViewById<Button>(R.id.logoutButton)
        
        gameAdapter = GameAdapter(games) { game ->
            val intent = Intent(this, GameWebViewActivity::class.java)
            intent.putExtra("gameUrl", game.url)
            intent.putExtra("gameName", game.name)
            startActivity(intent)
        }
        
        gamesRecyclerView.layoutManager = LinearLayoutManager(this)
        gamesRecyclerView.adapter = gameAdapter
        
        addGameButton.setOnClickListener {
            startActivity(Intent(this, AddGameActivity::class.java))
        }
        
        logoutButton.setOnClickListener {
            val sharedPref = getSharedPreferences("SalaPB", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("isLoggedIn", false)
                clear()
                apply()
            }
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        
        loadGames()
        startBotService()
    }

    private fun loadGames() {
        games.clear()
        games.add(Game("Mines", "https://ck44.com"))
        games.add(Game("Aviator", "https://ck44.com"))
        games.add(Game("Coin Toss", "https://ck44.com"))
        games.add(Game("Roulette", "https://ck44.com"))
        games.add(Game("Andar Bahar", "https://ck44.com"))
        games.add(Game("Mines", "https://cv666.com"))
        games.add(Game("Aviator", "https://cv666.com"))
        games.add(Game("Coin Toss", "https://cv666.com"))
        games.add(Game("Roulette", "https://cv666.com"))
        games.add(Game("Andar Bahar", "https://cv666.com"))
        games.add(Game("Mines", "https://299bet.com"))
        games.add(Game("Aviator", "https://299bet.com"))
        games.add(Game("Coin Toss", "https://299bet.com"))
        games.add(Game("Roulette", "https://299bet.com"))
        games.add(Game("Andar Bahar", "https://299bet.com"))
        games.add(Game("Mines", "https://499bet.com"))
        games.add(Game("Aviator", "https://499bet.com"))
        games.add(Game("Coin Toss", "https://499bet.com"))
        games.add(Game("Roulette", "https://499bet.com"))
        games.add(Game("Andar Bahar", "https://499bet.com"))
        games.add(Game("Mines", "https://3333bet.com"))
        games.add(Game("Aviator", "https://3333bet.com"))
        games.add(Game("Coin Toss", "https://3333bet.com"))
        games.add(Game("Roulette", "https://3333bet.com"))
        games.add(Game("Andar Bahar", "https://3333bet.com"))
        games.add(Game("Mines", "https://3111bet.com"))
        games.add(Game("Aviator", "https://3111bet.com"))
        games.add(Game("Coin Toss", "https://3111bet.com"))
        games.add(Game("Roulette", "https://3111bet.com"))
        games.add(Game("Andar Bahar", "https://3111bet.com"))
        games.add(Game("Mines", "https://tk999.com"))
        games.add(Game("Aviator", "https://tk999.com"))
        games.add(Game("Coin Toss", "https://tk999.com"))
        games.add(Game("Roulette", "https://tk999.com"))
        games.add(Game("Andar Bahar", "https://tk999.com"))
        games.add(Game("Mines", "https://bk33.com"))
        games.add(Game("Aviator", "https://bk33.com"))
        games.add(Game("Coin Toss", "https://bk33.com"))
        games.add(Game("Roulette", "https://bk33.com"))
        games.add(Game("Andar Bahar", "https://bk33.com"))
        games.add(Game("Mines", "https://eg333.com"))
        games.add(Game("Aviator", "https://eg333.com"))
        games.add(Game("Coin Toss", "https://eg333.com"))
        games.add(Game("Roulette", "https://eg333.com"))
        games.add(Game("Andar Bahar", "https://eg333.com"))
        games.add(Game("Mines", "https://3999bet.com"))
        games.add(Game("Aviator", "https://3999bet.com"))
        games.add(Game("Coin Toss", "https://3999bet.com"))
        games.add(Game("Roulette", "https://3999bet.com"))
        games.add(Game("Andar Bahar", "https://3999bet.com"))
        games.add(Game("Mines", "https://bd222.com"))
        games.add(Game("Aviator", "https://bd222.com"))
        games.add(Game("Coin Toss", "https://bd222.com"))
        games.add(Game("Roulette", "https://bd222.com"))
        games.add(Game("Andar Bahar", "https://bd222.com"))
        games.add(Game("Mines", "https://777bd.com"))
        games.add(Game("Aviator", "https://777bd.com"))
        games.add(Game("Coin Toss", "https://777bd.com"))
        games.add(Game("Roulette", "https://777bd.com"))
        games.add(Game("Andar Bahar", "https://777bd.com"))
        games.add(Game("Mines", "https://eg33bet.com"))
        games.add(Game("Aviator", "https://eg33bet.com"))
        games.add(Game("Coin Toss", "https://eg33bet.com"))
        games.add(Game("Roulette", "https://eg33bet.com"))
        games.add(Game("Andar Bahar", "https://eg33bet.com"))
        gameAdapter.notifyDataSetChanged()
    }

    private fun startBotService() {
        val intent = Intent(this, BotFloatingService::class.java)
        startService(intent)
    }
}
