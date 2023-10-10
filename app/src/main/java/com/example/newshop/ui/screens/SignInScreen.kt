package com.example.newshop.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newshop.ui.patterns.MyTextField
import com.example.newshop.ui.theme.NewShopTheme

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
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
        UserInfo(modifier = modifier.weight(1f))
        LoginActions(
            signIn = { },
            loginIn = { },
            modifier = modifier
        )
    }
}

@Composable
private fun UserInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        MyTextField()
        MyTextField()
        MyTextField()
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
            onClick = { /*TODO*/ },
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
                modifier = modifier.clickable { }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignInPreview() {
    NewShopTheme {
        SignInScreen()
    }
}