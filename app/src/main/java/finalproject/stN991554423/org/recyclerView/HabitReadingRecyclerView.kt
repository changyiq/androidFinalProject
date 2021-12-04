package finalproject.stN991554423.org.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import finalproject.stN991554423.org.R
import finalproject.stN991554423.org.data.HabitReading

class HabitReadingRecyclerView (private val sampleList: List<HabitReading>): RecyclerView.Adapter <HabitReadingRecyclerView.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val field1: TextView = itemView.findViewById(R.id.habit_field_1)
        val field2: TextView = itemView.findViewById(R.id.habit_field_2)
        val field3: TextView = itemView.findViewById(R.id.habit_field_3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.habit_list,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = sampleList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampleList [position]

        holder.field1.text= currentItem.readingDate
        holder.field2.text= currentItem.readingTime
        holder.field3.text= currentItem.readingDuration.toString()

    }
}