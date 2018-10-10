pipeline{
    agent none
    stages{
        def workspace = pwd()
        def props = readYaml file: "${workspace}/config.yml"
        def x = props['skipconfig'][0]['config1']
        stage('Build VMX'){
            agent {label 'vmx_build'}
            steps{
                echo $x
            }
        }
    }
}