pipeline {
    agent any

    environment {
            PATH+EXTRA='/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven_3.6.3/bin:/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven_3.6.3/bin'
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