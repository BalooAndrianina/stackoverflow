package fr.mastersid.stackoverflow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverFlowTheme

@Composable
fun QuestionRow(question: Question){
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){ //espace entre les éléments
        Text(
            text = question.title,
            maxLines = 1, //pas de retour à la ligne
            overflow = TextOverflow.Ellipsis, //pointillés si trop long
            modifier = Modifier.weight(1f) //prend le max de place, le plus long possible
        )
        Text(
            text = stringResource(id = R.string.answer_count, question.answerCount)
        )
    }
}

@Preview(widthDp = 400, showBackground = true)
@Composable
fun QuestionRowPreview() {
    StackOverFlowTheme {
        QuestionRow(Question(1, "Comment faire du bacon?", 6))
    }
}