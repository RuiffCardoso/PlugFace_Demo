package com.example.document_sample.plugin_manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import java.net.URISyntaxException;
import java.net.URL;

import org.plugface.core.PluginManager;
import org.plugface.core.PluginRef;
import org.plugface.core.factory.PluginSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class PluginLoader {
	private static final Logger logger = LoggerFactory.getLogger(PluginLoader.class);

	/**
	 * Initializes application plugins
	 * 
	 * @param pm
	 * @param beanFactory
	 * @param pluginsDir
	 * @throws Exception
	 */
	@Autowired
	public PluginLoader(PluginManager pm, AbstractAutowireCapableBeanFactory beanFactory,
			@Value("${petro.plugins-dir}") String pluginsDir) throws Exception {

		// Load plugins from configured plugins directory
		try {
			loadPlugins(pm, pluginsDir);
		} catch (Exception err) {
			logger.error("An error occurred loading plugins ");
			throw err;
		}

		// Register all plugins as beans
		registerAsBeans(beanFactory, pm);
	}

	/**
	 * Loads all plugins on pluginsDir into PluginManager
	 * 
	 * @param pm
	 *                       DefaultPluginContext with name "springDefaultPluginManager"
	 * @param pluginsDir
	 *                       Directory containing PlugFace *.jar compatible plugins
	 * @throws URISyntaxException
	 * @throws Exception
	 */
	protected void loadPlugins(PluginManager pm, String pluginsDir) throws URISyntaxException, Exception {
		URL path = new URL(pluginsDir);
		logger.info("Loading plugins from '{}'");
		pm.loadPlugins(PluginSources.jarSource(path.toURI()));
	}

	/**
	 * Register all plugins as Spring Boot Bean to allow auto-wiring
	 * 
	 * @param beanFactory
	 * @param pm
	 *                        DefaultPluginContext with name "springDefaultPluginManager"
	 */
	protected void registerAsBeans(AbstractAutowireCapableBeanFactory beanFactory, PluginManager pm) {
		Collection<PluginRef> loadedPlugins = pm.getAllPlugins();
		logger.info("Loaded {} plugins", loadedPlugins.size());
		for (PluginRef ref : loadedPlugins) {
			Object plugin = ref.get();
			String beanName = plugin.getClass().getName();
			beanFactory.registerSingleton(plugin.getClass().getName(), plugin);
			logger.info("Registered {} as plugin", beanName);
		}
	}
}