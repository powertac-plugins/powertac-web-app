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
    log.debug("findByLoginRequest - start")
    def broker = Broker.findByUsername("${request.username}")
    if (!broker) {
      if (ConfigurationHolder.config?.powertac?.deployment?.type != 'competition') {
        broker = createNewBroker(request.username.text(), request.password.text())
      } else {
        if (participantManagementService.authenticate(request.username.text())) {
          broker = createNewBroker(request.username.text(), request.password.text())
        }
      }
    }

    log.debug("broker is ${broker}, errors are ${broker?.errors}")
    log.debug("findByLoginRequest - end")

    return broker
  }

  def createNewBroker(username, password) {
    return new Broker(username: username,
                   password: springSecurityService.encodePassword(password),
                   enabled: true).save(failOnError: true)
  }
}
