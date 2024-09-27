package com.example.bnb.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bnb.R
import com.example.bnb.navigation.ROUT_ABOUT
import com.example.bnb.navigation.ROUT_DETAIL
import com.example.bnb.navigation.ROUT_INTENT


@Composable
fun HomeScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)

    {
        Image(
            painter = painterResource(id = R.drawable.img) ,
            contentDescription ="home",
            modifier = Modifier
                .size(300.dp),

            contentScale = ContentScale.Crop

        )







        Text(
            text ="BNB",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black,


            )
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text ="Your Reliable Choice",
            fontSize = 20.sp,


            )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(ROUT_DETAIL) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp)



        ) {

            Text(
                text = "CONTINUE",
                fontSize = 21.sp

            )

        }













    }









}
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())




}