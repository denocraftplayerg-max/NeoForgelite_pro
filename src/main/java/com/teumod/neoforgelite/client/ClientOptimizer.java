package com.teumod.neoforgelite.client;

import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "neoforgelite", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientOptimizer {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();

            // Reduz partículas
            if (mc.options != null) {
                mc.options.particles().set(0); // MINIMAL
                mc.options.entityShadows().set(false);
                mc.options.bobView().set(false);
            }
        });
    }
}
