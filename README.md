# Star Quiz

## Group 7

Max Yedid, maxyedid1@gmail.com, maxyedid
Victor Feng He, victorfeng2000@gmail.com, DeanEvil
Jaden Guevara, officialjadenguevara@gmail.com, JGuevara626
Kamil Skorupa, k.a.skorupa85@gmail.com, Kamil-S85

## 5 Initial Features

### Log-in / registration optional (Home Screen)
To begin the app, we want the user to provide information for authorization (log-in). 
This is also the screen where users would register and create their profiles. 
All this will lead towards the following important functions. 

### Username textbox (Home Screen)
Interacts with taken and banned username databases. 
Submit button to submit and progress to next (Info) screen.

### Hashing Passwords (Home Screen)
Allows the encryption and decryption of login passwords for the purpose of security.

### Theme Screen (Home Screen)
This allows the user to set the background of the application.

### Leaderboard (Home Screen)
Allows users to see a specific leaderboard (leaderboards for different modes of the quiz).

## MVP (Minimal Viable Product) composed of 6 user stories

### Home Screen - Guest Enter Name
User launches app. Arrives at Home screen and may enter a guest name into textbox and click enter to proceed to next screen. Warning message triggered if user enters
name stored in banned username database.

### Info Screen
User can read the setup and rules of the game and click OK to advance to next screen or Home to go back to Home screen.

### Mode Select Screen
User can select one of 6 game modes providing different number of questions, or go back to the Info or Home screens.

### Question Screen - Answer
User can pick 1 of 4 answers on the Question screen within a time limit and accumulate points if answered correctly. If no answer is picked in time the next question
is displayed.

### Question Screen - Lifeline
User can click on any of 3 lifelines which provide different aid for the question. If they do not pick a lifeline during the quiz, bonus points are added to their
total score.

### Question Screen - Last Question
User answers the last question and their total score is displayed to them on the next screen as well as their leaderboard placement and some stats comparing user to
other players.

## Risks and Mitigation
Risk of poor time management, which could result in late delivery of app or 
different modules during the app creation phase.
- Schedule meetings throughout the week to measure progress.
- Reassess throughout if the tentative timeline and goals need to be adjusted as needed.

Group size decreases due to student(s) withdrawing from class.
- Reassess the extra work that will need to be reassigned to remaining team members. 
Reassess the timeline of future goals and adjust as needed.

Copyright infringement accusations (Star Trek theme) app may be taken down.
- Don’t name the app anything related to Star Trek and don’t monetize in order to keep it free use.

Lack of understanding of Android app development, which could result in a subpar product
- Try to look at online tutorials to get used to developing apps on Android Studio.
- Practice Android app development over the course of the semester. The more 
  we practice and get used to 
  Android Studio’s UI and functions, we can complete the project more 
  efficiently with a better looking final product.
- Reading the documentation. Getting a basic understanding of Android app 
  development will help us for the project.

Having no creative designers for the design of what the app will look like that is most appealing
- Learn how to create appealing designs through Youtube tutorials
- Receive input from others on potential designs
- Test out different designs and see what “feels” right.

## Iteration Report:
During this iteration, we were able to create the layouts for all of the user stories/screens that we would need to deliver our MVP.
We also prioritized writing functional code for transitioning between the different screens as well as allowing the screens to retain
user information. The user stories that are being prioritized in this iteration is "Info Screen" and "Home Screen - Leaderboard Select Screen." 
As of the time of this writing, we have not been able to complete "Question Screen - Lifeline,"
"Question Screen - Answer," "Question Screen - Last Question," and "Specfic Leaderboard Screen." The other difficulty we faced is that most of our
commits have not been marked in accordance to "Red-Green-Refactoring," as we didn't look at the assignment until we were already done with
some of our user stories.

## Second Iteration Report:
For the second Iteration, we were able to close out the user stories for the "Home Screen - Enter Guest Name" and "Question Screen - Answer". For the final iteration, the last user stories to be finished are "Question Screen - Last Question" and "Specfic Leaderboard Screen.". Additional user stores such as "Question Screen - Lifeline", "Question Screen - Timer" and "Question Screen - Score" are all dependant on the final code included for Last Question, and will be closed simultaniously once Last Question is also completed. Test cases checking for the use of username and interaction of question scene buttons are in place for the test cases. 

## Design Pattern 
For this project, we have chosen to implement the model-view-controller design pattern, with the model being a "Quiz" question object, the view being the "QuizView" interface, and the controller being the "QuizController" class. In the context of our Star Quiz application, this design pattern will essentially serve to transition from question to question as the user answers questions. The controller will appropriately update the display of the QuestionAnswerActivity so that it will display a new question and an update score value.   

## Third Iteration Report:
For the Third and final iteration, the "QuestionAnswerActivity" and "Question Screen - Lifeline" user stories were completed, along it connecting the "Question Screen - Timer" and "Question Screen - Score" to complete the project to be in a working state. The QuestionAnswerActivity is able to iterate between questions and lead the user as well as the data they have procressed straight to be saved onto the specific leaderboard select of the difficulty they have chosen. To summerize the analysis, due to the sudden departure of a team member, it became the responsibility of the others to take over their tasks, and the difficulty it came with understanding what corners to cut or code to make in order to deliver in time. There are alot of minor warning that do not impose on the core code, as it is mostly name formatting that the system perfers over whats written, yet the code will still run. The code slightly deviated from the structure yet has still achieved its goal.
