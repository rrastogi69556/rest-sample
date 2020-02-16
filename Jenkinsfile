/*
 * Testing with Multi-branch Pipeline github webhook trigger.Configure webhook for once in github.
 */
pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deliver for development') {
                    when {
                        branch 'development'
                    }
                    steps {
                       echo 'Building DEVELOPMENT branch'
                    }
                }
        stage('Deploy for production') {
                    when {
                        branch 'production'
                    }
                    steps {
                        echo 'Building PROD branch'
                    }
                }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
