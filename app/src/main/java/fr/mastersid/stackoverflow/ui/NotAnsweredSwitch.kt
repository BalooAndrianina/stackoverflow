package fr.mastersid.stackoverflow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.ui.theme.StackOverFlowTheme

@Composable
fun NotAnsweredSwitch(modifier: Modifier, notAnswered: Boolean, onChange: (Boolean)-> Unit){
    Row (
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        Text(
            stringResource(id = R.string.not_answered_questions)
        )
        Switch(
            checked = notAnswered,
            onCheckedChange = onChange
        )
    }
}

@Preview(
    widthDp = 400,
    showBackground = true
)
@Composable
fun NotAnsweredSwitchPreview () {
    StackOverFlowTheme {
        NotAnsweredSwitch (modifier = Modifier.padding(horizontal = 16.dp), notAnswered = true) {
        }
    }
}
