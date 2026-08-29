package com.orangecash.app.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.orangecash.app.ui.theme.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SuccessScreen(
    navController: NavHostController,
    amount: String,
    phone: String,
    transactionId: String
) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale("ar"))
    val currentDate = dateFormat.format(Date())
    val fee = "1.00"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkNavy)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Black, shape = CircleShape)
                    .clickable { navController.popBackStack() },
                contentAlignment = Alignment.Center
            ) {
                Text("→", fontSize = 24.sp, color = White)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp, bottom = 20.dp)
                .background(White, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(SuccessGreen, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("OK", fontSize = 32.sp, color = White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "$amount جنيه",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkGray
                )

                Text(
                    "المبلغ المحول",
                    fontSize = 12.sp,
                    color = Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGray, shape = RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(horizontalAlignment = Alignment.End) {
                            Text("المستقبل", fontSize = 12.sp, color = Gray)
                            Text(phone, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = DarkGray)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGray, shape = RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        DetailRow("المبلغ", "$amount جنيه")
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(BorderGray))
                        Spacer(modifier = Modifier.height(12.dp))
                        DetailRow("الرسوم", "$fee جنيه", isGreen = true)
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(BorderGray))
                        Spacer(modifier = Modifier.height(12.dp))
                        DetailRow("الحالة", "ناجحة", isGreen = true)
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(BorderGray))
                        Spacer(modifier = Modifier.height(12.dp))
                        DetailRow("نوع العملية", "تحويل أموال")
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(BorderGray))
                        Spacer(modifier = Modifier.height(12.dp))
                        DetailRow("التاريخ", currentDate)
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(BorderGray))
                        Spacer(modifier = Modifier.height(12.dp))
                        DetailRow("رقم العملية", transactionId)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(White, shape = CircleShape)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Share", fontSize = 12.sp, color = OrangeMain)
                    }

                    Button(
                        onClick = { navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        } },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = OrangeMain),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("تم", color = White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String, isGreen: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = if (isGreen) SuccessGreen else DarkGray
        )
        Text(
            label,
            fontSize = 12.sp,
            color = Gray
        )
    }
}
