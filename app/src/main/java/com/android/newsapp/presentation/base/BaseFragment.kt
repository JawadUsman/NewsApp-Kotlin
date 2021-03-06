package com.android.newsapp.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.android.newsapp.presentation.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The class BaseFragment
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
abstract class BaseFragment : Fragment(), BaseView {
    abstract val layoutId: Int

    protected abstract fun initializePresenter(view: View)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(layoutId, container, false)
        initializePresenter(view)
        return view
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    internal fun showSnackBar(message: String) =
        Snackbar.make((activity as MainActivity).nav_host_fragment, message, Snackbar.LENGTH_SHORT)
            .show()

    private fun hideKeyboard() {
        requireActivity().currentFocus?.let {
            val imm: InputMethodManager? =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}