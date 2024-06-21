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
                    def saveDir = "C:\\ProgramData\\Jenkins\\.jenkins\\${env.JOB_NAME}\\${env.BUILD_ID}"
                    def savePath = "${saveDir}\\${env.IMAGE_NAME}-${env.BUILD_ID}.tar"
                    
                    // Create the directory if it doesn't exist
                    bat "mkdir \"${saveDir}\""
                    
                    // Save the Docker image to the specified path
                    bat "docker save -o \"${savePath}\" ${env.IMAGE_NAME}:${env.BUILD_ID}"
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
