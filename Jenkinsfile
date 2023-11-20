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
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
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
						-v "C:/Users/an_bo/Documents/workspace-spring-tool-suite-4-4.20.0.RELEASE/gradle-first:/app" \
						snyk/snyk:gradle-jdk8
					docker ps -e
					exit \$?
					"""
               }
            }
        }
    }
}
