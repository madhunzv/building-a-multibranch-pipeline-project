pipeline{
    agent none
    def workspace = pwd()
    def props = readYaml file: "${workspace}/config.yml"
    stages{
        stage('Build VMX'){
            agent {label 'vmx_build'}
            steps{
                echo $
            }
        }
    }
}