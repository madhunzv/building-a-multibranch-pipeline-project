import groovy.transform.Field
//@Field def datas
//@Field def var1
//@Field def var2
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
                    workspace= pwd()
                    datas = readYaml (file:"${workspace}/config.yml")
                    var1 = datas.config1.toString()
                    var2 = datas.config2.toString()
                    //echo props.config1.toString()
                }
                
                echo datas.config1.toString()
                sh "chmod +x build.sh && ./build.sh ${params.Timestamp} ${var1} ${var2}"
            }
        }
    }
}