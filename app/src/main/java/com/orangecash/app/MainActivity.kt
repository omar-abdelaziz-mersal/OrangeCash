package com.orangecash.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.orangecash.app.ui.screens.LoginScreen
import com.orangecash.app.ui.screens.HomeScreen
import com.orangecash.app.ui.screens.TransferScreen
import com.orangecash.app.ui.screens.ConfirmPasswordScreen
import com.orangecash.app.ui.screens.LoadingScreen
import com.orangecash.app.ui.screens.SuccessScreen
import com.orangecash.app.ui.theme.OrangeCashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeCashTheme {
                OrangeCashApp()
            }
        }
    }
}

@Composable
fun OrangeCashApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("transfer") {
            TransferScreen(navController)
        }
        composable("confirm_password/{amount}/{phone}") { backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            ConfirmPasswordScreen(navController, amount, phone)
        }
        composable("loading/{amount}/{phone}") { backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            LoadingScreen(navController, amount, phone)
        }
        composable("success/{amount}/{phone}/{transactionId}") { backStackEntry ->
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            val transactionId = backStackEntry.arguments?.getString("transactionId") ?: ""
            SuccessScreen(navController, amount, phone, transactionId)
        }
    }
}
