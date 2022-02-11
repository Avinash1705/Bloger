package com.example.blog.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blog.R
import com.example.blog.adapter.RecycerViewDetail
import com.example.blog.databinding.FragmentShowListBinding
import com.example.blog.model.UserDetail

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var  binding :FragmentShowListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowListBinding.inflate(inflater,container,false)
//        return inflater.inflate(R.layout.fragment_show_list, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populatingHorizontalList()
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShowListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun populatingHorizontalList() {
        //fake data
        var arrayData = ArrayList<UserDetail>()
        arrayData.add(UserDetail(R.drawable.per1, "Deep", "Noob", "Web Dev", 555))
        arrayData.add(UserDetail(R.drawable.per2, "Avinash", "Pro", "Android Dev", 222))
        arrayData.add(UserDetail(R.drawable.per3, "jeys", "Moderate", "Entrepreneur", 559))

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        val recyAdapter = RecycerViewDetail(arrayData, requireContext())
        binding.rv.adapter = recyAdapter
    }
}