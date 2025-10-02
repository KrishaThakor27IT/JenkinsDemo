pipeline {
    agent any

    // THIS IS THE CRUCIAL SECTION THAT IS MISSING
    tools {
        jdk 'jdk-17' 
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                // The 'git' step is cleaner than relying on the default checkout.
                git url: 'https://github.com/KrishaThakor27IT/JenkinsDemo.git', credentialsId: 'github-pat', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling Java files...'
                // This will now work because the tools block has set up the JDK.
                bat 'javac Calculator.java CalculatorTest.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running automated tests...'
                // Note: This simple command might not work for a real test suite.
                // It assumes CalculatorTest has a main method.
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

