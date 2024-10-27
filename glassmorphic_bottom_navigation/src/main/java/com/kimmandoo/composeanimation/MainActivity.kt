package com.kimmandoo.composeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kimmandoo.composeanimation.ui.theme.ComposeAnimationTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hazeState = remember { HazeState() }
            ComposeAnimationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { GlassMorphicBottomNavScreen(hazeState = hazeState) }
                ) { innerPadding ->

                    LazyColumn(
                        Modifier
                            .haze(
                                hazeState,
                                backgroundColor = MaterialTheme.colorScheme.background,
                                tint = Color.Black.copy(alpha = .2f),
                                blurRadius = 30.dp,
                            )
                            .fillMaxSize(),
                        contentPadding = innerPadding
                    ) {
                        items(50) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(8.dp)
                            ) {
                                Row {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                        contentDescription = null
                                    )
                                    Text(text = "Item $it", modifier = Modifier.padding(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
