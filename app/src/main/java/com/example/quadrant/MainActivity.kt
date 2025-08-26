package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

// fonction composable pour le text composable
@Composable
fun TextComposable(title: String, content: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFFEADDFF),
        modifier = modifier.fillMaxSize() // la surface occupe tout l'espace disponible
    ) {
        Column (
            verticalArrangement = Arrangement.Center, // centre verticalement
            horizontalAlignment = Alignment.CenterHorizontally, // centre horizontalement
            modifier = Modifier.padding(16.dp)

        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold, // text en gras
                modifier = Modifier.padding(bottom = 16.dp) // marge inferieure de 16 dp

            )
            Text(
                text = content,
                textAlign = TextAlign.Justify // texte justifié
            )
        }

    }
}

// fonction composable pour l'image composable
@Composable
fun ImageComposable(title: String, content: String, modifier: Modifier = Modifier) {
    Surface (
        color = Color(0xFFD0BCFF),
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

// fonction composable pour le row composable
@Composable
fun RowComposable(title: String, content: String, modifier: Modifier = Modifier) {
    Surface (
        color = Color(0xFFB69DF8),
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

// fonction composable pour le column composable
@Composable
fun ColumnComposable(title: String, content: String, modifier: Modifier = Modifier) {
    Surface (
        color = Color(0xFFF6EDFF),
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
    Column (
        modifier = modifier.fillMaxSize()
    ) {
        Row (
            modifier = Modifier
                .weight(1f) // la ligne occupe 1/2 de l'espace disponible
                .fillMaxWidth() // la ligne occupe toute la largeur disponible
        ) {
            TextComposable(
                stringResource(R.string.TitleComposableText),
                stringResource(R.string.ContentComposableText),
                modifier = Modifier
                    .weight(1f) // la colonne occupe 1/2 de l'espace disponible //
            )
            ImageComposable(
                stringResource(R.string.TitleComposableImage),
                stringResource(R.string.ContentComposableImage),
                modifier = Modifier
                    .weight(1f)
            )
        }

        Row (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            RowComposable(
                stringResource(R.string.TitleComposableRow),
                stringResource(R.string.ContentComposableRow),
                modifier = Modifier
                    .weight(1f)
            )
            ColumnComposable(
                stringResource(R.string.TitleComposableColumn),
                stringResource(R.string.ContentComposableColumn),
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