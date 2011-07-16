package org.powertac.server

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

class ParticipantManagementService implements ApplicationContextAware
{

  static transactional = false

  def brokersInCompetitions = []
  def fileReader
  def applicationContext

  synchronized def initialize() {
    // fake data first
    brokersInCompetitions = [ ['cat', 'dog', 'pig'],
                              ['grailsDemo', 'monkey', 'tiger'],
                              ['yellow', 'red'],
                              ['grailsDemo', 'black', 'red'] ]

    // let's read the file and load brokersInCompetitions
    def filePath = ConfigurationHolder.config.powertac.participationList.filePath
    if (filePath) {
      def file = applicationContext.getResource(filePath)?.file
      if (file)  {
        log.debug("initialize() - file ${file} exists")
        brokersInCompetitions = []
        file.eachLine { line ->
          def brokers = line.split(' *, *') as Set
          log.debug("initialize() - in line '${line}', we have ${brokers.size()} brokers")
          brokersInCompetitions.add(brokers)
        }
        log.debug("initialize() - there are ${brokersInCompetitions.size()} lines in ${brokersInCompetitions}")
      }
    }
  }

  synchronized boolean authenticate(brokerUsername) {
    def brokersInCurrentCompetition = brokersInCompetitions.first()
    return brokersInCurrentCompetition?.contains(brokerUsername)
  }

  synchronized boolean advanceToNewGame() {
    def gameExists = true
    brokersInCompetitions.remove(0)
    if (brokersInCompetitions.empty) {
      gameExists = false
      initialize()
    }

    return gameExists
  }

  void setApplicationContext (ApplicationContext applicationContext)
  {
    this.applicationContext = applicationContext
  }
}
