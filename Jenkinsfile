pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source from GitHub...'
                git url: 'https://github.com/YOUR_GITHUB_USERNAME/CalculatorPipelineDemo.git', branch: 'main'
                // print last commit info
                bat 'git --no-pager log -1 --pretty=format:"Commit: %H%nAuthor: %an%nDate: %ad%nMessage: %s"'
            }
        }
        stage('Build') {
            steps {
                echo 'Compiling Java files...'
                bat 'javac -version || true'
                bat 'javac Calculator.java CalculatorTest.java'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
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
        success {
            echo 'Pipeline finished SUCCESS'
        }
        failure {
            echo 'Pipeline finished FAILURE'
        }
    }
}
