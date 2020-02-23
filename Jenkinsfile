/*
 * Testing with Multi-branch Pipeline github webhook trigger.Configure webhook for once in github.
 */
def branchBuildBadge = addEmbeddableBadgeConfiguration(id: "branchBuildBadge")
pipeline {
    agent any
    
    stages {
            stage('Build') {
                steps {
                    branchBuildBadge.setSubject('Master branch running')
                    try {
                     echo 'Building..'
                    branchBuildBadge.setStatus('passing')
                } catch (Exception err) {
                    branchBuildBadge.setStatus('failing')
                }
               }
            }
            stage('Test') {
                steps {
                    branchBuildBadge.setStatus('Master branch in testing...')
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

