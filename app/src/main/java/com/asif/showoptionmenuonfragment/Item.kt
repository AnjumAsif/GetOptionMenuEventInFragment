package com.asif.showoptionmenuonfragment

data class Item(
    var itemLabel: String,
    var isAdd: Boolean = false,
    var isEdit: Boolean = false,
    var isDelete: Boolean = false,
    var isView: Boolean = false
) {
    constructor() : this("")
}



