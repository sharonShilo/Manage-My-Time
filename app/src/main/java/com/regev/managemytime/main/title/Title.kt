package com.regev.managemytime.main.title

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
        wrapContentWidth()
        .padding(horizontal = 10.dp)
        .fillMaxHeight()
        .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CircularImage(
            imageResource = imageResource,
            contentDescription = "Profile picture",
            size = 120,
            borderWidth = 3f,
            borderColor = Color.Transparent
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = greeting,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun CircularImage(
    imageResource: Int,
    contentDescription: String? = null,
    size: Int = 100,
    borderWidth: Float,
    borderColor: Color
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(size.dp)
                .border(width = borderWidth.dp, color = borderColor, shape = CircleShape)
        ) {
            drawCircle(
                color = Color.White,
                radius = size / 2f
            )
        }
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            modifier = Modifier
                .size((size - borderWidth * 2).dp)
                .clip(CircleShape)
        )
    }
}


@Preview
@Composable
fun sdf() {
    ImageAndTitle(R.drawable.ic_launcher_background, "Hi", "sharon")
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
