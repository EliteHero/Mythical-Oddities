package com.example.mythicaloddities.data

import com.example.mythicaloddities.R
import com.example.mythicaloddities.model.Badge
import com.example.mythicaloddities.model.Creature
import com.example.mythicaloddities.model.Place

class DataSource {
    fun loadCreatures(): List<Creature> {
        return listOf(
            Creature(1, R.string.creature1, R.drawable.creature1, R.string.creature1Detail),
            Creature(2, R.string.creature2, R.drawable.creature2, R.string.creature2Detail),
            Creature(3, R.string.creature3, R.drawable.creature3, R.string.creature3Detail),
            Creature(4, R.string.creature4, R.drawable.creature4, R.string.creature4Detail),
            Creature(5, R.string.creature5, R.drawable.creature5, R.string.creature5Detail),
            Creature(6, R.string.creature6, R.drawable.creature6, R.string.creature6Detail),
            Creature(7, R.string.creature7, R.drawable.creature7, R.string.creature7Detail),
            Creature(8, R.string.creature8, R.drawable.creature8, R.string.creature8Detail),
            Creature(9, R.string.creature9, R.drawable.creature9, R.string.creature9Detail),
            Creature(10, R.string.creature10, R.drawable.creature10, R.string.creature10Detail)
        )
    }

    fun loadPlaces(): List<Place> {
        return listOf(
            Place(1, R.string.place1, R.drawable.place1, R.string.place1desc, R.string.place1detail),
            Place(2, R.string.place2, R.drawable.place2, R.string.place2desc, R.string.place2detail),
            Place(3, R.string.place3, R.drawable.place3, R.string.place3desc, R.string.place3detail),
            Place(4, R.string.place4, R.drawable.place4, R.string.place4desc, R.string.place4detail),
            Place(5, R.string.place5, R.drawable.place5, R.string.place5desc, R.string.place5detail),
            Place(6, R.string.place6, R.drawable.place6, R.string.place6desc, R.string.place6detail),
            Place(7, R.string.place7, R.drawable.place7, R.string.place7desc, R.string.place7detail),
            Place(8, R.string.place8, R.drawable.place8, R.string.place8desc, R.string.place8detail),
            Place(9, R.string.place9, R.drawable.place9, R.string.place9desc, R.string.place9detail),
            Place(10, R.string.place10, R.drawable.place10, R.string.place10desc, R.string.place10detail)
        )
    }

    fun loadBadges(): List<Badge> {
        return listOf(
            Badge(1, R.string.badge1, R.drawable.badge1, R.string.badge1desc),
            Badge(2, R.string.badge2, R.drawable.badge2, R.string.badge2desc),
            Badge(3, R.string.badge3, R.drawable.badge3, R.string.badge3desc),
            Badge(4, R.string.badge4, R.drawable.badge4, R.string.badge4desc),
            Badge(5, R.string.badge5, R.drawable.badge5, R.string.badge5desc),
            Badge(6, R.string.badge6, R.drawable.badge6, R.string.badge6desc),
            Badge(7, R.string.badge7, R.drawable.badge7, R.string.badge7desc),
            Badge(8, R.string.badge8, R.drawable.badge8, R.string.badge8desc),
            Badge(9, R.string.badge9, R.drawable.badge9, R.string.badge9desc),
            Badge(10, R.string.badge10, R.drawable.badge10, R.string.badge10desc)
        )
    }
}