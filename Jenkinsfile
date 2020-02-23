/*
 * Testing with Multi-branch Pipeline github webhook trigger.Configure webhook for once in github.
 */
def branchBuildBadge = addEmbeddableBadgeConfiguration(id: "branchBuildBadge")
pipeline {
    agent any
    
    stages {
            stage('Build') {
                steps {
                    echo 'Building'
                }
            }
            stage('Test') {
                steps {
                    script {
                        branchBuildBadge.setSubject('Master branch')
                        try {
                            echo 'Testing..'
                            branchBuildBadge.setStatus('passing')
                        } catch (Exception err) {
                            branchBuildBadge.setStatus('failing')
                        }
                    }
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
        stage ('Running Performance') {
            steps {
                script {
                    dir('C:\\Users\\roopansr\\workspace\\rest-sample\\src\\main\\resources\\jmeter') {
                        bat label: '', script: 'C:\\DEV\\apache-jmeter-5.2.1\\bin\\jmeter -Jjmeter.save.saveservice.output_format=xml -n -t JUnitRequest.jmx -l \'JunitResult.jtl\''
                        perfReport filterRegex: '', sourceDataFiles: 'JunitResult.jtl'    
                    }
                    
                }
            }
        }
    }
}
