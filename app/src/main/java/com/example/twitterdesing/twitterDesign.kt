package com.example.twitterdesing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun twitterDesign() {


    Row(
        Modifier

            .padding(16.dp)
    ) {
        PicksProfile()
        NameUser()
    }


}

@Composable
fun IconsTwitter() {
    var chat by remember { mutableStateOf(false) }
    var rt by remember { mutableStateOf(false) }
    var like by remember { mutableStateOf(false) }
    var msj by remember { mutableStateOf(false) }


    Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround) {

        TintedIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_like),
                     "",
                    tint = Color(0xFF626364)
                )
            },
            selectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_like_filled),
                    "",
                    tint = Color(0xFFE70606)
                )
            },
            isSelected = like,
        ) {
            like = !like
        }
        TintedIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_rt),
                     "",
                    tint = Color(0xFF626364)
                )
            },
            selectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_share),
                    contentDescription = "",
                    tint = Color(0xFF0FE40F)
                )
            },
            isSelected = rt,
        ) {
            rt = !rt
        }
        TintedIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_chat),
                     "",
                    tint = Color(0xFF626364)
                )
            },
            selectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_chat_filled),
                     "",
                    tint = Color(0xFF626464)
                )
            },
            isSelected = chat,

            ) {
            chat = !chat
        }
        TintedIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_share),
                     "",
                    tint = Color(0xFF626364)
                )
            },
            selectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_share),
                     "",
                    tint = Color(0xFF626464)
                )
            },
            isSelected = msj,
        ) {
            msj = !msj
        }
    }
}

@Composable
fun TintedIcon(
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    modifier: Modifier,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(modifier = modifier.clickable{ onItemSelected() }) {
        if(isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        Text(
            text = if(isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF626364),
            modifier = Modifier.padding(start = 4.dp)
        )

    }
}

@Composable
fun NameUser() {
    Column {
        Row(Modifier.fillMaxWidth()) {
            Text(text = "Joaquin", color = Color.White, fontWeight = FontWeight.Bold)
            Text(
                text = "@Joaquinxtx",
                Modifier.padding(horizontal = 10.dp),
                color = Color(0xFF626364),
                fontWeight = FontWeight.Bold
            )
            Text(text = "4h", color = Color(0xFF626364), fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "dots",
                alignment = Alignment.CenterEnd,
                modifier = Modifier.weight(1f),
                colorFilter = ColorFilter.tint(Color.White)

            )

        }
        BodyTwitter()

    }

}

@Composable
fun BodyTwitter() {
    Column {
        Text(
            text = "\uD83D\uDE80 It's finally here! \n" +
                    "@KotlinConf\n" +
                    " is LIVE in Amsterdam! \n" +
                    "\n" +
                    "The JetBrains keynote just unveiled some thrilling updates – dive into the thread for the announcements!  ....", color = Color.White
        )
        ImagenTwitter()
        IconsTwitter()

    }
}

@Composable
fun ImagenTwitter() {
    Image(
        painter = painterResource(id = R.drawable.images),
        contentDescription = "Profile image",
        modifier = Modifier
            .padding(vertical = 16.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop

    )
}

@Composable
fun PicksProfile() {
    Image(
        painter = painterResource(id = R.drawable.imgtw),
        contentDescription = "Profile image",
        modifier = Modifier
            .padding(end = 9.dp)
            .clip(CircleShape)
            .size(55.dp)
    )
}
@Composable
fun DividerRt() {
    Divider(Modifier.padding(top = 4.dp).height(0.7.dp).fillMaxWidth(),
    color = Color(0xFF32465A)
    )
}
