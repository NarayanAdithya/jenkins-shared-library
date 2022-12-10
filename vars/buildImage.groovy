
def call() {
    echo "Building Docker Image..."
    withCredentials([usernamePassword(credentialsId: '', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh "docker build -t NarayanAdithya/nanajanashia:jma-2.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push NarayanAdithya/nanajanashia:jma-2.0"
    }
}