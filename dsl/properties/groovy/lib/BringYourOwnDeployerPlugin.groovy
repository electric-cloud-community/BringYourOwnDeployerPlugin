import com.cloudbees.flowpdf.*

import java.text.SimpleDateFormat

/**
* BringYourOwnDeployerPlugin
*/
class BringYourOwnDeployerPlugin extends FlowPlugin {

    @Override
    Map<String, Object> pluginInfo() {
        return [
                pluginName     : '@PLUGIN_KEY@',
                pluginVersion  : '@PLUGIN_VERSION@',
                configFields   : ['config'],
                configLocations: ['ec_plugin_cfgs'],
                defaultConfigValues: [:]
        ]
    }
// === check connection ends ===
/**
    * deployProcedure - Deploy Procedure/Deploy Procedure
    * Add your code into this method and it will be called when the step runs
    * @param useDefaultArtifacts (required: true)
    * @param deploymentArtifacts (required: false)
    
    */
    def deployProcedure(StepParameters p, StepResult sr) {
        // Use this parameters wrapper for convenient access to your parameters
        DeployProcedureParameters sp = DeployProcedureParameters.initParameters(p)

        String deploymentArtifactsPropertyPath = "/myJob/ec_deployment_artifacts"

        if (sp.getUseDefaultArtifacts()) {
            log.info("Using default deployment artifacts (hardcoded in plugin)")
            String autoVersion = new SimpleDateFormat("yyyy.MMdd.HHmmss").format(new Date());
            String defaultDeploymentArtifacts = """{
  "deploymentSystem": "Some3rdPartyTool",
  "deploymentUrl": "https://repository.sonatype.org/service/local/repositories/atlassian-maven-external/content/org/apache/tomcat/apache-tomcat/",
  "artifacts": [
    {
      "artifactName": "artifact1",
      "artifactVersion": "1.2.5",
      "artifactUrl": "https://repository.sonatype.org/service/local/repositories/atlassian-maven-external/content/org/apache/tomcat/apache-tomcat/10.0.14-atlassian-hosted/apache-tomcat-10.0.14-atlassian-hosted.pom",
      "additionalDetails": {
        "deploymentTargets": "target1, target2",
        "detail1": "value1",
        "detail2": "value2"
      }
    },
    {
      "artifactName": "artifact2",
      "artifactVersion": "${autoVersion}",
      "artifactUrl": "https://repository.sonatype.org/service/local/repositories/atlassian-maven-external/content/org/apache/tomcat/apache-tomcat/10.0.14-atlassian-hosted/apache-tomcat-10.0.14-atlassian-hosted.pom",
      "additionalDetails": {
        "deploymentTargets": "target2, target4",
        "detail1": "value1",
        "detail2": "vFalue2"
      }
    }
  ]
}"""
            log.info("Information about deployment artifacts to be stored in the property ${deploymentArtifactsPropertyPath}:")
            log.info(defaultDeploymentArtifacts)
            sr.setOutcomeProperty(deploymentArtifactsPropertyPath, defaultDeploymentArtifacts)
        } else if (sp.getDeploymentArtifacts()) {
            log.info("Using deployment artifacts provided by user within procedure parameter")

            log.info("Information about deployment artifacts to be stored in the property ${deploymentArtifactsPropertyPath}:")
            log.info(sp.getDeploymentArtifacts())
            sr.setOutcomeProperty(deploymentArtifactsPropertyPath, sp.getDeploymentArtifacts())
        } else {
            log.info("Nothing to be stored in the property ${deploymentArtifactsPropertyPath} by this plugin")
        }

        sr.apply()
        log.info("step Deploy Procedure has been finished")
    }

/**
    * undeployProcedure - Undeploy Procedure/Undeploy Procedure
    * Add your code into this method and it will be called when the step runs
    * @param useDefaultArtifacts (required: true)
    * @param deploymentArtifacts (required: false)
    
    */
    def undeployProcedure(StepParameters p, StepResult sr) {
        // Use this parameters wrapper for convenient access to your parameters
        UndeployProcedureParameters sp = UndeployProcedureParameters.initParameters(p)

        String deploymentArtifactsPropertyPath = "/myJob/ec_deployment_artifacts"

        if (sp.getUseDefaultArtifacts()) {
            log.info("Using default deployment artifacts (hardcoded in plugin)")
            String defaultDeploymentArtifacts = """{
  "deploymentSystem": "Some3rdPartyTool",
  "deploymentUrl": "https://repository.sonatype.org/service/local/repositories/atlassian-maven-external/content/org/apache/tomcat/apache-tomcat/",
  "artifacts": [
    "artifact1",
    "artifact2",
    "artifact3",
    "artifact1x",
    "artifact2x",
    "artifact3x"
  ]
}"""
            log.info("Information about deployment artifacts to be stored in the property ${deploymentArtifactsPropertyPath}:")
            log.info(defaultDeploymentArtifacts)
            sr.setOutcomeProperty(deploymentArtifactsPropertyPath, defaultDeploymentArtifacts)
        } else if (sp.getDeploymentArtifacts()) {
            log.info("Using deployment artifacts provided by user within procedure parameter")

            log.info("Information about deployment artifacts to be stored in the property ${deploymentArtifactsPropertyPath}:")
            log.info(sp.getDeploymentArtifacts())
            sr.setOutcomeProperty(deploymentArtifactsPropertyPath, sp.getDeploymentArtifacts())
        } else {
            log.info("Nothing to be stored in the property ${deploymentArtifactsPropertyPath} by this plugin")
        }

        sr.apply()
        log.info("step Undeploy Procedure has been finished")
    }

// === step ends ===

}