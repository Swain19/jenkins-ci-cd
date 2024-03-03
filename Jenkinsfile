pipeline{

    agent any

    tools{
        maven "maven"
    }

    stages{
        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Swain19/jenkins-ci-cd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }

        stage("Deploy to Container"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9191/')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }
    }
    post{
        always{
           emailext attachLog: true, body: '''<html>
    <body>
        <p>Build Status: ${BUILD_STATUS}</p>
        <p>Build Number: ${BUILD_NUMBER}</p>
        <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
    </body>
</html>''', mimeType: 'text/html', replyTo: 'swainrashmiranjan10@gmail.com', subject: 'Pieline Status : ${BUILD_NUMBER}', to: 'swainrashmiranjan10@gmail.com'}
    }
}

//SCM checkout
//build
//deploy the WAR
//EMAIL