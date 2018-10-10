//def datas
//def var1
pipeline{
    agent none
    parameters{
        string(name: 'Timestamp', description: 'Timestamp Folder Name to Download OVA')
    }
    stages{
        stage('Build'){
            agent {label 'master'}
            steps{
                script{
                    def workspace= pwd()
                    datas = readYaml (file:"${workspace}/config.yml")
                    def var1 = datas.config1.toString()
                    def var2 = datas.config2.toString()
                    //echo props.config1.toString()
                    echo var1
                }
                
                echo datas.config1.toString()
                //sh "chmod +x build.sh && ./build.sh ${params.Timestamp} ${var1}"
                //echo "Timestamp is ${params.Timestamp}"
                //print "${workspace}"
                //print "${var}"
            }
        }
    }
}