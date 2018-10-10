pipeline{
    agent none

    stages{
        stage('Build VMX'){
            agent {label 'master'}
            steps{
                
                script{
                    def workspace = pwd()
                    def props = readYaml file: "${workspace}/building-a-multibranch-pipeline-project/config.yml"
                    def var = props.skipconfig.config1.toString()
                    echo props.skipconfig.config1.toString()
                }
                //print "${workspace}"
                //print "${var}"
            }
        }
    }
}