package com.cyberwalker.fashionstore.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberwalker.fashionstore.R
import com.cyberwalker.fashionstore.home.HomeScreenActions
import com.cyberwalker.fashionstore.signin.SignInViewModel

@Composable
fun ProfileScreen(onAction: (actions: HomeScreenActions) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
    ) {
        ProfileHeader(
            name = "John Doe",
            bio = "Software Engineer",
            onAction = onAction
        )
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        ProfileSection(
            sectionTitle = "About",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        )
        ProfileSection(
            sectionTitle = "Skills",
            content = "Kotlin, Java, Swift, Python, C++, Android, iOS, Firebase, AWS"
        )
        ProfileSection(
            sectionTitle = "Education",
            content = "Bachelor of Computer Science, University of California, Los Angeles (UCLA)"
        )
        ProfileSection(
            sectionTitle = "Experience",
            content = "Software Engineer, Google Inc. (2018-2021)\nSoftware Engineer, Facebook Inc. (2016-2018)"
        )
        ProfileSection(
            sectionTitle = "e-mail",
            content = "jitrisolti@gufum.com"
        )
        ProfileSection(
            sectionTitle = "Section X",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        )
        ProfileSection(
            sectionTitle = "Section Y",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        )
        ProfileSection(
            sectionTitle = "Section Z",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        )
    }
}

@Composable
fun ProfileHeader(
    viewModel: SignInViewModel = hiltViewModel(),
    name: String,
    bio: String,
    onAction: (actions: HomeScreenActions) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_man),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h5
            )
            Text(
                text = bio,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.secondary
            )
        }
        IconButton(
            onClick = {
                viewModel.logOut()
                onAction(HomeScreenActions.SignIn)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = "Settings"
            )
        }
    }
}

@Composable
fun ProfileSection(
    sectionTitle: String,
    content: String
) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = content,
            style = MaterialTheme.typography.body1
        )
    }
}
