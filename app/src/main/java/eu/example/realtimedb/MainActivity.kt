package eu.example.realtimedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.example.realtimedb.ui.theme.RealTimeDBTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			RealTimeDBTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					RealTimeDatabase()
				}
			}
		}
	}
}

@Composable
fun RealTimeDatabase() {

	var rollNumber by remember {
		mutableStateOf("")
	}

	var studentName by remember {
		mutableStateOf("")
	}

	var course by remember {
		mutableStateOf("")
	}

	var result by remember {
		mutableStateOf("")
	}

	var check by remember {
		mutableStateOf<Boolean>(false)
	}



	Column(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(
			text = "Student Info from Realtime database",
			fontSize = 20.sp,
			color = Color.Red
		)

		Spacer(modifier = Modifier.height(10.dp))

		OutlinedTextField(
			value = rollNumber,
			onValueChange = { rollNumber = it.toString() },
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp),
			placeholder = {
				Text(
					text = "Enter student rollnumber",
					fontSize = 14.sp,
					color = Color.Blue
				)
			}
		)
		Spacer(modifier = Modifier.height(10.dp))

		OutlinedTextField(
			value = studentName,
			onValueChange = { studentName = it.toString() },
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp),
			placeholder = {
				Text(
					text = "Enter student name",
					fontSize = 14.sp,
					color = Color.Blue
				)
			}
		)
		Spacer(modifier = Modifier.height(10.dp))

		OutlinedTextField(
			value = course,
			onValueChange = { course = it.toString() },
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp),
			placeholder = {
				Text(
					text = "Enter student course",
					fontSize = 14.sp,
					color = Color.Blue
				)
			}
		)
		Spacer(modifier = Modifier.height(20.dp))
		Row() {
			OutlinedButton(onClick = { /*TODO*/ }) {
				Text(text = "Insert", fontSize = 16.sp, color = Color.Red)
			}
			OutlinedButton(onClick = { /*TODO*/ }) {
				Text(text = "Display", fontSize = 16.sp, color = Color.Red)
			}
			OutlinedButton(onClick = { /*TODO*/ }) {
				Text(text = "Update", fontSize = 16.sp, color = Color.Red)
			}
			OutlinedButton(onClick = { /*TODO*/ }) {
				Text(text = "Delete", fontSize = 16.sp, color = Color.Red)
			}
		}
		Spacer(modifier = Modifier.height(10.dp))
		AnimatedVisibility(
			visible = check,
			modifier = Modifier
				.fillMaxWidth()) {
			Text(text = result, fontSize = 14.sp, color = Color.Red)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	RealTimeDBTheme {
		RealTimeDatabase()
	}
}