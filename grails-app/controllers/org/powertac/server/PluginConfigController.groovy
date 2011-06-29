package org.powertac.server

import org.powertac.common.PluginConfig
import grails.converters.XML

class PluginConfigController {

 def scaffold = PluginConfig

  def get = {
    def pluginConfigInstance = PluginConfig.get(params.id)
    render(contentType: "text/xml", encoding: "UTF-8", text: pluginConfigInstance as XML)
  }}
