package com.patikadev.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.patikadev.livedata.databinding.FragmentFirstBinding
import com.patikadev.livedata.model.LoginState
import com.patikadev.livedata.viewmodel.MyViewModel
import kotlin.math.log

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    private lateinit var viewModel: MyViewModel
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java) //viewmodel yaratıldıysa instance'ını, yaratılmadıysa lifecyle aware olarak yaratıyor ve döndürüyor

        /*viewModel.isOperationDone.observe(viewLifecycleOwner, { isDone ->
            if (isDone) {
                Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Uncompleted", Toast.LENGTH_SHORT).show()
            }

        })*/

        /*viewModel.greetingsMessage.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

        })*/



        viewModel.datasReceived.observe(viewLifecycleOwner, { receivedDataAsString ->
            Toast.makeText(requireContext(), receivedDataAsString, Toast.LENGTH_SHORT).show()
        })

        viewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            viewModel.setStatus()
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}