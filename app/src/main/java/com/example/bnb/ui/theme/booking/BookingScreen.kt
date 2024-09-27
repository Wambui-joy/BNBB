package com.example.bnb.ui.theme.booking


import android.annotation.SuppressLint
import android.content.Intent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bnb.ui.theme.redbrown
import com.example.bnb.R



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar(

                    contentColor = Color.White




                ) {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "LAVINGTON")
                            },
                    colors = TopAppBarDefaults.mediumTopAppBarColors()
                )
            },


            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 60.dp)
                ){
//row1

                    Row {
                        Card ()
                        {

                            Box(
                                modifier = Modifier
                                    .height(220.dp)
                                    .width(200.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_7) ,
                                    contentDescription ="home",
                                    modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
                                )


                                Icon(imageVector = Icons.Default.Favorite,
                                    contentDescription = "favorite",
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(20.dp),

                                )




                            }


                        }


                        //end of card
                        Column (modifier = Modifier.padding(start = 12.dp)){
                            Text(text = "Visit Lavington", fontSize = 22.sp)
                            Text(text = "Highest reviwed", fontSize = 18.sp)
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription ="star" , tint = redbrown ,modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription ="star" , tint = redbrown ,modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription ="star" , tint = redbrown ,modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription ="star" , tint = redbrown ,modifier = Modifier.size(30.dp))
                                Icon(imageVector = Icons.Default.Star, contentDescription ="star" , tint = redbrown ,modifier = Modifier.size(30.dp))




                            }
                            val mContext = LocalContext.current

                            Text(text = "14,000 Revies")
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = {val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0103817513".toUri()
                                mContext.startActivity(callIntent)


                            },

                                modifier = Modifier
                                    .height(50.dp)
                                    .padding(end = 20.dp),
                                colors = ButtonDefaults.buttonColors(Color.Black),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "CALL")

                            }






                        }





                    }


//end of row

                    Spacer(modifier = Modifier.height(30.dp))

                    val mContext = LocalContext.current

                    Button(
                        onClick = { val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }


                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)



                    ){
                        Text(text = "Mpesa")
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = {  val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0103817513".toUri()
                            mContext.startActivity(callIntent)

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)



                    ){
                        Text(text = "call")
                    }
                    Spacer(modifier = Modifier.height(30.dp))





                    Button(
                        onClick = { val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("akinyiglory2@gmail.com"))
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)



                    ){
                        Text(text = "email")
                    }
                    Spacer(modifier = Modifier.height(30.dp))


                    Button(
                        onClick = { val shareIntent= Intent(Intent.ACTION_SEND)
                            shareIntent.type="text/plain"
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(10.dp)



                    ){
                        Text(text = "Share")


                    }

                    Spacer(modifier = Modifier.height(30.dp))





                }

            }

        )

    }




}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Detail",
        route="detail",
        selectedIcon= Icons.Filled.Info,
        unselectedIcon= Icons.Outlined.Info,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Property",
        route="property",
        selectedIcon= Icons.Filled.PlayArrow,
        unselectedIcon= Icons.Outlined.PlayArrow,
        hasNews = true,
        badges=1
    ),

    BottomNavItem(
        title = "About",
        route="about",
        selectedIcon= Icons.Filled.AccountBox,
        unselectedIcon= Icons.Outlined.AccountBox,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)












@Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(rememberNavController())
}