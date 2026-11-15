package com.lumly.novastore.ui.screens.auth

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lumly.novastore.R
import com.lumly.novastore.ui.components.AppButton
import com.lumly.novastore.ui.components.AppTextField
import com.lumly.novastore.ui.theme.NovastoreTheme

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Logo()
            Welcome()
            FormContainer()
            SocialLoginContainer()
            Footer()
        }
    }
}

@Composable
fun Logo() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // icons
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(shape = RoundedCornerShape(size = 12.dp))
                .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingBag,
                contentDescription = "nova store logo",
                modifier = Modifier
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }

        // app title
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Nova",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 22.sp,
                    letterSpacing = 1.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Store",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Light,
                    fontSize = 22.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun Welcome() {
    Column() {
        Text(
            text = "Welcome back",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
        )

        Text(text = "Sign in to continue shopping",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
fun FormContainer() {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        AppTextField(
            label = "Email",
            placeholder = "Type your email address here",
            securedField = false,
            leadingIcon = Icons.Default.Email
        )

        AppTextField(
            label = "Password",
            placeholder = "Type password here",
            securedField = true,
            leadingIcon = Icons.Default.Lock
        )

        AppButton(
            modifier = Modifier
                .fillMaxWidth(),
            label = "Log In",
            onClick = {}
        )

        // divider
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(color = MaterialTheme.colorScheme.outline)
            )

            Text(text = "OR",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant)

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(color = MaterialTheme.colorScheme.outline)
            )
        }

    }
}

@Composable
fun SocialLoginContainer() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SocialButton(
            modifier = Modifier
                .weight(1f),
            label = "Google",
            icon = R.drawable.font_awesome_google,
            onClick = {},
            contentDescription = "Google sign In"
        )

        SocialButton(
            modifier = Modifier
                .weight(1f),
            label = "Apple",
            icon = R.drawable.simple_icons_apple,
            onClick = {},
            contentDescription = "Apple sign In"
        )
    }
}

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    contentDescription: String
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.colorScheme.surface)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(size = 10.dp))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .size(18.dp)
            )

            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun Footer() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical  = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Don't have an account?",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.clickable(onClick = {})
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    NovastoreTheme {
        LoginPage()
    }
}