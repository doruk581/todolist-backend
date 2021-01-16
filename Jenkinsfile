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
                    sh "./mvnw clean test -DargLine=-Djdk.net.URLClassPath.disableClassPathURLCheck=true"
               }
          }
     }
}