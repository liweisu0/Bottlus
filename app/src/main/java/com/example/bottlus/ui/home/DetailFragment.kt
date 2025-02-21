import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottlus.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val args: DetailFragmentArgs by navArgs()
        
        binding.detailImage.setImageResource(args.item.imageRes)
        binding.detailContent.text = args.item.content
        
        return binding.root
    }
}

class DetailFragmentArgs {

}
