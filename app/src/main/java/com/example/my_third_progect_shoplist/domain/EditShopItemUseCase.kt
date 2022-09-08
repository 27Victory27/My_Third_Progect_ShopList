package com.example.my_third_progect_shoplist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem:ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}