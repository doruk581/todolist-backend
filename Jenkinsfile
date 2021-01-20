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

          stage("Deploy") {
                         steps {
                         script{
                            try {
                            sh "docker container stop todo-backend-app"
                            sh "docker container rm -f todo-backend-app"
                            }finally {
                            sh "docker container run -d -p 4567:4567 --name todo-backend-app 167.71.61.101:5000/todo-backend-app"
                            }
                         }
                         }
                    }
          stage("API Test") {
                        steps {
                                sh "newman run https://www.getpostman.com/collections/5cbef1b8b072f62247a5"
                        }
            }
     }
}