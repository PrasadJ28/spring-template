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
                    def app = docker.build(imageName)
                }
            }
        }
        stage('Save Docker Image Locally') {
            steps {
                script {
                    sh 'docker save -o /path/to/save/image/your-docker-image-${env.BUILD_ID}.tar your-docker-image:${env.BUILD_ID}'
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
