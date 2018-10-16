mavenJob("MVNJOB-CodeStability") {
  description("Code stability job through DSL")
  parameters {
    gitParam('Minor_Tag') {
      type('TAG')
      tagFilter("Minor*")
  	}
  }
  logRotator {
    numToKeep(5)
    daysToKeep(5)
    artifactNumToKeep(1)
    artifactDaysToKeep(1)
  }
  scm {
    git {
      remote {
        url("https://github.com/anupam-sy/MavenProject_01.git")
      }
      branch('${Minor_Tag}')
    }
  }
  mavenInstallation('default') // Select which installation of Maven to uses
  rootPOM('pom.xml')
  goals('clean compile')
}