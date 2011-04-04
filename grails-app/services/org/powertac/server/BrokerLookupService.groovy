package org.powertac.server

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.powertac.common.Broker
import org.powertac.common.command.LoginResponseCmd
import java.util.UUID
import org.powertac.common.Competition


class BrokerLookupService {

  static transactional = true

  def findByLoginRequest(request) {
    def broker = Broker.findByUsername("${request.username}")
    if (!broker) {
      def apiKey = request.apiKey?.text()
      if (apiKey?.length() < 32) {
        apiKey = UUID.randomUUID().toString()     // very low probability of collision
      }
      if (ConfigurationHolder.config?.powertac?.deployment?.type != 'competition') {
        broker = new Broker(username: request.username.text(),
                   apiKey: apiKey,
                   enabled: true).save(failOnError: true)

        // temporary workaround to add broker to current competition
        Competition.currentCompetition()?.addToBrokers(broker)
      }
    }
    return broker
  }
}
