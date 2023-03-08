package com.cyberwalker.fashionstore.signup

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.data.core.Constants.VERIFY_EMAIL_MESSAGE
import com.cyberwalker.fashionstore.data.core.Utils.Companion.showMessage
import com.cyberwalker.fashionstore.signin.SignInScreenActions
import com.cyberwalker.fashionstore.signup.components.SendEmailVerification
import com.cyberwalker.fashionstore.signup.components.SignUp
import com.cyberwalker.fashionstore.signup.components.SignUpContent
import com.cyberwalker.fashionstore.signup.components.SignUpTopBar

@Composable
@ExperimentalComposeUiApi
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: SignUpScreenActions) -> Unit,
    navigateBack: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            SignUpTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            SignUpContent(
                padding = padding,
                signUp = { email, password ->
                    viewModel.signUpWithEmailAndPassword(email, password)
                },
                navigateBack = navigateBack
            )
        }
    )

    SignUp(
        sendEmailVerification = {
            viewModel.sendEmailVerification()
        },
        showVerifyEmailMessage = {
            showMessage(context, VERIFY_EMAIL_MESSAGE)
        }
    )

    SendEmailVerification()
}

sealed class SignUpScreenActions {
    object LoadSignUp : SignUpScreenActions()
}