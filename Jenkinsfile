.@Library('my-shared-library') _

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
     					ls -ltr ${env.WORKSPACE}
					docker run \
						--env SNYK_TOKEN \
						-v "${env.WORKSPACE}:/app" \
						snyk/snyk:gradle-jdk8
					docker ps -e
					exit \$?
					"""
               }
            }
        }
    }
}
