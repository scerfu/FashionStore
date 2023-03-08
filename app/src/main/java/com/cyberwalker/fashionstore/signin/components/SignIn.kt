package com.cyberwalker.fashionstore.signin.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

import com.cyberwalker.fashionstore.data.core.Utils.Companion.print
import com.cyberwalker.fashionstore.data.components.ProgressBar
import com.cyberwalker.fashionstore.data.domain.model.Response.*
import com.cyberwalker.fashionstore.home.HomeScreenActions
import com.cyberwalker.fashionstore.signin.SignInViewModel
import com.cyberwalker.fashionstore.signup.SignUpScreenActions


@Composable
fun SignIn(
    viewModel: SignInViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit,
    onAction: (actions: HomeScreenActions) -> Unit
) {
    when(val signInResponse = viewModel.signInResponse) {
        is Loading -> ProgressBar()
        is Success -> {
            if(signInResponse.data){
                onAction(HomeScreenActions.Details)
            }
        }
        is Failure -> signInResponse.apply {
            LaunchedEffect(e) {
                print(e)
                showErrorMessage(e.message)
            }
        }
    }
}