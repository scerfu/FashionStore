package com.cyberwalker.fashionstore.signup.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.data.components.ProgressBar
import com.cyberwalker.fashionstore.data.domain.model.Response.Loading
import com.cyberwalker.fashionstore.data.domain.model.Response.Success
import com.cyberwalker.fashionstore.data.domain.model.Response.Failure
import com.cyberwalker.fashionstore.signup.SignUpViewModel

@Composable
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel(),
    sendEmailVerification: () -> Unit,
    showVerifyEmailMessage: () -> Unit
) {
    when(val signUpResponse = viewModel.signUpResponse) {
        is Loading -> ProgressBar()
        is Success -> {
            val isUserSignedUp = signUpResponse.data
            LaunchedEffect(isUserSignedUp) {
                if (isUserSignedUp) {
                    sendEmailVerification()
                    showVerifyEmailMessage()
                }
            }
        }
        is Failure -> signUpResponse.apply{
            LaunchedEffect(e) {
                print(e)
            }
        }
    }
}