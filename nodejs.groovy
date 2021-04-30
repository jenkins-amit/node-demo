job('NodeJS example') {
  scm {
    git('https://github.com/jenkins-amit/node-demo.git') { node ->
        node / gitConfigName('DSL User')
        node / gitConfigEmail('jenkins-dsl@gmail.com')
    }
  }

  triggers {
    scm('H/5 * * * *')
  }

  wrappers {
    nodejs('nodejs') // this is the name of the NodeJS installation in Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
  }

  steps {
    shell('npm install')
  }
}