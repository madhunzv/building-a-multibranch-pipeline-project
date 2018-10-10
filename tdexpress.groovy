pipeline{
    agent none
    stages{
        stage('Build VMX'){
            def workspace = pwd()
            def props = readYaml file: "${workspace}/config.yml"
            def x = props['skipconfig'][0]['config1']
            agent {label 'vmx_build'}
            steps{
                echo $x
            }
        }
    }
}