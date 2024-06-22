package com.example.enlightenmebooks

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enlightenmebooks.model.Book
import com.example.enlightenmebooks.ui.theme.EnlightenMeBooksTheme


@Composable
fun BookCard(
    book: Book,
    bookNumber: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        var expanded by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            // Main content: Book details (Row)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {

                val rainbowColorsBrush = remember {
                    Brush.sweepGradient(
                        listOf(
                            Color(0xFF9575CD),
                            Color(0xFFBA68C8),
                            Color(0xFFE57373),
                            Color(0xFFFFB74D),
                            Color(0xFFFFF176),
                            Color(0xFFAED581),
                            Color(0xFF4DD0E1),
                            Color(0xFF9575CD)
                        )
                    )
                }
                Image(
                    painter = painterResource(id = book.coverImageResId),
                    contentDescription = book.title,
                    modifier = Modifier
                        .size(160.dp)  // Adjust size as needed
                        .clip(RoundedCornerShape(4.dp))
                        .weight(1f)
                        .border(
                            BorderStroke(4.dp, rainbowColorsBrush),
                            RoundedCornerShape(4.dp)
                        )
                        .background(
                            brush = rainbowColorsBrush,
                            )
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = book.title,
                        modifier = Modifier
                            .padding(0.dp, 0.dp, 0.dp, 8.dp)
                            .align(Alignment.Start),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = book.author,
                        modifier = Modifier.align(Alignment.Start),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            // Book number indicator: Positioned at top end
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
            ) {
                Text(
                    text = bookNumber.toString(),
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.Center)
                )

            }
            BookSynopsisButton(
                expanded = expanded,
                onClick = { expanded = !expanded },
                modifier = Modifier.align(Alignment.BottomEnd),
            )

            // Synopsis Button: Positioned at bottom end

        }
        if(expanded){
            BookSynopsis(
                synopsis = book.synopsis,
                modifier = Modifier.padding(16.dp)
                    .clip(RoundedCornerShape(0.dp,0.dp,8.dp,8.dp))
            )
        }

    }
}

@Composable
 fun BookSynopsisButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(24.dp)
            .background(MaterialTheme.colorScheme.onSecondaryContainer) // Background color
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            IconButton(
                onClick = onClick,
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) "Show less" else "Show more",
                    tint = MaterialTheme.colorScheme.surfaceDim,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun BookSynopsis(
    @SuppressLint("SupportAnnotationUsage") @StringRes synopsis: String,
    modifier: Modifier = Modifier
){
    Text(
        text = synopsis,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    EnlightenMeBooksTheme {
//        BookCard(
//            book = Book(
//                id = 1,
//                title = "Atomic Habits",
//                author = "James Clear",
//                coverImageResId = R.drawable.atomic_habits,
//                synopsis = "Tiny Changes, Remarkable Results"
//            ),
//            bookNumber = 1,
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}
