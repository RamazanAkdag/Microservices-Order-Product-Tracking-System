pipeline {
    agent any
    environment {
            BRANCH_NAME = "${env.GIT_BRANCH?.replaceAll('origin/', '')}"
    }
    stages {
        stage('Build and Push Docker image') {
            agent {
                docker {
                    image 'maven:3.8.3-openjdk-17'
                }
            }
            steps {
                echo 'Building and Pushing Docker Image...'
                 withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'mvn clean compile jib:build -Djib.to.auth.username=$DOCKER_USERNAME -Djib.to.auth.password=$DOCKER_PASSWORD'
                 }

            }
        }
       stage('Create Deployment Yamls') {
               steps {
                   script {
                        def outputPath = "/home/kali/CICD/deployments/${BRANCH_NAME}"
                        sh "mkdir -p ${outputPath}"
                        sh "kompose convert -f . -o ${outputPath}"
                        sh "source /home/kali/CICD/sendToK8s.sh ${BRANCH_NAME}"
                   }
               }
       }

    }
}
