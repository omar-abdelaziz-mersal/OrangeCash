package com.orangecash.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.orangecash.app.ui.theme.*

@Composable
fun TransferScreen(navController: NavHostController) {
    var phoneNumber by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "تحويل الأموال",
            style = OrangeCashTypography.headlineLarge,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it.take(11) },
            label = { Text("رقم الهاتف") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { 
                if (it.isEmpty() || it.toIntOrNull() ?: 0 <= 60000) {
                    amount = it
                }
            },
            label = { Text("المبلغ (1-60000)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                if (phoneNumber.isNotEmpty() && amount.isNotEmpty()) {
                    val amountInt = amount.toIntOrNull() ?: 0
                    if (amountInt in 1..60000) {
                        navController.navigate("confirm_password/$amount/$phoneNumber")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = OrangeMain),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("تحويل", color = White)
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
