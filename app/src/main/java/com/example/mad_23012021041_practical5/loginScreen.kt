package com.example.mad_23012021041_practical5

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle


@Composable
fun LoginScreen(onSignupClick: () -> Unit) {

    // States to hold the email and password values
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp), // Thoda padding badhaya
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.guni), // Make sure 'guni.png' is in your res/drawable folder
            contentDescription = "GUNI Logo"
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Card with elevation for the login form
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) // Sahi tareeka
        )
        {
            Column(modifier = Modifier.padding(15.dp)) {


                Spacer(modifier = Modifier.height(16.dp))

                // Email Row
                Row(
                    verticalAlignment = Alignment.CenterVertically, // Text aur TextField ko vertically align karein
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Email ",
                        fontSize = 18.sp,
                        modifier = Modifier.width(90.dp)
                            ) // Label ko ek fixed width di
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Enter Email") }, // Label ab placeholder jaisa kaam karega
                        modifier = Modifier.weight(1f), // Bachi hui saari space le lega
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Password Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Password ",
                        fontSize = 18.sp,
                        modifier = Modifier.width(90.dp)) // Label ko same fixed width di
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Enter Password") },
                        modifier = Modifier.weight(1f), // Bachi hui saari space le lega
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation()
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                // Forgot Password Text
                Text(
                    text = "Forgot Password?",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // Yahan "Forgot Password" par click karne ka logic aayega
                        },
                    textAlign = androidx.compose.ui.text.style.TextAlign.End // Text ko end mein align karein
                )


                Spacer(modifier = Modifier.height(24.dp))

                // Login Button
                Button(
                    onClick = {
                        // Yahan aap login logic likh sakte hain
                        // For example: if (email == "test@guni.ac.in" && password == "123") { ... }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("LOGIN")
                }
            }
        }
        val text = buildAnnotatedString {
            append("Don't have an account? ")
            pushStringAnnotation(tag = "signup", annotation = "signup")
            withStyle(
                SpanStyle(
                    color = Color(0xFFFF4081),
                    fontWeight = FontWeight.Bold
                )
            ) { append("SIGN UP") }
            pop()
        }

        ClickableText(
            text = text,
            onClick = { offset ->
                onSignupClick()   // <-- MOVE TO REGISTER SCREEN
            },
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        )

    }
}
