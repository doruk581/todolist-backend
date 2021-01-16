pipeline {
     agent any
     stages {
          stage("Compile") {
               steps {
                    sh "./mvnw compile"
               }
          }
          stage("Test") {
               steps {
                    sh "./mvnw clean test"
               }
          }
          stage("Code coverage") {
               steps {
                    publishHTML (target: [
                         reportDir: 'test-results/coverage/jacoco',
                         reportFiles: 'index.html',
                         reportName: "JaCoCo Report"
                    ])
               }
          }
     }
}