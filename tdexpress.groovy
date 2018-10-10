pipeline{
    agent none
    stages{
        stage('Build VMX'){
            steps{
                script{
                    def workspace = pwd()
                    def props = readYaml file: "${workspace}/config.yml"
                    def x = props['skipconfig'][0]['config1']
                    agent {label 'vmx_build'}
                    echo $x
                }
            }
        }
    }
}