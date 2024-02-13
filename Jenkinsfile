pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'docker build . -t spring-boot'
            }
        }
        stage('Run') {
            steps {
                sh 'docker run -d -p 8000:8000 --name spring-boot spring-boot'
            }
        }
    }
}
