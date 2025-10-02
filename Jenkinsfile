pipeline {
    agent any

    tools {
        // <-- ADD THIS SECTION
        // This name MUST match the name you used in Manage Jenkins > Tools
        jdk 'jdk-17' 
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                git url: 'https://github.com/KrishaThakor27IT/JenkinsDemo.git', credentialsId: 'github-pat', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling Java files...'
                bat 'javac Calculator.java CalculatorTest.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running automated tests...'
                // Note: This command might fail if JUnit is not in your classpath.
                // A more robust command is: bat 'java -cp . org.junit.runner.JUnitCore CalculatorTest'
                bat 'java CalculatorTest'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '*.class', allowEmptyArchive: false
            }
        }
    }

    post {
        success { echo 'Pipeline finished SUCCESS' }
        failure { echo 'Pipeline finished FAILURE' }
    }
}
