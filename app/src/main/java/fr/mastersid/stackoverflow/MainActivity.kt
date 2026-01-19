package fr.mastersid.stackoverflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StackOverFlowTheme {
                QuestionsScreen(modifier = Modifier.safeDrawingPadding())
            }
        }
    }
}

@Composable
fun QuestionsScreen(modifier: Modifier){
    var notAnswered : Boolean by rememberSaveable { mutableStateOf(false) }
    val questionList = listOf(
        Question(1, "Comment faire du bacon?", 6),
        Question(2, "Comment manger du poulet sans se tacher", 0),
        Question(3, "Comment tuer le papillon", 6),
    )

    Scaffold(
        modifier = modifier,
        bottomBar = {
            Row() {
                Text(
                    stringResource(id = R.string.not_answered_questions)
                )
                Switch(
                    checked = notAnswered,
                    onCheckedChange = { checked -> notAnswered = checked }
                )
            }
        }
    ){ innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(questionList){ question ->
                QuestionRow(question)
            }
        }
    }
}

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