package com.orangecash.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.orangecash.app.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun LoadingScreen(
    navController: NavHostController,
    amount: String,
    phone: String
) {
    LaunchedEffect(Unit) {
        delay(4000)
        val transactionId = generateTransactionId()
        navController.navigate("success/$amount/$phone/$transactionId") {
            popUpTo("loading/$amount/$phone") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = OrangeMain,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "جاري معالجة العملية",
            style = OrangeCashTypography.headlineMedium,
            color = DarkGray
        )
    }
}

fun generateTransactionId(): String {
    val chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return (1..16).map { chars.random() }.joinToString("")
}
