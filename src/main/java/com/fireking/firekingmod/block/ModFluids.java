package com.fireking.firekingmod.block;

import com.fireking.firekingmod.FireKingMod;
import com.fireking.firekingmod.block.custom.OilFluid;
import net.minecraft.fluid.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid FLOWING_OIL = register("flowing_oil", new OilFluid.Flowing());
    public static final FlowableFluid OIL = register("oil", new OilFluid.Still());

    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(FireKingMod.MOD_ID, id), value);
    }

    static {
        for (Fluid fluid : Registries.FLUID) {
            for (FluidState fluidState : fluid.getStateManager().getStates()) {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }
    public static void registerModFluids() {
        FireKingMod.LOGGER.info("Registering ModFluids");
    }
}
