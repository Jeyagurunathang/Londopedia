package com.example.mycityapp.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.mycityapp.R
import com.example.mycityapp.data.Category

@Composable
fun LondopediaAppCategoryItem(
    category: Category,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier.fillMaxWidth().padding(dimensionResource(R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        /*
        * Can't show the preview image of each category. Coz, the images are in high quality
        * So, the application takes some times to respond to the user's interactions
         */
        /*
            Image(
                painter = painterResource(category.categoryImage),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .size(dimensionResource(R.dimen.category_image_size))
                    .clip(shape = MaterialTheme.shapes.small)
                    .weight(1F),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.width_large)))
         */

        Column (
            modifier = Modifier.weight(3F)
        ) {
            Text(
                text = (stringResource(category.categoryName)),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_small)))

            Text(
                text = stringResource(category.categoryDescription),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            if (category.categoryEstablishedDate != null) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_small)))

                Text(
                    text = stringResource(category.categoryEstablishedDate, "Established:"),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            shape = MaterialTheme.shapes.extraSmall
                        )
                        .padding(
                            horizontal = dimensionResource(R.dimen.padding_small),
                            vertical = dimensionResource(R.dimen.padding_small) / 2
                        )
                )
            }
        }

        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = stringResource(R.string.right_arrow)
            )
        }
    }
}