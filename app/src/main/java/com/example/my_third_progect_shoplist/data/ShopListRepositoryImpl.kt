package com.example.my_third_progect_shoplist.data

import android.app.Instrumentation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.my_third_progect_shoplist.domain.ShopItem
import com.example.my_third_progect_shoplist.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList = mutableListOf<ShopItem>() //в этой переменной будем хранить коллекцию эл-тов
    private var autoIncrementId = 0

    init{
        for (i in 0 until 10){
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id==ShopItem.UNDEFINED_ID) { //проверка нужна для сохранения id ИЗМЕНЯЕМОГО (editShopItem) эл-та
            shopItem.id = autoIncrementId
        }
        autoIncrementId++
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) { //находим старый эл-нт по id, удаляем его, затем добавляем новый
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId } ?: throw RuntimeException("Element with id $shopItemId not found") //обработка нулабельного исхода
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD // .toList() чтобы создать копию листа, ибо возвращать оригинал нехорошо. (.toMutableList() - если коллекция именяемая)
    }

    private fun updateList(){
        shopListLD.value = shopList.toList()
    }

}