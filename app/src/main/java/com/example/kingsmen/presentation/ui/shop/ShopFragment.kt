package com.example.kingsmen.presentation.ui.shop

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kingsmen.R
import com.example.kingsmen.core.BaseFragment
import com.example.kingsmen.data.network.RetrofitClient
import com.example.kingsmen.data.remote.RemoteDataSource
import com.example.kingsmen.databinding.FragmentShopBinding
import com.example.kingsmen.domain.repository.Repository
import com.example.kingsmen.presentation.ui.shop.adapter.ShopAdapter

class ShopFragment : BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {
    private val retrofitClient=RetrofitClient().createApiService()
    private val remoteDataSource=RemoteDataSource(retrofitClient)
    private val repository=Repository(remoteDataSource)
    override val viewModel= ShopViewModel(repository)
    private val shopAdapter=ShopAdapter()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShopBinding {
        return FragmentShopBinding.inflate(inflater, container, false)
    }

    override fun initClicker() {
    }

    override fun initListenrs() {
        viewModel.getProduct()
    }

    @SuppressLint("SetTextI18n")
    override fun initLivedata() {

        viewModel.product.observe(viewLifecycleOwner){
            shopAdapter.addData(it)
            binding.rvProduct.adapter=shopAdapter
            binding.count.text=shopAdapter.itemCount.toString()+" товаров"
        }
        viewModel.loading.observe(viewLifecycleOwner){loading->
            if(loading){
                binding.loading.root.visibility=View.VISIBLE
            }
            else{
                binding.loading.root.visibility=View.GONE
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }
//    private fun onStudentClick(studentModel: StudentModel) {
//        val bundle = Bundle().apply {
//            putLong(StudentReportsCardFragment.STUDENT_ID, studentModel.id!!)
//            putString(StudentReportsCardFragment.STUDENT_NAME, studentModel.name)
//            putString(StudentReportsCardFragment.STUDENT_SURNAME, studentModel.surname)
//            putString(StudentReportsCardFragment.GROUP_NAME, groupName)
//            putInt(StudentReportsCardFragment.SUBJECT_TYPE_CLASSES, typeClasses)
//        }
//        findNavController().navigate(R.id.studentReportsCardFragment, bundle)
//    }
//
//    class StudentReportsCardFragment : BaseFragment<
//            FragmentStudentReportsCardBinding, StudentReportsCardViewModel
//            >(R.layout.fragment_student_reports_card) {
//
//        override val viewModel: StudentReportsCardViewModel by viewModels()
//        private lateinit var preferenceHelper: PreferenceHelper
//
//        override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
//            FragmentStudentReportsCardBinding.inflate(inflater, container, false)
//
//        override fun sizeListener() {
//            preferenceHelper = PreferenceHelper(requireContext())
//            if (preferenceHelper.getSize() == "big" || Listeners.booleanLiveData.value == true) {
//                val configuration = Configuration(resources.configuration)
//                val newValue = 1f
//
//                configuration.fontScale = newValue
//                resources.updateConfiguration(configuration, resources.displayMetrics)
//            }
//        }
//
//        override fun initUI() {
//            super.initUI()
//
//            binding.btnBack.setOnClickListener {
//                findNavController().navigateUp()
//            }
//
//            val tabLayout = binding.tabLayout
//            val viewPager2 = binding.viewPager2
//
//            val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
//            val args = Bundle()
//            args.putLong(STUDENT_ID, arguments?.getLong(STUDENT_ID)!!)
//            args.putString(STUDENT_NAME, arguments?.getString(STUDENT_NAME))
//            args.putString(STUDENT_SURNAME, arguments?.getString(STUDENT_SURNAME))
//            args.putString(GROUP_NAME, arguments?.getString(GROUP_NAME))
//            args.putInt(SUBJECT_TYPE_CLASSES, arguments?.getInt(SUBJECT_TYPE_CLASSES)!!)
//            adapter.setArguments(args)
//
//            viewPager2.adapter = adapter
//
//            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
//                when (position) {
//                    0 -> tab.text = resources.getText(R.string.learning_metrics)
//                    1 -> tab.text = resources.getText(R.string.general_indicators)
//                }
//            }.attach()
//        }
//
//        companion object {
//            const val STUDENT_ID = "student id"
//            const val STUDENT_NAME = "student name"
//            const val STUDENT_SURNAME = "student surname"
//            const val GROUP_NAME = "group name"
//            const val SUBJECT_TYPE_CLASSES = "subject type classes"
//        }
//    }
//
//
//    class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
//        FragmentStateAdapter(fragmentManager, lifecycle) {
//
//        private var fragmentArguments: Bundle? = null
//
//        fun setArguments(args: Bundle) {
//            fragmentArguments = args
//        }
//
//        override fun getItemCount(): Int = 2
//
//
//        override fun createFragment(position: Int): Fragment {
//            return when (position) {
//                0 -> {
//                    val fragment = TotalPointsFragment()
//                    fragment.arguments = fragmentArguments // Передача аргументов в фрагмент
//                    fragment
//                }
//                1 -> {
//                    val fragment = StudentPerformanceFragment()
//                    fragment.arguments = fragmentArguments // Передача аргументов во второй фрагмент
//                    fragment
//                }
//                else -> TotalPointsFragment()
//            }
//        }
//    }

}