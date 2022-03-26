package com.robin.wiser_wrtc

enum class GameType {
    PAIR_THE_CARDS, FASTEST_HANDS
}

class Game(val type: GameType, val title: String) {
    companion object {
        val PAIR_THE_CARDS = Game(GameType.PAIR_THE_CARDS, "Pair the cards")
        val FASTEST_HANDS = Game(GameType.FASTEST_HANDS,"Fastest Hands")
    }
}