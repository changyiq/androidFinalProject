/*
    Date: December 5th, 2021
    Name(s): Qingqing Wu(991500423), Yiqian Chang(991554674)
    Description:RecyclerView Adapter class to hold each cardView value of the list from meditation habit collection, and also perform the item click event
 */

package finalproject.stN991554423.org.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import finalproject.stN991554423.org.data.HabitDrinking
import finalproject.stN991554423.org.data.HabitMeditation
import finalproject.stN991554423.org.databinding.HabitListBinding

class HabitMeditationItemListAdapter(private val onItemClicked: (HabitMeditation) -> Unit) :
    ListAdapter<HabitMeditation, HabitMeditationItemListAdapter.ItemViewHolder>(DiffCallback) {

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

        fun bind(item: HabitMeditation) {
            binding.apply {
                habitField1.text = item.meditationDate
                habitField2.text = item.meditationTime
                habitField3.text = item.meditationDuration.toString()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<HabitMeditation>() {
            override fun areItemsTheSame(oldItem: HabitMeditation, newItem: HabitMeditation): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: HabitMeditation, newItem: HabitMeditation): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


}