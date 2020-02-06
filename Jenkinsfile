pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Pre-Build') {

            steps {
                withEnv({"PATH+EXTRA=/opt/payara5/javadb/bin"}) {
                    echo 'Pre-Build'
                    sh 'mvn clean exec:exec'
                }
            }
            post {
                success {
                    echo 'Successfully deleted old project'
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Build'
                sh 'mvn package'
            }
            post {
                success {
                    echo 'Successfully built'
                    sh 'mvn cargo:redeploy'
                }
            }
        }
    }
}