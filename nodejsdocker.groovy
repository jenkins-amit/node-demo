job('nodejs docker example') {
  scm {
    git('https://github.com/jenkins-amit/node-demo.git') { node ->
        node / gitConfigName('DSL User')
        node / gitConfigEmail('jenkins-dsl@gmail.com')
    }
  }

  triggers {
    scm('H/5 * * * *')
  }
  
  steps {
    dockerBuildAndPublish {
      repositoryName('amit0511/docker-nodejs-demo')
      tag('${GIT_REVISION,length=9}')
      registryCredentials('dockerhub')
      forcePull(false)
      forceTag(false)
      createFingerprints(false)
      skipDecorate()
    }
  }
}