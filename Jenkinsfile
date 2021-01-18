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
                         reportDir: 'target/test-results/coverage/jacoco',
                         reportFiles: 'index.html',
                         reportName: "JaCoCo Report"
                    ])
               }
          }
          stage("Dockerize") {
               steps {
                    sh "./mvnw package"
                    sh "docker build -t todo-backend-app ."
                    sh "docker tag todo-backend-app 167.99.250.62/todo-backend-app"
                    sh "docker push 167.99.250.62/todo-backend-app"
               }
          }
     }
}