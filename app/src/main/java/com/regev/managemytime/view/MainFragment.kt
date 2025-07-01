package com.regev.managemytime.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.regev.managemytime.R
import com.regev.managemytime.main.title.MainTitle
import com.regev.managemytime.ui.theme.ManageMyTimeTheme
import com.regev.managemytime.viewmodel.MainViewModel


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                ManageMyTimeTheme {
                    MainTitle(
                        imageResource = R.drawable.ic_launcher_foreground,
                        greeting = "Hi",
                        name = "Sharon",
                        firstButtonIcon = Icons.Default.Create,
                        firstButtonOnClick = {onClickFirstButton()},
                        secondButtonIcon = Icons.Default.Build,
                        secondButtonOnClick = {onClickSecondButton()}
                    )
                }
            }
        }
    }

    fun onClickFirstButton() {

    }
    fun onClickSecondButton() {

    }


}