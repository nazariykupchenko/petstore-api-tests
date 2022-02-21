pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				git branch: 'surefire-report', url: 'https://github.com/nazariykupchenko/petstore-api-tests.git'
				sh "mvn clean test"
				script {
					def summary = junit testResults: 'target/surefire-reports/TEST-*.xml'
					slackSend(
						channel: "#jenkins",
						teamDomain: 'testingtrainingtalk',
						color: '#007D00',
						message: "\n *Test Summary* - ${summary.totalCount}, Failures: ${summary.failCount}, Skipped: ${summary.skipCount}, Passed: ${summary.passCount}"
					)
				}
			}
		}
	}
	post {
		success {
			allure includeProperties: false, jdk: '', results: [
				[path: 'target/allure-results']
			]
		}
	}
}