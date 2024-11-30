package com.example.galleryanddatabase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.galleryanddatabase.Db.MyDbHelper
import com.example.galleryanddatabase.databinding.FragmentAddBinding
import com.example.galleryanddatabase.models.MyImage
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date

class AddFragment : Fragment() {
    private val binding by lazy { FragmentAddBinding.inflate(layoutInflater) }
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.imageAdd.setOnClickListener {
            getImageCount.launch("image/*")
        }
        myDbHelper = MyDbHelper(binding.root.context)
        binding.btnSave.setOnClickListener {
            val myImage = MyImage(absolutePath!!, binding.edtName.text.toString())
            myDbHelper.addImage(myImage)
            Toast.makeText(context, "SAVE", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    var absolutePath: String? = null
    private val getImageCount = registerForActivityResult(ActivityResultContracts.GetContent()) {
        it ?: return@registerForActivityResult
        binding.imageAdd.setImageURI(it)
        val inputStream = requireActivity().contentResolver?.openInputStream(it)
        val title = SimpleDateFormat("yyyyMMdd_hhmmss").format(Date())
        val file = File(requireActivity().filesDir, "${title}.jpg")
        val fileOutputStream = FileOutputStream(file)
        inputStream?.copyTo(fileOutputStream)
        inputStream?.close()
        fileOutputStream.close()
        absolutePath = file.absolutePath
    }

}