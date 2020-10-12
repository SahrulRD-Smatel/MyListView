package com.example.mylistview

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class DemonAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Demon>()

    override fun getCount(): Int = heroes.size

    override fun getItem(i: Int): Any = heroes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_demon, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Demon
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
        internal fun bind(demon: Demon) {
            txtName.text = demon.name
            txtDescription.text = demon.description
            imgPhoto.setImageResource(demon.photo)
        }
    }
}