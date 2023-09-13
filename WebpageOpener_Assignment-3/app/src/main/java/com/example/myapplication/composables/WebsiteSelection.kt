// WebsiteSelection.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.Website

@Composable
fun WebsiteSelection(
    selectedWebsite: Website?,
    onWebsiteSelected: (Website) -> Unit
) {
    val websites = listOf(
        Website("LinkedIn", R.drawable.linkedin, "https://www.linkedin.com/"),
        Website("Github", R.drawable.github, "https://github.com/"),
        Website("Youtube", R.drawable.youtube, "https://www.youtube.com/"),
        Website("Spotify", R.drawable.spotify, "https://open.spotify.com/")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Select a website:")
        Spacer(modifier = Modifier.height(8.dp))

        websites.forEach { website ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onWebsiteSelected(website)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedWebsite == website,
                    onCheckedChange = { checked ->
                        if (checked) {
                            onWebsiteSelected(website)
                        }
                    },
                    modifier = Modifier.padding(4.dp)
                )

                WebsiteIcon(website.icon)

                Spacer(modifier = Modifier.width(8.dp))

                Text(text = website.name)
            }
        }
    }
}

@Composable
fun WebsiteIcon(iconResource: Int) {
    val painter = painterResource(id = iconResource)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(24.dp)
    )
}
