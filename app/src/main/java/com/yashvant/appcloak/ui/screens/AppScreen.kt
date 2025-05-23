package com.yashvant.appcloak.ui.screens


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yashvant.appcloak.WebViewActivity

@Composable
fun AppScreen(modifier: Modifier, context: Context) {
    var websiteUrl by remember { mutableStateOf("") }
    var appName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Enter Website URL", style = MaterialTheme.typography.headlineMedium)

        BasicTextField(
            value = websiteUrl,
            onValueChange = { websiteUrl = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Enter App Name", style = MaterialTheme.typography.headlineMedium)
        BasicTextField(
            value = appName,
            onValueChange = { appName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (websiteUrl.isNotBlank() && appName.isNotBlank()) {
                    val intent = Intent(context, WebViewActivity::class.java).apply {
                        putExtra("URL", websiteUrl)
                        putExtra("APP_NAME", appName)
                    }
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Fields cannot be empty! Please fill remaining fields", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Generate App")
        }
    }
}
