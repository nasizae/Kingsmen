import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingsmen.data.model.PostReviws
import com.example.kingsmen.databinding.ItemReviewsBinding

class ReviewsAdapter : RecyclerView.Adapter<ReviewsAdapter.ReviewsHolder>() {
    private val _list = mutableListOf<PostReviws>()
    val list get() = _list

    @SuppressLint("NotifyDataSetChanged")
    fun addData(postReviws: List<PostReviws>) {
        _list.clear()
        _list.addAll(postReviws)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsHolder {
        val binding = ItemReviewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewsHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ReviewsHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ReviewsHolder(private val binding: ItemReviewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postReviws: PostReviws) {
            with(binding) {
                tvName.text = postReviws.client.toString()
                tvDesc.text = postReviws.text
                time.text = postReviws.date_time
            }
        }
    }
}
