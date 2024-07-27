package com.example.tinypeace.TinyPeaceUI.tinyPeaceComposables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tinypeace.TinyPeaceUI.tinyPeaceData.iconData.IconViewModel

@Composable
fun TP_Icon(viewModel: IconViewModel) {
    viewModel.showIcon.value?.let { showingIcon ->
        if (showingIcon) {
            Icon(
                imageVector = viewModel.icon.imageVector,
                contentDescription = viewModel.icon.imageVector.name,
                modifier = viewModel.icon.modifier
                    .clickable(
                        enabled = viewModel.icon.isClickable.first,
                        onClickLabel = viewModel.icon.imageVector.name + " icon",
                        role = null,
                    ) {
                        viewModel.icon.isClickable.second?.invoke()
                    }
            )
        }
    }
}

@Preview(showBackground=true)
@Composable
fun TP_IconPreview() {

}