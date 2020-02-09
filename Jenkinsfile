pipeline {
    agent any
    environment {
        PAYARA_ADMIN_PORT='10048'
        PAYARA_DOMAIN_NAME='production'
        PAYARA_HOME='/opt/payara5'
        PAYARA_USERNAME='isdp01'
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
                echo 'Build'
                sh 'mvn package'
            }
            post {
                success {
                    echo 'Successfully built'
                    sh 'mvn cargo:redeploy -pl main'
                }
            }
        }

        stage('Integration tests') {
            steps {
                echo 'Integration tests'
                sh 'mvn failsafe:integration-test'
            }
            post {
                always {
                    junit 'test/target/failsafe-reports/*.xml'
                }
            }
        }
    }
}
