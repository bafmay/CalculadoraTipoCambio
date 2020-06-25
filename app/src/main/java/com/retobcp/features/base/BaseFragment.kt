package com.retobcp.features.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.retobcp.features.utils.inflate

abstract class BaseFragment : Fragment(){

    abstract fun getLayoutId() : Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(getLayoutId())
    }
}