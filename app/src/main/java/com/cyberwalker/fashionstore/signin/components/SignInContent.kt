package com.cyberwalker.fashionstore.signin.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyberwalker.fashionstore.data.components.EmailField
import com.cyberwalker.fashionstore.data.components.PasswordField
import com.cyberwalker.fashionstore.data.components.SmallSpacer
import com.cyberwalker.fashionstore.data.core.Constants.FORGOT_PASSWORD
import com.cyberwalker.fashionstore.data.core.Constants.NO_ACCOUNT
import com.cyberwalker.fashionstore.data.core.Constants.NO_VALUE
import com.cyberwalker.fashionstore.data.core.Constants.SIGN_IN
import com.cyberwalker.fashionstore.data.core.Constants.VERTICAL_DIVIDER
import com.cyberwalker.fashionstore.home.HomeScreenActions
import com.cyberwalker.fashionstore.signin.SignInScreenActions
import com.cyberwalker.fashionstore.signup.SignUpScreenActions

@Composable
@ExperimentalComposeUiApi
fun SignInContent(
    padding: PaddingValues,
    signIn: (email: String, password: String) -> Unit,
    onAction: (actions: SignUpScreenActions) -> Unit,
) {
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) { mutableStateOf(TextFieldValue(NO_VALUE)) }
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) { mutableStateOf(TextFieldValue(NO_VALUE)) }
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(
            email = email,
            onEmailValueChange = { newValue ->
                email = newValue
            }
        )
        SmallSpacer()
        PasswordField(
            password = password,
            onPasswordValueChange = { newValue ->
                password = newValue
            }
        )
        SmallSpacer()
        Button(
            onClick = {
                keyboard?.hide()
                throw RuntimeException("Test Crash")
               // signIn(email.text, password.text)
            }
        ) {
            Text(
                text = SIGN_IN,
                fontSize = 15.sp
            )
        }
        Row {
//            Text(
//                modifier = Modifier.clickable {
//                    navigateToForgotPasswordScreen()
//                },
//                text = FORGOT_PASSWORD,
//                fontSize = 15.sp
//            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                text = VERTICAL_DIVIDER,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.clickable {
                    onAction(SignUpScreenActions.LoadSignUp)
                },
                text = NO_ACCOUNT,
                fontSize = 15.sp
            )
        }
    }
}