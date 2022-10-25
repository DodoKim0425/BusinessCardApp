package com.example.businesscardapp
import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(){
    Column(
        modifier = Modifier
            .background(Color(0, 80, 94, 255))
            .fillMaxSize()
    ) {
        Name(
            stringResource(id = R.string.name),
            stringResource(id = R.string.job),
            Modifier.weight(2f)
        )
        ContactMe(
            phoneNumber = stringResource(id = R.string.phone_number),
            snsAccount = stringResource(id = R.string.sns_account),
            email = stringResource(id = R.string.email),
            modifier=Modifier.weight(1f)
        )
    }
}
@Composable
fun Name(name:String, job:String ,modifier: Modifier){
    Column(
        modifier= modifier
            .fillMaxWidth()
            .wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,//가로로 정렬 어떻게 할지
        verticalArrangement = Arrangement.Center//세로로 정렬 어떻게 할지, 위에 붙일건지 어쩔건지 그런거
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(130.dp, 130.dp)
        )
        Text(
            text = name,
            fontSize = 40.sp,
            color = Color.White
        )
        Text(
            text = job,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color=Color(107, 199, 151, 255)
        )
    }
}
@Composable
fun ContactMe(phoneNumber:String, snsAccount:String, email:String, modifier: Modifier){
    //icon출처:https://fonts.google.com/icons?selected=Material+Icons&authuser=1&hl=ko
    Column(
        modifier = modifier
            .wrapContentHeight()//이 Column안의 컴포즈들이 top, bottom, start, end 중 어디갈지?
            .fillMaxHeight(),//가능한 최대 높이를 이 Column이 차지한다
        //verticalArrangement = Arrangement.Bottom//바닥에 붙이는법
        verticalArrangement = Arrangement.Top//이 Column통째로 가능한 제일 위에 붙이도록함
    ) {
        Divider(color = Color.White, thickness = 1.dp)//선을 긋는 컴포즈
        ContactElement(
            icon = painterResource(id = R.drawable.phone),
            contectText = phoneNumber,
        )
        Divider(color = Color.White, thickness = 1.dp)
        ContactElement(
            icon = painterResource(id = R.drawable.sns_account),
            contectText = snsAccount
        )
        Divider(color = Color.White, thickness = 1.dp)
        ContactElement(
            icon = painterResource(id = R.drawable.email),
            contectText = email
        )
    }
}
@Composable
fun ContactElement(icon:Painter, contectText:String){
    Row(modifier=Modifier.padding(bottom = 15.dp, top = 15.dp)) {
        Icon(
            painter = icon, contentDescription = null,
            Modifier
                .size(30.dp)
                .weight(1f),
            tint = Color(107, 199, 151, 255)//아이콘 색은 tint로 바꾼다
        )
        Text(
            text = contectText,
            Modifier.weight(2f),
            color = Color.White,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}