package org.powertac.server

import grails.converters.XML
import org.powertac.common.TariffTransaction

class TariffTransactionController {

  def scaffold = TariffTransaction

  def get = {
    def tariffTransactionInstance = TariffTransaction.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: tariffTransactionInstance as XML)
  }
}
