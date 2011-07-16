package org.powertac.server

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.powertac.common.Broker
import org.powertac.common.command.LoginResponseCmd
import java.util.UUID
import org.powertac.common.Competition


class BrokerLookupService {

  static transactional = true
  def springSecurityService
  def participantManagementService

  def findByLoginRequest(request) {
    def broker = Broker.findByUsername("${request.username}")
    def deployType = ConfigurationHolder.config?.powertac?.deployment?.type
    if (!broker) {
      if (deployType != 'competition') {
        broker = createNewBroker(request.username.text(), request.password.text())
      } else {
        if (participantManagementService.authenticate(request.username.text())) {
          broker = createNewBroker(request.username.text(), request.password.text())
        }
      }
    }

    log.debug("findByLoginRequest(${request.username?.text()}:${deployType}) - broker is ${broker}, errors are ${broker?.errors}")

    return broker
  }

  def createNewBroker(username, password) {
    return new Broker(username: username,
                   password: springSecurityService.encodePassword(password),
                   enabled: true).save(failOnError: true)
  }
}
