package com.orangecash.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.orangecash.app.ui.theme.*
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun ConfirmPasswordScreen(
    navController: NavHostController,
    amount: String,
    phone: String
) {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "أدخل كلمة المرور",
            style = OrangeCashTypography.headlineMedium,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(6) { index ->
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            if (index < password.length) OrangeMain else LightGray,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (index < password.length) {
                        Text("*", fontSize = 20.sp, color = White)
                    }
                }
                if (index < 5) Spacer(modifier = Modifier.width(10.dp))
            }
        }

        TextField(
            value = password,
            onValueChange = { password = it.take(6) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LightGray,
                unfocusedContainerColor = LightGray
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (password.length == 6) {
                    navController.navigate("loading/$amount/$phone")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = OrangeMain),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("تأكيد", color = White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LightGray),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("رجوع", color = OrangeMain)
        }
    }
}
