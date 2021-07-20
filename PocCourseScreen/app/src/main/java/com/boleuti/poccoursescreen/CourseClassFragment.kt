package com.boleuti.poccoursescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.boleuti.poccoursescreen.databinding.FragmentFirstBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CourseClassFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter = TestListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.rvClassList?.adapter = adapter
        val listItem = arrayListOf<TestListAdapter.ItemList>()
        var i = 0
        while(i++ < 500) {
            listItem.add(TestListAdapter.ItemList(i, "title: $i - ${Random.nextInt(500, 9000)}"))
        }
        adapter.submitList(listItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}