pipeline {
    agent any
    stages {
        stage('Build and Push') {
            steps {
                script {
                    docker.image('maven:3.8.1-jdk-11').inside {
                        echo 'Building and Pushing Docker Image...'
                        sh 'mvn clean compile jib:build'
                    }
                }
            }
        }
    }
}
