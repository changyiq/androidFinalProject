package finalproject.stN991554423.org.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import finalproject.stN991554423.org.data.HabitRun
import finalproject.stN991554423.org.databinding.HabitListBinding

class HabitRunItemListAdapter(private val onItemClicked: (HabitRun) -> Unit) :
    ListAdapter<HabitRun, HabitRunItemListAdapter.ItemViewHolder>(DiffCallback) {

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

        fun bind(item: HabitRun) {
            binding.apply {
                habitField1.text = item.runDate
                habitField2.text = item.runTime
                habitField3.text = item.runDistance.toString()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<HabitRun>() {
            override fun areItemsTheSame(oldItem: HabitRun, newItem: HabitRun): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: HabitRun, newItem: HabitRun): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


}