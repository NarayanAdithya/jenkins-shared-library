#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Dcoker(script) {
        this.script=script
    }

    def buildDockerImage(String ImageName, String Version){
        script.echo "Building $ImageName for $script.BRANCH_NAME"
        script.withCredentials([script.usernamePassword(credentialsId:'dockerhub-adina', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        script.sh "docker build -t narayanadithya/nanajanashia:$ImageName-$script.BRANCH_NAME-$Version ."
        script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        script.sh "docker push narayanadithya/nanajanashia:$ImageName-$script.BRANCH_NAME-$Version"
    }
    }
}