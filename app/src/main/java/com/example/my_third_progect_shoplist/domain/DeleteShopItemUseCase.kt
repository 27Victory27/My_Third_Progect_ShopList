package com.example.my_third_progect_shoplist.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem:ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}