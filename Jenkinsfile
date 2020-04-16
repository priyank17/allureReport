pipeline{
	agent any
	stages{
		stage('build'){
			steps{
					sh 'mvn clean verify'
				}
			}
	}
	post{
		always{
			allure results: [[path: 'target/allure-results']]			
		}	
	}	
}
