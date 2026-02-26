pipeline {
    agent any

    tools {
        maven 'PaikallinenMaven'
    }

    environment{
        PATH = "path-to-docker ; ${env.PATH}"
        DOCKERHUB_ID = "topiahola"
        DOCKERHUB_REPO = "jenkins_docker_repo"
        DOCKER_IMAGE_TAG "latest"
        DOCKERHUB_CREDENTIALS = "dockehub_pat" //Kirjoitusvirhe jenkinsin puolella... Replace with your Jenkins credentials ID
        //dockerhub salasana Jenkinsistä?
    }

    /* docker tag local-image:tagname new-repo:tagname */
    /* docker push new-repo:tagname */

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
                } //TODO: tämä on väärin,
            }
        }

        /* docker push topiahola/jenkins_docker_repo:tagname */
         stage ('push docker image to dockerhub'){
            steps {
                script {
                    docker.withRegistry("'https://index.docker.io/v1/'", DOCKERHUB_CREDENTIALS)
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    //TODO: tässä pitäisi pushata rakennettu image?

                }
            }
        }



    }
}