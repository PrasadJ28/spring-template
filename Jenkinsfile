pipeline {
    agent any
    environment {
        IMAGE_NAME = "your-docker-image"
    }
    stages {
        stage('Clone Repository') {
            steps {
                git branch: '**', url: 'https://github.com/PrasadJ28/spring-template.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    def imageName = "${env.IMAGE_NAME}:${env.BUILD_ID}"
                    docker.build(imageName)
                }
            }
        }
        stage('Save Docker Image Locally') {
            steps {
                script {
                    // Path to save the Docker image tar file within the Jenkins repository directory
                    def savePath = "C:\\ProgramData\\Jenkins\\.jenkins\\${env.JOB_NAME}\\${env.BUILD_ID}\\${env.IMAGE_NAME}-${env.BUILD_ID}.tar"
                    bat "docker save -o ${savePath} ${env.IMAGE_NAME}:${env.BUILD_ID}"
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
