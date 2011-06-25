package org.powertac.server

import grails.converters.XML
import org.powertac.common.OrderbookBid

class OrderbookBidController {

  def scaffold = OrderbookBid

  def get = {
    def orderbookBidInstance = OrderbookBid.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: orderbookBidInstance as XML)
  }
}
