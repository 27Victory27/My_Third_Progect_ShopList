package com.example.my_third_progect_shoplist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemId:Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}