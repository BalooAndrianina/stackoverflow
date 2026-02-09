package fr.mastersid.stackoverflow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverFlowTheme

@Composable
fun QuestionRow(question: Question){
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){ //espace entre les éléments
        Column(
            modifier = Modifier.weight(1f), //prend le max de place, le plus long possible
            ) {
            Text(
                text = question.title,
                style = MaterialTheme.typography.headlineSmall, //style pour le titre
                maxLines = 1, //pas de retour à la ligne
                overflow = TextOverflow.Ellipsis, //pointillés si trop long
            )
            Text(
                text = question.body,
                maxLines = 2, //affichage sur 2 line max
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp
            )
        }
        Text(
            text = stringResource(id = R.string.answer_count, question.answerCount),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(16.dp) //padding autour du nombre.
        )
    }
}

@Preview(widthDp = 400, showBackground = true)
@Composable
fun QuestionRowPreview() {
    val loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"

    StackOverFlowTheme {
        QuestionRow(Question(1, "Comment faire du bacon?",loremIpsum, 6))
    }
}