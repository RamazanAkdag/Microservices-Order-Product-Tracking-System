pipeline {
    agent any
    environment {
            BRANCH_NAME = "${env.GIT_BRANCH?.replaceAll('origin/', '')}"
    }
    stages {
      /*  stage('Build and Push Docker image') {
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
        }*/
       stage('Create Deployment Yamls') {
               steps {
                   script {
                        sh "whoami"
                        sh "pwd"
                        def outputPath = "/home/jenkins/CICD/deployments/${BRANCH_NAME}"
                        sh "mkdir -p ${outputPath}"
                        sh "kompose convert -f docker-compose.yml -o ${outputPath}"
                        sh "source /home/jenkins/CICD/sendToK8s.sh ${BRANCH_NAME}"
                   }
               }
       }

    }
}
