pipeline {
    agent any
    stages {
        /*stage('Build and Push Docker image') {
            agent {
                docker {
                    image 'maven:3.8.3-openjdk-17'
                }
            }
            steps {
                echo 'Building and Pushing Docker Image...'
                 withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'mvn compile jib:build -Djib.to.auth.username=$DOCKER_USERNAME -Djib.to.auth.password=$DOCKER_PASSWORD'
                 }

            }
        }*/
        stage('Create Deployment Yamls') {
            steps {
                sh 'ls -la'
            }

        }

    }
}