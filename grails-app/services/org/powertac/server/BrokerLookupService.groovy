package org.powertac.server

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.powertac.common.Broker
import org.powertac.common.command.LoginResponseCmd
import java.util.UUID
import org.powertac.common.Competition


class BrokerLookupService {

  static transactional = true
  def springSecurityService

  def findByLoginRequest(request) {
    log.debug("findByLoginRequest - start")
    def broker = Broker.findByUsername("${request.username}")
    if (!broker) {
      if (ConfigurationHolder.config?.powertac?.deployment?.type != 'competition') {
        broker = new Broker(username: request.username.text(),
                   password: springSecurityService.encodePassword(request.password.text()),
                   enabled: true).save(failOnError: true)
      }
    }
    log.debug("broker is ${broker}, errors are ${broker.errors}")
    log.debug("findByLoginRequest - end")

    return broker
  }
}
