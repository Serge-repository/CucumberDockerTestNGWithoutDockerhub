pipeline {

    agent {
        node("test-executor")
    }

    parameters {
        string(name: 'branch', defaultValue: 'master', description: 'Branch to checkout')
        string(name: 'TAGS', defaultValue: '@Smoke',
            description: '''Cucumber tags to be executed. Examples:
                            @Regression,
                            @Sanity.
                            Leave this field empty if you want to run single feature class.
                            ''')
        string(name: 'FEATURE_CLASS', defaultValue: "src/test/resources/features/dragAndDrop.feature",
            description: '''Select feature class to execute. Examples:
                            src/test/resources/features/agileProject.feature,
                            src/test/resources/features/smokeNavigation.feature.
                            Leave this field empty if you want to run tags.
                            ''')
        string(name: 'forks', defaultValue: '1', description: 'Number of parallel threads')
        choice(name: 'browser', choices: ['chrome', 'firefox'], description: 'Tests run on exact browser')
    }

    stages {

        stage('Selenium GRID start') {
            steps {
                bat "docker-compose up -d --scale ${params.browser}=${params.forks}"
            }
        }

        stage('Execute tests'){
            steps {
                script {
                    if ( !TAGS.isEmpty() ) {
                        bat "mvn clean test -Dcucumber.filter.tags=${TAGS} -Dbrowser=${params.browser} -DremoteLocal=remote -Dforks=${params.forks}"
                    }
                    if ( !FEATURE_CLASS.isEmpty() ) {
                        bat "mvn clean test -Dcucumber.options="${FEATURE_CLASS}" -Dbrowser=${params.browser} -DremoteLocal=remote -Dforks=${params.forks}"
                    }
                }
            }
        }
    }

    post {
        always {
            bat "docker-compose stop"
            bat "docker-compose rm --force"
        }
    }

}