package com.regev.managemytime.main.title

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.regev.managemytime.R

@Composable
fun MainTitle(
    imageResource: Int,
    greeting: String,
    name: String,
    firstButtonIcon: ImageVector,
    firstButtonOnClick: () -> Unit,
    secondButtonIcon: ImageVector,
    secondButtonOnClick: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Row(modifier = Modifier.fillMaxWidth()
        .height(100.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageAndTitle(imageResource, greeting, name)
        ButtonsForTitle(firstButtonIcon, firstButtonOnClick, secondButtonIcon, secondButtonOnClick, modifier)
    }
}

@Composable
fun ImageAndTitle(imageResource: Int, greeting: String, name: String) {
    Row(modifier = Modifier.
    width(60.dp)
        .padding(horizontal = 10.dp)
        .fillMaxHeight()) {
        CircularImage(
            imageResource = imageResource,
            contentDescription = "Profile picture",
            size = 120,
            borderWidth = 3f,
            borderColor = Color.Black
        )
        Spacer(modifier = Modifier
            .fillMaxHeight()
            .width(10.dp)
        )
        Column {
            Text(greeting)
            Text(name)
        }
    }
}

@Composable
fun CircularButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconTint: Color = Color.White,
    backgroundColor: Color = Color.Black.copy(alpha = 0.3f)
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
    }

}

@Composable
fun CircularImage(
    imageResource: Int,
    contentDescription: String? = null,
    size: Int = 100,
    borderWidth: Float = 2f,
    borderColor: Color = Color.Gray
    ) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .border(borderWidth.dp, borderColor, CircleShape)

    )
}

@Composable
fun ButtonsForTitle( firstButtonIcon: ImageVector,
                     firstButtonOnClick: () -> Unit,
                     secondButtonIcon: ImageVector,
                     secondButtonOnClick: () -> Unit,
                     modifier: Modifier = Modifier,) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
    ) {
        CircularButton(
            icon =  firstButtonIcon,
            onClick = firstButtonOnClick,
            modifier = modifier
        )
        CircularButton(
            icon = secondButtonIcon,
            onClick = secondButtonOnClick,
            modifier
        )
    }
}
