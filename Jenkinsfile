pipeline {
    agent any

    tools {
        maven 'Maven_3.8.5' // This should match the name configured in Jenkins Global Tools
        jdk 'JDK_11'        // This should also match Jenkins global tool name
    }

    environment {
        // Define any environment variables here if needed
        APP_NAME = "MyJavaApp"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source code from branch: ${env.BRANCH_NAME}"
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building the Java application with Maven..."
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                echo "Running unit tests..."
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo "Packaging the application..."
                sh 'mvn package'
            }
        }

        stage('Deploy to Dev') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying ${APP_NAME} to the Dev environment..."
                // Example: sh './scripts/deploy.sh dev'
            }
        }
    }

    post {
        always {
            echo "Pipeline completed for branch: ${env.BRANCH_NAME}"
        }
        success {
            echo "Pipeline succeeded ✅"
        }
        failure {
            echo "Pipeline failed ❌"
        }
    }
}
