pipeline {
    agent any

    // THIS IS THE CRUCIAL SECTION THAT MUST BE IN THE FILE
    tools {
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
                // This command will now succeed
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
                archiveArtifacts artifacts: '*.class', allowEmptyArchive: true
            }
        }
    }

    post {
        success { echo 'Pipeline finished SUCCESS' }
        failure { echo 'Pipeline finished FAILURE' }
    }
}
