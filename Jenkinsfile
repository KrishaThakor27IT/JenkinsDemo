pipeline {
    agent any

    tools {
        // This line tells Jenkins to use the JDK you configured.
        jdk 'jdk-17' 
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                // Using the git step is cleaner than the default checkout
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
                // This command may need to be adjusted if you are using a test framework like JUnit
                bat 'java CalculatorTest'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '*.class', allowEmptyArchive: true // Changed to true to prevent failures if no .class files are found
            }
        }
    }

    post {
        success { echo 'Pipeline finished SUCCESS' }
        failure { echo 'Pipeline finished FAILURE' }
    }
}

