pipeline{
    agent none

    stages{
        stage('Build VMX'){
            agent {label 'master'}
            steps{
                script{
                    def workspace = pwd()
                    def props = readYaml file: "${workspace}/config.yml"
                    def x = props['skipconfig'][0]['config1']
                    //echo $x
                }
                print "${x}"
            }
        }
    }
}