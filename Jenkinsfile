pipeline{
	agent any
	stages{
		stage('build'){
			steps{
					sh 'mvn clean test'
				}
			}
	}
	post{
		always{
			allure results: [[path: 'target/allure-results']]			
		}	
	}	
}