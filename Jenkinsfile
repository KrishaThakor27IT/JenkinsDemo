pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                git url: 'https://github.com/KrishaThakor27IT/JenkinsDemo.git', credentialsId: 'github-pat', branch: 'main'
, branch: 'main'
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
