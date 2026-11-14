package com.lumly.novastore.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lumly.novastore.ui.components.AppButton
import com.lumly.novastore.ui.components.AppOnboardingPageContent
import com.lumly.novastore.ui.components.AppPageIndicator
import com.lumly.novastore.ui.theme.NovastoreTheme
import kotlinx.coroutines.launch

data class OnboardingItem(
    val title: String,
    val description: String,
    val icon: ImageVector
)

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    onFinish: () -> Unit = {},
    onSkip: () -> Unit = {}
) {
    val items = listOf(
        OnboardingItem(
            title = "Discover products",
            description = "Browse thousands of products across electronics, fashion, jewelry and more — all in one place.",
            icon = Icons.Default.Search
        ),
        OnboardingItem(
            title = "Save your favorites",
            description = "Keep track of the items you love and never lose sight of them again.",
            icon = Icons.Default.Favorite
        ),
        OnboardingItem(
            title = "Shop with ease",
            description = "Fast checkout, secure payments and smooth delivery right to your door.",
            icon = Icons.Default.ShoppingCart
        )
    )

    val pagerState = rememberPagerState(pageCount = { items.size })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                if (pagerState.currentPage < items.size - 1) {
                    TextButton(onClick = onSkip) {
                        Text(
                            text = "Skip",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                val item = items[page]
                AppOnboardingPageContent(
                    title = item.title,
                    description = item.description,
                    icon = item.icon
                )
            }

            // Bottom controls: Indicators and Next/Get Started button
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                AppPageIndicator(
                    pageCount = items.size,
                    currentPage = pagerState.currentPage
                )

                AppButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = if (pagerState.currentPage == items.size - 1) "Get Started" else "Next",
                    onClick = {
                        if (pagerState.currentPage < items.size - 1) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            onFinish()
                        }
                    },
                    enabled = true,
                    isPrimary = true
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPagePreview() {
    NovastoreTheme {
        OnboardingPage()
    }
}
