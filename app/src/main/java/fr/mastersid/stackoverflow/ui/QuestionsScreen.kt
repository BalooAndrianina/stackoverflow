package fr.mastersid.stackoverflow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.mastersid.stackoverflow.ui.QuestionRow
import fr.mastersid.stackoverflow.R
import fr.mastersid.stackoverflow.data.Question
import fr.mastersid.stackoverflow.ui.theme.StackOverFlowTheme
import fr.mastersid.stackoverflow.viewmodels.QuestionListViewModel


@Composable
fun QuestionsScreen(modifier: Modifier, questionListViewModel: QuestionListViewModel = viewModel()){
    val questionListAll by questionListViewModel.questionList.observeAsState(emptyList())

    var notAnswered : Boolean by rememberSaveable { mutableStateOf(false) }

    val questionList = if (notAnswered){
        questionListAll.filter{it.answerCount == 0}
    }else{
        questionListAll
    }

    val refreshing: Boolean by questionListViewModel.isUpdating.observeAsState(false)

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NotAnsweredSwitch(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = WindowInsets.safeDrawing
                        .asPaddingValues()
                        .calculateBottomPadding()),
                notAnswered = notAnswered
            ) {
                checked ->
                notAnswered = checked

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = questionListViewModel::updateQuestionList
            ) {
                Icon(painterResource(R.drawable.baseline_download_24),
                    stringResource(R.string.Update_questions)
                )
            }
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(questionList) { question ->
                    QuestionRow(question)
                }
            }

            if (refreshing) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                )
            }
        }
    }
}

@Preview(
    widthDp = 400,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun QuestionsScreenPreview() {
    StackOverFlowTheme {
        QuestionsScreen(
            modifier = Modifier
        )
    }
}
