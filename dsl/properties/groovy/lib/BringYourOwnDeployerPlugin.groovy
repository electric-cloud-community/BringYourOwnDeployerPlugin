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
    * @param deploymentArtifacts (required: false)
    
    */
    def deployProcedure(StepParameters p, StepResult sr) {
        // Use this parameters wrapper for convenient access to your parameters
        DeployProcedureParameters sp = DeployProcedureParameters.initParameters(p)

        String deploymentArtifactsPropertyPath = "/myJob/ec_deployment_artifacts"

        if (sp.getDeploymentArtifacts()) {
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
    * @param deploymentArtifacts (required: false)
    
    */
    def undeployProcedure(StepParameters p, StepResult sr) {
        // Use this parameters wrapper for convenient access to your parameters
        UndeployProcedureParameters sp = UndeployProcedureParameters.initParameters(p)

        String deploymentArtifactsPropertyPath = "/myJob/ec_deployment_artifacts"

        if (sp.getDeploymentArtifacts()) {
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