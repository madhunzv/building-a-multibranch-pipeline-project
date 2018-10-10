pipeline{
    agent none

    stages{
        stage('Build VMX'){
            agent {label 'master'}
            steps{
                
                script{
                    def workspace = pwd()
                    def props = readYaml file: "${workspace}/config.yml"
                    def var = props.skipconfig.config1.toString()
                    def s = props.size()
                    print ${x}
                }
                //print "${workspace}"
                //print "${var}"
            }
        }
    }
}