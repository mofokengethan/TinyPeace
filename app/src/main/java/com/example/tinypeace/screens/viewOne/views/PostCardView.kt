package com.example.tinypeace.screens.viewOne.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalFireDepartment
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinypeace.TinyPeaceUI.homeScreen.montserratFamily
import com.example.tinypeace.screens.viewOne.ViewOne



@Composable
fun PostCardView(
    postCardContent: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        DualRowContent(
            leftSide = {
            Column {
                Text(
                    text = "\uD83C\uDF93 College Majors",
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = montserratFamily,  // Replace with montserratFamily
                )
                Text(
                    text = "username",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Serif,  // Replace with dmSerifDisplay
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
            rightSide = {
                Text(
                    text = "Inside LA",
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = FontFamily.SansSerif,  // Replace with montserratFamily
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "Los Angeles, CA",
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily.SansSerif  // Replace with montserratFamily
                )
            }
        )
        postCardContent()
        DualRowContent(
            leftSide = {
                PostCardInteractionButton("12k") {
                    
                }
            },
            rightSide = {
                Text(
                    text = "\uD83D\uDE82 Mechanical Engineering",
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = montserratFamily,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(top = 6.dp)

                )
            },
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Composable
fun DualRowContent(
    leftSide: @Composable () -> Unit,
    rightSide: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(1f)
    ) {
        Box {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                leftSide()
            }
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalAlignment = Alignment.End
            ) {
                rightSide()
            }
        }
    }
}

@Composable
fun PostCardInteractionButton(
    interactions: String,
    action: () -> Unit
) {
    Box(modifier = Modifier.padding(2.dp).clickable { action() }) {
       Row(
           verticalAlignment = Alignment.Bottom
       ) {
           Text(
               text = interactions,
               style = MaterialTheme.typography.bodySmall,
               fontFamily = montserratFamily,
               modifier = Modifier
           )
           Icon(
               imageVector = Icons.Outlined.LocalFireDepartment,
               contentDescription ="",
               modifier = Modifier.size(20.dp)
           )
       }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewOnePreview() {
    ViewOne()
}