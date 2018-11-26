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
                sh 'sed -ri "s/(.*teradata\/)(.*)/\1${params.Timestamp}\/\2/g" /root/tdexpress_build/try.txt'
                script{
                    workspace= pwd()
                    datas = readYaml (file:"${workspace}/config.yml")
                    var1 = datas.config1.toString()
                    var2 = datas.config2.toString()
                }
                
                echo datas.config1.toString()
                sh "chmod +x build.sh && ./build.sh ${params.Timestamp}"
            }
        }
        stage('Load VM'){
            agent {label 'vmx_player'}
            steps{
                dir("C:\\Users\\admin\\Documents\\VIX_Config"){
                    bat "./download_tde.bat ${params.Timestamp}"
                }
                script{
                    props = readYaml (file:"C:\\TD-Express\\props.yml")
                    
                }
            }
        }
    }
}