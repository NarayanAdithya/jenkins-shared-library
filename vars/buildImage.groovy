
def call() {
    echo "Building Docker Image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-adina', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh "docker build -t NarayanAdithya/nanajanashia:jmasl-2.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push NarayanAdithya/nanajanashia:jmasl-2.0"
    }
}
