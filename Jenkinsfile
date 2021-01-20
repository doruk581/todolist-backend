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
                    sh "docker tag todo-backend-app 167.71.61.101:5000/todo-backend-app"
                    sh "docker push 167.71.61.101:5000/todo-backend-app"
               }
          }

          stage("Deploy to Docker Swarm") {
                         steps {
                              sh "./mvnw package"
                              sh "docker build -t todo-backend-app ."
                              sh "docker tag todo-backend-app 167.71.61.101:5000/todo-backend-app"
                              sh "docker push 167.71.61.101:5000/todo-backend-app"
                         }
                    }
     }
}