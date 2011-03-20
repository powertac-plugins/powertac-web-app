package org.powertac.server

import grails.converters.XML
import org.powertac.common.MarketTransaction

class MarketTransactionController {

  def scaffold = MarketTransaction

  def get = {
    def marketTransactionInstance = MarketTransaction.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: marketTransactionInstance as XML)
  }
}
