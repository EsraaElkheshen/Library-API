pipeline {
    agent any

    stages {
        stage('Get Code') {
            steps {
                git url: 'https://github.com/EsraaElkheshen/Library.git', changelog: false, poll: false
            }
        }

        stage('Run Test') {
            steps {
                bat 'newman run  Library.postman_collection.json -e Library-Test.postman_environment.json --reporters=cli,htmlextra'
            }
        }
    }
}
