pipeline {
    agent any

    tools {
        maven 'PaikallinenMaven'
        docker 'Docker'
    }

    environment{
        PATH = "path-to-docker ; ${env.PATH}"
        DOCKERHUB_ID = "topiahola"
        DOCKERHUB_REPO = "jenkins_docker_repo"
        DOCKER_IMAGE_TAG = "latest"
        BUILD_IMAGE_NAME = "jenkinsAssignment"
        DOCKERHUB_CREDENTIALS = "dockehub_pat" //Kirjoitusvirhe jenkinsin puolella... Replace with your Jenkins credentials ID
        JAVA_HOME = "C:\\Koodaus\\Kielet\\Java21"
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

        /*
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

         stage('Publish Test Results') {
            steps {
                junit '**//* target/surefire-reports *//*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
        */

        stage ('Build docker image'){
            steps {
                script {
                    /*(name, pathToDockerfile)*/
                   docker.build("${BUILD_IMAGE_NAME}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        /* docker push topiahola/jenkins_docker_repo:tagname */
         stage ('push docker image to dockerhub'){
            steps {
                script {
                    //käyttää dockeria ei-oletus repositiolla
                    docker.withRegistry("'https://index.docker.io/v1/'", DOCKERHUB_CREDENTIALS) {
                        docker.image("${BUILD_IMAGE_NAME}:${DOCKER_IMAGE_TAG}").push()  //"${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                    }


                }
            }
        }



    }
}