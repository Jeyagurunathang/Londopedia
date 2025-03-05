package com.example.mycityapp.ui

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycityapp.R
import com.example.mycityapp.data.Category

@Composable
fun LondopediaAppCategoryDetailScreen(
    category: Category,
    keyFeatures: List<Int>,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        BackHandler(
            onBack = onBackClicked
        )

        Box {
            Image(
                painter = painterResource(category.categoryImage),
                contentDescription = stringResource(category.categoryName),
            )

            Box(
                modifier = Modifier.fillMaxWidth().padding(horizontal = dimensionResource(R.dimen.padding_medium))
            ) {
                IconButton(
                    onClick = onBackClicked,
                    modifier = modifier.background(color = Color.White, shape = MaterialTheme.shapes.extraLarge).padding(
                        dimensionResource(R.dimen.padding_small)
                    ).size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back_arrow)
                    )
                }
            }
        }

        Text(
            text = stringResource(category.categoryName),
            style = MaterialTheme.typography.labelLarge,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 28.sp
        )

        Text(
            text = stringResource(category.categoryDescription),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.fillMaxWidth().padding(horizontal = dimensionResource(R.dimen.padding_large)),
            textAlign = TextAlign.Justify
        )

        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.height_large) * 2),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_large))
                .background(color = MaterialTheme.colorScheme.secondaryContainer, shape = MaterialTheme.shapes.medium),
            contentPadding = PaddingValues(dimensionResource(R.dimen.padding_large))
        ) {
            item {
                Text(
                    text = stringResource(R.string.additional_information),
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 20.sp
                )
            }
            items(keyFeatures) { keyFeature ->
                Text(
                    text = stringResource(keyFeature, "*"),
                    style = MaterialTheme.typography.titleMedium,
                    letterSpacing = 3.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify,
                    fontSize = 16.sp
                )
            }
        }

    }
}