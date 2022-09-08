package com.example.my_third_progect_shoplist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem:ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}