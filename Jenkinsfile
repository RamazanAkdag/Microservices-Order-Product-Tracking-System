pipeline {
    agent any
    stages {
        stage('Build and Push') {
            agent {
                docker {
                    image 'maven:3.8.1-jdk-11'
                    args '-v /var/run/docker.sock:/var/run/docker.sock'
                }
            }
            steps {
                echo 'Building and Pushing Docker Image...'
                sh 'mvn clean compile jib:build'
            }
        }
    }
}
