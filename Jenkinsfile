pipeline {
    agent any

    stages {
        stage('Build and Push') {
                   steps {
                       echo 'Building and Pushing Docker Image...'
                       sh 'mvn clean compile jib:build'
                   }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}