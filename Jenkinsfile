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
                     bat "jmeter.bat -Jjmeter.save.saveservice.output_format=xml
          -n -t 'src/main/resources/jmeter/JUnitRequest.jmx' 
            -l 'src/main/resources/jmeter/result/JunitResult.jtl'"
                }
                step([$class: 'ArtifactArchiver', artifacts: 'src/main/resources/jmeter/result/JMeter.jtl,src/main/resources/jmeter/result/jmeter.log'])
                perfReport filterRegex: '', sourceDataFiles: 'JMeter reports:"src/main/resources/jmeter/result/JunitResult.jtl";'
                
       
            }
    }
}

