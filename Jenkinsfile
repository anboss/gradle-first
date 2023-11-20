@Library('my-shared-library') _

pipeline {
    agent any
    tools {
        gradle "MyGradle"
    }
    environment {
        GIT_USER = 'anboss'
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/anboss/gradle-first.git'
				script {
					sh "gradle clean test"
				}
            }
        }
	stage('Snyk Scan'){
            steps{
                script {
					sh """
					set -x
					docker run \
						--env SNYK_TOKEN \
						-v "C:/ProgramData/Jenkins/.jenkins/workspace/gradle-first_master:/app" \
						snyk/snyk:gradle-jdk8
					docker ps -e
					exit \$?
					"""
               }
            }
        }
    }
}
