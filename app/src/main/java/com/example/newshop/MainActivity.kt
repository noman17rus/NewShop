package com.example.newshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newshop.ui.theme.NewShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    NewShopTheme {
        Column {
            Text(text = "titleLarge", style = MaterialTheme.typography.titleLarge)
            Text(text = "labelMedium", style = MaterialTheme.typography.labelMedium)
            Text(text = "labelLarge", style = MaterialTheme.typography.labelLarge)
            Text(text = "labelSmall", style = MaterialTheme.typography.labelSmall)
            Button(onClick = { /*TODO*/ }) {
                Text(text = "hello", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}