pipeline {
    agent any

    stages {
        stage('Get Code') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/EsraaElkheshen/Library-API.git'
            }
        }

        stage('Run Test') {
            steps {
                bat 'newman run  "Library.postman_collection.json" -e "Library-Test.postman_environment.json" --reporters=cli,htmlextra'
            }
        }
    }
}
