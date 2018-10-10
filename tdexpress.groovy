node {
    def workspace= pwd()
    def props = readYaml (file:"${workspace}/config.yml")
}
pipeline{
    agent none

    stages{
        stage('Build VMDK'){
            agent {label 'master'}
            steps{
                
                script{
                    //def workspace= pwd()
                    //def props = readYaml (file:"${workspace}/config.yml")
                    def var = props.skipconfig.config1.toString()
                    //echo props.config1.toString()
                }
                echo props.config1.toString()
                //print "${workspace}"
                //print "${var}"
            }
        }
    }
}