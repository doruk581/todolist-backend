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
                    sh "./mvnw  -DargLine="-Djdk.net.URLClassPath.disableClassPathURLCheck=true""
               }
          }
     }
}