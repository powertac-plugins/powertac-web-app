package org.powertac.server

import grails.converters.XML
import org.powertac.common.OrderbookAsk

class OrderbookAskController {

  def scaffold = OrderbookAsk

  def get = {
    def orderbookAskInstance = OrderbookAsk.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: orderbookAskInstance as XML)
  }
}
