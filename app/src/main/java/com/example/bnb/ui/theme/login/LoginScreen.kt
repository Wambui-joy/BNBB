package com.example.bnb.ui.theme.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bnb.R
import com.example.bnb.data.AuthViewModel
import com.example.bnb.navigation.ROUT_SIGNUP


@Composable
fun LoginScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        Spacer(modifier = Modifier.height(90.dp))

        Image(
            painter = painterResource(id = R.drawable.img_10) ,
            contentDescription ="home",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Crop

        )

        Text(
            text ="Welcome Back",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text ="Already have an account.please enter your credentials",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center



        )


        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }



        OutlinedTextField(value = email, onValueChange = {email =it},
            label = { Text("Enter Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            leadingIcon ={ Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)


        )

        OutlinedTextField(value = password, onValueChange = {password =it},
            label = { Text("Enter password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            leadingIcon ={ Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()


        )

        Spacer(modifier = Modifier.height(20.dp))
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)


        Button(
            onClick = {authViewModel.login(email, password)},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp)



        ) {

            Text(
                text = "login",
                fontSize = 21.sp

            )

        }

        Spacer(modifier = Modifier.height(20.dp))


        Text(text = "Do not have an account!")

        TextButton(onClick = { navController.navigate(ROUT_SIGNUP)}) {


            Text(
                text ="REGISTER HERE",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)

        }





















    }






}
@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())




}