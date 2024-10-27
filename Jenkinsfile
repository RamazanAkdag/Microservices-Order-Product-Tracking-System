pipeline {
    agent any

    stages {
        stage('Build and Push') {
            agent {
                docker { image 'maven:3.8.1-jdk-11' }
            }
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