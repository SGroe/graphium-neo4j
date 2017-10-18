/**
 * Graphium Neo4j - Server integration for Graphium modules in Neo4j Standalone server as unmanaged Extensions
 * Copyright © 2017 Salzburg Research Forschungsgesellschaft (graphium@salzburgresearch.at)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * (C) 2016 Salzburg Research Forschungsgesellschaft m.b.H.
 *
 * All rights reserved.
 *
 */
package at.srfg.graphium.neo4j.bootstrap;

import javax.servlet.Filter;

import org.neo4j.server.NeoServer;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Servlet 3.0+ web application initializer, no need for XML.
 * 
 * @author anwagner
 *
 */
public class GraphiumSpringWebAppInitializer extends AbstractDispatcherServletInitializer {

	private static final String rootAppCtx = "application-context-graphium-neo4j-integration.xml";

	private String servletName;
	private NeoServer neoServer;

	public GraphiumSpringWebAppInitializer(String servletName, NeoServer neoServer) {
		this.servletName = servletName;
		this.neoServer = neoServer;
	}

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		GenericXmlApplicationContext rootContext = new GenericXmlApplicationContext();
		rootContext.registerShutdownHook();
		rootContext.getBeanFactory().registerSingleton("database", neoServer.getDatabase().getGraph());
		rootContext.refresh();
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setParent(rootContext);
		context.setConfigLocation("classpath:/" + rootAppCtx);

		return context;
	}

	@Override
	protected String getServletName() {
		return servletName;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	protected Filter[] getServletFilters() {
		return null;
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		// currently bootstrapping does not split into root/web app context. Not
		// required just web context gets booted.
		return null;
	}
}
