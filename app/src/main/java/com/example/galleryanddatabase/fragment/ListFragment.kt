package com.example.galleryanddatabase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.galleryanddatabase.Db.MyDbHelper
import com.example.galleryanddatabase.adapter.MyImageAdapter
import com.example.galleryanddatabase.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var myImageAdapter: MyImageAdapter
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        myDbHelper=MyDbHelper(binding.root.context)
        myImageAdapter=MyImageAdapter(myDbHelper.getAllImage())
        binding.rv.adapter=myImageAdapter
        return binding.root
    }

}