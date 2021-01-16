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
                    sh "./mvnw test -DargLine=-Djdk.net.URLClassPath.disableClassPathURLCheck=true"
               }
          }
     }
}