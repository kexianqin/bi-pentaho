#!groovy
node {
  stage('Checkout'){
    checkout scm
  }

  stage('SonarQube Analysis') {
    // requires SonarQube Scanner 2.8+
    def scannerHome = tool 'SonarQube Scanner 2.8';
    withSonarQubeEnv('Youpin SonarQube Server') {
      sh "${scannerHome}/bin/sonar-scanner -X"
    }
  }

  stage('Build'){
    sh "bash -ex deploy.sh"
  }

  stage('Publish Test Report') {
    junit keepLongStdio: true, testResults: 'build/test-results/test/*.xml'
    step([$class: 'JacocoPublisher'])
  }

}
