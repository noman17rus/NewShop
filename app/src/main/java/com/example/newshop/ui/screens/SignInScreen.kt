package com.example.newshop.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newshop.R
import com.example.newshop.ui.patterns.MyTextField
import com.example.newshop.ui.theme.NewShopTheme

@Composable
fun SignInScreen(
    viewModel: SignScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    modifier: Modifier = Modifier
) {
    val signScreenState by viewModel.signScreenState.collectAsState()
    val context = LocalContext.current
    Log.d("MyTag", signScreenState.toString())
    LaunchedEffect(key1 = true) {
        viewModel.checkUserInfo()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxSize()
            .padding(44.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center, modifier = modifier.weight(1f)) {
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.titleLarge,
            )
        }
        UserInfo(
            name = viewModel.userName,
            onNameChange = { viewModel.updateName(it) },
            email = viewModel.eMail,
            onEmailChange = { viewModel.updateEmail(it) },
            lastName = viewModel.userLastName,
            onLastNameChange = { viewModel.updateLastName(it) },
            modifier = modifier.weight(1f)
        )
        LoginActions(
            signIn = {
                viewModel.checkUserInfo()
                if (signScreenState.isEmptyEmail || signScreenState.isEmptyName || signScreenState.isEmptyLastName) {
                    Toast.makeText(context, "Incorrect input", Toast.LENGTH_LONG).show()
                }
            },
            loginIn = {

            },
            modifier = modifier
        )
        Column(modifier = modifier.weight(1f), verticalArrangement = Arrangement.SpaceEvenly) {
            SignWithSocialRow(socialImage = R.drawable.google, "Sign with google")
            SignWithSocialRow(socialImage = R.drawable.apple, "Sign with apple")
        }
    }
}

@Composable
private fun UserInfo(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        MyTextField(
            value = name,
            onValueChange = onNameChange,
            placeholderText = "name"
        )
        MyTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholderText = "email"
        )
        MyTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            placeholderText = "last name"
        )
    }
}

@Composable
private fun LoginActions(
    signIn: () -> Unit,
    loginIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Button(
            onClick = signIn,
            modifier = modifier
                .fillMaxWidth()
                .height(46.dp)
        ) {
            Text(text = "Sign in", style = MaterialTheme.typography.labelLarge)
        }
        Spacer(modifier = modifier.padding(6.dp))
        Row {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Black
            )
            Spacer(modifier = modifier.padding(2.dp))
            Text(text = "Log in",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Blue,
                modifier = modifier.clickable {
                    loginIn()
                }
            )
        }
    }
}

@Composable
fun SignWithSocialRow(
    socialImage: Int,
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val image = painterResource(id = socialImage)
        Image(
            painter = painterResource(id = socialImage),
            contentDescription = null,
            modifier = modifier.size(24.dp)
        )
        Spacer(modifier = modifier.padding(5.dp))
        Text(text = text, style = MaterialTheme.typography.labelLarge, color = Color.Black)
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignInPreview() {
    NewShopTheme {
        SignInScreen()
    }
}