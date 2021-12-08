/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:RecyclerView Adapter class to hold each cardView value of the list from reading habit collection, and also perform the item click event
 */

package finalproject.stN991554423.org.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import finalproject.stN991554423.org.data.HabitReading
import finalproject.stN991554423.org.databinding.HabitListBinding

class HabitReadingItemListAdapter(private val onItemClicked: (HabitReading) -> Unit) :
    ListAdapter<HabitReading, HabitReadingItemListAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            HabitListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    class ItemViewHolder(private var binding: HabitListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HabitReading) {
            binding.apply {
                habitField1.text = item.readingDate
                habitField2.text = item.readingTime
                habitField3.text = item.readingDuration.toString()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<HabitReading>() {
            override fun areItemsTheSame(oldItem: HabitReading, newItem: HabitReading): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: HabitReading, newItem: HabitReading): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


}