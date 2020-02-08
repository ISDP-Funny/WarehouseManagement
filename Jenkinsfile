pipeline {
    agent any
    environment {
        PAYARA_ADMIN_PORT='10048'
        PAYARA_DOMAIN_NAME='production'
        PAYARA_HOME='/opt/payara5'
        PAYARA_USERNAME='isdp'
    }
    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Pre-Build') {

            steps {
                withEnv(["PATH+EXTRA=/opt/payara5/javadb/bin"]) {
                    echo 'Pre-Build'
                    sh 'mvn clean'
                    sh 'scripts/prepare_database.sh'
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
                withEnv(["PATH+EXTRA=/opt/payara5/javadb/bin"]) {
                    echo 'Build'
                    sh 'mvn package'
                }
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
