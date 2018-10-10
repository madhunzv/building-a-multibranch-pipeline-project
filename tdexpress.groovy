pipeline{
    agent none
    environment{
        pr = readYaml file: "${workspace}/config.yml"
        x = pr['skipconfig'][0]['config1']
    }
    stages{
        stage('Build VMX'){
            agent {label 'master'}
            steps{
                script{
                    def workspace = pwd()
                    def props = readYaml file: "${workspace}/config.yml"
                    def x = props['skipconfig'][0]['config1']
                    
                    echo $x
                }
            }
        }
    }
}