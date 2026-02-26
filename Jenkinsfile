pipeline {
    agent any

    tools {
        maven 'PaikallinenMaven'
    }

    environment{
        PATH = "path-to-docker ; ${env.PATH"
        DOCKERHUB_ID = "TopiAhola"
        DOCKERHUB_REPO = ""
        DOCKER_IMAGE_TAG "latest"
        //dockerhub salasana Jenkinsistä?
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/TopiAhola/Week5_jenkins_assignment.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install' // sh for linux and ios
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage ('Build docker image'){
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

         stage ('push docker image to dockerhub'){
            steps {
                script {
                    docker.withRegistry("dockerhub.io",DOCKERHUB_REPO)
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }



    }
}