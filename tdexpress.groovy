pipeline{
    agent none
    def workspace = pwd()
    def props = readYaml file: "${workspace}/config.yml"
    def x = props['skipconfig'][0]['config1']
    stages{
        stage('Build VMX'){
            agent {label 'vmx_build'}
            steps{
                echo $x
            }
        }
    }
}