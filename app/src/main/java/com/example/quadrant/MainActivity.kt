package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllComposes(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Compose(title: String, content: String, backgroundColor: Long, modifier: Modifier = Modifier) {
    Surface (
        color = Color(backgroundColor),
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify
            )
        }
    }
}

// fonction composable pour tous les composables
@Composable
fun AllComposes(modifier: Modifier = Modifier) {
    Column {
        Row (
            modifier = Modifier
                .weight(1f) // la ligne occupe 1/2 de l'espace disponible
                .fillMaxWidth() // la ligne occupe toute la largeur disponible
        ) {
            Compose(
                stringResource(R.string.TitleComposableText),
                stringResource(R.string.ContentComposableText),
                0xFFEADDFF,
                modifier = Modifier
                    .weight(1f) // la colonne occupe 1/2 de l'espace disponible //
            )
            Compose(
                stringResource(R.string.TitleComposableImage),
                stringResource(R.string.ContentComposableImage),
                0xFFD0BCFF,
                modifier = Modifier
                    .weight(1f)
            )
        }

        Row (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Compose(
                stringResource(R.string.TitleComposableRow),
                stringResource(R.string.ContentComposableRow),
                0xFFB69DF8,
                modifier = Modifier
                    .weight(1f)
            )
            Compose(
                stringResource(R.string.TitleComposableColumn),
                stringResource(R.string.ContentComposableColumn),
                0xFFF6EDFF,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    QuadrantTheme {
        AllComposes()
    }
}