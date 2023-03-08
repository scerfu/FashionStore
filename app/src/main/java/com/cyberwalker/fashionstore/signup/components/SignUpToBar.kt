package com.cyberwalker.fashionstore.signup.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.cyberwalker.fashionstore.data.components.BackIcon
import com.cyberwalker.fashionstore.data.core.Constants.SIGN_UP_SCREEN


@Composable
fun SignUpTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = SIGN_UP_SCREEN
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}