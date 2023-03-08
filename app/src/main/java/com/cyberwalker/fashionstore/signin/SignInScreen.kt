package com.cyberwalker.fashionstore.signin

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.data.core.Utils.Companion.showMessage
import com.cyberwalker.fashionstore.home.HomeScreenActions
import com.cyberwalker.fashionstore.signin.components.SignIn
import com.cyberwalker.fashionstore.signin.components.SignInContent
import com.cyberwalker.fashionstore.signin.components.SignInTopBar
import com.cyberwalker.fashionstore.signup.SignUpScreenActions

@Composable
@ExperimentalComposeUiApi
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onAction: (actions: SignInScreenActions) -> Unit,
    onAction1: (actions: SignUpScreenActions) -> Unit,
    onAction2: (actions: HomeScreenActions) -> Unit
) {
    val context = LocalContext.current
    viewModel.logOut()

    Scaffold(
        topBar = {
            SignInTopBar()
        },
        content = { padding ->
            SignInContent(
                padding = padding,
                signIn = { email, password ->
                    viewModel.signInWithEmailAndPassword(email, password)
                },
                onAction1
            )
        }
    )

    SignIn(
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }, onAction = onAction2
    )
}

sealed class SignInScreenActions {
    object LoadSignIn : SignInScreenActions()
}