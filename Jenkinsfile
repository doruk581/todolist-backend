pipeline {
     agent any
     stages {
          stage("Compile") {
               steps {
                    sh "mvn compile"
               }
          }
          stage("Test") {
               steps {
                    sh "mvn clean test"
               }
          }
     }
}