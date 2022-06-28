job('Docker DSL') {
    scm {
        git('https://github.com/haarikad/Docker-Jenkins-Integration.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('HarikaDikkala')
            node / gitConfigEmail('harikadikkala95@gmail.com')
        }
    }
    triggers {
        scm('H/20 * * * *')
    }
    wrappers {
        // nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('haarikad/docker-jenkins-dsl-demo')
            tag()
            registryCredentials('Dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
