#!groovy
node {
  stage('Chcekout'){
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

}