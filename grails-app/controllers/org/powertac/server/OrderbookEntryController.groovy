package org.powertac.server

import grails.converters.XML
import org.powertac.common.OrderbookEntry

class OrderbookEntryController {

  def scaffold = OrderbookEntry

  def get = {
    def orderbookEntryInstance = OrderbookEntry.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: orderbookEntryInstance as XML)
  }
}
