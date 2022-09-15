package com.example.my_third_progect_shoplist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem:ShopItem)
    fun deleteShopItem(shopItem:ShopItem)
    fun editShopItem(shopItem:ShopItem)
    fun getShopItem(shopItemId:Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}