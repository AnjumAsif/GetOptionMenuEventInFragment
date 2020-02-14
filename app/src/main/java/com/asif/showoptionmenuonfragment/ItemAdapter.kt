package com.asif.showoptionmenuonfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val mContext: Context,
    private val itemArrayList: HashMap<String, Item>,
    private val itemLabel: ArrayList<String>,
    private val mListener: OnItemClick
) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.list_item_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemArrayList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemData = itemArrayList[itemLabel.get(position)]
        holder.textTitle.text = itemData!!.itemLabel
        holder.checkboxCreate.isChecked = itemData.isAdd
        holder.checkboxEdit.isChecked = itemData.isEdit
        holder.checkboxDelete.isChecked = itemData.isDelete
        holder.checkboxView.isChecked = itemData.isView


        holder.checkboxView.setOnCheckedChangeListener { _, isChecked ->
            itemData.isView = isChecked
            mListener.OnClickItemGet(itemArrayList)

        }
        holder.checkboxEdit.setOnCheckedChangeListener { _, isChecked ->
            itemData.isEdit = isChecked
            mListener.OnClickItemGet(itemArrayList)

        }
        holder.checkboxDelete.setOnCheckedChangeListener { _, isChecked ->
            itemData.isDelete = isChecked
            mListener.OnClickItemGet(itemArrayList)

        }
        holder.checkboxCreate.setOnCheckedChangeListener { _, isChecked ->
            itemData.isAdd = isChecked
            mListener.OnClickItemGet(itemArrayList)

        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle = itemView.findViewById<View>(R.id.textTitle) as TextView
        var checkboxView = itemView.findViewById<View>(R.id.checkboxView) as CheckBox
        var checkboxCreate = itemView.findViewById<View>(R.id.checkboxCreate) as CheckBox
        var checkboxEdit = itemView.findViewById<View>(R.id.checkboxEdit) as CheckBox
        var checkboxDelete = itemView.findViewById<View>(R.id.checkboxDelete) as CheckBox


    }
}