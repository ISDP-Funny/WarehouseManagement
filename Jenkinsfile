pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
    }

    stages {
        stage('Pre-Build') {
            steps {
                echo 'Pre-Build'
                sh 'mvn clean'
            }
            post {
                success {
                    echo 'Succesfully deleted old project'
                }
            }
        }
    }
}