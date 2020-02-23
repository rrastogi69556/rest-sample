/*
 * Testing with Multi-branch Pipeline github webhook trigger.Configure webhook for once in github.
 */
def branchBuilddBadge = addEmbeddableBadgeConfiguration(id: "branchBuildBadge")
pipeline {
    agent any
    
    stages {
        stage('Build') {
            when {
                branch 'master'
            }
            steps {
                branchBuilddBadge.setSubject('Master branch Building')
                echo 'Building..'
            }
            when {
                branch 'development'
            }
            steps {
                branchBuilddBadge.setSubject('development branch Building')
                echo 'Building..'
            }
            when {
                branch 'production'
            }
            steps {
                 branchBuilddBadge.setSubject('production branch Building')
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
