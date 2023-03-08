package com.cyberwalker.fashionstore.signup.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.data.components.ProgressBar
import com.cyberwalker.fashionstore.data.core.Utils.Companion.print
import com.cyberwalker.fashionstore.data.domain.model.Response.Loading
import com.cyberwalker.fashionstore.data.domain.model.Response.Success
import com.cyberwalker.fashionstore.data.domain.model.Response.Failure
import com.cyberwalker.fashionstore.signup.SignUpViewModel



@Composable
fun SendEmailVerification(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    when(val sendEmailVerificationResponse = viewModel.sendEmailVerificationResponse) {
        is Loading -> ProgressBar()
        is Success -> Unit
        is Failure -> sendEmailVerificationResponse.apply {
            LaunchedEffect(e) {
                print(e)
            }
        }
    }
}