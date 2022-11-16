$[/myProject/groovy/scripts/preamble.groovy.ignore]

BringYourOwnDeployerPlugin plugin = new BringYourOwnDeployerPlugin()
plugin.runStep('Undeploy Procedure', 'Undeploy Procedure', 'undeployProcedure')