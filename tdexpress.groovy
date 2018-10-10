def datas
pipeline{
    agent none
    parameters{
        string(name: 'Timestamp', description: 'Timestamp Folder Name to Download OVA')
    }
    stages{
        stage('Build VMDK'){
            agent {label 'master'}
            steps{
                
                script{
                    def workspace= pwd()
                    datas = readYaml (file:"${workspace}/config.yml")
                    //def var = props.skipconfig.config1.toString()
                    //echo props.config1.toString()
                }
                echo datas.config1.toString()
                echo "Timestamp is ${params.Timestamp}"
                //print "${workspace}"
                //print "${var}"
            }
        }
    }
}