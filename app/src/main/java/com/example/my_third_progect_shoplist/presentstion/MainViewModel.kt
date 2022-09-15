package com.example.my_third_progect_shoplist.presentstion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_third_progect_shoplist.data.ShopListRepositoryImpl
import com.example.my_third_progect_shoplist.domain.DeleteShopItemUseCase
import com.example.my_third_progect_shoplist.domain.EditShopItemUseCase
import com.example.my_third_progect_shoplist.domain.GetShopListUseCase
import com.example.my_third_progect_shoplist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl //передали реаизацию интерфейса и её передаём в UseCase-ы

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()//MutableLiveData<List<ShopItem>>() //Взаимодействие Activity и View-модели ДОЛЖНО происходит через LiveData
    // (нельзя создавать экземпляр LiveData, ибо это абстр.класс, зато можно от его наследника - MutableLiveData)
    // MutableLiveData - это LiveData, в кот. мы можем сами вставлять объекты и все подписчики сразу их получат

    fun deleteShopItem(shopItem:ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}