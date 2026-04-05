# QuizGenerator

## Overview
QuizGenerator is a versatile application designed to create, manage, and conduct quizzes efficiently. It is built for educators, trainers, and anyone interested in assessing knowledge through quizzes.

## Features
- **User-Friendly Interface**: Simple and intuitive design for easy navigation.
- **Customizable Quizzes**: Create quizzes tailored to various subjects and difficulty levels.
- **Score Tracking**: Automatic score calculation and tracking for participants.
- **Real-time Performance Analytics**: View performance statistics of participants after quiz completion.
- **Multi-Platform Support**: Accessible on various devices including mobile, tablet, and desktop.

## Tech Stack
- **Frontend**: HTML, CSS, JavaScript, and React.
- **Backend**: Node.js, Express.js.
- **Database**: MongoDB for storage of quizzes and user information.
- **Deployment**: Hosted on Heroku.

## Installation Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/ShravanOfficial-09/QuizGenerator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd QuizGenerator
   ```
3. Install dependencies:
   ```bash
   npm install
   ```
4. Start the server:
   ```bash
   npm start
   ```
5. Open your browser and go to `http://localhost:3000` to access the application.

## Usage Guide
- To create a quiz, navigate to the 'Create Quiz' section.
- Fill in the quiz details such as title, questions, and options.
- Save the quiz and share the link with participants.
- Review participant scores and analysis in the 'Results' section.

## Project Structure
```
QuizGenerator/
├── client/                  # Frontend application
│   ├── public/              # Public assets
│   └── src/                 # Source code for frontend
├── server/                  # Backend application
│   ├── models/              # Database models
│   └── routes/              # API routes
├── .env                     # Environment variables
├── .gitignore               # Git ignore file
├── package.json             # NPM dependencies
└── README.md                # Project documentation
```

## Code Examples
### Creating a Quiz
```javascript
const createQuiz = async () => {
    const response = await fetch('/api/quizzes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: 'Sample Quiz',
            questions: [
                { question: 'What is 2 + 2?', options: ['3', '4', '5'], answer: '4' },
                // additional questions
            ]
        }),
    });
    return await response.json();
};
```

## API Documentation
### POST /api/quizzes
- **Description**: Create a new quiz.
- **Request Body**:
   - `title`: String - Title of the quiz.
   - `questions`: Array of Objects - Quiz questions with options and the answer.
- **Response**: Returns details of the created quiz.

### GET /api/quizzes/:id
- **Description**: Retrieve a specific quiz by ID.
- **Response**: Returns quiz details including questions and options.

## Testing Guide
1. Ensure you have `jest` and `supertest` installed.
2. Run the tests using:
   ```bash
   npm test
   ```
3. Check test results and ensure all tests pass.

## Learning Outcomes
- Understand the fundamentals of web development using React and Node.js.
- Gain experience in working with databases and RESTful APIs.
- Learn to create user-friendly applications with real-time features.
- Improve problem-solving skills through project-based learning.

---