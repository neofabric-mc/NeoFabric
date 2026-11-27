/*
 * Copyright 2016 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.minecraft.legacy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModOrigin;
import net.fabricmc.loader.impl.discovery.BundledApiRegistry;
import net.fabricmc.loader.impl.game.NeoFabricGameVersion;

class LegacyIntegrationTest {
	private static final FabricLoader LOADER = FabricLoader.getInstance();

	@BeforeAll
	static void bootstrap() {
		SharedConstants.createGameVersion();
		Bootstrap.initialize();
	}

	@Test
	void usesJava17AndActualMinecraft1182() {
		assertEquals(17, Runtime.version().feature());
		assertEquals("1.18.2", SharedConstants.getGameVersion().getName());
		assertEquals(Collections.singleton("1.18.2"), NeoFabricGameVersion.SUPPORTED_VERSIONS);
		assertEquals("1.18.2", LOADER.getModContainer("minecraft").orElseThrow()
				.getMetadata().getVersion().getFriendlyString());
	}

	@Test
	void unmarkedModAndExactBundledApiAreLoaded() {
		ModContainer mod = LOADER.getModContainer("neofabric-legacy-test").orElseThrow();
		assertFalse(mod.getMetadata().containsCustomValue("neofabric"));
		assertEquals("0.77.0+1.18.2", LOADER.getModContainer("fabric-api").orElseThrow()
				.getMetadata().getVersion().getFriendlyString());
		ModContainer nested = LOADER.getModContainer("fabric-lifecycle-events-v1").orElseThrow();
		assertEquals(ModOrigin.Kind.NESTED, nested.getOrigin().getKind());
		assertEquals("fabric-api", nested.getOrigin().getParentModId());
	}

	@Test
	void bundledApiDoesNotFallBack() throws IOException {
		BundledApiRegistry registry = BundledApiRegistry.load();
		assertEquals("0.77.0+1.18.2", registry.require("1.18.2").getApiVersion());
		assertThrows(IOException.class, () -> registry.require("1.20.1"));
	}

	@Test
	void yarnMappingsAndOldRegistryAreUsable() {
		assertEquals("net.minecraft.client.MinecraftClient", LOADER.getMappingResolver()
				.mapClassName("intermediary", "net.minecraft.class_310"));
		assertEquals("minecraft:diamond", Registry.ITEM.getId(Items.DIAMOND).toString());
		assertTrue(LOADER.isModLoaded("fabric-api-base"));
		assertNotNull(Items.DIAMOND);
	}
}
